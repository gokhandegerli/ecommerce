package com.avazon.ecommerce.exception;

public class RegisterFieldsMissingException extends Exception{

    public RegisterFieldsMissingException() {
    }

    public RegisterFieldsMissingException(String message) {
        super(message);
    }
}
