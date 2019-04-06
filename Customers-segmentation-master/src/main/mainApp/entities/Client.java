package mainApp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Client {


    @Id
    private String id;
    private String name;
    private String email;
    //private Gender gender;
    private double income;
    private double score;
    private String cluster;

    @ManyToOne
    private Manager manager;

    public Client() {
    }

    public Client(String id, String name, String email, double income, double score, String managerId) {
        this.id = id;
        this.name = name;
        this.email = email;
        //this.gender=gender;
        this.income = income;
        this.score = score;
        this.manager = new Manager("");
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

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
