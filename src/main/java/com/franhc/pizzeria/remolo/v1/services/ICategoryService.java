package com.franhc.pizzeria.remolo.v1.services;

import com.franhc.pizzeria.remolo.v1.payloads.dto.CategoryDto;
import com.franhc.pizzeria.remolo.v1.payloads.requests.CategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.responses.CategoryResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICategoryService {

    ResponseEntity<CategoryResponse> addCategory(CategoryRequest categoryRequest);

    ResponseEntity<List<CategoryResponse>> getCategories();

    ResponseEntity<CategoryResponse> updateCategory(Long categoryId, CategoryDto categoryRequest);

}
