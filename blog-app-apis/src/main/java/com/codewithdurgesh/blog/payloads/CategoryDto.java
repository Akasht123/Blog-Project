package com.codewithdurgesh.blog.payloads;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CategoryDto {
	private Integer categoryId;
	@NotNull
	@Size(min= 4, message = "min size is 4")
	private String categoryTitle;
	@NotNull
	@Size(min = 10, message ="min size is 10")
	private String categoryDescription;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public CategoryDto() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(Integer categoryId, String categoryTitle, String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
	}
}
