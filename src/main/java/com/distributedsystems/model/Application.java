package com.distributedsystems.model;

import javax.persistence.*;
import java.io.Serializable;




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

    @Column(name = "user_info")
    private String user_info;

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

    @Column(name = "collected_points")
    private Long collected_points;

    private String statusDisplay;

    private String bothParentsUnemployedDisplay;

    private String hasSiblingsDisplay;

    private String hasSiblingsInOtherCitiesDisplay;

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

    public Application(long user_id, String user_info, long income, boolean bothParentsUnemployed, boolean hasSiblings, boolean hasSiblingsInOtherCities, String status, Long collected_points, String statusDisplay,
                       String bothParentsUnemployedDisplay, String hasSiblingsDisplay, String hasSiblingsInOtherCitiesDisplay) {
        this.user_id = user_id;
        this.user_info = user_info;
        this.income = income;
        this.bothParentsUnemployed = bothParentsUnemployed;
        this.hasSiblings = hasSiblings;
        this.hasSiblingsInOtherCities = hasSiblingsInOtherCities;
        this.status = status;
        this.collected_points = collected_points;
        this.statusDisplay = statusDisplay;
        this.bothParentsUnemployedDisplay = bothParentsUnemployedDisplay;
        this.hasSiblingsDisplay = hasSiblingsDisplay;
        this.hasSiblingsInOtherCitiesDisplay = hasSiblingsInOtherCitiesDisplay;
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

    public String getUser_info() {
        return user_info;
    }

    public void setUser_info(String user_info) {
        this.user_info = user_info;
    }

    public Long getCollected_points() {
        return collected_points;
    }

    public void setCollected_points(Long collected_points) {
        this.collected_points = collected_points;
    }

    public String getStatusDisplay() {
        return statusDisplay;
    }

    public void setStatusDisplay(String statusDisplay) {
        this.statusDisplay = statusDisplay;
    }

    public String getBothParentsUnemployedDisplay() {
        return bothParentsUnemployedDisplay;
    }

    public void setBothParentsUnemployedDisplay(String bothParentsUnemployedDisplay) {
        this.bothParentsUnemployedDisplay = bothParentsUnemployedDisplay;
    }

    public String getHasSiblingsDisplay() {
        return hasSiblingsDisplay;
    }

    public void setHasSiblingsDisplay(String hasSiblingsDisplay) {
        this.hasSiblingsDisplay = hasSiblingsDisplay;
    }

    public String getHasSiblingsInOtherCitiesDisplay() {
        return hasSiblingsInOtherCitiesDisplay;
    }

    public void setHasSiblingsInOtherCitiesDisplay(String hasSiblingsInOtherCitiesDisplay) {
        this.hasSiblingsInOtherCitiesDisplay = hasSiblingsInOtherCitiesDisplay;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", user_info='" + user_info + '\'' +
                ", income=" + income +
                ", bothParentsUnemployed=" + bothParentsUnemployed +
                ", hasSiblings=" + hasSiblings +
                ", hasSiblingsInOtherCities=" + hasSiblingsInOtherCities +
                ", status='" + status + '\'' +
                ", collected_points=" + collected_points +
                '}';
    }
}
