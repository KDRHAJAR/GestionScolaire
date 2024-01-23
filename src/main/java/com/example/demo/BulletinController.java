package com.example.demo;

import org.springframework.stereotype.Controller;  // Import the Controller annotation
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // Add the Controller annotation
public class BulletinController {

    @GetMapping("/Bulletin")
    public String hajar(Model model) {
        return "Bulletin";
    }
}
