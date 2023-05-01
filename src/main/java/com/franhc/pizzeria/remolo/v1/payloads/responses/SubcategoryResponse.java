package com.franhc.pizzeria.remolo.v1.payloads.responses;

import com.franhc.pizzeria.remolo.v1.payloads.dtos.basics.SubcategoryDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SubcategoryResponse extends SubcategoryDto {

    @Schema(example = "1")
    private Long id;

}
