package com.UsersMVC.users.services;

import com.UsersMVC.users.models.Role;
<<<<<<< HEAD

import java.util.Collection;

public interface RoleService {
Collection<Role> getAllRoles();
}
=======
import com.UsersMVC.users.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository) {this.roleRepository = roleRepository;}

    public Collection<Role> findAll() {return roleRepository.findAll();}
}

>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
