package com.distributedsystems.web.viewmodel;

public class ApplicationViewModel {


    private int id;

    private long userId;

    private String userInfo;

    private long income;

    private Long collectedPoints;

    private String submissionPeriod;

    private String statusDisplay;

    private String bothParentsUnemployedDisplay;

    private String hasSiblingsDisplay;

    private String hasSiblingsInOtherCitiesDisplay;

    public ApplicationViewModel() {

    }

    public ApplicationViewModel(long userId, long income, Long collectedPoints, String submissionPeriod) {
        super();
        this.userId = userId;
        this.income = income;
        this.collectedPoints = collectedPoints;
        this.submissionPeriod = submissionPeriod;
    }

    public ApplicationViewModel(long userId, String user_info, long income, Long collectedPoints, String statusDisplay,
                                String bothParentsUnemployedDisplay, String hasSiblingsDisplay, String hasSiblingsInOtherCitiesDisplay, String submissionPeriod) {
        this.userId = userId;
        this.userInfo = user_info;
        this.income = income;
        this.collectedPoints = collectedPoints;
        this.submissionPeriod = submissionPeriod;
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
                ", collectedPoints=" + collectedPoints +
                ", submissionPeriod='" + submissionPeriod + '\'' +
                '}';
    }
}
