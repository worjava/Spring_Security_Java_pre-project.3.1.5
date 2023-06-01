package com.UsersMVC.users.controllers;

import com.UsersMVC.users.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")

public class UserController {


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping()
    public ResponseEntity<User> showUser(Authentication auth){
        return new ResponseEntity<>((User) auth.getPrincipal(), HttpStatus.OK);
    }

}