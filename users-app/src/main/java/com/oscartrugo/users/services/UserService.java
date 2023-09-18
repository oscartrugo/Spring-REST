package com.oscartrugo.users.services;

import com.github.javafaker.Faker;
import com.oscartrugo.users.models.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private Faker faker;

    private List<User> users = new ArrayList<>();

    @PostConstruct
    public void init(){
        for (int i = 0; i<100; i++){ //Inicializamos la lista de users y le añadimos 100 objetos
            users.add(new User(faker.funnyName().name(), faker.name().username(), faker.dragonBall().character()));
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
