package com.distributedsystems.web;

import com.distributedsystems.model.ApplicationParameters;
import com.distributedsystems.service.ApplicationParametersService;
import com.distributedsystems.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/parameters")
public class ParametersController {

    private final ApplicationParametersService _applicationParametersService;
    private final UserService _userService;

    public ParametersController(ApplicationParametersService applicationParametersService, UserService userService) {
        _applicationParametersService = applicationParametersService;
        _userService = userService;
    }

    @GetMapping
    public ModelAndView showUserForEdit(Model model) {
        ApplicationParameters parameters = _applicationParametersService.getParameters();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("parameters");
        modelAndView.addObject("parameters", parameters);
        return modelAndView;
    }
}
