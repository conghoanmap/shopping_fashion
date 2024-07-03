package com.shopping.fashion.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @RequestMapping("/")
    public String welcome() {
        return "Welcome to Fashion Shopping";
    }

}
