package com.example.demo;

import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    public String ShowHomePage(){
        return "Index";
    }

}
