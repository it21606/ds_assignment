package com.distributedsystems.web;

import com.distributedsystems.model.User;
import com.distributedsystems.service.ApplicationParametersService;
import com.distributedsystems.service.UserService;
import com.distributedsystems.web.viewmodel.ChangePasswordViewModel;
import com.distributedsystems.web.viewmodel.UserViewModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private UserService userService;
    private ApplicationParametersService applicationParametersService;

    public MainController(UserService userService, ApplicationParametersService applicationParametersService) {
        this.userService = userService;
        this.applicationParametersService = applicationParametersService;

    }

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/listusers")
    public String userList() {
        return "list-users";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.findByEmail(authentication.getName());
        UserViewModel userVM = userService.Map(currentUser);
        model.addAttribute("currentUser", userVM);
        return "profile";
    }


    @GetMapping("/changePassword")
    public String changePassword(Model model) {
        ChangePasswordViewModel passwordVM = new ChangePasswordViewModel(null, null, null);
        model.addAttribute("passwordVM", passwordVM);
        return "changePassword";
    }

    @PostMapping("/changePassword")
    public String changePassword(@ModelAttribute("passwordVM") ChangePasswordViewModel passwordVM) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "redirect:/changePassword?success";
    }
}
