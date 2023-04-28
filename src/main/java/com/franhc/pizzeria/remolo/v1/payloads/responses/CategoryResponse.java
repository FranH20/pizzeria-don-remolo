package com.franhc.pizzeria.remolo.v1.payloads.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Data
public class CategoryResponse {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "Bebida")
    private String name;

    private List<SubcategoryResponse> subcategories;

    public List<SubcategoryResponse> getSubcategories() {
        return CollectionUtils.isEmpty(this.subcategories) ? Collections.emptyList() : this.subcategories;
    }
}
