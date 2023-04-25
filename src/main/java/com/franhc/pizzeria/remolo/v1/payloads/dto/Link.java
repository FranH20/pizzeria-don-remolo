package com.franhc.pizzeria.remolo.v1.payloads.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.util.UrlPathHelper;

@Data
@AllArgsConstructor
public class Link {
    private String first;
    private String last;
    private String next;
    private String previous;

}
