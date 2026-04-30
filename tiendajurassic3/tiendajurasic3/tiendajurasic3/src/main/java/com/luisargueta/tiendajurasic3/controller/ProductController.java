package com.luisargueta.tiendajurasic3.controller;


import com.luisargueta.tiendajurasic3.entity.Product;

import com.luisargueta.tiendajurasic3.service.ProductService;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showsUsers(Model model){
        model.addAttribute("products",productService.listProducts());
        model.addAttribute("products", new Product());
        return "products";
    }

    @GetMapping("/new")
    public String showFromNew(Model model) {
        model.addAttribute("products", new Product());
        model.addAttribute("modoEdicion", false);
        return "product-form";
    }

    @PostMapping("/create")
    public String createProduct(@Validated @ModelAttribute("product") Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", false);
            return "products-form";
        }

        productService.create(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable @Min(value = 1, message = "The ID has to be greater than 0") Integer id) {
        productService.delete(id);
        return "redirect:/products";

    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        model.addAttribute("modoEdicion", true);
        return "product-form";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Integer id, @Validated @ModelAttribute("products") Product product,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", true);
            return "product-form";
        }
        productService.update(id, product);
        return "redirect:/products";
    }


}
