package com.limon.exception;

import java.time.LocalDateTime;

/**
 * This error is thrown when the translate ID
 * is not found in the translate table.
 */

public class TranslateNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TranslateNotFoundException(Long id) {
        super("There is translate mapping in this id:"+id);
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
