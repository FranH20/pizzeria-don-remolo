package com.franhc.pizzeria.remolo.v1.payloads.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class Pagination {
    private int page;
    private int totalPages;
    private long totalElements;
    private int pageSize;

    public Pagination(Page<?> pagination) {
        this.page = pagination.getNumber();
        this.totalPages = pagination.getTotalPages();
        this.totalElements = pagination.getTotalElements();
        this.pageSize = pagination.getSize();
    }
}
