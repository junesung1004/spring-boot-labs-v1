package com.example.myfirstspringbootapp.di_with_beans.cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Baristar {

    private CoffeeMachine machine;

@Autowired
    public Baristar(CoffeeMachine machine) {
        this.machine = machine;
    }



    public String makeCoffee() {
        return machine.brew();
    }
}
