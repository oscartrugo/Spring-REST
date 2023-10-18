package com.oscartrugo.users.services;

import com.oscartrugo.users.entities.User;
import com.oscartrugo.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getUsers(){
        return repository.findAll();
    }

}
