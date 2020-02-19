package com.distributedsystems.service;

import com.distributedsystems.helpers.Helpers;
import com.distributedsystems.model.Application;
import com.distributedsystems.repository.ApplicationRepository;
import com.distributedsystems.web.viewmodel.ApplicationViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {


    private final ApplicationRepository _applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this._applicationRepository = applicationRepository;
    }

    public Application findById(int id) {
        return _applicationRepository.findById(id);
    }

    public Application save(Application application) {
        if (application != null) {
            return _applicationRepository.save(application);
        } else {
            return null;
        }
    }

    public Application update(ApplicationViewModel applicationViewModel) {
        if (applicationViewModel != null) {
            Application application = findById(applicationViewModel.getId());
            application.setStatus(Helpers.statusStatusMap.get(applicationViewModel.getStatusDisplay()));
            return _applicationRepository.save(application);
        }
        return new Application();
    }
    @Override
    public List<Application> findAll() {
        return _applicationRepository.findAll();
    }
}
