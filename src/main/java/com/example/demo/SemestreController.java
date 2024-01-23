package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


    @Controller
    public class SemestreController { // Corrected class name

        @GetMapping("Semester2")
        public String hajar(Model model) {
            return "affichageS2";
        }

        @GetMapping("Semester1")
        public String haja(Model model) {
            return "affichageS1";
        }
    }
