package com.limon.exception;

import com.limon.entity.Category;

import java.time.LocalDateTime;

public class CategoryAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CategoryAlreadyExistsException(Category category) {
        super("There is already category name in this value :"+category.getName()+" id :"+category.getId());
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
