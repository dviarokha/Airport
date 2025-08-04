package com.solvdinc.airport.model;

import java.util.List;

public class Airport {
    private String name;
    private String country;
    private String city;
    private String address;
    private String phone;
    private List<Terminal> terminals;
    private List<Flight> flights;
    private BookingSystem bookingSystem;
    private Service service;
    public static String airportCode = "WRO";

    public Airport() {
    }

    public Airport(String name, String country, String city, String address, String phone, String airportCode,
                   List<Terminal> terminals, List<Flight> flights, BookingSystem bookingSystem, Service service) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.terminals = terminals;
        this.flights = flights;
        this.bookingSystem = bookingSystem;
        this.service = service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        Airport.airportCode = airportCode;
    }

    public List<Terminal> getTerminal() {
        return terminals;
    }

    public void setTerminal(List<Terminal> terminals) {
        this.terminals = terminals;
    }

    public List<Flight> getFlight() {
        return flights;
    }

    public void setFlight(List<Flight> flights) {
        this.flights = flights;
    }

    public BookingSystem getBookingSystem() {
        return bookingSystem;
    }

    public void setBookingSystem(BookingSystem bookingSystem) {
        this.bookingSystem = bookingSystem;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Airport " +
                "name:'" + name + '\'' + country + '\'' +
                ", address: " + city + '\'' + address + '\'' +
                ", phone: " + phone + '\'' +
                "terminal " + terminals +
                "\nflight " + flights +
                "\nbookingSystem:" + bookingSystem +
                "\n service:" + service;
    }

}


