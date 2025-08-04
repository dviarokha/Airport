package com.solvdinc.airport.fault;

public class UncheckedBaggageException extends Exception {

    public String message;

    public UncheckedBaggageException() {
    }

    public UncheckedBaggageException(String message) {
        super(message);
    }
}
