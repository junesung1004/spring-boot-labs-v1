package com.example.myfirstspringbootapp.di_with_assembler.cafe;

public class Baristar {

    private CoffeeMachine machine;


    public Baristar(CoffeeMachine machine) {
        this.machine = machine;
    }



    public String makeCoffee() {
        return machine.brew();
    }
}
