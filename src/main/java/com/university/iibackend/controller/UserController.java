package com.university.iibackend.controller;

import com.university.iibackend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private final AuthenticationService service;

    @GetMapping("/{email}")
    public ResponseEntity<UserDetails> getUser(@RequestHeader("Token") String token, @PathVariable String email) {
        return ResponseEntity.ok(service.getUserByEmail(token, email));
    }
}
