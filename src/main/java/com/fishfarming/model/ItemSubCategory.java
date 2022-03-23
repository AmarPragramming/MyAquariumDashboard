package com.fishfarming.model;

import java.util.List;

public class ItemSubCategory {

	private String categoryId;
	
	private String subCategoryId;
	
	private String subCategoryName;

	private String subCategoryImageUrl;
	
	private List<Items> items;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(String subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getSubCategoryImageUrl() {
		return subCategoryImageUrl;
	}

	public void setSubCategoryImageUrl(String subCategoryImageUrl) {
		this.subCategoryImageUrl = subCategoryImageUrl;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}
	
	
}
