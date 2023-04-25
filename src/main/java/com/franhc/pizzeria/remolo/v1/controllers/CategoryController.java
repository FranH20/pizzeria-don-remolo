package com.franhc.pizzeria.remolo.v1.controllers;

import com.franhc.pizzeria.remolo.v1.payloads.dto.CategoryDto;
import com.franhc.pizzeria.remolo.v1.payloads.requests.CategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.responses.CategoryResponse;
import com.franhc.pizzeria.remolo.v1.services.impl.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<CategoryResponse>> getCategories() {
        log.info("... running CategoryController.getCategories ...");
        return categoryService.getCategories();
    }

    @PutMapping("/{category-id}")
    public ResponseEntity<CategoryResponse> updateCategory(
            @NotNull @PathVariable("category-id") Long categoryId,
            @Valid @RequestBody CategoryDto categoryRequest) {
        log.info("... running CategoryController.updateCategory ...");
        return categoryService.updateCategory(categoryId, categoryRequest);
    }
}
