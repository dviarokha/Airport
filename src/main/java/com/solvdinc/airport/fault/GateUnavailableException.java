package com.solvdinc.airport.fault;

public class GateUnavailableException extends Exception {
    private String message;

    public GateUnavailableException() {
    }

    public GateUnavailableException(String message) {
        super(message);
    }
}
