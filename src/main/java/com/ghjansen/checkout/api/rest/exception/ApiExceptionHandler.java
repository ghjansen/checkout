package com.ghjansen.checkout.api.rest.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public final class ApiExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handle(final ConstraintViolationException e){
        ErrorResponse errors = new ErrorResponse();
        for(ConstraintViolation v : e.getConstraintViolations()){
            Error error = new Error();
            error.setCode(v.getMessageTemplate());
            error.setMessage(v.getMessage());
            errors.addError(error);
        }
        return new ResponseEntity<ErrorResponse>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Error> handle(final ResourceNotFoundException e){
        Error error = new Error();
        error.setMessage(e.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }

    private static class Error {

        @JsonInclude(JsonInclude.Include.NON_NULL) private String code;
        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    private static class ErrorResponse {

        private List<Error> errors = new ArrayList();

        public List<Error> getErrors() {
            return errors;
        }

        public void setErrors(List<Error> errors) {
            this.errors = errors;
        }

        public void addError(Error error){
            this.errors.add(error);
        }
    }
}