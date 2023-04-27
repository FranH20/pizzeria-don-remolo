package com.franhc.pizzeria.remolo.v1.controllers;

import com.franhc.pizzeria.remolo.v1.payloads.dto.CategoryDto;
import com.franhc.pizzeria.remolo.v1.payloads.requests.CategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.responses.CategoryResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.PaginationResponse;
import com.franhc.pizzeria.remolo.v1.services.impl.CategoryService;
import com.franhc.pizzeria.remolo.v1.util.Constants;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    private final Log log = LogFactory.getLog(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> addCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        log.info("... running CategoryController.addCategory ...");
        return categoryService.addCategory(categoryRequest);
    }

    @GetMapping
    public ResponseEntity<PaginationResponse<CategoryResponse>> getCategories(
            @RequestParam(name = "paginationKey", required = false, defaultValue = Constants.DEFAULT_PAGE_KEY)
            @Max(value = Constants.MAX_PAGE_KEY) @Min(value = 0)
            int paginationKey,
            @RequestParam(name = "pageSize", required = false, defaultValue = Constants.DEFAULT_PAGE_SIZE)
            @Max(value = Constants.MAX_PAGE_SIZE) @Min(value = 0)
            int pageSize
    ) {
        log.info("... running CategoryController.getCategories ...");
        PaginationResponse<CategoryResponse> response = categoryService.getCategories(paginationKey, pageSize);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{category-id}")
    public ResponseEntity<CategoryResponse> updateCategory(
            @NotNull @PathVariable("category-id") Long categoryId,
            @Valid @RequestBody CategoryDto categoryRequest) {
        log.info("... running CategoryController.updateCategory ...");
        return categoryService.updateCategory(categoryId, categoryRequest);
    }
}
