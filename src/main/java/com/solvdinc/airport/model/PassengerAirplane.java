package com.solvdinc.airport.model;

import com.solvdinc.airport.action.IFly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PassengerAirplane extends Airplane implements IFly {
    private String number;
    private int seats;
    private String serviceClass;

    public PassengerAirplane() {
    }

    private static final Logger logger = LogManager.getLogger(PassengerAirplane.class);

    public PassengerAirplane(String model, String registrationNumber, String number, int seats, String serviceClass) {
        super(model, registrationNumber);
        this.number = number;
        this.seats = seats;
        this.serviceClass = serviceClass;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getServiceClass() {
        return serviceClass;
    }

    public void setServiceClass(String serviceClass) {
        this.serviceClass = serviceClass;
    }

    @Override
    public String toString() {
        return "Passenger Aircraft " + getModel() + getRegistrationNumber() +
                "seats " + seats +
                ", serviceClass '" + serviceClass;
    }


    @Override
    public void takeoff() {
        logger.info("Passenger Aircraft" + getModel() + number + "lands smoothly at the airport.");
    }

    @Override
    public void land() {
        logger.info("Passenger Aircraft" + getModel() + number + "takes off from the main runway.");
    }

    @Override
    public void fly() {
       logger.info("PassengerAirplane " + getModel() + number + " fly between cities every day.");
    }

}
