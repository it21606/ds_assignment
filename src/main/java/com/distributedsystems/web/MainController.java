package com.distributedsystems.web;

import com.distributedsystems.model.User;
import com.distributedsystems.service.UserService;
import com.distributedsystems.web.viewmodel.UserViewModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
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

}
