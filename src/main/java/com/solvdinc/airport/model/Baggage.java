package com.solvdinc.airport.model;

import com.solvdinc.airport.fault.UncheckedBaggageException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Baggage {
    private String id;
    private String weight;
    private boolean isCheckIn;

    public Baggage() {
    }

    private static Logger logger = LogManager.getLogger(Baggage.class);

    public Baggage(String id, String weight, boolean isCheckIn) {
        this.id = id;
        this.weight = weight;
        this.isCheckIn = isCheckIn;
    }

    public String getId() {
        return id;
    }

    public String getWeight() {
        return weight;
    }

    public boolean isCheckIn() {
        return isCheckIn;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setCheckIn(boolean checkIn) {
        isCheckIn = checkIn;
    }

    @Override
    public String toString() {
        return "Baggage: " + id + " , weight  " + weight + ", " + isCheckIn;
    }

    public void checkIfCheckIn(Baggage baggage) throws UncheckedBaggageException {
        if (!baggage.isCheckIn()) {
            logger.error("Baggage check failed — baggage is not checked in. ID - {} ", baggage.getId());
            throw new UncheckedBaggageException("Baggage is not checked in.");
        }
    }
}
