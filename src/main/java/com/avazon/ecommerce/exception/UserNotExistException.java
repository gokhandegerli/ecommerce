package com.avazon.ecommerce.exception;

public class UserNotExistException extends Exception{

    public UserNotExistException() {
    }

    public UserNotExistException(String message) {
        super(message);
    }
}
