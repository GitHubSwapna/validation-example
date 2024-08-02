package com.spring.boot.oauth.controller;

import com.spring.boot.oauth.exception.AccessNotAllowedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorController {
    GlobalErrorController() {
        System.out.println("ErrorController Created");
    }

    @ExceptionHandler(AccessNotAllowedException.class)
    public ResponseEntity getAdminHome(RuntimeException message)
    {
        return ResponseEntity.ok(message.getMessage()) ;
    }
}
