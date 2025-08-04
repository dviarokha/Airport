package com.solvdinc.airport.model;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class Airplane {
    private String model;
    private String registrationNumber;

    private static final Logger logger = LogManager.getLogger(Airplane.class);

    public Airplane() {
    }

    public Airplane(String model, String registrationNumber) {
        this.model = model;
        this.registrationNumber = registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {

        this.registrationNumber = registrationNumber;
    }

    public final void printInfo() {
        logger.info("Model: " + model);
        logger.info("Registration Number: " + registrationNumber);
    }

}
