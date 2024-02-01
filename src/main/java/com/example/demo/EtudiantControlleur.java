package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EtudiantControlleur {
    @GetMapping("/Etudiant")
    public String hajar(Model model){
        return "etudiant";
    }
}
