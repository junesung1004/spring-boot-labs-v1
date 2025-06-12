package com.example.ch2labs.labs03;

import org.springframework.stereotype.Component;

@Component
public class Random {
    int randomDice;

    public int getPrintDiceData() {
        this.randomDice = (int)(Math.random()* 100 + 1);
        return this.randomDice;
    }
}
