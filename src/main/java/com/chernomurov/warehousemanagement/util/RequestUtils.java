package com.chernomurov.warehousemanagement.util;

import jakarta.persistence.Entity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Slf4j
public class RequestUtils {

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

    public static <E, R> E getEntityFromRequest(R request, Class<E> entityClass) {
        E entity;
        try {
            entity = entityClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate entity.");
        }
        ReflectionUtils.doWithFields(request.getClass(), fieldOfRequest -> {
            ReflectionUtils.makeAccessible(fieldOfRequest);

            try {
                Field fieldOfEntity = entity.getClass().getDeclaredField(fieldOfRequest.getName());
                if (fieldOfEntity.isAnnotationPresent(Entity.class)) {
                    // Handle the case when the field is annotated with @Entity
                    // You can throw an exception or implement your logic here
                    log.warn("Field is annotated with @Entity");
                } else if (fieldOfRequest.getType().isAssignableFrom(Collection.class)) {
                    // Handle the case when the field is a collection (e.g., Set)
                    // You can throw an exception or implement your logic here
                    log.warn("Field is a collection");
                } else {
                    fieldOfEntity.setAccessible(true);
                    ReflectionUtils.setField(fieldOfEntity, entity, ReflectionUtils.getField(fieldOfRequest, request));
                    fieldOfEntity.setAccessible(false);
                }
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        });

        return entity;
    }

}
