package com.avazon.ecommerce.exception;

public class AuthFieldsMissingException extends Exception{

    public AuthFieldsMissingException() {
    }

    public AuthFieldsMissingException(String message) {
        super(message);
    }
}
