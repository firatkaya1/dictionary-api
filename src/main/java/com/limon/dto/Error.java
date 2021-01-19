package com.limon.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)    //  ignore all null fields
public class Error {

    public static class of {

        private HttpStatus status;
        private int errorCode;
        private String errorMessage;
        private String path;
        private List<String> errorDetails;

        public of httpStatus(HttpStatus status) {
            this.status = status;
            return this;
        }

        public of errorCode(int errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public of message(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public of path(String path) {
            this.path = path.substring(path.indexOf("=") + 1, path.indexOf(";"));
            return this;
        }

        public of errorDetails(List<String> errors) {
            this.errorDetails = errors;
            return this;
        }

        public Error build() {
            return new Error(this);
        }

    }

    private HttpStatus status;
    private int errorCode;
    private String errorMessage;
    private List<String> errorDetails;
    private LocalDateTime timestamp;
    private String path;


    public Error(of build) {
        this.status = build.status;
        this.errorCode = build.errorCode;
        this.errorMessage = build.errorMessage;
        this.timestamp = LocalDateTime.now();
        this.path = build.path;
        this.errorDetails = build.errorDetails;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getPath() {
        return path;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }


    public List<String> getErrorDetails() {
        return errorDetails;
    }


}
