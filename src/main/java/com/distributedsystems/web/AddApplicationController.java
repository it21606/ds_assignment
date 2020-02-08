package com.distributedsystems.web;

import com.distributedsystems.model.Application;
import com.distributedsystems.model.User;
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

    public AddApplicationController(ApplicationService applicationService, UserService userService) {
        _applicationService = applicationService;
        _userService = userService;
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
        application.setUser_id(currentUser.getId());
        application.setStatus("PENDING");
        application.setUser_info(currentUser.getFirstName() + " " + currentUser.getLastName());
        _applicationService.save(application);
        System.out.print("Application : " + application);
        if (result.hasErrors()) {
            return "addapplication";
        }
        return "redirect:/addapplication?success";
    }

}
