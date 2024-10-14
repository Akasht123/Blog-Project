package com.codewithdurgesh.blog.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	private String resourseName;
	private String fieldName;
	private long fieldValue;
	public ResourceNotFoundException(String resourseName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %s", resourseName,fieldName,fieldValue));
		this.resourseName = resourseName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getResourseName() {
		return resourseName;
	}
	public void setResourseName(String resourseName) {
		this.resourseName = resourseName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public long getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(long fieldValue) {
		this.fieldValue = fieldValue;
	}
}
