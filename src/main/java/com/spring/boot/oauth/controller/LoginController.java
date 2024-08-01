package com.spring.boot.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
