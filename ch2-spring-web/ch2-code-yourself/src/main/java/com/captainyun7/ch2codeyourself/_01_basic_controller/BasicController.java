package com.captainyun7.ch2codeyourself._01_basic_controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class BasicController {

    // GET / basic/hello 요청이 왔을 때, hello 메서드가 실행
    @GetMapping("/basic/hello")
    @ResponseBody // http body에 담아줘~
    public String hello() {
        return "hello"; // 뷰 ? HttpMessageConverter
    }

    // userId가 동적인 값
    // {경로 변수}
    @GetMapping("/basic/users/{userId}")
    @ResponseBody
    public String users(@PathVariable int userId) {
        return "users " + userId;
    }

    @GetMapping("/basic/users/{userId}/orders/{orderId}")
    @ResponseBody
    public String userOrder(@PathVariable int userId, @PathVariable int orderId) {
        return "users " + userId + " orders " + orderId;
    }

    // /basic/search?x=1&y=2
    @GetMapping("/basic/params")
    @ResponseBody
    public String params(@RequestParam String name, @RequestParam int age) {
        return "name :" + name + ", age : " + age;

    }


    @GetMapping("/basic/filter")
    @ResponseBody
    public String params(@RequestParam Map<String, String> params) {
        return "전체 파라미터 : " + params;
    }

    @PostMapping("/basic/users")
    @ResponseBody
    public String post() {
        return "사용자 생성 성공!";
    }


    @PutMapping("/basic/users/{userId}") // 하나 수정
    @ResponseBody
    public String put() {
        return "사용자 수정 성공!";
    }


    @DeleteMapping("/basic/users/{userId}") // 하나 수정
    @ResponseBody
    public String delete() {
        return "사용자 삭제 성공!";
    }

}
