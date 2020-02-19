package com.distributedsystems.service;

import com.distributedsystems.model.Application;
import com.distributedsystems.web.viewmodel.ApplicationViewModel;

import java.util.List;


public interface ApplicationService {

    Application findById(int id);

    Application save(Application application);

    Application update(ApplicationViewModel applicationViewModel);

    List<Application> findAll();
}
