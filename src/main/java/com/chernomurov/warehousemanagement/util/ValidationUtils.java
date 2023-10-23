package com.chernomurov.warehousemanagement.util;

import org.springframework.http.RequestEntity;
import org.springframework.util.ReflectionUtils;

import java.util.List;
import java.util.Objects;

public class ValidationUtils {

    public static <T> void validateRequest(RequestEntity<T> request, List<String> fieldNamesToValidate) {
        T requestBody = Objects.requireNonNull(request.getBody());
        StringBuilder messageBuilder = new StringBuilder();
        ReflectionUtils.doWithFields(request.getClass(), field -> {
            String fieldName = field.getName();
            Object fieldValue = field.get(requestBody);
            if (fieldNamesToValidate.contains(fieldName) && fieldValue == null) {
                String fieldErrorMessage = "Field '" + fieldName + "' of request body is not specified.\n";
                messageBuilder.append(fieldErrorMessage);
            }
        });

        if (!messageBuilder.isEmpty()) {
            String errorMessage = messageBuilder.substring(0, messageBuilder.lastIndexOf("\n") - 1);
            throw new RuntimeException(errorMessage);
        }
    }

}
