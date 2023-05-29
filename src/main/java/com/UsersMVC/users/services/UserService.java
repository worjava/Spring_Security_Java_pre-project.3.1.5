package com.UsersMVC.users.services;

import com.UsersMVC.users.models.User;


import javax.validation.Valid;
import java.util.List;

interface UserService {
    List<User> index();

    User show(int id);

    void save(@Valid User person);

    void delete(int id);

    boolean existsUserByEmail(String email);


}
