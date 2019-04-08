package com.entities;

import javax.persistence.Column;
import javax.persistence.Id;

public class Hr {

    //Human resources responsible

    @Id @Column
    private String id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private double salary;

    public Hr() {
    }

    public Hr(String id, String name, String email, double salary) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
