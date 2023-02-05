package com.fishfarming.repository;

import java.util.List;

import javax.persistence.Query;

import com.fishfarming.model.Items;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fishfarming.model.ItemCategory;
import com.fishfarming.model.ItemSubCategory;

@Repository
public class  AquaFarmingRepo extends  CommonRepo{


	
	public List<ItemCategory> getAllCategory() {
		
		Session session = getDbSession();
		Query query = session.createQuery("from ItemCategory"); 
		List<ItemCategory> categories =  query.getResultList();
		return categories;
		
	}
	
	public List<ItemSubCategory> getSubCategoriesByCatId(String categoryId){
		Session session = getDbSession();
		ItemCategory category = session.find(ItemCategory.class, categoryId);
		Hibernate.initialize(category.getSubCategories());
		return category.getSubCategories();
	}

	public List<Items> getItemsBasedOnSubCategorySelected(String subCategoryId){
		Session session = getDbSession();
		ItemSubCategory subCategory = session.find(ItemSubCategory.class, subCategoryId);
		Hibernate.initialize(subCategory.getItems());
		return subCategory.getItems();
	}
}
