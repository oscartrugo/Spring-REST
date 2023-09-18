package com.oscartrugo.users.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Stereotype que registra la aplicación en el contexto de Spring
@RequestMapping("/hello") //Define el recurso "hello"
@Slf4j
public class OscartrugoController {

    @GetMapping
    public String helloWorld(){
        return "Hello world!";
    }

}
