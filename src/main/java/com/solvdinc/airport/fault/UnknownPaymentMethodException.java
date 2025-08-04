package com.solvdinc.airport.fault;

public class UnknownPaymentMethodException extends RuntimeException {

    public UnknownPaymentMethodException() {}
    public UnknownPaymentMethodException(String message) {
        super(message);
    }
}
