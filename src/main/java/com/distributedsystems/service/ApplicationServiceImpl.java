package com.distributedsystems.service;

import com.distributedsystems.model.Application;
import com.distributedsystems.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    private ApplicationRepository applicationRepository;

    public Application findById(int id){
        return applicationRepository.findById(id);
    }
}
