package com.UsersMVC.users.services;

import com.UsersMVC.users.models.Role;
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

