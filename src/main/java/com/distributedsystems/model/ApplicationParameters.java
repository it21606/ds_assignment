package com.distributedsystems.model;


import javax.persistence.*;

@Entity
@Table(name = "parameters")
public class ApplicationParameters {

    private static final long serialVersionUID = 4310661683443846471L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "current_period")
    private String currentPeriod;

    @Column(name = "applications_enabled")
    private boolean applicationsEnabled;

    @Column(name = "max_applicants")
    private Long maxApplicants;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(String currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public boolean isApplicationsEnabled() {
        return applicationsEnabled;
    }

    public void setApplicationsEnabled(boolean applicationsEnabled) {
        this.applicationsEnabled = applicationsEnabled;
    }

    public Long getMaxApplicants() {
        return maxApplicants;
    }

    public void setMaxApplicants(Long maxApplicants) {
        this.maxApplicants = maxApplicants;
    }

    @Override
    public String toString() {
        return "ApplicationParameters{" +
                "id=" + id +
                ", currentPeriod='" + currentPeriod + '\'' +
                ", applicationsEnabled=" + applicationsEnabled +
                ", maxApplicants=" + maxApplicants +
                '}';
    }
}
