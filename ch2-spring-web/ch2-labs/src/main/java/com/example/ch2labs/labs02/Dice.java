package com.example.ch2labs.labs02;

import org.springframework.stereotype.Component;

@Component
public class Dice {
    double dice;


    public int printCalcData() {
        return (int)(Math.random()*6 + 1);
    }
}
