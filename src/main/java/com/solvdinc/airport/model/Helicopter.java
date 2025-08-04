package com.solvdinc.airport.model;

import com.solvdinc.airport.action.IFly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Helicopter extends Airplane implements IFly {
    private String type;
    private double maxSpeed;
    private boolean autopilotEnabled;

    public Helicopter() {
    }

    private static final Logger logger = LogManager.getLogger(Helicopter.class);

    public Helicopter(String model, String registrationNumber, String type, double maxSpeed, boolean autopilotEnabled) {
        super(model, registrationNumber);
        this.type = type;
        this.maxSpeed = maxSpeed;
        this.autopilotEnabled = autopilotEnabled;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isAutopilotEnabled() {
        return autopilotEnabled;
    }

    public void setAutopilotEnabled(boolean autopilotEnabled) {
        this.autopilotEnabled = autopilotEnabled;
    }

    @Override
    public void fly() {
        logger.info("Helicopter" + " " +  getModel() + " " + type + " is flying at low altitude for rescue operations.");
    }

    @Override
    public void land() {
        logger.info("Helicopter" + " " + getModel() + " lands gently on the helipad.");
    }

    @Override
    public void takeoff() {
        logger.info("For helicopter airport staff are performing  engine check before flight.");
    }

}
