package com.luisargueta.tiendajurasic3.controller;

import com.luisargueta.tiendajurasic3.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainViewController {

    @GetMapping("/login")
    public String login() {
        return "login";

        }

    @GetMapping("/home")
    public String home() {
            return "home";
        }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        return "redirect:/login?success";
    }


}

