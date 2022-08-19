package com.example.mavenspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public void hello() {
        System.out.println("Hello World!");
    }
}
