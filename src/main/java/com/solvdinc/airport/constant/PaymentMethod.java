package com.solvdinc.airport.constant;

import com.solvdinc.airport.fault.InvalidReservationStatusException;
import org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;

public enum PaymentMethod {
    VISA,
    PAYPAL,
    APPLE_PAY,
    AMEX,
    MASTERCARD;

    private static final Logger logger = LogManager.getLogger(PaymentMethod.class);

    public void validatePaymentMethod() throws InvalidReservationStatusException {
        switch (this) {
            case VISA:
            case MASTERCARD:
            case AMEX:
                logger.info("Processing Credit Card Payment.");
                break;
            case PAYPAL:
                logger.info("Processing PayPal Payment.");
                break;
            case APPLE_PAY:
                logger.info("Processing ApplePay Payment.");
                break;
            default:
                logger.error("Invalid Payment Method: {}", this);
                throw new InvalidReservationStatusException("Payments method is unknown: " + this);
        }
    }
}
