package com.UsersMVC.users.services;

import com.UsersMVC.users.models.Role;
import com.UsersMVC.users.models.User;
import com.UsersMVC.users.repositories.UserRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository peopleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = peopleRepository;

        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void saveUser(@Valid User person) {
        String hashedPassword = passwordEncoder.encode(person.getPassword());
        person.setPassword(hashedPassword);
        userRepository.save(person);
    }


    @Override
    @Transactional
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }



    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(usernameOrEmail);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(String.format("user name or email not find " + usernameOrEmail));
        }
        return user.get();
    }




}

