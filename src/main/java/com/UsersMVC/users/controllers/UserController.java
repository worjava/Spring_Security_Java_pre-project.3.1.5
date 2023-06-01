package com.UsersMVC.users.controllers;

import com.UsersMVC.users.models.User;
<<<<<<< HEAD
=======
import com.UsersMVC.users.repositories.UserRepository;
import com.UsersMVC.users.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
<<<<<<< HEAD
=======
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
=======
import java.security.Principal;
import java.util.List;

>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
@RestController
@RequestMapping("api/user")

public class UserController {

<<<<<<< HEAD

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping()
    public ResponseEntity<User> showUser(Authentication auth){
=======
    private UserServiceImpl userService;


    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<User> showUsers(Authentication auth){
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
        return new ResponseEntity<>((User) auth.getPrincipal(), HttpStatus.OK);
    }

}