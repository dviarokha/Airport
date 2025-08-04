package com.solvdinc.airport.model;

import com.solvdinc.airport.action.ICost;
import com.solvdinc.airport.fault.InvalidTicketException;
import com.solvdinc.airport.functions.TicketCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Ticket implements ICost {
    private String id;
    private String seatNumber;
    private double price;
    final double vat = 0.08;
    private boolean isCheckIn;

    public Ticket() {
    }

    private static Logger logger = LogManager.getLogger(Ticket.class);

    public Ticket(String id, String seatNumber, double price, boolean isCheckIn) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isCheckIn = isCheckIn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVat() {
        return vat;
    }

    public boolean isCheckIn() {
        return isCheckIn;
    }

    public void setCheckIn(boolean checkIn) {
        isCheckIn = checkIn;
    }


    @Override
    public String toString() {
        return "Ticket{" + id + '\'' +
                ", seatNumber " + seatNumber + '\'' +
                ", price " + price + "VAT " + vat + "Total Price: " + getTotalPrice() +
                "\n isCheckIn=" + isCheckIn;
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
        Ticket ticket = (Ticket) o;
        return id.equals(ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public double getTaxAmount() {
        return price * vat;
    }

    @Override
    public double getTotalPrice() {
        return getTaxAmount() + getPrice();
    }


    public void TaxAmount() {
        System.out.println("Tax Amount: " + getTaxAmount());
    }

    public void TotalPrice() {
        System.out.println("Total Price: " + getTotalPrice());
    }

    public void validateTicket() throws InvalidTicketException {
        if (id == null || id.isEmpty()) {
            logger.error("Ticket validation is failed. ID {} is empty", id);
            throw new InvalidTicketException("Ticket ID is Empty");
        }
        if (seatNumber == null || seatNumber.isEmpty()) {
            logger.error("Ticket validation is failed. SEAT NUMBER {} is empty", seatNumber);
            throw new InvalidTicketException("Seat Number is Empty");
        }
        if (price < 0) {
            logger.error("Ticket validation is failed. Price {} is negative", price);
            throw new InvalidTicketException("Price cannot be Negative or Zero");
        }
    }

    public static List<Ticket> filterTicket(List<Ticket> ticketList, Predicate<Ticket> predicate ) {
        List<Ticket> filteredList = new ArrayList<>();
        for (Ticket ticket : ticketList) {
            if (predicate.test(ticket)) {
                filteredList.add(ticket);
            }
        }
        return filteredList;
    }

    public static int countValidTickets(List<Ticket> ticketList, Predicate<Ticket> predicate ) {
        int count = 0;
        for (Ticket ticket : ticketList) {
            if (predicate.test(ticket)) {
                count++;
            }
        }
        return count;
    }


    public static double calculateTotalPrice(List<Ticket> ticketList, TicketCalculator calculator ) {
        if (ticketList == null || ticketList.isEmpty()) {
            return 0;
        }
        double totalPrice = 0;
        for (Ticket ticket : ticketList) {
            if (ticket != null) {
                totalPrice += calculator.calculatePrice(ticket);
            }
        }
        return totalPrice;
    }
}
