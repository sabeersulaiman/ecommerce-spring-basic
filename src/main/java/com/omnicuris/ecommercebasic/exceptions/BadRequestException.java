package com.omnicuris.ecommercebasic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public BadRequestException( String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s cannot take value %s for property '%s'", resourceName, fieldValue, fieldName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
