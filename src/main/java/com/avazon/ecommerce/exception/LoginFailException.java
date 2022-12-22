package com.avazon.ecommerce.exception;


public class LoginFailException extends Exception{

    public LoginFailException() {
    }

    public LoginFailException(String message) {
        super(message);
    }
}
