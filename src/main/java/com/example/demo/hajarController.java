package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class hajarController {
    @GetMapping("/hajar")
    public String hajar(Model model){
        return "hajar";
    }

}
