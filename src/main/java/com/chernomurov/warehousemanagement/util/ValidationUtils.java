package com.chernomurov.warehousemanagement.util;

import org.springframework.util.ReflectionUtils;

import java.util.List;

public class ValidationUtils {

    public static <T> void validateRequest(T request, List<String> fieldNamesToValidate) {
        StringBuilder messageBuilder = new StringBuilder();
        ReflectionUtils.doWithFields(request.getClass(), field -> {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object fieldValue = field.get(request);
            if (fieldNamesToValidate.contains(fieldName) && fieldValue == null) {
                String fieldErrorMessage = "Field '" + fieldName + "' of request body is not specified.\n";
                messageBuilder.append(fieldErrorMessage);
            }
            field.setAccessible(false);
        });

        if (!messageBuilder.isEmpty()) {
            String errorMessage = messageBuilder.substring(0, messageBuilder.lastIndexOf("\n"));
            throw new RuntimeException(errorMessage);
        }
    }

}
