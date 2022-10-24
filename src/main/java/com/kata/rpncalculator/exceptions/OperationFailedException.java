package com.kata.rpncalculator.exceptions;

public class OperationFailedException extends RuntimeException{
    public OperationFailedException(final String message) {
        super(message);
    }
}
