package com.franhc.pizzeria.remolo.v1.services.impl;

import com.franhc.pizzeria.remolo.v1.exceptions.ResourceNotFoundException;
import com.franhc.pizzeria.remolo.v1.models.Subcategory;
import com.franhc.pizzeria.remolo.v1.payloads.requests.SubcategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.responses.SubcategoryResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.pagination.PaginationResponse;
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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.*;

@SpringBootTest
class SubcategoryServiceTest {

    @InjectMocks
    private SubcategoryService subcategoryService;

    @Mock
    private SubcategoryRepository subcategoryRepository;

    @Test
    void getSubcategoriesTest() throws IOException {
        Subcategory subcategory = ObjectMapperReadJson.INSTANCE.getSubcategoryDatabase();
        when(subcategoryRepository.findAll(any(PageRequest.class))).thenReturn(new PageImpl<>(Collections.singletonList(subcategory)));
        PaginationResponse<SubcategoryResponse> response = subcategoryService.getSubcategories(0, 10);
        assertNotNull(response);
        assertNotNull(response.getData());
        assertNotNull(response.getPagination());
    }

    @Test
    void deleteSubcategoryTest() {
        subcategoryService.deleteSubcategory(1L);
        verify(subcategoryRepository).deleteById(anyLong());
    }

    @Test
    void updateSubcategoriesTest() throws IOException{
        Subcategory subcategory = ObjectMapperReadJson.INSTANCE.getSubcategoryDatabase();
        when(subcategoryRepository.findById(anyLong())).thenReturn(Optional.ofNullable(subcategory));
        when(subcategoryRepository.save(any(Subcategory.class))).thenReturn(new Subcategory());
        SubcategoryResponse response = subcategoryService.updateSubcategories(1L, new SubcategoryRequest());
        assertNotNull(response);
    }

    @Test()
    void updateSubcategoriesTest_when_execute_ResourceNotFoundException() {
        ResourceNotFoundException response = assertThrowsExactly( ResourceNotFoundException.class, () -> subcategoryService.updateSubcategories(1L, new SubcategoryRequest()));
        assertNotNull(response);
        assertNotNull(response.getMessage());
    }
}