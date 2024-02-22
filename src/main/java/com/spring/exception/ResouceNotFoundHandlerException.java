package com.spring.exception;


public class ResouceNotFoundHandlerException extends RuntimeException{

    public ResouceNotFoundHandlerException() {
    }

    public ResouceNotFoundHandlerException(String message) {
        super(message);
    }
}
