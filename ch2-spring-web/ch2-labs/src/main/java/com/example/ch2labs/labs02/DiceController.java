package com.example.ch2labs.labs02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class DiceController {

    @Autowired
    Dice dice;

    @GetMapping("/dice")
    public Map<String, Integer> dice() {
        Map<String, Integer> map = new HashMap<>();
        int diceNuMber = dice.printCalcData();
        map.put("dice", diceNuMber);
        return map;
    }
}
