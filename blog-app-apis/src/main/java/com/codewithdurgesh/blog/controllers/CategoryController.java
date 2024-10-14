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
import org.springframework.web.bind.annotation.RestController;

import com.codewithdurgesh.blog.payloads.ApiResponse;
import com.codewithdurgesh.blog.payloads.CategoryDto;
import com.codewithdurgesh.blog.payloads.UserDto;
import com.codewithdurgesh.blog.services.CategoryService;
import com.codewithdurgesh.blog.services.UserServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	
	@Autowired
	private CategoryService categoryService;
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		return new ResponseEntity<CategoryDto>(categoryService.createCategory(categoryDto) ,HttpStatus.CREATED);
				}  
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory( @Valid @RequestBody CategoryDto categoryDto , @PathVariable ("catId") Integer catId){
		
		return new ResponseEntity<CategoryDto>(categoryService.updateCategory(categoryDto, catId), HttpStatus.OK);
	}
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("catId") Integer catId){
		categoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully" , true),HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
		return new ResponseEntity<List<CategoryDto>>(categoryService.getCategories(),HttpStatus.OK);
	}
	
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable Integer catId){
		return new ResponseEntity<CategoryDto>(categoryService.getCategory(catId),HttpStatus.OK);
	}

}
