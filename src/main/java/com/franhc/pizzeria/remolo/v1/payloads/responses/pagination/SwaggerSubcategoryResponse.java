package com.franhc.pizzeria.remolo.v1.payloads.responses.pagination;

import com.franhc.pizzeria.remolo.v1.payloads.dtos.Pagination;
import com.franhc.pizzeria.remolo.v1.payloads.responses.SubcategoryResponse;
import jakarta.validation.Valid;

import java.util.List;

public class SwaggerSubcategoryResponse extends PaginationResponse<SubcategoryResponse>{
    public SwaggerSubcategoryResponse(List<SubcategoryResponse> data, @Valid Pagination pagination) {
        super(data, pagination);
    }
}
