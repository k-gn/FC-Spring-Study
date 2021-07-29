package com.example.hello.controller;

import com.example.hello.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    // Post 방식 (등록)
    // @RequestBody : Post 방식에서 Json으로 받은 HTTP Body 데이터를 받을 수(parsing) 있다.
    @PostMapping("/post")
    public void post(@RequestBody Map<String, String> requestData) {
        requestData.forEach((key, value) -> { // map을 람다로 더 간단하게 추출 가능
            System.out.println("key : " + key);
            System.out.println("value : " + value);
        });
    }

    @PostMapping("/post02")
    public void post02(@RequestBody PostRequestDto requestData) {
        System.out.println(requestData);
    }
}

    /*
        # 대부분 현업에선 JSON 데이터를 주고받는다.
        # JSON 형태

        String : value
        number : value
        boolean : value
        object : value { .. }
        array : value [ .. ]

        # 단어 구분은 카멜 or 스네이크 케이스를 사용한다.

        ex1 object)
        {
            "phone_number" : "010-1111-2222",
            "age" : 10,
            "isAgree" : false,
            "account" : {
                "email" : "aaa@aaa.com",
                "password" : "1234"
            }
        }
        ex2 array)
        {
            "user_list" : [
                { .. },
                { .. },
                { .. },
                ...
            ]
        }
    */