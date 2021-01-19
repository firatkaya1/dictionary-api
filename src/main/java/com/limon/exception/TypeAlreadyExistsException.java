package com.limon.exception;

import com.limon.entity.Type;

import java.time.LocalDateTime;

/**
 * This error is thrown when the value
 * is already exists in the type table.
 */

public class TypeAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TypeAlreadyExistsException(Type type) {
        super("There is already type name in this value :"+type.getName()+" id :"+type.getId());
    }

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public LocalDateTime getTime() {
        return LocalDateTime.now();
    }

}
