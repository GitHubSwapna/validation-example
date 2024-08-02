package com.spring.boot.oauth.exception;

import org.springframework.security.core.AuthenticationException;


public class AccessNotAllowedException extends RuntimeException {

    public AccessNotAllowedException(String msg) {
        super(msg);
    }
}
