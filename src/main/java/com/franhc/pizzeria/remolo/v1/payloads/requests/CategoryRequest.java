package com.franhc.pizzeria.remolo.v1.payloads.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Data
public class CategoryRequest {

    @NotBlank(message = "'${validatedValue}' must not be empty.")
    @Size(min = 1, max = 80, message = "The body of the comment must have a maximum of 80 characters.")
    private String name;

    @Valid
    @NotNull(message = "List subcategories must not be null")
    private List<SubcategoryRequest> subcategories;

    public List<SubcategoryRequest> getSubcategories() {
        return CollectionUtils.isEmpty(this.subcategories) ? Collections.emptyList() : this.subcategories;
    }
}
