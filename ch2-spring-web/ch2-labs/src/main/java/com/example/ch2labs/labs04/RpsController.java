package com.example.ch2labs.labs04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class RpsController {

    @GetMapping("/rps")
    public Result rps(@RequestParam String user) {
        Result result = new Result();
        result.setUser(user);

        // 서버 선택 (랜덤)
        String server = "";
        int random = (int) (Math.random() * 3); // 0, 1, 2

        if (random == 0) server = "scissors";
        else if (random == 1) server = "rock";
        else server = "paper";

        result.setServer(server);

        // 승패 판단
        if (user.equals(server)) {
            result.setResult("draw");
        } else if (
                (user.equals("scissors") && server.equals("paper")) ||
                        (user.equals("rock") && server.equals("scissors")) ||
                        (user.equals("paper") && server.equals("rock"))
        ) {
            result.setResult("win");
        } else {
            result.setResult("lose");
        }

        return result;
    }
}
