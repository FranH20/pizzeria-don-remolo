package com.franhc.pizzeria.remolo.v1.payloads.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryDto {

    @NotBlank(message = "'${validatedValue}' must not be empty.")
    @Size(min = 1, max = 80, message = "The body of the comment must have a maximum of 80 characters.")
    private String name;

}
