package com.solvdinc.airport.fault;

public class UnavailableSeatNumberException extends Exception {
    private String message;

    public UnavailableSeatNumberException() {
    }

    public UnavailableSeatNumberException(String message) {
        super(message);
    }
}
