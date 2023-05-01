package com.franhc.pizzeria.remolo.v1.payloads.requests;

import com.franhc.pizzeria.remolo.v1.payloads.dtos.basics.CategoryDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryRequest extends CategoryDto {

    @Valid
    @NotNull(message = "List subcategories must not be null")
    private List<SubcategoryRequest> subcategories;

    public List<SubcategoryRequest> getSubcategories() {
        return CollectionUtils.isEmpty(this.subcategories) ? Collections.emptyList() : this.subcategories;
    }
}
