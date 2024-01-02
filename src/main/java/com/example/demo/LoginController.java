package com.example.demo;


//import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;


import java.io.Serializable;
import java.util.Objects;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;







@Controller
public class LoginController {



    @Autowired
    private LoginService userService;


    @GetMapping("/login")

    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("Login");
        mav.addObject("user", new Login());
        return mav;
    }

    @PostMapping("/Login")
    public String login(@ModelAttribute("user") Login user ) {

        Login oauthUser = userService.login(user.getUsername(), user.getPassword());


        System.out.print(oauthUser);
        if(Objects.nonNull(oauthUser))
        {

            return "redirect:/";


        } else {
            return "redirect:/Liste";


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
