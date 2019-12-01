package com.distributedsystems.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import com.distributedsystems.helpers.Helpers;
import com.distributedsystems.repository.RoleRepository;
import com.distributedsystems.repository.UserRepository;
import com.distributedsystems.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.distributedsystems.model.Role;
import com.distributedsystems.model.User;
import com.distributedsystems.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<UserDto> findAll(){

        List<User>  users = userRepository.findAll();
        List<UserDto> userDtos= new ArrayList<UserDto>();
        for (User user: users) {
            UserDto mappedUser = Map(user);
            userDtos.add(mappedUser);
        }

        return userDtos;
    }

    public UserDto findByEmailUserDto(String email){

        User user = userRepository.findByEmail(email);
        UserDto userDto= Map(user);

        return userDto;
    }


    public User save(UserRegistrationDto registration) {
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setCategory(registration.getCategory());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        user.setMemberSince(sdf.format(timestamp));
        user.setPhoneNumber(registration.getPhoneNumber());
        boolean isAdmin = registration.getCategory().contains("Υπάλληλος");
        if(isAdmin) {
            Role initialRole = roleRepository.findByName("ROLE_ADMIN");
            if (initialRole != null) {
                user.setRoles(Arrays.asList(initialRole));
            } else {
                user.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
            }
        }else{
            Role initialRole = roleRepository.findByName("ROLE_USER");
            if (initialRole != null) {
                user.setRoles(Arrays.asList(initialRole));
            } else {
                user.setRoles(Arrays.asList(new Role("ROLE_USER")));
            }
        }
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null){
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
    private UserDto Map(User user){
        UserDto userDto = new UserDto();
        if(user != null) {
            userDto.setFirstName(user.getFirstName());
            userDto.setLastName(user.getLastName());
            userDto.setEmail(user.getEmail());
            userDto.setRoles(user.getRoles());
            userDto.setCategory(user.getCategory());
            userDto.setPhoneNumber(user.getPhoneNumber());
            userDto.setMemberSince(user.getMemberSince());
            userDto.setStatus(Helpers.userStatusMap.get(user.getStatus()));
        }
        return userDto;
    }

    //endregion
}
