package com.solvdinc.airport.constant;

import com.solvdinc.airport.fault.FlightAlreadyDepartedException;
import com.solvdinc.airport.fault.InvalidReservationStatusException;

public enum FlightStatus {
    SCHEDULED,
    DELAYED,
    BOARDING,
    DEPARTED
}
