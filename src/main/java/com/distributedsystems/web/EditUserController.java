package com.distributedsystems.web;

import com.distributedsystems.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/edit/")
public class EditUserController {

    private final UserService _userService;

    public EditUserController(UserService userService) {
        this._userService = userService;
    }

    @GetMapping(value = "/{id}")
    public String showUserForEdit(@PathVariable("id") int id, Model model) {

        return "addapplication";
    }
}
