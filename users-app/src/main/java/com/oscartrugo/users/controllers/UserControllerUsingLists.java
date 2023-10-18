package com.oscartrugo.users.controllers;

import com.oscartrugo.users.models.UserUsingLists;
import com.oscartrugo.users.services.UserServiceUsingLists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") //Definición de mi recurso
public class UserControllerUsingLists {

    @Autowired
    private UserServiceUsingLists userServiceUsingLists; //Inyección de dependencia userService

    @GetMapping
    public ResponseEntity<List<UserUsingLists>> getUsers(@RequestParam(value = "startWith", required = false) String startWith){ //Handler method - Método HTTP + Recurso
        return new ResponseEntity<>(userServiceUsingLists.getUsers(startWith), HttpStatus.OK);
    }
    /*Path param
    localhost:8080/users/oscartrugo/emails/10

    Dame el email con id=10 de oscartrugo

    Query param
    localhost:8080/users/oscartrugo/emails?startDate=19-08-2023&endDate=20-08-2023*/
    @GetMapping(value = "/{username}") //Pasamos el username por el url
    public ResponseEntity<UserUsingLists> getUserByUsername(@PathVariable("username") String username){ //Inyectamos el valor de {username} en el método
        return new ResponseEntity<>(userServiceUsingLists.getUserByUsername(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserUsingLists> createUser(@RequestBody UserUsingLists user){
        return new ResponseEntity<>(userServiceUsingLists.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<UserUsingLists> updateUser(@PathVariable("username")String username, @RequestBody UserUsingLists user){
        return new ResponseEntity<>(userServiceUsingLists.updateUser(user, username), HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable("username")String username){
        userServiceUsingLists.deleteUser(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
