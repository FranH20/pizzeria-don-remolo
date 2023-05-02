package com.franhc.pizzeria.remolo.v1.services;

import com.franhc.pizzeria.remolo.v1.payloads.dtos.basics.CategoryDto;
import com.franhc.pizzeria.remolo.v1.payloads.requests.CategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.requests.SubcategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.responses.CategoryResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.SubcategoryPostResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.pagination.PaginationResponse;

public interface ICategoryService {

    CategoryResponse addCategory(CategoryRequest categoryRequest);

    PaginationResponse<CategoryResponse> getCategories(int paginationKey, int pageSize);

    CategoryResponse updateCategory(Long categoryId, CategoryDto categoryRequest);

    void deleteCategory(Long categoryId);

    SubcategoryPostResponse addSubcategoryWithinCategory(Long categoryId, SubcategoryRequest subcategoryRequest);
}
