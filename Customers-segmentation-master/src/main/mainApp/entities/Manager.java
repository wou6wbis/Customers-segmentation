package mainApp.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Manager {

    //Account manager ou chargé de clientèle

    @Id
    private String id;
    private String name;
    private String email;
    private double salary;

    public Manager() {
    }

    public Manager(String id) {
        this.id = id;
    }

    public Manager(String id, String name, String email, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
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
