package org.example.exception;

public class SignInException extends RuntimeException{
    public SignInException(String message) {
        super(message);
    }
}
