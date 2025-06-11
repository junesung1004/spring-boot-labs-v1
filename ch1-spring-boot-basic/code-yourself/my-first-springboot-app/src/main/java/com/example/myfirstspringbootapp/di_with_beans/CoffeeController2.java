package com.example.myfirstspringbootapp.di_with_beans;

import com.example.myfirstspringbootapp.di_with_assembler.Assembler;
import com.example.myfirstspringbootapp.di_with_beans.cafe.Baristar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeController2 {

    @Autowired
    Baristar baristar;

    @GetMapping("/coffee-bean")
    public String coffee() {
        return baristar.makeCoffee();
    }

    @Autowired
    public void setBaristar(Baristar baristar) {
        this.baristar = baristar;
    }
}
