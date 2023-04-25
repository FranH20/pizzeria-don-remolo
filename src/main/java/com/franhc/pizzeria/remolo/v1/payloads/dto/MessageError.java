package com.franhc.pizzeria.remolo.v1.payloads.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
public class MessageError {

    @NonNull
    private int status;

    @NonNull
    private String title;

    @NonNull
    private List<String> errors;

    private LocalDateTime timestamp = LocalDateTime.now();


}
