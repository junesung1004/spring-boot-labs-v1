package com.example.ch2labs.labs01.correct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class CalcController2 {

    @GetMapping("/calc")
    public String calc(@RequestParam int x, @RequestParam int y, @RequestParam String op) {

        int result = 0;

        switch (op) {
            case "add":
                result = x + y;
                break;
            case "sub":
                result = x - y;
                break;
            case "mul":
                result = x * y;
                break;
            case "div":
                result = x / y;
                break;
        }

        return String.valueOf(result);
    }
}
