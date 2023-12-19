package com.example.artifactmanagement.exception;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException() {
        super();
    }

    public EmailNotFoundException(String message) {
        super(message);
    }
}
