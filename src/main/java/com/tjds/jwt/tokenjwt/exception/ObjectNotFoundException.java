package com.tjds.jwt.tokenjwt.exception;

import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends RuntimeException {

    private final HttpStatus httpStatus;

    private final String errorMessage;

    public ObjectNotFoundException(HttpStatus httpStatus, String message) {
        this.errorMessage = message;
        this.httpStatus = httpStatus;
    }

}
