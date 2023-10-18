package com.oscartrugo.users.services;

import com.github.javafaker.Faker;
import com.oscartrugo.users.models.UserUsingLists;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceUsingLists {

    @Autowired
    private Faker faker;

    private List<UserUsingLists> users = new ArrayList<>();

    @PostConstruct
    public void init(){
        for (int i = 0; i<100; i++){ //Inicializamos la lista de users y le añadimos 100 objetos
            users.add(new UserUsingLists(faker.funnyName().name(), faker.name().username(), faker.dragonBall().character()));
        }
    }

    public List<UserUsingLists> getUsers(String startWith) {
        if(startWith != null){
            return users.stream().filter(u -> u.getUsername().startsWith(startWith)).collect(Collectors.toList());
        }else{
            return users;
        }

    }

    public UserUsingLists getUserByUsername(String username){
        return users.stream()
                .filter(u -> u.getUsername().equals(username)) //Buscamos el usuario con username igual a la variable "username"
                .findAny()
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s not found", username))
                );
    }

    public UserUsingLists createUser(UserUsingLists user){
        if(users.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()))){ //Si el objeto ua existe...
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("User %s already exists", user.getUsername())); //Manda un error
        }
        users.add(user); //Añade el user a la lista si no existe
        return user;
    }

    public UserUsingLists updateUser(UserUsingLists user, String username){
        UserUsingLists userToBeUpdated = getUserByUsername(username);
        userToBeUpdated.setNickname(user.getNickname());
        userToBeUpdated.setPassword(user.getPassword());

        return userToBeUpdated;
    }

    public void deleteUser(String username){
        UserUsingLists userByUsername = getUserByUsername(username);
        users.remove(userByUsername);
    }
}
