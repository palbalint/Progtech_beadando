package com.Exceptions;

public class InvalidPaymentException extends Exception {
    public InvalidPaymentException(String errorMessage) {
        super(errorMessage);
    }
}
