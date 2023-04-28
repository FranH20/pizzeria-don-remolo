package com.franhc.pizzeria.remolo.v1.services;

import com.franhc.pizzeria.remolo.v1.payloads.dto.CategoryDto;
import com.franhc.pizzeria.remolo.v1.payloads.requests.CategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.responses.CategoryResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.pagination.PaginationResponse;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {

    ResponseEntity<CategoryResponse> addCategory(CategoryRequest categoryRequest);

    PaginationResponse<CategoryResponse> getCategories(int paginationKey, int pageSize);

    ResponseEntity<CategoryResponse> updateCategory(Long categoryId, CategoryDto categoryRequest);

}
