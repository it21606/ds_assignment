package com.distributedsystems.web;

import com.distributedsystems.model.Application;
import com.distributedsystems.model.User;
import com.distributedsystems.service.ApplicationService;
import com.distributedsystems.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/applications/")
public class ApplicationController {

    private final ApplicationService _applicationService;
    private final UserService _userService;

    public ApplicationController(ApplicationService applicationService, UserService userService) {
        _applicationService = applicationService;
        _userService = userService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public Application findById(@PathVariable("id") int id, HttpServletRequest request){
        Application application = _applicationService.findById(id);
        Principal principal = request.getUserPrincipal();
        User user = _userService.findByEmail(principal.getName());

        System.out.print("Application from "+ user.getFirstName() +" "+ user.getLastName() +": " + application);
        return application;

    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<Application> listApplications() {
        List<Application> application = _applicationService.findAll();
        System.out.print("Application : " + application);
        return application;

    }

}
