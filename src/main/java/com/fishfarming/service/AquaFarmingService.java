package com.fishfarming.service;

import java.util.List;

import com.fishfarming.model.Items;
import com.fishfarming.repository.AquaFarmingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fishfarming.model.ItemCategory;
import com.fishfarming.model.ItemSubCategory;

@Service
public class AquaFarmingService {
	
	@Autowired
	AquaFarmingRepo aquaFarmingRepo;
	
	public List<ItemCategory> getAvailableCategories() {
		return aquaFarmingRepo.getAllCategory();
	}
	
	public List<ItemSubCategory> getSubCatByCatId(String categoryId) {
		return aquaFarmingRepo.getSubCategoriesByCatId(categoryId);
	}

	public List<Items> getItemsBySubCatId(String subCatId) {
		return aquaFarmingRepo.getItemsBasedOnSubCategorySelected(subCatId);
	}
}
