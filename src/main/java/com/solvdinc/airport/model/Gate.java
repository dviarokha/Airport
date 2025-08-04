package com.solvdinc.airport.model;

import com.solvdinc.airport.constant.StatusGate;
import com.solvdinc.airport.action.IWork;
import com.solvdinc.airport.fault.GateUnavailableException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;

public class Gate implements IWork {
    private String number;
    private LocalTime openTime;
    private LocalTime closeTime;
    private StatusGate statusGate;
    private Staff staff;


    private static final Logger logger = LogManager.getLogger(Gate.class);

    public Gate() {
    }

    public Gate(String number, LocalTime openTime, LocalTime closeTime, StatusGate statusGate, Staff staff) {
        this.number = number;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.statusGate = statusGate;
        this.staff = staff;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
    }

    public StatusGate getStatusGate() {
        return statusGate;
    }

    public void setStatusGate(StatusGate statusGate) {
        this.statusGate = statusGate;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Gate" + number + '\'' +
                ", openTime " + openTime + ", closeTime=" + closeTime +
                ", statusGate " + statusGate + '\'' +
                ", staff " + staff;
    }

    @Override
    public void open() {
        logger.info(getNumber() + " open from " + openTime + " to " + closeTime);
    }

    @Override
    public void close() {
        logger.info(getNumber() + " is closing from " + closeTime + " to " + openTime);

    }

    public void validateNumber(String number) throws GateUnavailableException {
        if (this.number == null || number.length() == 0) {
            logger.error("Validation of gate number is failed - Gate number is null or empty, number: {} ", number);
            throw new GateUnavailableException("Gate number is unavailable.");
        }

    }

}


