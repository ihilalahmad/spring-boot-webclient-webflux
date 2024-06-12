package com.codingzest.first_spring_app.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.codingzest.first_spring_app.services.MyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class MyController {
   
    @Autowired
    private MyService myService;
    
    @GetMapping("/api/postData")
    public String testPost() {
        myService.sendPostRequest();
        return "Post Request Sent";
    }

    @GetMapping("/api/getMessage")
    public String getMethodName() {
        return myService.getCatBreeds();
    }
    
    
}
