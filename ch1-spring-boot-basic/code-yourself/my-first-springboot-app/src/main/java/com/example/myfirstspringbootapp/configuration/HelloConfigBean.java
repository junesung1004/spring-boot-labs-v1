package com.example.myfirstspringbootapp.configuration;

import org.springframework.stereotype.Component;


public class HelloConfigBean {
    public String sayHello() {
        return "Hello from config bean";
    }
}
