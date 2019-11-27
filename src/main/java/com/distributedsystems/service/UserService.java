package com.distributedsystems.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.distributedsystems.model.User;
import com.distributedsystems.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
