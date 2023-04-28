package com.franhc.pizzeria.remolo.v1.payloads.responses.pagination;

import com.franhc.pizzeria.remolo.v1.payloads.dto.Pagination;
import com.franhc.pizzeria.remolo.v1.payloads.responses.CategoryResponse;
import jakarta.validation.Valid;

import java.util.List;

public class SwaggerCategoryResponse extends PaginationResponse<CategoryResponse> {
    public SwaggerCategoryResponse(
            List<CategoryResponse> data, @Valid Pagination pagination) {
        super(data, pagination);
    }

}
