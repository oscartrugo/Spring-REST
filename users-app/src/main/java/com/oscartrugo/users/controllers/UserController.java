package com.oscartrugo.users.controllers;

import com.oscartrugo.users.entities.User;
import com.oscartrugo.users.services.UserService;
import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @Timed("get.users")
    public ResponseEntity<Page<User>> getUsers(@RequestParam(required = false, value = "page", defaultValue = "0") int page,
                                               @RequestParam(required = false, value = "size", defaultValue = "1000") int size){
        return new ResponseEntity<>(service.getUsers(page, size), HttpStatus.OK);
    }

    @GetMapping("/usernames")
    public ResponseEntity<Page<String>> getUsernames(@RequestParam(required = false, value = "page", defaultValue = "0") int page,
                                                     @RequestParam(required = false, value = "size", defaultValue = "1000") int size){
        return new ResponseEntity<>(service.getUsernames(page, size), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "Returns a user for a given user id.", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved record."),
            @ApiResponse(code = 404, message = "Record wasn't found.")
    })
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
