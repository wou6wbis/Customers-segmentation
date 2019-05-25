package com.entities;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "manager")
public class Manager {

    //Account manager ou chargé de clientèle

    @Id
    @Column
    private String id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private double salary;

    @OneToMany(mappedBy = "manager", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Collection<Client> clients;


    public Manager() {
    }

    public Manager(String id) {
        this.id = id;
    }

    public Manager(String id, String name, String email, double salary, Collection<Client> clients) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.clients = clients;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
