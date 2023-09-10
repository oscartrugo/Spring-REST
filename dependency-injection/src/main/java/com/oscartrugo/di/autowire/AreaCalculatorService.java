package com.oscartrugo.di.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaCalculatorService {

    @Autowired //Inyectamos a la lista los beans de tipo Figure (Circle y Square)
    private List<Figure> figureList;

    public double calcArea(){
        double area = 0;
        for (Figure figure: figureList){
            area+= figure.calcularArea();
        }
        return area;
    }
}
