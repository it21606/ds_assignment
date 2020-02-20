package com.distributedsystems.web;

import com.distributedsystems.model.Application;
import com.distributedsystems.model.ApplicationParameters;
import com.distributedsystems.model.User;
import com.distributedsystems.service.ApplicationParametersService;
import com.distributedsystems.service.ApplicationService;
import com.distributedsystems.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addapplication")
public class AddApplicationController {

    private final ApplicationService _applicationService;
    private final UserService _userService;
    private final ApplicationParametersService _appParaService;

    public AddApplicationController(ApplicationService applicationService, UserService userService, ApplicationParametersService appParaService) {
        _applicationService = applicationService;
        _userService = userService;
        this._appParaService = appParaService;
    }

    @ModelAttribute("newapplication")
    public Application application() {
        return new Application();
    }

    @GetMapping
    public String showAddApplicationForm(Model model) {
        return "addapplication";
    }


    @PostMapping()
    public String addApplication(@ModelAttribute("newapplication") Application application,
                                 BindingResult result) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = _userService.findByEmail(authentication.getName());
        ApplicationParameters params = _appParaService.getParameters();
        application.setUserId(currentUser.getId());
        long points = 0;
        if (application.getIncome() == 0 && application.isBothParentsUnemployed()) {
            application.setStatus("APPROVED");
        } else {
            application.setStatus("PENDING");
        }
        if (application.getIncome() <= 10000) {
            points = 100;
        } else if (application.getIncome() > 10000 && application.getIncome() <= 15000) {
            points = 30;
        }
        if (application.isHasSiblings()) {
            points = points + 20;
        }
        if (application.isHasSiblingsInOtherCities()) {
            points = points + 50;
        }
        application.setCollectedPoints(points);
        application.setSubmissionPeriod(params.getCurrentPeriod());
        application.setUserInfo(currentUser.getFirstName() + " " + currentUser.getLastName());
        _applicationService.save(application);
        System.out.print("Application : " + application);
        if (result.hasErrors()) {
            return "addapplication";
        }
        return "redirect:/addapplication?success";
    }

}
