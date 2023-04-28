package com.franhc.pizzeria.remolo.v1.controllers;

import com.franhc.pizzeria.remolo.v1.payloads.responses.PaginationResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.SubcategoryResponse;
import com.franhc.pizzeria.remolo.v1.util.Constants;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Validated
@RequestMapping("api/v1/subcategories")
public interface ISubcategoryController {

    @GetMapping
    @ResponseBody
    ResponseEntity<PaginationResponse<SubcategoryResponse>> getSubcategories(
            @RequestParam(name = "paginationKey", required = false, defaultValue = Constants.DEFAULT_PAGE_KEY)
            @Max(value = Constants.MAX_PAGE_KEY) @Min(value = 0)
            int paginationKey,
            @RequestParam(name = "pageSize", required = false, defaultValue = Constants.DEFAULT_PAGE_SIZE)
            @Max(value = Constants.MAX_PAGE_SIZE) @Min(value = 0)
            int pageSize
    );
}
