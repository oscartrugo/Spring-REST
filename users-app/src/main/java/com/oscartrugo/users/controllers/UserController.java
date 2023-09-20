package com.oscartrugo.users.controllers;

import com.oscartrugo.users.models.User;
import com.oscartrugo.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") //Definición de mi recurso
public class UserController {

    @Autowired
    private UserService userService; //Inyección de dependencia userService

    @GetMapping
    public ResponseEntity<List<User>> getUsers(@RequestParam(value = "startWith", required = false) String startWith){ //Handler method - Método HTTP + Recurso
        return new ResponseEntity<>(userService.getUsers(startWith), HttpStatus.OK);
    }
    /*Path param
    localhost:8080/users/oscartrugo/emails/10

    Dame el email con id=10 de oscartrugo

    Query param
    localhost:8080/users/oscartrugo/emails?startDate=19-08-2023&endDate=20-08-2023*/
    @GetMapping(value = "/{username}") //Pasamos el username por el url
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username){ //Inyectamos el valor de {username} en el método
        return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<User> updateUser(@PathVariable("username")String username, @RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(user, username), HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable("username")String username){
        userService.deleteUser(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
