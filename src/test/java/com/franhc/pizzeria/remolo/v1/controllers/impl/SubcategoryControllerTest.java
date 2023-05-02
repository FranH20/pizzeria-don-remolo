package com.franhc.pizzeria.remolo.v1.controllers.impl;

import com.franhc.pizzeria.remolo.v1.payloads.requests.SubcategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.responses.SubcategoryResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.pagination.PaginationResponse;
import com.franhc.pizzeria.remolo.v1.services.impl.SubcategoryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubcategoryControllerTest {

    @InjectMocks
    private SubcategoryController subcategoryController;

    @Mock
    private SubcategoryService subcategoryService;

    @Test
    void getSubcategoriesTest() {
        when(subcategoryService.getSubcategories(anyInt(), anyInt())).thenReturn(new PaginationResponse<>(anyList(), any()));
        ResponseEntity<PaginationResponse<SubcategoryResponse>> response = subcategoryController.getSubcategories(0, 20);
        assertNotNull(response);
    }

    @Test
    void deleteSubcategoryTest() {
        ResponseEntity<String> response = subcategoryController.deleteSubcategory(1L);
        assertNotNull(response);
    }

    @Test
    void updateSubcategory() {
        when(subcategoryService.updateSubcategories(anyLong(), any())).thenReturn(new SubcategoryResponse());
        ResponseEntity<SubcategoryResponse> response = subcategoryController.updateSubcategory(1L, new SubcategoryRequest());
        assertNotNull(response);
    }

}