package com.solvdinc.airport.fault;

public class FlightAlreadyDepartedException extends Exception {
    public FlightAlreadyDepartedException() {}
    public FlightAlreadyDepartedException(String message) {
        super(message);
    }
}
