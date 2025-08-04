package com.solvdinc.airport.model;

import java.util.List;

public class Passenger extends Person {
    private List<Ticket> tickets;
    private List<Baggage> baggage;


    public Passenger() {
    }

    public Passenger(int id, String name, String surname, List<Ticket> tickets, List<Baggage> baggage) {
        super(id, name, surname);
        this.tickets = tickets;
        this.baggage = baggage;
    }

    public List<Ticket> getTicket() {
        return tickets;
    }

    public void setTicket(List<Ticket> ticket) {
        this.tickets = tickets;
    }

    public List<Baggage> getBaggage() {
        return baggage;
    }

    public void setBaggage(List<Baggage> baggage) {
        this.baggage = baggage;
    }

    @Override
    public String toString() {
        return "Passenger " + getId() + " " + getName() + " " + getSurname() + " " +
                "\nticket=" + tickets + " baggage " + baggage;
    }

}
