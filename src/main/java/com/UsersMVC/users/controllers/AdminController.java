package com.UsersMVC.users.controllers;


import com.UsersMVC.users.models.Role;
import com.UsersMVC.users.models.User;

import com.UsersMVC.users.services.RoleServiceImpl;
import com.UsersMVC.users.services.UserServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

import java.util.stream.Collectors;


@RestController
@RequestMapping("api/admin")
public class AdminController {

    private final UserServiceImpl userServiceImp;
    public final RoleServiceImpl roleService;

    public AdminController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userServiceImp = userService;
        this.roleService = roleService;
    }


    @GetMapping("/roles")
    public ResponseEntity<Collection<Role>> getAllRoles() {
        Collection<Role> rolelist = roleService.getAllRoles();

        return rolelist != null && !rolelist.isEmpty()
                ? new ResponseEntity<>(rolelist, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userServiceImp.getAllUsers();

        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        User user = userServiceImp.getUserById(id);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/add")
    public ResponseEntity<?> createUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        userServiceImp.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<List<User>> updateUser(@RequestBody @Valid User user) {
        userServiceImp.saveUser(user);
        List<User> users = userServiceImp.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable("id") int id) {
        userServiceImp.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}


