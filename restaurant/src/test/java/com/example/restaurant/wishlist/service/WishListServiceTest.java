package com.example.restaurant.wishlist.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class WishListServiceTest {

    @Autowired
    private WishListService wishListService;


    @Test
    public void searchTest() {

        // 실제로는 현재 NaverClient를 Mocking 처리해서 테스트를 해야함
        var result = wishListService.search("갈비집");

        System.out.println(result);
        Assertions.assertNotNull(result);
    }
}