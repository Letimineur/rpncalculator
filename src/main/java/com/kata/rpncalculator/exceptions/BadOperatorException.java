package com.kata.rpncalculator.exceptions;

public class BadOperatorException extends RuntimeException{
    public BadOperatorException(final String message) {
        super(message);
    }
}
