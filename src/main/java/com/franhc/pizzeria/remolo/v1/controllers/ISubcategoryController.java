package com.franhc.pizzeria.remolo.v1.controllers;

import com.franhc.pizzeria.remolo.v1.payloads.dto.MessageError;
import com.franhc.pizzeria.remolo.v1.payloads.responses.SubcategoryResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.pagination.PaginationResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.pagination.SwaggerSubcategoryResponse;
import com.franhc.pizzeria.remolo.v1.util.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequestMapping("api/v1/subcategories")
@Tag(name = Constants.SUBCATEGORY_TAG, description = "The subcategory API")
public interface ISubcategoryController {

    @Operation(summary = "Get subcategories", description = "Get a list of categories.", tags = { Constants.SUBCATEGORY_TAG })
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Successful operation",
                            content = { @Content(mediaType = "application/json" ,
                                    schema = @Schema( implementation = SwaggerSubcategoryResponse.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Bad Request",
                            content = { @Content(mediaType = "application/json" ,
                                    schema = @Schema( implementation = MessageError.class))})
            })
    @GetMapping
    @ResponseBody
    ResponseEntity<PaginationResponse<SubcategoryResponse>> getSubcategories(
            @Parameter(description = Constants.DESCRIPTION_PAGE_KEY)
            @RequestParam(name = "paginationKey", required = false, defaultValue = Constants.DEFAULT_PAGE_KEY)
            @Max(value = Constants.MAX_PAGE_KEY) @Min(value = 0)
            int paginationKey,
            @Parameter(description = Constants.DESCRIPTION_PAGE_SIZE)
            @RequestParam(name = "pageSize", required = false, defaultValue = Constants.DEFAULT_PAGE_SIZE)
            @Max(value = Constants.MAX_PAGE_SIZE) @Min(value = 0)
            int pageSize
    );

    @Operation(summary = "Delete subcategories", description = "Delete one subcategory by id.", tags = {Constants.SUBCATEGORY_TAG})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Successful operation",
                            content = { @Content(mediaType = "text") }
                    ),
                    @ApiResponse(responseCode = "409", description = "Conflict",
                            content = { @Content(mediaType = "text")}
                    )
            }
    )
    @DeleteMapping("/{subcategory-id}")
    ResponseEntity<String> deleteSubcategory(
            @Parameter(description = "The subcategory identifier.")
            @Positive @NotNull @PathVariable("subcategory-id")
            Long id);
}
