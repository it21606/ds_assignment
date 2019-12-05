package com.distributedsystems.service;

import com.distributedsystems.model.Application;

import java.util.List;


public interface ApplicationService {

    Application findById(int id);

    Application save(Application application);

    List<Application> findAll();
}
