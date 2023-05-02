package com.franhc.pizzeria.remolo.v1.controllers.impl;

import com.franhc.pizzeria.remolo.v1.payloads.dtos.basics.CategoryDto;
import com.franhc.pizzeria.remolo.v1.payloads.requests.CategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.requests.SubcategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.responses.CategoryResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.SubcategoryPostResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.pagination.PaginationResponse;
import com.franhc.pizzeria.remolo.v1.services.impl.CategoryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class CategoryControllerTest {

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;

    @Test
    void addCategoryTest() {
        CategoryRequest categoryRequest = new CategoryRequest();
        when(categoryService.addCategory(any())).thenReturn(new CategoryResponse());
        ResponseEntity<CategoryResponse> response = categoryController.addCategory(categoryRequest);
        assertNotNull(response);
    }

    @Test
    void getCategoriesTest() {
        when(categoryService.getCategories(anyInt(), anyInt())).thenReturn(new PaginationResponse<>(anyList(), any()));
        ResponseEntity<PaginationResponse<CategoryResponse>> response = categoryController.getCategories(0, 20);
        assertNotNull(response);
    }

    @Test
    void updateCategoryTest() {
        when(categoryService.updateCategory(anyLong(), any())).thenReturn(new CategoryResponse());
        ResponseEntity<CategoryResponse> response = categoryController.updateCategory(1L, new CategoryDto());
        assertNotNull(response);
    }

    @Test
    void deleteCategoryTest() {
        ResponseEntity<String> response = categoryController.deleteCategory(1L);
        assertNotNull(response);
    }

    @Test
    void addSubcategoryWithinCategoryTest() {
        when(categoryService.addSubcategoryWithinCategory(anyLong(), any())).thenReturn(new SubcategoryPostResponse());
        ResponseEntity<SubcategoryPostResponse> response = categoryController.addSubcategoryWithinCategory(1L, new SubcategoryRequest());
        assertNotNull(response);
    }
}