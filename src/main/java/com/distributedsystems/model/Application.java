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
    private long userId;

    @Column(name = "user_info")
    private String userInfo;

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
    private Long collectedPoints;

    @Column(name = "submission_period")
    private String submissionPeriod;

    private String statusDisplay;

    private String bothParentsUnemployedDisplay;

    private String hasSiblingsDisplay;

    private String hasSiblingsInOtherCitiesDisplay;

    public Application() {

    }

    public Application(long userId, long income, boolean bothParentsUnemployed, boolean hasSiblings, boolean hasSiblingsInOtherCities,
                       String status, Long collectedPoints, String submissionPeriod) {
        super();
        this.userId = userId;
        this.income = income;
        this.bothParentsUnemployed = bothParentsUnemployed;
        this.hasSiblings = hasSiblings;
        this.hasSiblingsInOtherCities = hasSiblingsInOtherCities;
        this.status = status;
        this.collectedPoints = collectedPoints;
        this.submissionPeriod = submissionPeriod;
    }

    public Application(long userId, String user_info, long income, boolean bothParentsUnemployed, boolean hasSiblings, boolean hasSiblingsInOtherCities, String status, Long collectedPoints, String statusDisplay,
                       String bothParentsUnemployedDisplay, String hasSiblingsDisplay, String hasSiblingsInOtherCitiesDisplay, String submissionPeriod) {
        this.userId = userId;
        this.userInfo = user_info;
        this.income = income;
        this.bothParentsUnemployed = bothParentsUnemployed;
        this.hasSiblings = hasSiblings;
        this.hasSiblingsInOtherCities = hasSiblingsInOtherCities;
        this.status = status;
        this.collectedPoints = collectedPoints;
        this.submissionPeriod = submissionPeriod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long user_id) {
        this.userId = user_id;
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

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String user_info) {
        this.userInfo = user_info;
    }

    public Long getCollected_points() {
        return collectedPoints;
    }

    public void setCollected_points(Long collectedPoints) {
        this.collectedPoints = collectedPoints;
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

    public Long getCollectedPoints() {
        return collectedPoints;
    }

    public void setCollectedPoints(Long collectedPoints) {
        this.collectedPoints = collectedPoints;
    }

    public String getSubmissionPeriod() {
        return submissionPeriod;
    }

    public void setSubmissionPeriod(String submissionPeriod) {
        this.submissionPeriod = submissionPeriod;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", user_id=" + userId +
                ", user_info='" + userInfo + '\'' +
                ", income=" + income +
                ", bothParentsUnemployed=" + bothParentsUnemployed +
                ", hasSiblings=" + hasSiblings +
                ", hasSiblingsInOtherCities=" + hasSiblingsInOtherCities +
                ", status='" + status + '\'' +
                ", collectedPoints=" + collectedPoints +
                ", submissionPeriod='" + submissionPeriod + '\'' +
                '}';
    }
}
