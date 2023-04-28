package com.franhc.pizzeria.remolo.v1.controllers;

import com.franhc.pizzeria.remolo.v1.payloads.dto.CategoryDto;
import com.franhc.pizzeria.remolo.v1.payloads.requests.CategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.responses.CategoryResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.PaginationResponse;
import com.franhc.pizzeria.remolo.v1.util.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequestMapping("api/v1/categories")
@Tag(name = "category", description = "the category API")
public interface ICategoryController {

    @Operation(summary = "Create category", description = "Create a new category.", tags = { "category" })
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Successful operation",
                            content = { @Content(mediaType = "application/json" ,
                                    schema = @Schema( implementation = CategoryResponse.class ))
                    }),
                    @ApiResponse(responseCode = "400", description = "Bad Request")
            })
    @PostMapping
    ResponseEntity<CategoryResponse> addCategory(
            @Parameter(description = "Created category object", required = true)
            @Valid @RequestBody CategoryRequest categoryRequest);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<PaginationResponse<CategoryResponse>> getCategories(
            @RequestParam(name = "paginationKey", required = false, defaultValue = Constants.DEFAULT_PAGE_KEY)
            @Max(value = Constants.MAX_PAGE_KEY) @Min(value = 0)
            int paginationKey,
            @RequestParam(name = "pageSize", required = false, defaultValue = Constants.DEFAULT_PAGE_SIZE)
            @Max(value = Constants.MAX_PAGE_SIZE) @Min(value = 0)
            int pageSize
    );

    @PutMapping("/{category-id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<CategoryResponse> updateCategory(
            @NotNull @PathVariable("category-id") Long categoryId,
            @Valid @RequestBody CategoryDto categoryRequest);
}
