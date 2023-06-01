package com.UsersMVC.users.controllers;


import com.UsersMVC.users.models.Role;
import com.UsersMVC.users.models.User;

<<<<<<< HEAD
import com.UsersMVC.users.services.RoleServiceImpl;
=======
import com.UsersMVC.users.services.RoleService;
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
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
<<<<<<< HEAD
    public final RoleServiceImpl roleService;

    public AdminController(UserServiceImpl userService, RoleServiceImpl roleService) {
=======
    public final RoleService roleService;

    public AdminController(UserServiceImpl userService, RoleService roleService) {
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
        this.userServiceImp = userService;
        this.roleService = roleService;
    }


    @GetMapping("/roles")
<<<<<<< HEAD
    public ResponseEntity<Collection<Role>> getAllRoles() {
        Collection<Role> rolelist = roleService.getAllRoles();
=======
    public ResponseEntity<Collection<Role>> indexRoles() {
        Collection<Role> rolelist = roleService.findAll();
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26

        return rolelist != null && !rolelist.isEmpty()
                ? new ResponseEntity<>(rolelist, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
<<<<<<< HEAD
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userServiceImp.getAllUsers();
=======
    public ResponseEntity<List<User>> index() {
        List<User> users = userServiceImp.index();
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26

        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user/{id}")
<<<<<<< HEAD
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        User user = userServiceImp.getUserById(id);
=======
    public ResponseEntity<User> showUser(@PathVariable("id") int id) {
        User user = userServiceImp.show(id);
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/add")
<<<<<<< HEAD
    public ResponseEntity<?> createUser(@RequestBody @Valid User user, BindingResult bindingResult) {
=======
    public ResponseEntity<?> create(@RequestBody @Valid User user, BindingResult bindingResult) {
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

<<<<<<< HEAD
        userServiceImp.saveUser(user);
=======
        userServiceImp.save(user);
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<List<User>> updateUser(@RequestBody @Valid User user) {
<<<<<<< HEAD
        userServiceImp.saveUser(user);
        List<User> users = userServiceImp.getAllUsers();
=======
        userServiceImp.save(user);
        List<User> users = userServiceImp.index();
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
<<<<<<< HEAD
    public ResponseEntity<User> deleteUserById(@PathVariable("id") int id) {
        userServiceImp.deleteUserById(id);
=======
    public ResponseEntity<User> delete(@PathVariable("id") int id) {
        userServiceImp.delete(id);
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
        return new ResponseEntity<>(HttpStatus.OK);

    }


}


