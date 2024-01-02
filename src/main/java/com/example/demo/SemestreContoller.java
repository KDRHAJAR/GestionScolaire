package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class SemestreContoller {
    @GetMapping("Semester2")
    public String hajar(Model model){
        return "affichageS2";
    }
}
