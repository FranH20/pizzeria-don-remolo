package com.franhc.pizzeria.remolo.v1.services.impl;

import com.franhc.pizzeria.remolo.v1.models.Category;
import com.franhc.pizzeria.remolo.v1.models.Subcategory;
import com.franhc.pizzeria.remolo.v1.payloads.requests.CategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.responses.CategoryResponse;
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

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    void getCategories() throws IOException {
        Category category = ObjectMapperReadJson.INSTANCE.getCategoryDatabase();
        when(categoryRepository.findAll(any(PageRequest.class))).thenReturn(new PageImpl<>(Collections.singletonList(category)));
        PaginationResponse<CategoryResponse> response = categoryService.getCategories(0, 10);
        assertNotNull(response);
        assertNotNull(response.getData());
        assertNotNull(response.getPagination());
    }
}