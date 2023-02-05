package com.fishfarming.controller;

import java.util.List;

import com.fishfarming.model.Items;
import com.fishfarming.service.AquaFarmingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fishfarming.model.ItemCategory;
import com.fishfarming.model.ItemSubCategory;

@RestController
@CrossOrigin(origins = "*")
public class AquaFarmingController {
	
	@Autowired
	AquaFarmingService aquaFarmingService;
	
	//list of categories
	@GetMapping("/getCategories")
	public List<ItemCategory> getAllAvailableCategory() {
		return aquaFarmingService.getAvailableCategories();
	}
	
	//After clicking on category in UI -> Fetch the list of sub category based on category clicked
	@GetMapping("/getSubCategories")
	public List<ItemSubCategory> getSubCategoryBasedOnCategoryID(@RequestParam (name="id") String categoryId) {
		return aquaFarmingService.getSubCatByCatId(categoryId);
	}

	//get list of items on click of a sub-category
	@GetMapping("/getItems")
	public List<Items> getItemsBySubCategoryId(@RequestParam String subCategoryId) {
		return aquaFarmingService.getItemsBySubCatId(subCategoryId);
	}

}
