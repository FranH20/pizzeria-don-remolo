package com.franhc.pizzeria.remolo.v1.services.impl;

import com.franhc.pizzeria.remolo.v1.exceptions.ResourceNotFoundException;
import com.franhc.pizzeria.remolo.v1.models.Category;
import com.franhc.pizzeria.remolo.v1.models.Subcategory;
import com.franhc.pizzeria.remolo.v1.payloads.dtos.basics.CategoryDto;
import com.franhc.pizzeria.remolo.v1.payloads.requests.CategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.requests.SubcategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.responses.CategoryResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.SubcategoryPostResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.pagination.PaginationResponse;
import com.franhc.pizzeria.remolo.v1.repositories.CategoryRepository;
import com.franhc.pizzeria.remolo.v1.repositories.SubcategoryRepository;
import com.franhc.pizzeria.remolo.v1.util.ObjectMapperReadJson;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private SubcategoryRepository subcategoryRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    void addCategoryTest() throws IOException{
        Category category = ObjectMapperReadJson.INSTANCE.getCategoryDatabase();
        Subcategory subcategory = ObjectMapperReadJson.INSTANCE.getSubcategoryDatabase();
        when(categoryRepository.save(any(Category.class))).thenReturn(category);
        when(subcategoryRepository.saveAll(anyList())).thenReturn(Collections.singletonList(subcategory));
        CategoryResponse categoryResponse = categoryService.addCategory(new CategoryRequest());
        assertNotNull(categoryResponse);
    }

    @Test
    void getCategoriesTest() throws IOException {
        Category category = ObjectMapperReadJson.INSTANCE.getCategoryDatabase();
        when(categoryRepository.findAll(any(PageRequest.class))).thenReturn(new PageImpl<>(Collections.singletonList(category)));
        PaginationResponse<CategoryResponse> response = categoryService.getCategories(0, 10);
        assertNotNull(response);
        assertNotNull(response.getData());
        assertNotNull(response.getPagination());
    }

    @Test
    void updateCategoryTest() throws IOException {
        Category category = ObjectMapperReadJson.INSTANCE.getCategoryDatabase();
        when(categoryRepository.findById(anyLong())).thenReturn(Optional.ofNullable(category));
        when(categoryRepository.save(any(Category.class))).thenReturn(new Category());
        CategoryResponse response = categoryService.updateCategory(1L, new CategoryDto());
        assertNotNull(response);
    }

    @Test
    void updateCategoryTest_when_execute_ResourceNotFoundException() {
        ResourceNotFoundException resourceNotFoundException = assertThrowsExactly( ResourceNotFoundException.class, () -> categoryService.updateCategory(1L, new CategoryDto()));
        assertNotNull(resourceNotFoundException);
        assertNotNull(resourceNotFoundException.getMessage());
    }

    @Test
    void deleteCategoryTest() {
        categoryService.deleteCategory(1L);
        verify(categoryRepository).deleteById(anyLong());
    }

    @Test
    void addSubcategoryWithinCategoryTest() throws IOException{
        Category category = ObjectMapperReadJson.INSTANCE.getCategoryDatabase();
        when(categoryRepository.findById(anyLong())).thenReturn(Optional.ofNullable(category));
        when(subcategoryRepository.save(any(Subcategory.class))).thenReturn(new Subcategory());
        SubcategoryPostResponse response = categoryService.addSubcategoryWithinCategory(1L, new SubcategoryRequest());
        assertNotNull(response);
    }

    @Test
    void addSubcategoryWithinCategoryTest_when_execute_ResourceNotFoundException() {
        ResourceNotFoundException resourceNotFoundException = assertThrowsExactly( ResourceNotFoundException.class, () -> categoryService.addSubcategoryWithinCategory(1L, new SubcategoryRequest()));
        assertNotNull(resourceNotFoundException);
        assertNotNull(resourceNotFoundException.getMessage());
    }
}