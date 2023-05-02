package com.franhc.pizzeria.remolo.v1.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.franhc.pizzeria.remolo.v1.payloads.requests.CategoryRequest;

import java.io.File;
import java.io.IOException;

public class ObjectMapperReadJson {

    public static final ObjectMapperReadJson INSTANCE = new ObjectMapperReadJson();
    private final ObjectMapper objectMapper;
    private ObjectMapperReadJson() {
        objectMapper = new ObjectMapper();
    }

    public CategoryRequest getCategoryRequest() throws IOException {
        return objectMapper.readValue(new File(Constants.PATH + "category_request.json"), CategoryRequest.class);
    }
}
