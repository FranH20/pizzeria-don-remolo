package com.franhc.pizzeria.remolo.v1.payloads.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pagination {
    private int page;
    private int totalPages;
    private long totalElements;
    private int pageSize;
}
