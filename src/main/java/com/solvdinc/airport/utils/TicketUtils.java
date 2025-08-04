package com.solvdinc.airport.utils;

import com.solvdinc.airport.model.Ticket;

public final class TicketUtils {

    private TicketUtils() {
    }

    public static double calculateTotalPrice(Ticket[] tickets) {
        double total = 0;

        if (tickets != null) {

            for (int i = 0; i < tickets.length; i++) {

                Ticket currentTicket = tickets[i];
                if (currentTicket != null) {

                    double price = currentTicket.getPrice();
                    total = total + price;
                }
            }
        }
        return total;
    }
}
