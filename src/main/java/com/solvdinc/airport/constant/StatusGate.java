package com.solvdinc.airport.constant;

import com.solvdinc.airport.fault.GateUnavailableException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum StatusGate {
    SCHEDULED,
    BOARDING,
    CLOSED,
    DEPARTED;

    private static final Logger logger = LogManager.getLogger(StatusGate.class);

    public void validateBoarding() throws GateUnavailableException {
        switch (this) {
            case SCHEDULED:
                logger.info("Flight is scheduled");
                break;
            case BOARDING:
                logger.info("Boarding is in process for flight.");
                break;
            case CLOSED:
                logger.info("Gate is closed");
                break;
            case DEPARTED:
                logger.info("Flight has already departed");
                break;
            default:
                logger.error("Unknown StatusGate. {} ", this);
                throw new GateUnavailableException("Gate status is unknown.");
        }
    }
}
