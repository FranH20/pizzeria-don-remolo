package com.franhc.pizzeria.remolo.v1.payloads.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class Pagination {
    @Schema(example = "0")
    private int page;
    @Schema(example = "1")
    private int totalPages;
    @Schema(example = "6")
    private long totalElements;
    @Schema(example = "10")
    private int pageSize;

    public Pagination(Page<?> pagination) {
        this.page = pagination.getNumber();
        this.totalPages = pagination.getTotalPages();
        this.totalElements = pagination.getTotalElements();
        this.pageSize = pagination.getSize();
    }
}
