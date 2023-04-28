package com.franhc.pizzeria.remolo.v1.payloads.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SubcategoryRequest {

    @Schema(example = "Dietetica")
    @NotBlank(message = "name must not be empty.")
    @Size(max = 160, message = "The body of the comment must have a maximum of 160 characters.")
    private String name;
}
