package com.solvdinc.airport.functions;

import com.solvdinc.airport.model.Ticket;

import java.util.List;

@FunctionalInterface
public interface TicketCalculator {
    double calculatePrice(Ticket ticket);
}
