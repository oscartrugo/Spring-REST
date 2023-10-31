package com.oscartrugo.users.services;

import com.oscartrugo.users.entities.User;
import com.oscartrugo.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> getUsers(@RequestParam(required = false, value = "page", defaultValue = 0) int page,
                               @RequestParam(required = false, value = "size", defaultValue = "1000") int size){
        return userRepository.findAll(PageRequest.of(page, size));
    }

    public User getUserById(Integer userId){
        return userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %d not found", userId)));
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s not found", username)));
    }

    public User getUserByUsernameAndPassword(String username, String password){
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s not found", username)));
    }

}
