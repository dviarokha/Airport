package com.solvdinc.airport.model;

import com.solvdinc.airport.action.ISearch;
import com.solvdinc.airport.fault.UnavailableSeatNumberException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class TicketSearchService implements ISearch {
    private List<Ticket> tickets;

    private static final Logger logger = LogManager.getLogger(TicketSearchService.class);

    public TicketSearchService(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public Ticket searchTicketBySeatNumber(String seatNumber) throws UnavailableSeatNumberException {
        for (Ticket ticket : tickets) {
            if (ticket.getSeatNumber().equals(seatNumber)) {
                return ticket;
            }
        }
        logger.error("Searching of ticket is failed. Ticket seatNumber {} not found", seatNumber);
        throw new UnavailableSeatNumberException("Ticket with" + seatNumber + " not found");
    }
}
