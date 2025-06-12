package com.example.ch2labs.labs03;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DiceRandomController {

    @Autowired
    Random random;

    @GetMapping("random/dice")
    public Map<String, Integer> randomDice(@PathVariable int min, @PathVariable int max) {
        Map<String, Integer> dice = new HashMap<>();
        int randomNum = random.getPrintDiceData();

        dice.put("number", randomNum);
        return dice;
    }
}
