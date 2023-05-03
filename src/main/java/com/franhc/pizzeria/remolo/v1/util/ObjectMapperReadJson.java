package com.franhc.pizzeria.remolo.v1.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.franhc.pizzeria.remolo.v1.models.Category;
import com.franhc.pizzeria.remolo.v1.models.Subcategory;
import com.franhc.pizzeria.remolo.v1.payloads.requests.CategoryRequest;

import java.io.File;
import java.io.IOException;

public class ObjectMapperReadJson {

    public static final ObjectMapperReadJson INSTANCE = new ObjectMapperReadJson();
    private final ObjectMapper objectMapper;
    private ObjectMapperReadJson() {
        objectMapper = new ObjectMapper();
    }

    public CategoryRequest getCategoryRequest() throws IOException {
        String jsonPath = FunctionUtils.createPath(Constants.PATH,FOLDERS.CATEGORIES.getFolderName(),"category_request.json");
        return objectMapper.readValue(new File(jsonPath), CategoryRequest.class);
    }

    public Category getCategoryDatabase() throws IOException {
        String jsonPath = FunctionUtils.createPath(Constants.PATH,FOLDERS.CATEGORIES.getFolderName(),"category_db.json");
        return objectMapper.readValue(new File(jsonPath), Category.class);
    }

    public Subcategory getSubcategoryDatabase() throws IOException{
        String jsonPath = FunctionUtils.createPath(Constants.PATH,FOLDERS.SUBCATEGORIES.getFolderName(),"subcategory_db.json");
        return objectMapper.readValue(new File(jsonPath), Subcategory.class);
    }

    private enum FOLDERS {
        CATEGORIES("categories"),
        SUBCATEGORIES("subcategories");

        private String folderName;

        FOLDERS(String folderName){
            this.folderName = folderName;
        }

        public String getFolderName() {
            return folderName;
        }
    }
}
