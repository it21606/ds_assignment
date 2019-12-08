package com.distributedsystems.web;

import com.distributedsystems.model.ApplicationParameters;
import com.distributedsystems.service.ApplicationParametersService;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

    private ApplicationParametersService applicationParametersService;

    public BaseController(ApplicationParametersService applicationParametersService) {
        this.applicationParametersService = applicationParametersService;
    }

    public BaseController() {

    }

    public ApplicationParameters getAppParameters() {
        ApplicationParameters applicationParameters = applicationParametersService.getParameters();
        return applicationParameters;
    }
}
