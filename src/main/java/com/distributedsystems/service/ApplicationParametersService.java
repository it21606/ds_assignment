package com.distributedsystems.service;

import com.distributedsystems.model.ApplicationParameters;

public interface ApplicationParametersService {

    ApplicationParameters getParameters();

    void setParameters(ApplicationParameters appParameters);
}
