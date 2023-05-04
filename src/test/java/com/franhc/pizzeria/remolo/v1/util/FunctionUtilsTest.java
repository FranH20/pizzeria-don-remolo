package com.franhc.pizzeria.remolo.v1.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionUtilsTest {

    @Test
    void createPathTest() {
        String response = "src/test/resources/JSONObjects/categories/request_db.json";
        String finalPath = FunctionUtils.createPath(Constants.PATH, "categories", "request_db.json");
        assertEquals(response, finalPath);
    }
}