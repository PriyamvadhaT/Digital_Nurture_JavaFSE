package com.cognizant.authservice.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authservice.model.AuthenticationResponse;
import com.cognizant.authservice.util.JwtUtil;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public AuthenticationResponse authenticate(
            @RequestHeader("Authorization") String authHeader) {

        // Remove "Basic "
        String base64Credentials = authHeader.substring(6);

        // Decode username:password
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(decodedBytes, StandardCharsets.UTF_8);

        String username = credentials.split(":")[0];
        String password = credentials.split(":")[1];

        // You can print them for checking
        System.out.println("Username : " + username);
        System.out.println("Password : " + password);

        // Generate JWT
        String token = jwtUtil.generateToken(username);

        return new AuthenticationResponse(token);
    }
}