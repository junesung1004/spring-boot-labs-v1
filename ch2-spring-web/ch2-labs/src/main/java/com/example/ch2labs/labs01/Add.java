package com.example.ch2labs.labs01;

import org.springframework.stereotype.Component;

@Component("add")
class Add implements Calc {
    @Override
    public double calc(int a, int b) {
        return a + b;
    }
}

@Component("min")
class Min implements  Calc {
    @Override
    public double calc(int a, int b) {
        return a - b;
    }
}

@Component("mul")
class Mul implements Calc {
    @Override
    public double calc(int a, int b) {
        return a * b;
    }
}

@Component("div")
class Div implements Calc {
    @Override
    public double calc(int a, int b) {
        return a / b;
    }
}