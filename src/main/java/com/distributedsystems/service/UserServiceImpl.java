package com.distributedsystems.service;

import com.distributedsystems.helpers.Helpers;
import com.distributedsystems.model.Role;
import com.distributedsystems.model.User;
import com.distributedsystems.repository.RoleRepository;
import com.distributedsystems.repository.UserRepository;
import com.distributedsystems.web.dto.UserRegistrationDto;
import com.distributedsystems.web.viewmodel.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public List<UserViewModel> findAll() {
        List<User> users = userRepository.findAll();
        List<UserViewModel> userViewModels = new ArrayList<>();
        for (User user : users) {
            UserViewModel mappedUser = Map(user);
            userViewModels.add(mappedUser);
        }

        return userViewModels;
    }

    public UserViewModel findByIdUserViewModel(long id) {

        User user = userRepository.findById(id);
        UserViewModel userViewModel = Map(user);

        return userViewModel;
    }

    public User findById(long id) {

        User user = userRepository.findById(id);
        return user;
    }


    public User save(UserRegistrationDto registration) {
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        passwordEncoder.encode(registration.getPassword());

        user.setCategory(registration.getCategory());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        user.setMemberSince(sdf.format(timestamp));
        user.setPhoneNumber(registration.getPhoneNumber());
        boolean isAdmin = registration.getCategory().contains("Υπάλληλος");
        if (isAdmin) {
            Role initialRole = roleRepository.findByName("ROLE_ADMIN");
            if (initialRole != null) {
                user.setRoles(Arrays.asList(initialRole));
            } else {
                user.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
            }
        } else {
            Role initialRole = roleRepository.findByName("ROLE_USER");
            if (initialRole != null) {
                user.setRoles(Arrays.asList(initialRole));
            } else {
                user.setRoles(Arrays.asList(new Role("ROLE_USER")));
            }
        }
        return userRepository.save(user);
    }


    public User update(UserViewModel userUpdate) {
        if (userUpdate != null) {
            User user = findById(userUpdate.getUserId());
            user.setId(userUpdate.getUserId());
            user.setFirstName(userUpdate.getFirstName());
            user.setLastName(userUpdate.getLastName());
            user.setEmail(userUpdate.getEmail());
            user.setCategory(userUpdate.getCategory());
            user.setPhoneNumber(userUpdate.getPhoneNumber());
            String newStatus = userUpdate.getStatus();
            String newStatusMapped = Helpers.userStatusMap.get(newStatus);
            user.setStatus(newStatusMapped);
            return userRepository.save(user);
        } else {
            return new User();
        }

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Λάνθασμένα στοιχεία σύνδεσης.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    //region Mapping
    public UserViewModel Map(User user) {
        UserViewModel userViewModel = new UserViewModel();
        if (user != null) {
            userViewModel.setUserId(user.getId());
            userViewModel.setFirstName(user.getFirstName());
            userViewModel.setLastName(user.getLastName());
            userViewModel.setEmail(user.getEmail());
            userViewModel.setRoles(user.getRoles());
            userViewModel.setCategory(user.getCategory());
            userViewModel.setPhoneNumber(user.getPhoneNumber());
            userViewModel.setMemberSince(user.getMemberSince());
            userViewModel.setStatus(Helpers.userStatusMap.get(user.getStatus()));
        }
        return userViewModel;
    }

    //endregion
}
