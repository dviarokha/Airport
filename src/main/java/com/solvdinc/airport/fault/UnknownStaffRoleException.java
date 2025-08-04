package com.solvdinc.airport.fault;

public class UnknownStaffRoleException extends RuntimeException {

    public UnknownStaffRoleException() {}
    public UnknownStaffRoleException(String message) {
        super(message);
    }
}
