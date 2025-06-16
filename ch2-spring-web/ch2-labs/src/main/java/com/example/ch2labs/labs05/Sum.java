package com.example.ch2labs.labs05;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class Sum {

    @GetMapping("/sum-digit")
    public ResponseEntity<?> sum(@RequestParam String number) {
        // number 검증 제일 우선
        if(number == null || number.isEmpty()) {
            return ResponseEntity.badRequest().body("number 파라미터는 필수입니다.");
        }

        try {
            int num = Integer.parseInt(number);
            if(num < 0) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("음수는 지원하지 않습니다. 양의 정수를 입력해주세요.");
            }

            // 각 자리수 더한 값
            // "1234" -> [1, 2, 3, 4]
            int sum = Arrays.stream(number.split(""))
                    .mapToInt(Integer::parseInt)
                    .sum();

            return ResponseEntity.ok(String.valueOf(sum));
        } catch (NumberFormatException e) {
            // 숫자가 아니다
            return ResponseEntity
                    .status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body("정수만 입력 가능합니다. 예: /sum-digits?number=1234");
        }



    }
}
