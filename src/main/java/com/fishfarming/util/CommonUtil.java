package com.fishfarming.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fishfarming.model.ItemSubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

    @Autowired
    ItemSubCategory subCategory;


	public File getFileFromResource(String fileLocation) throws IOException {

        Resource resource = new ClassPathResource(fileLocation);
        InputStream input = resource.getInputStream();
        File file = resource.getFile();

        return file;
    }

    public boolean subCategoryExists(List<ItemSubCategory> subCategories, String id) {
	    boolean exists = false;
	    for(ItemSubCategory sb: subCategories) {
            if (sb.getSubCategoryId().equalsIgnoreCase(id)) {
                exists = true;
            }
        }
	    return exists;
    }

    public ItemSubCategory getSubCategory(List<ItemSubCategory> subCategories, String id) {
        for(ItemSubCategory sb: subCategories) {
            if (sb.getSubCategoryId().equalsIgnoreCase(id)) {
                subCategory = sb;
            }
        }
        return subCategory;
    }
}
