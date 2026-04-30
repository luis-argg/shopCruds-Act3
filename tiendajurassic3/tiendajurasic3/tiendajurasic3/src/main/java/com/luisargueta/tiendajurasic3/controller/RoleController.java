package com.luisargueta.tiendajurasic3.controller;

import com.luisargueta.tiendajurasic3.entity.Role;
import com.luisargueta.tiendajurasic3.entity.Sales;
import com.luisargueta.tiendajurasic3.service.RoleService;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rol")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public String showRoles(Model model){
        model.addAttribute("role", roleService.listRole());
        model.addAttribute("roles", new Role());
        return "rol";
    }

    @GetMapping("/new")
    public String showFormNew(Model model) {
        model.addAttribute("role", new Role());
        model.addAttribute("modoEdicion", false);
        return "roles-form";
    }

    @PostMapping("/create")
    public String createRoles(@Validated @ModelAttribute("roles") Role role, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", false);
            return "roles-form";
        }

        roleService.create(role);
        return "redirect:/rol";
    }

    @GetMapping("/delete/{id}")
    public String deleteRoles(@PathVariable @Min(value = 1, message = "The ID has to be greater than 0") Integer id) {
        roleService.delete(id);
        return "redirect:/rol";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Role role = roleService.getById(id);
        model.addAttribute("roles", role);
        model.addAttribute("modoEdicion", true);
        return "roles-form";
    }

    @PostMapping("/update/{id}")
    public String updateRoles(@PathVariable Integer id, @Validated @ModelAttribute("roles") Role role,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", true);
            return "roles-form";
        }

        roleService.update(id, role);
        return "redirect:/roles";
    }

}

