package mainApp.entities;

import mainApp.entities.Manager;

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
    private double annualIncome;
    private double spendingScore;
    private String cluster;

    @ManyToOne
    private Manager manager;

    public Client() {
    }

    public Client(String id, String name, String email, double income, double spendingScoreore, String managerId) {
        this.id = id;
        this.name = name;
        this.email = email;
        //this.gender=gender;
        this.annualIncome = income;
        this.spendingScore = spendingScoreore;
        this.manager = new Manager("");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public double getIncome() {
        return annualIncome;
    }

    public double getScore() {
        return spendingScore;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public void setIncome(double income) {
        this.annualIncome = income;
    }

    public void setScore(double spendingScoreore) {
        this.spendingScore = spendingScoreore;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
