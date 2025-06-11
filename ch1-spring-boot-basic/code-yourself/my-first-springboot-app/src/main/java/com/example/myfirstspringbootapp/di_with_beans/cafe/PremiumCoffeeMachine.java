package com.example.myfirstspringbootapp.di_with_beans.cafe;

import org.springframework.stereotype.Component;

@Component
public class PremiumCoffeeMachine implements CoffeeMachine {

    @Override
    public String brew() {
        return "프리미엄으로 커피를내립니다.";






    }
}
