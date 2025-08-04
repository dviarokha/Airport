package com.solvdinc.airport.model;

import java.util.List;

public class BookingSystem {
    private String name;
    private List<Payment> payments;
    private List<Reservation> reservations;

    public BookingSystem() {
    }

    public BookingSystem(String name, List<Payment> payments, List<Reservation> reservations) {
        this.name = name;
        this.payments = payments;
        this.reservations = reservations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }


    @Override
    public String toString() {
        return "BookingSystem:  " + name
                + "\n payments: " + payments + ", reservations:" + reservations;
    }
}
