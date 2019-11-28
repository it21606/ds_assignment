package com.distributedsystems.service;

import com.distributedsystems.model.Application;
import com.distributedsystems.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService{


    private final ApplicationRepository _applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        _applicationRepository = applicationRepository;
    }

    public Application findById(int id){
        return _applicationRepository.findById(id);
    }

    @Override
    public List<Application> findAll() {
        return _applicationRepository.findAll();
    }
}
