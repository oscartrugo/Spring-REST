package com.oscartrugo.users.controllers;

import com.oscartrugo.users.models.User;
import com.oscartrugo.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users") //Definición de mi recurso
public class UserController {

    @Autowired
    private UserService userService; //Inyección de dependencia userService

    @GetMapping
    public ResponseEntity<List<User>> get(){ //Handler method - Método HTTP + Recurso
        return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
    }

}
