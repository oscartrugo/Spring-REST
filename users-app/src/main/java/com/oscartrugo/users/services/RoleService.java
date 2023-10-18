package com.oscartrugo.users.services;

import com.oscartrugo.users.entities.Role;
import com.oscartrugo.users.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    public RoleRepository repository;

    public List<Role> getRoles(){
        return repository.findAll();
    }

    public Role createRole(Role role){
        return repository.save(role);
    }

}
