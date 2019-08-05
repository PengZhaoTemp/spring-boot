package com.example.zhaop.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hello")
public class TestAController {

    @RequestMapping("/index")
    public String index() {
        System.out.println("11111111111111");
        System.out.println("2222222222222");
        return "Hello World";
    }
}
