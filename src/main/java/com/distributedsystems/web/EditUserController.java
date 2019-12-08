package com.distributedsystems.web;

import com.distributedsystems.service.UserService;
import com.distributedsystems.web.viewmodel.UserViewModel;
import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/edit/")
public class EditUserController {

    private final UserService _userService;

    public EditUserController(UserService userService) {
        this._userService = userService;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView showUserForEdit(@PathVariable("id") int id, Model model) {
        UserViewModel user = _userService.findByIdUserViewModel(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edituser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("/{id}")
    public ModelAndView editUserAction(@ModelAttribute("user") UserViewModel user, HttpServletRequest request, @PathVariable Long id,
                                       BindingResult bindingResult) throws Exception {
        user.setUserId(id);
        _userService.update(user);

        if (user == null) {
            throw new NotFoundException("Not found user with ID " + id);
        }

        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("edituser");

            return modelAndView;
        } else {
            modelAndView.addObject("user", user);
            modelAndView.setViewName("redirect:/edit/" + user.getUserId() + "?success");
            return modelAndView;
        }
    }
}
