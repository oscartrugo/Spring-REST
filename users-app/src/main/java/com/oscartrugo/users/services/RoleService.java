package com.oscartrugo.users.services;

import com.oscartrugo.users.entities.Role;
import com.oscartrugo.users.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    public Role updateRole(Integer roleId, Role role){
        Optional<Role> result = repository.findById(roleId);
        if(result.isPresent()){
            return repository.save(role);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn't exist", roleId));
        }
    }

    public void deleteRole(Integer roleId) {
        Optional<Role> result = repository.findById(roleId);

        if(result.isPresent()){
            repository.delete(result.get());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn't exist", roleId));
        }
    }
}
