package com.kata.rpncalculator.exceptions;

public class StackNotFoundException extends RuntimeException{
    public StackNotFoundException(final String message) {
        super(message);
    }
}
