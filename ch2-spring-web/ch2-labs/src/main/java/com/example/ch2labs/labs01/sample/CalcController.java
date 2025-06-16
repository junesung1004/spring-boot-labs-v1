package com.example.ch2labs.labs01.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalcController {

    @Autowired
    @Qualifier("add")
    private Calc add;

    @Autowired
    @Qualifier("min")
    private Calc min;

    @Autowired
    @Qualifier("mul")
    private Calc mul;

    @Autowired
    @Qualifier("div")
    private Calc div;

    @GetMapping("/add")
    public String add(Model model) {
        double result = add.calc(10,5);
        model.addAttribute("result", result);
        return "add";
    }


    @GetMapping("/min")
    public String min(Model model) {
        double result = min.calc(10,5);
        model.addAttribute("result", result);
        return "min";
    }


    @GetMapping("/mul")
    public String mul(Model model) {
        double result = mul.calc(10,5);
        model.addAttribute("result", result);
        return "mul";
    }

    @GetMapping("/div")
    public String div(Model model) {
        double result = div.calc(10,5);
        model.addAttribute("result", result);
        return "div";
    }
}
