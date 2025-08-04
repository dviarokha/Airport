package com.solvdinc.airport.action;

import com.solvdinc.airport.fault.UnavailableSeatNumberException;
import com.solvdinc.airport.model.Ticket;

public interface ISearch {
    Ticket searchTicketBySeatNumber(String seatNumber) throws UnavailableSeatNumberException;
}
