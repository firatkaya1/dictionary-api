package com.limon.exception;

import com.limon.entity.English;
import com.limon.entity.Turkish;

import java.time.LocalDateTime;

/**
 * This error is thrown when the same english
 * word is found in the english table.
 */

public class EnglishWordAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EnglishWordAlreadyExistsException(English english) {
        super("There is already english word in this value :"+english.getWord()+" id :"+english.getId());
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
