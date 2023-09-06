package com.oscartrugo.di.qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Nido {
    @Autowired
    @Qualifier("pajaro")
    private Animal animal;

    public void imprimir(){
        System.out.println("Mi nido tiene al animal " + animal.getNombre());
    }
}
