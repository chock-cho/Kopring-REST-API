package com.practice.kopring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class PracticeKopringController {
    @GetMapping("/start-kopring")
    @ResponseBody // 메서드의 반환 값을 HTTP 응답 본문에 직접 전달 -> view resolver가 이를 찾으려 시도
    fun hello(): String { // hello 메서드: 반환 값 String
        return "Hello, Kopring! :)"
    }
}
