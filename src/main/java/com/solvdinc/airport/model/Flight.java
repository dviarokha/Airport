package com.solvdinc.airport.model;

import com.solvdinc.airport.constant.FlightStatus;

import java.util.List;

public class Flight {
    private FlightStatus flightStatus;
    private String flightNumber;
    private Airplane airplane;
    private Gate gate;
    private List<Passenger> passengers;

    public Flight() {
    }

    public Flight(FlightStatus flightStatus, String flightNumber, Airplane airplane, Gate gate, List<Passenger> passengers) {
        this.flightStatus = flightStatus;
        this.flightNumber = flightNumber;
        this.airplane = airplane;
        this.gate = gate;
        this.passengers = passengers;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public List<Passenger> getPassenger() {
        return passengers;
    }

    public void setPassenger(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Flight " + flightStatus + '\'' +
                " flightNumber " + flightNumber + '\'' +
                ", airplane=" + airplane +
                "\n gate " + gate +
                "\n passenger " + passengers;
    }
}
