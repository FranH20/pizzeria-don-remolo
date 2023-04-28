package com.franhc.pizzeria.remolo.v1.payloads.responses.pagination;

import com.franhc.pizzeria.remolo.v1.payloads.dto.Pagination;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PaginationResponse<T> {

    private List<T> data;

    @Valid
    private Pagination pagination;
}
