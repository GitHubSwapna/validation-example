package com.spring.validation.demo.controller;

import com.spring.validation.demo.dto.UserDto;
import com.spring.validation.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userservice;

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody @Valid UserDto userDto)
    {
        userservice.saveUser(userDto);
        return ResponseEntity.ok("Successfully created the user"+userDto.getUsername());
    }

    @GetMapping("/fetchAll")
    public List<UserDto> getAllUsers()
    {
        return userservice.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public UserDto getUser(@PathVariable String userId)
    {
        return userservice.getUser(Long.valueOf(userId));
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid UserDto user) {

        return userservice.verify(user);
    }

}
