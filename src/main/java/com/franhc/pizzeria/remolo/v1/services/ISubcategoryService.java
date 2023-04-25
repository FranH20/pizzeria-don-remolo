package com.franhc.pizzeria.remolo.v1.services;

import com.franhc.pizzeria.remolo.v1.models.Subcategory;
import com.franhc.pizzeria.remolo.v1.payloads.responses.PaginationResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.SubcategoryResponse;
import org.springframework.stereotype.Service;

@Service
public interface ISubcategoryService {

    PaginationResponse<SubcategoryResponse> getCategories(int paginationKey, int pageSize);
}
