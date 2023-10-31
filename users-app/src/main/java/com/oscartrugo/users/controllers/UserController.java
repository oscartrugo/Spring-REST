package com.oscartrugo.users.controllers;

import com.oscartrugo.users.entities.User;
import com.oscartrugo.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<Page<User>> getUsers(@RequestParam("page") int page, @RequestParam("size") int size){
        return new ResponseEntity<>(service.getUsers(page, size), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId){
        return new ResponseEntity<>(service.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username){
        return new ResponseEntity<>(service.getUserByUsername(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> authenticate(@RequestBody User user){
        return new ResponseEntity<>(service.getUserByUsernameAndPassword(user.getUsername(), user.getPassword()), HttpStatus.OK);
    }

}
