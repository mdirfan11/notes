package com.secure.notes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello!!!";
    }

    @GetMapping("/contacts")
    public String contact() {
        return "Contact";
    }

}
