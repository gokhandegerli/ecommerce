package com.avazon.ecommerce.exception;

public class AlreadyExistException extends Exception{

    public AlreadyExistException(String message) {
        super(message);
    }

    public AlreadyExistException() {};
}
