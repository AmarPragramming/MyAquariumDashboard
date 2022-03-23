package com.fishfarming.model;

import java.util.List;


public class ItemCategory {
	
		private String categoryId;
		
		private String categoryName;
	
		private String categoryImageUrl;
		
		private List<ItemSubCategory> subCategories;

		public String getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(String categoryId) {
			this.categoryId = categoryId;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		public String getCategoryImageUrl() {
			return categoryImageUrl;
		}

		public void setCategoryImageUrl(String categoryImageUrl) {
			this.categoryImageUrl = categoryImageUrl;
		}

		public List<ItemSubCategory> getSubCategories() {
			return subCategories;
		}

		public void setSubCategories(List<ItemSubCategory> subCategories) {
			this.subCategories = subCategories;
		}
		
		
}
