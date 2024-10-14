package com.codewithdurgesh.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codewithdurgesh.blog.entities.Post;
import com.codewithdurgesh.blog.payloads.ApiResponse;
import com.codewithdurgesh.blog.payloads.PostDto;
import com.codewithdurgesh.blog.payloads.PostResponse;
import com.codewithdurgesh.blog.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	@Autowired
	private PostService postService;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,@PathVariable Integer categoryId){
		
	PostDto createdPost=	this.postService.createPost(postDto, userId, categoryId);
	return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
	List<PostDto> posts=	this.postService.getPostByUser(userId);
	return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	
	
	}
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
	List<PostDto> posts=	this.postService.getPostByCategory(categoryId);
	return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	
	
	}
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(@RequestParam(value="pageNumber",defaultValue="0",required=false) Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue="10",required=false) Integer pageSize,
			@RequestParam(value="sortBy",defaultValue="postId",required=false) String sortBy){
	PostResponse allpost	=this.postService.getAllPost(pageNumber,pageSize,sortBy);
	
	return new ResponseEntity<PostResponse>(allpost, HttpStatus.OK);
	}
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
	PostDto allpost	=this.postService.getPostById(postId);
	
	return new ResponseEntity<PostDto>(allpost, HttpStatus.OK);
	}
	
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) {
		postService.deletePost(postId);
		return new ApiResponse("post is deleted" ,true);
	}

	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId) {
	PostDto updatePost =	postService.updatePost(postDto,postId);
		return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
				}
	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable("keywords") String keywords){
	List<PostDto> result=	postService.searchPosts(keywords);
	return new ResponseEntity<List<PostDto>>(result, HttpStatus.OK);
	}
	 
}
