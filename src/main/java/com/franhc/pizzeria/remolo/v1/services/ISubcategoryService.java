package com.franhc.pizzeria.remolo.v1.services;

import com.franhc.pizzeria.remolo.v1.payloads.requests.SubcategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.responses.SubcategoryResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.pagination.PaginationResponse;
import org.springframework.stereotype.Service;

@Service
public interface ISubcategoryService {

    PaginationResponse<SubcategoryResponse> getSubcategories(int paginationKey, int pageSize);

    void deleteSubcategory(Long subcategoryId);

    SubcategoryResponse updateSubcategories(Long subcategoryId, SubcategoryRequest subcategoryRequest);
}
