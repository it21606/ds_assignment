package com.distributedsystems.web;

import com.distributedsystems.model.Application;
import com.distributedsystems.model.User;
import com.distributedsystems.service.ApplicationService;
import com.distributedsystems.service.UserService;
import com.distributedsystems.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/")
public class ApplicationController {

    private final ApplicationService _applicationService;
    private final UserService _userService;

    public ApplicationController(ApplicationService applicationService,UserService userService) {
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
