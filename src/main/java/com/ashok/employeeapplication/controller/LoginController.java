package com.ashok.employeeapplication.controller;

import com.ashok.employeeapplication.vo.LoginRequest;
import com.ashok.employeeapplication.vo.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Security;

@RestController
@RequestMapping("restapi/v1/user")
public class LoginController {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        LoginResponse loginResponse = null;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(null != auth && request.getUsername().equals(auth.getName())){
                loginResponse = new LoginResponse(auth.isAuthenticated());
        }
        return loginResponse;
    }
}
