package com.solvdinc.airport.model;

import com.solvdinc.airport.constant.ReservationStatus;

import java.util.List;
import java.util.Objects;

public class Reservation {
    private String id;
    private ReservationStatus status;
    private List<Ticket> tickets;


    public Reservation() {
    }

    public Reservation(String id, ReservationStatus status, List<Ticket> tickets) {
        this.id = id;
        this.status = status;
        this.tickets = tickets;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public List<Ticket> getTicket() {
        return tickets;
    }

    public void setTicket(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Reservation" + id + '\'' +
                ", status " + status + ", ticket " + tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Reservation that = (Reservation) o;
        return this.id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
