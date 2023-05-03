package com.franhc.pizzeria.remolo.v1.util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FunctionUtils {

    private FunctionUtils() {}

    public static String filterMessageError(String message, String delimiter) {
        String[] messages = message.split(delimiter);
        return messages.length > 1 ? messages[1].trim() : null;
    }

    public static String createPath(String... paths) {
        return Arrays.stream(paths).collect(Collectors.joining("/"));
    }
}
