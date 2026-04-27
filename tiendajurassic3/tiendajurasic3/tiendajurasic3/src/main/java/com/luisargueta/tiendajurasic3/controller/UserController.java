package com.luisargueta.tiendajurasic3.controller;


import com.luisargueta.tiendajurasic3.entity.User;
import com.luisargueta.tiendajurasic3.service.UserService;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String showsUsers(Model model){
        model.addAttribute("users",userService.listUsers());
        return "users";
    }

    @GetMapping("/new")
    public String showFormNew(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("modoEdicion", false);
        return "user-form";
    }

    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute User user, Model model, BindingResult result){
        if (result.hasErrors()) {
            model.addAttribute("modeEdicion", false);
            return "user-form";
        }

        userService.create(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable  @Min(value = 1, message = "The ID has to be greater than 0") Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        model.addAttribute("modoEdicion", true);
        return "user-form";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Integer id, @Validated @ModelAttribute("user") User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", true);
            return "user-form";
        }
        userService.update(id, user);
        return "redirect:/users";
    }

}
