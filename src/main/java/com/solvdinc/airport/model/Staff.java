package com.solvdinc.airport.model;

import com.solvdinc.airport.fault.InvalidStaffIdException;
import com.solvdinc.airport.constant.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Staff extends Person {
    private Role role;


    public Staff(int id, String name, String surname, Role role) {
        super(id, name, surname);
        this.role = role;
    }

    private static Logger logger = LogManager.getLogger(Staff.class);

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return " Staff role: " + getId() + ", " + getName() + ", " + getSurname() + ", " + role;
    }

    public void validateID() throws InvalidStaffIdException {
        if (this.getId() <= 0) {
            logger.error("Validation of Staff is failed - Staff ID {} is invalid.", this.getId());
            throw new InvalidStaffIdException("Invalid Staff ID");
        }
    }

}
