package com.solvdinc.airport.fault;

public class InvalidReservationStatusException extends RuntimeException {

    public InvalidReservationStatusException() {}
    public InvalidReservationStatusException(String message) {
        super(message);
    }
}
