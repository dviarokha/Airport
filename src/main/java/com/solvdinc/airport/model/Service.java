package com.solvdinc.airport.model;

import java.util.Arrays;
import java.util.List;

public class Service {
    private String name;
    private String location;
    private List<Staff> staff;

    public Service() {
    }

    public Service(String name, String location, List<Staff> staff) {
        this.name = name;
        this.location = location;
        this.staff = staff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Service{" + name + '\'' + location + '\'' +
                ", staff " + staff;
    }
}
