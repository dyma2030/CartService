package com.itemtransaction.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class WelcomeTest {
    
    @GetMapping
    public String welcome(){
        return "hi Welcome";
    }
}
