package com.franhc.pizzeria.remolo.v1.payloads.responses;

import com.franhc.pizzeria.remolo.v1.payloads.dtos.basics.CategoryDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryResponse extends CategoryDto {

    @Schema(example = "1")
    private Long id;

    private List<SubcategoryResponse> subcategories;

    public List<SubcategoryResponse> getSubcategories() {
        return CollectionUtils.isEmpty(this.subcategories) ? Collections.emptyList() : this.subcategories;
    }
}
