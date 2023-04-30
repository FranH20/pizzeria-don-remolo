package com.franhc.pizzeria.remolo.v1.payloads.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SubcategoryPostResponse {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "Dietetica")
    private String name;

    @Schema(example = "2")
    private Long categoryId;
}
