package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // REST API 를 처리하는 컨트롤러로 등록
@RequestMapping("/api") // URI 주소 할당
public class ApiController {

    @GetMapping("/hello")
    public String hello() {
        return "hello spring boot";
    }
}
