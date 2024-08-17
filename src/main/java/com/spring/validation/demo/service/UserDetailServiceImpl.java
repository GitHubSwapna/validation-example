package com.spring.validation.demo.service;

import com.spring.validation.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       com.spring.validation.demo.entity.User u1 = userRepository.findByUsername(username);
       return  User.builder()
                .username(u1.getUsername())
                .password(u1.getPassword())
                .authorities(u1.getRole())
                .build();
    }
}
