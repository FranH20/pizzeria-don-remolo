package com.franhc.pizzeria.remolo.v1.controllers.impl;

import com.franhc.pizzeria.remolo.v1.controllers.ICategoryController;
import com.franhc.pizzeria.remolo.v1.payloads.dtos.basics.CategoryDto;
import com.franhc.pizzeria.remolo.v1.payloads.requests.CategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.requests.SubcategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.responses.CategoryResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.SubcategoryPostResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.pagination.PaginationResponse;
import com.franhc.pizzeria.remolo.v1.services.impl.CategoryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CategoryController implements ICategoryController {

    private final Log log = LogFactory.getLog(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @Override
    public ResponseEntity<CategoryResponse> addCategory(CategoryRequest categoryRequest) {
        log.info("... running CategoryController.addCategory ...");
        CategoryResponse categoryResponse = categoryService.addCategory(categoryRequest);
        return new ResponseEntity<>(categoryResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PaginationResponse<CategoryResponse>> getCategories(int paginationKey,int pageSize) {
        log.info("... running CategoryController.getCategories ...");
        PaginationResponse<CategoryResponse> response = categoryService.getCategories(paginationKey, pageSize);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryResponse> updateCategory(Long categoryId, CategoryDto categoryRequest) {
        log.info("... running CategoryController.updateCategory ...");
        CategoryResponse response = categoryService.updateCategory(categoryId, categoryRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteCategory(Long id) {
        log.info("... running CategoryController.updateCategory ...");
        categoryService.deleteCategory(id);
        return new ResponseEntity<>("Successful Operation", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SubcategoryPostResponse> addSubcategoryWithinCategory(Long categoryId, SubcategoryRequest subcategoryRequest) {
        log.info("... running CategoryController.addSubcategoryWithinCategory ...");
        SubcategoryPostResponse response = categoryService.addSubcategoryWithinCategory(categoryId, subcategoryRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
