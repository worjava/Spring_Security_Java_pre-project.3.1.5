package com.UsersMVC.users.controllers;


import com.UsersMVC.users.models.Role;
import com.UsersMVC.users.models.User;

import com.UsersMVC.users.services.RoleService;
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
    public final RoleService roleService;

    public AdminController(UserServiceImpl userService, RoleService roleService) {
        this.userServiceImp = userService;
        this.roleService = roleService;
    }


    @GetMapping("/roles")
    public ResponseEntity<Collection<Role>> indexRoles() {
        Collection<Role> rolelist = roleService.findAll();

        return rolelist != null && !rolelist.isEmpty()
                ? new ResponseEntity<>(rolelist, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> index() {
        List<User> users = userServiceImp.index();

        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> showUser(@PathVariable("id") int id) {
        User user = userServiceImp.show(id);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        userServiceImp.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<List<User>> updateUser(@RequestBody @Valid User user) {
        userServiceImp.save(user);
        List<User> users = userServiceImp.index();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> delete(@PathVariable("id") int id) {
        userServiceImp.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}


