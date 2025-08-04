package com.solvdinc.airport.model;

import java.util.Arrays;
import java.util.List;

public class Terminal {
    private String name;
    private String type;
    private List<Staff> staff;


    public Terminal() {
    }

    public Terminal(String name, String type, List<Staff> staff) {
        this.name = name;
        this.type = type;
        this.staff = staff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Terminal " +
                ", name " + name + '\'' + ", type " + type + '\'' +
                ", staff=" + staff;
    }

}


