package com.limon.exception;

import com.limon.entity.Turkish;

import java.time.LocalDateTime;

/**
 * This error is thrown when the value
 * is already exists in the turkish table.
 */

public class TurkishWordAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TurkishWordAlreadyExistsException(Turkish turkish) {
        super("There is already turkish word in this value :"+turkish.getWord()+" id :"+turkish.getId());
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
