package com.UsersMVC.users.services;

import com.UsersMVC.users.models.User;


import javax.validation.Valid;
import java.util.List;

interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    void saveUser(@Valid User person);

    void deleteUserById(int id);




}
