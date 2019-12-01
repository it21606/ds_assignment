package com.distributedsystems.service;

import com.distributedsystems.web.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.distributedsystems.model.User;
import com.distributedsystems.web.dto.UserRegistrationDto;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);
    UserDto findByEmailUserDto(String email);
    List<UserDto> findAll();

    User save(UserRegistrationDto registration);
}
