package com.spring.boot.oauth.controller;

import com.spring.boot.oauth.exception.AccessNotAllowedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @GetMapping("/user")
    public ResponseEntity getUserHome()
    {
       return ResponseEntity.ok("Hello User Home") ;
    }

    @GetMapping("/admin")
    public ResponseEntity getAdminHome()
    {
        return ResponseEntity.ok("Welcome to Admin Home Page" );
    }

    @GetMapping("/view")
    public ResponseEntity getErrorInfo()
    {
        throw  new AccessNotAllowedException("Not Allowed to access this page");

    }



}
