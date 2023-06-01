package com.UsersMVC.users.services;

import com.UsersMVC.users.models.Role;
import com.UsersMVC.users.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {this.roleRepository = roleRepository;}

    public Collection<Role> getAllRoles() {return roleRepository.findAll();}
}

