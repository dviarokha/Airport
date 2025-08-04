package com.solvdinc.airport.fault;

import com.solvdinc.airport.model.Ticket;

public class InvalidTicketException extends Exception {

    public InvalidTicketException() {}

    public InvalidTicketException(String message) {
        super(message);
    }

}
