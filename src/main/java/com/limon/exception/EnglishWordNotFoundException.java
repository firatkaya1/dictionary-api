package com.limon.exception;

import java.time.LocalDateTime;

/**
 * This error is thrown when the value
 * is not found in the english table.
 */
public class EnglishWordNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EnglishWordNotFoundException(Long id) {
        super("There is no english word in this id:"+id);
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
