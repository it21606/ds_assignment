package com.distributedsystems.web;

import com.distributedsystems.service.UserService;
import com.distributedsystems.web.viewmodel.UserViewModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController {
    private final UserService _userService;

    public UsersController(UserService userService) {
        this._userService = userService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserViewModel findByIdUserViewModel(@PathVariable("id") long id, HttpServletRequest request) {
        UserViewModel user = _userService.findByIdUserViewModel(id);

        System.out.print("User from " + user.getFullName() + ": " + user);
        return user;

    }


    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserViewModel> listUsers() {
        List<UserViewModel> users = _userService.findAll();
        System.out.print("User : " + users);
        return users;

    }
}
