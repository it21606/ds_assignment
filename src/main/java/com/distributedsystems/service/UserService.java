package com.distributedsystems.service;

import com.distributedsystems.model.User;
import com.distributedsystems.web.dto.UserRegistrationDto;
import com.distributedsystems.web.viewmodel.UserViewModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    UserViewModel findByIdUserViewModel(long id);

    List<UserViewModel> findAll();

    User save(UserRegistrationDto registration);

    UserViewModel Map(User user);
}
