package com.distributedsystems.web;

import com.distributedsystems.model.Application;
import com.distributedsystems.model.User;
import com.distributedsystems.service.UserService;
import com.distributedsystems.web.dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController {
    private final UserService _userService;

    public UsersController(UserService userService) {
        this._userService = userService;
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserDto findByEmailUserDto(@PathVariable("email") String email, HttpServletRequest request) {
        UserDto user = _userService.findByEmailUserDto(email);

        System.out.print("User from " + user.getFullName() + ": " + user);
        return user;

    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserDto> listUsers() {
        List<UserDto> users = _userService.findAll();
        System.out.print("User : " + users);
        return users;

    }
}
