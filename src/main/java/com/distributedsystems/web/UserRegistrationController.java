package com.distributedsystems.web;

import javax.validation.Valid;

import com.distributedsystems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.distributedsystems.model.User;
import com.distributedsystems.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/adduser")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "adduser";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result){

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "Υπάρχει ήδη χρήστης στο σύστημα με το email" + userDto.getEmail());
        }

        if (result.hasErrors()){
            return "adduser";
        }

        userService.save(userDto);
        return "redirect:/adduser?success";
    }

}
