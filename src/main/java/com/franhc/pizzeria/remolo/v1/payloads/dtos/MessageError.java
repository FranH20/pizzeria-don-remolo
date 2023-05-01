package com.franhc.pizzeria.remolo.v1.payloads.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
public class MessageError {

    @NonNull
    @Schema(example = "400")
    private Integer status;

    @NonNull
    @Schema(example = "Invalid Parameters")
    private String title;

    @NonNull
    @Schema(example = "[\"The body of the comment must have a maximum of 80 characters.\", \"List subcategories must not be null\"]")
    private List<String> errors;

    private LocalDateTime timestamp = LocalDateTime.now();


}
