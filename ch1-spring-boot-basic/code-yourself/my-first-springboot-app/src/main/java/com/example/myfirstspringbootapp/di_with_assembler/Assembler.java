package com.example.myfirstspringbootapp.di_with_assembler;

import com.example.myfirstspringbootapp.di_with_assembler.cafe.Barista;
import com.example.myfirstspringbootapp.di_with_assembler.cafe.CoffeeMachine;
import com.example.myfirstspringbootapp.di_with_assembler.cafe.PremiumCoffeeMachine;

public class Assembler {
    public static String assemble() {
        CoffeeMachine machine = new PremiumCoffeeMachine(); // 커피머신 인스턴스

        Barista barista = new Barista(machine); // 외부에서 인스턴스를 주입

        return barista.makeCoffee();
    }
}
