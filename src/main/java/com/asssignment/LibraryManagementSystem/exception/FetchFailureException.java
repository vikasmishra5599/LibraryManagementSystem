package com.asssignment.LibraryManagementSystem.exception;

public class FetchFailureException extends RuntimeException{
    public FetchFailureException(String message, Exception e) {
        super(message, e);
    }
}
