package com.solvdinc.airport.fault;

public class InvalidStaffIdException extends Exception {

    private String message;

    public InvalidStaffIdException() {
    }

    public InvalidStaffIdException(String message) {
        super(message);
    }
}
