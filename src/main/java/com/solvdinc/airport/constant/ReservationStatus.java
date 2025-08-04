package com.solvdinc.airport.constant;

import com.solvdinc.airport.fault.InvalidReservationStatusException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum ReservationStatus {
    CONFIRMED,
    PENDING,
    CANCELLED,
    EXPIRED;

    private static final Logger logger = LogManager.getLogger(ReservationStatus.class);


    public void validateStatusForCheckIn() throws InvalidReservationStatusException {
        switch (this) {
            case CANCELLED:
            case EXPIRED:
            default:
                logger.error("Invalid reservation status: {} ", this);
                throw new InvalidReservationStatusException("Reservation status is INVALID");

        }
    }
}
