package com.solvdinc.airport.constant;

import com.solvdinc.airport.fault.UnknownStaffRoleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum Role {
    PILOT,
    CO_PILOT,
    FLIGHT_ATTENDANT,
    GROUND_STAFF,
    AIR_TRAFFIC_CONTROLLER,
    MAINTENANCE_ENGINEER,
    SECURITY_PERSONNEL,
    CUSTOMER_SERVICE_AGENT,
    BAGGAGE_HANDLER,
    CHECK_IN_AGENT,
    PARKING_AGENT,
    SHOP_AGENT;

    private static final Logger logger = LogManager.getLogger(Role.class);

    public void handRole() throws UnknownStaffRoleException {
        switch (this) {
            case PILOT:
            case CO_PILOT:
            case FLIGHT_ATTENDANT:
                logger.info("Staff is working on the plane");
                break;
            case GROUND_STAFF:
            case AIR_TRAFFIC_CONTROLLER:
                logger.info("Staff is working around runways");
                break;
            case MAINTENANCE_ENGINEER:
                logger.info("Staff is support airplane");
                break;
            case SECURITY_PERSONNEL:
            case CUSTOMER_SERVICE_AGENT:
            case CHECK_IN_AGENT:
                logger.info("Staff is working in the airport, in Terminal and Gate areas.");
                break;
            case BAGGAGE_HANDLER:
                logger.info("Staff help with baggage after and before flight.");
                break;
            case PARKING_AGENT:
            case SHOP_AGENT:
                logger.info("Staff is working in Airport Service.");
                break;
            default:
                logger.error("Staff has been handled. {} ", this);
                throw new UnknownStaffRoleException("Unknown Staff Role: " + this);
        }
    }
}
