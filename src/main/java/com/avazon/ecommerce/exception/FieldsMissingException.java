package com.avazon.ecommerce.exception;

public class FieldsMissingException extends Exception{

    public FieldsMissingException() {
    }

    public FieldsMissingException(String message) {
        super(message);
    }
}
