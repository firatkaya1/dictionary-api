package com.limon.exception;

import java.time.LocalDateTime;

public class TypeNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TypeNotFoundException(Long id) {
        super("There is no type in this id:"+id);
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
