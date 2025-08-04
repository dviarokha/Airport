package com.solvdinc.airport.constant;

public record Baggage(String id, String weight, boolean isCheckIn) {

    @Override
    public String toString() {
        return "Baggage: " + id + " , weight  " + weight + ", " + isCheckIn;
    }
}
