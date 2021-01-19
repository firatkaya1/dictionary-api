package com.limon.exception;

import com.limon.dto.Error;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author firatkaya1
 * @version 1.0.0
 * @since 19.01.2021
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    private ResponseEntity<Object> buildResponseEntity(Error error) {
        return new ResponseEntity<>(error, error.getStatus());
    }

    /**
     * This method is used to throwing exception when inserting
     * category name. If category name is already exists than this
     * exception will throw.
     * @param ex
     * @return HttpStatus.CONFLICT - 409
     */

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    protected ResponseEntity<Object> handleException(CategoryAlreadyExistsException ex) {
        Error apiError = new Error.of()
                .httpStatus(HttpStatus.CONFLICT)
                .errorCode(1)
                .message(ex.getMessage())
                .build();
        return buildResponseEntity(apiError);
    }

    /**
     * This method is used to throwing exception when searching
     * by category ID. If category ID is not exists in database
     * than this exception will throw.
     * @param ex
     * @return HttpStatus.NOT_FOUND - 404
     */

    @ExceptionHandler(CategoryNotFoundException.class)
    protected ResponseEntity<Object> handleException(CategoryNotFoundException ex) {
        Error apiError = new Error.of()
                .httpStatus(HttpStatus.NOT_FOUND)
                .errorCode(2)
                .message(ex.getMessage())
                .build();
        return buildResponseEntity(apiError);
    }

    /**
     * This method is used to throwing exception when inserting english
     * word to database. If english word is already exists in database
     * than this exception will throw.
     * @param ex
     * @return HttpStatus.CONFLICT - 409
     */

    @ExceptionHandler(EnglishWordAlreadyExistsException.class)
    protected ResponseEntity<Object> handleException(EnglishWordAlreadyExistsException ex) {
        Error apiError = new Error.of()
                .httpStatus(HttpStatus.CONFLICT)
                .errorCode(3)
                .message(ex.getMessage())
                .build();
        return buildResponseEntity(apiError);
    }

    /**
     * This method is used to throwing exception when searching english
     * word by ID. If english ID is not found in database
     * than this exception will throw.
     * @param ex
     * @return HttpStatus.NOT_FOUND - 404
     */

    @ExceptionHandler(EnglishWordNotFoundException.class)
    protected ResponseEntity<Object> handleException(EnglishWordNotFoundException ex) {
        Error apiError = new Error.of()
                .httpStatus(HttpStatus.NOT_FOUND)
                .errorCode(4)
                .message(ex.getMessage())
                .build();
        return buildResponseEntity(apiError);
    }

    /**
     * This method is used to throwing exception when searching english
     * word by ID. If english ID is not found in database
     * than this exception will throw.
     * @param ex
     * @return HttpStatus.CONFLICT - 409
     */
    @ExceptionHandler(TurkishWordAlreadyExistsException.class)
    protected ResponseEntity<Object> handleException(TurkishWordAlreadyExistsException ex) {
        Error apiError = new Error.of()
                .httpStatus(HttpStatus.CONFLICT)
                .errorCode(5)
                .message(ex.getMessage())
                .build();
        return buildResponseEntity(apiError);
    }

    /**
     * This method is used to throwing exception when searching english
     * word by ID. If english ID is not found in database
     * than this exception will throw.
     * @param ex
     * @return HttpStatus.CONFLICT - 409
     */

    @ExceptionHandler(TurkishWordNotFoundException.class)
    protected ResponseEntity<Object> handleException(TurkishWordNotFoundException ex) {
        Error apiError = new Error.of()
                .httpStatus(HttpStatus.CONFLICT)
                .errorCode(6)
                .message(ex.getMessage())
                .build();
        return buildResponseEntity(apiError);
    }

    /**
     * This method is used to throwing exception when searching english
     * word by ID. If english ID is not found in database
     * than this exception will throw.
     * @param ex
     * @return HttpStatus.CONFLICT - 409
     */

    @ExceptionHandler(TypeAlreadyExistsException.class)
    protected ResponseEntity<Object> handleException(TypeAlreadyExistsException ex) {
        Error apiError = new Error.of()
                .httpStatus(HttpStatus.CONFLICT)
                .errorCode(7)
                .message(ex.getMessage())
                .build();
        return buildResponseEntity(apiError);
    }

    /**
     * This method is used to throwing exception when searching
     * type by ID. If type ID is not found in database than
     * this exception will throw.
     * @param ex
     * @return HttpStatus.NOT_FOUND - 404
     */

    @ExceptionHandler(TypeNotFoundException.class)
    protected ResponseEntity<Object> handleException(TypeNotFoundException ex) {
        Error apiError = new Error.of()
                .httpStatus(HttpStatus.NOT_FOUND)
                .errorCode(8)
                .message(ex.getMessage())
                .build();
        return buildResponseEntity(apiError);
    }

}
