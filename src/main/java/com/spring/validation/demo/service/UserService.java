package com.spring.validation.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.validation.demo.dto.UserDto;
import com.spring.validation.demo.entity.User;
import com.spring.validation.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    JWTService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public List<UserDto> getAllUsers()
    {
      List<User>  users = userRepository.findAll();
        Function<User, UserDto> fun = (user) ->  convertUser(user);

      return users.stream().map(fun::apply).collect(Collectors.toList());
    }

    public void saveUser(UserDto userDto)
    {
       String passcode = passwordEncoder.encode(userDto.getPassword());
        User u1= new User(userDto.getUsername(), passcode, userDto.getEmail(), userDto.getGender(), userDto.getAge(), userDto.getRole());
        userRepository.save(u1);
    }

    public UserDto getUser(Long userId)
    {
       User user = userRepository.findByUserId(userId);
       return  convertUser(user);
    }

    private UserDto convertUser(User user)
    {
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.convertValue(user, UserDto.class);
    }

    public String verify(UserDto userDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(userDto.getUsername());
        } else {
            return "fail";
        }
    }

}
