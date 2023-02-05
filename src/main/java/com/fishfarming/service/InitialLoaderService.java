package com.fishfarming.service;

import java.util.ArrayList;
import java.util.List;

import com.fishfarming.repository.InitialDataRepo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fishfarming.model.ItemCategory;
import com.fishfarming.model.ItemSubCategory;
import com.fishfarming.model.Items;
import com.fishfarming.util.CommonUtil;

@Service
public class InitialLoaderService {

	@Autowired
	CommonUtil commonUtil;



	@Autowired
	InitialDataRepo dataRepo;

	public boolean loadData() {
		
		List<ItemCategory> myCategoryList = new ArrayList<ItemCategory>();
		try {
			Workbook workbook = new XSSFWorkbook(commonUtil.getFileFromResource("MyfishFarmingData.xlsx"));
			
			Sheet sheet = workbook.getSheetAt(0);
			
			//Setting up of category - simple set as we are just modeling around one category
			ItemCategory category = new ItemCategory();
			Row row = sheet.getRow(1);
			category.setCategoryId(row.getCell(1).toString());
			category.setCategoryName(row.getCell(0).toString());
			category.setCategoryImageUrl(row.getCell(2).toString());
			
			List<ItemSubCategory> subCategories = new ArrayList<ItemSubCategory>();
			//populating all available data's in respective buckets
			for(int i=1;i<14;i++) {
				row = sheet.getRow(i);
				String subCategoryId = row.getCell(3).toString();
				Items item = new Items();
				item.setItemName(row.getCell(6).toString());
				item.setImageUrl(row.getCell(7).toString());
				item.setPrice(Float.parseFloat(row.getCell(8).toString()));
				item.setItemId(row.getCell(9).toString());
				item.setQuantity(row.getCell(10).toString());

				if(subCategories.isEmpty() || !commonUtil.subCategoryExists(subCategories, subCategoryId)) {
					ItemSubCategory subCategory = new ItemSubCategory();
					subCategory.setSubCategoryId(row.getCell(3).toString());
					subCategory.setSubCategoryImageUrl(row.getCell(4).toString());
					subCategory.setSubCategoryName(row.getCell(5).toString());
					List<Items> itemList = new ArrayList<Items>();
					itemList.add(item);
					subCategory.setItems(itemList);
					subCategories.add(subCategory);
				} else if (commonUtil.subCategoryExists(subCategories, subCategoryId)) {
					ItemSubCategory subCategory = commonUtil.getSubCategory(subCategories, subCategoryId);
					List<Items> itemList = subCategory.getItems();
					itemList.add(item);
					subCategory.setItems(itemList);
					subCategories.remove(commonUtil.getSubCategory(subCategories, subCategoryId));
					subCategories.add(subCategory);
				}



			}

			category.setSubCategories(subCategories);

			myCategoryList.add(category);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataRepo.addCategory(myCategoryList);
	}
}
