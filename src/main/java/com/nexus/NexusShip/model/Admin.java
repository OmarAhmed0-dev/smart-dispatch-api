package com.nexus.NexusShip.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin_user")
public class Admin extends User{

    @Column(name = "salary")
    private double salary;



    public Admin(){}

    public Admin(String firstName, String lastName, Gender gender, String nationalId, String email, String password, String phoneNumber, double salary) {
        super(firstName, lastName, gender, nationalId, email, password, phoneNumber);
        this.salary = salary;
    }


    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "salary=" + salary +
                '}';
    }
}

