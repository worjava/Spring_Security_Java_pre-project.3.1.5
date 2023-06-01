package com.UsersMVC.users.services;

import com.UsersMVC.users.models.User;


import javax.validation.Valid;
import java.util.List;

interface UserService {
<<<<<<< HEAD
    List<User> getAllUsers();

    User getUserById(int id);

    void saveUser(@Valid User person);

    void deleteUserById(int id);


=======
    List<User> index();

    User show(int id);

    void save(@Valid User person);

    void delete(int id);

    boolean existsUserByEmail(String email);
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26


}
