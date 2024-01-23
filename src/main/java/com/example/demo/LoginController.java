package com.example.demo;


//import ch.qos.logback.core.model.Model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;







@Controller
public class LoginController {



    @Autowired
    private LoginService userService;

    @Autowired
    private ProfessorService professorService;
    @Autowired
    private HttpSession session;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("Login");
        mav.addObject("user", new Login());
        return mav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") Login user, Model model) {
        // Search for the user in the student table
        Login student = userService.login(user.getUsername(), user.getPassword());

        if (student != null) {
            // User found in the student table, redirect to student homepage
            model.addAttribute("user", student);
            return "redirect:/hajar";  // Adjust the URL based on your actual student homepage URL
        } else {
            // User not found in the student table, search in the professor table
            Professor professor = professorService.login(user.getUsername(), user.getPassword());

            if (professor != null) {
                // User found in the professor table, redirect to professor homepage
                session.setAttribute("matiere", professor.getMatiere());
                model.addAttribute("professor", professor);
                return "redirect:/Bulletin";  // Adjust the URL based on your actual professor homepage URL
            } else {
                // Neither student nor professor found, redirect to login page with an error message
                model.addAttribute("error", "Invalid username or password");
                return "login";
            }
        }
    }

    @GetMapping("/Register")

    public String ShowHomePage(Model model){

        model.addAttribute("user",new Login());

        return "Register";
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response)
    {


        return "redirect:/login";

    }
    @PostMapping("/Register")
    public String register(@ModelAttribute("user") Login user) {


        // Enregistrer le nouvel utilisateur
        userService.save(user);

        // Rediriger vers la page de connexion
        return "redirect:/login?registration=success";
    }
    @GetMapping("Semester2")
    public String hajar(Model model){
        return "affichageS2";
    }
    @GetMapping("Liste")
    public String liste(Model model){
        return "Liste";
    }
}
