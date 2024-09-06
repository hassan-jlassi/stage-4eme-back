package com.accent.controllers;

import com.accent.entities.LoginRequest;
import com.accent.entities.User;
import com.accent.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmailUser();
        String password = loginRequest.getPasswordUser();

        User user = userService.getUserByEmailAndPassword(email, password);

        if (user != null) {
            // Return a JSON response
            return ResponseEntity.ok().body("{\"message\": \"Login successful\"}");
        } else {
            // Return an error response
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Invalid credentials\"}");
        }
    }
}
