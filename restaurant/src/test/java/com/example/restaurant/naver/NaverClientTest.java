package com.example.restaurant.naver;

import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchLocalReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NaverClientTest {

    @Autowired
    public NaverClient naverClient;

    @Test
    public void localSearchTest() {

        var search = new SearchLocalReq();
        search.setQuery("갈비집");

        var result = naverClient.localSearch(search);

        System.out.println(result);
    }

    @Test
    public void imageSearchTest() {

        var search = new SearchImageReq();
        search.setQuery("갈비집");

        var result = naverClient.imageSearch(search);

        System.out.println(result);
    }
}