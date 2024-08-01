package com.spring.boot.oauth.controller;

import org.springframework.web.bind.annotation.*;

@RestController

public class LoginController {

    @GetMapping("/")
    public String getHome()
    {
       return "Hello Home" ;
    }

    @GetMapping("/login")
    public String getLoginHome()
    {
        return "Welcome to Login Page" ;
    }

    @PostMapping("/login/{username}")
    public String getLoginHome(@PathVariable String username)
    {
        return "Welcome to Login Page"+username ;
    }

}
