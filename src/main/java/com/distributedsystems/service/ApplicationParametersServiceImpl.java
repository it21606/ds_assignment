package com.distributedsystems.service;


import com.distributedsystems.model.ApplicationParameters;
import com.distributedsystems.repository.ApplicationParametersRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicationParametersServiceImpl implements ApplicationParametersService {

    private ApplicationParametersRepository applicationParametersRepository;

    public ApplicationParametersServiceImpl(ApplicationParametersRepository applicationParametersRepository) {
        this.applicationParametersRepository = applicationParametersRepository;
    }

    public ApplicationParameters getParameters() {
        ApplicationParameters applicationParameters = applicationParametersRepository.findById(1);
        if (applicationParameters != null) {
            return applicationParameters;
        } else {
            return new ApplicationParameters();
        }
    }


    public void setParameters(ApplicationParameters appParameters) {
        ApplicationParameters applicationParameters = applicationParametersRepository.findById(1);
        if (applicationParameters != null) {
            applicationParameters.setApplicationsEnabled(appParameters.isApplicationsEnabled());
            applicationParameters.setCurrentPeriod(appParameters.getCurrentPeriod());
            applicationParameters.setMaxApplicants(applicationParameters.getMaxApplicants());
            applicationParametersRepository.save(applicationParameters);
        } else {
            applicationParametersRepository.save(appParameters);
        }
    }
}
