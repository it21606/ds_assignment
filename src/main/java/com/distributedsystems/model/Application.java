package com.distributedsystems.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "applications")
public class Application implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4310661683443846471L;

    /**
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private int id;

    @Column(name = "user_id")
    private long user_id;

    @Column(name = "income")
    private long income;

    @Column(name = "bothParentsUnemployed")
    private boolean bothParentsUnemployed;

    @Column(name = "hasSiblings")
    private boolean hasSiblings;

    @Column(name = "hasSiblingsInOtherCities")
    private boolean hasSiblingsInOtherCities;

    @Column(name = "status")
    private String status;

    public Application() {

    }

    public Application(long user_id, long income, boolean bothParentsUnemployed, boolean hasSiblings, boolean hasSiblingsInOtherCities,
                       String status) {
        super();
        this.user_id = user_id;
        this.income = income;
        this.bothParentsUnemployed = bothParentsUnemployed;
        this.hasSiblings = hasSiblings;
        this.hasSiblingsInOtherCities = hasSiblingsInOtherCities;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getIncome() {
        return income;
    }

    public void setIncome(long income) {
        this.income = income;
    }

    public boolean isBothParentsUnemployed() {
        return bothParentsUnemployed;
    }

    public void setBothParentsUnemployed(boolean bothParentsUnemployed) {
        this.bothParentsUnemployed = bothParentsUnemployed;
    }

    public boolean isHasSiblings() {
        return hasSiblings;
    }

    public void setHasSiblings(boolean hasSiblings) {
        this.hasSiblings = hasSiblings;
    }

    public boolean isHasSiblingsInOtherCities() {
        return hasSiblingsInOtherCities;
    }

    public void setHasSiblingsInOtherCities(boolean hasSiblingsInOtherCities) {
        this.hasSiblingsInOtherCities = hasSiblingsInOtherCities;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer [user_id=" + user_id + ", income=" + income + ", bothParentsUnemployed=" + bothParentsUnemployed + ", " +
                "hasSiblings=" + hasSiblings + ", hasSiblingsInOtherCities=" + hasSiblingsInOtherCities + "]";
    }



}
