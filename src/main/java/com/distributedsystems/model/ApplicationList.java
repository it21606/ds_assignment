package com.distributedsystems.model;

import org.springframework.stereotype.Component;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class ApplicationList {

    List<Application> applicationList;

    public List<Application> getCustomerList(){
        return applicationList;
    }

    public void setCustomerList(List<Application> applicationList) {
        this.applicationList=applicationList;
    }

}
