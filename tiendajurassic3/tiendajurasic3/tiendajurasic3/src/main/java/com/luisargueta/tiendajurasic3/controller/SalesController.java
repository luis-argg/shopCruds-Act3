package com.luisargueta.tiendajurasic3.controller;

import com.luisargueta.tiendajurasic3.entity.Sales;
import com.luisargueta.tiendajurasic3.service.SalesService;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sales")
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }


    @GetMapping
    public String showSales(Model model){
        model.addAttribute("sales",salesService.listSales());
        model.addAttribute("sale", new Sales());
        return "sales";
    }

    @GetMapping("/new")
    public String showFormNew(Model model) {
        model.addAttribute("sales", new Sales());
        model.addAttribute("modoEdicion", false);
        return "sales-form";
    }

    @PostMapping("/create")
    public String createSale(@Validated @ModelAttribute("sales") Sales sales, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", false);
            return "sales-form";
        }

        salesService.create(sales);
        return "redirect:/sales";
    }

    @GetMapping("/delete/{id}")
    public String deleteSales(@PathVariable @Min(value = 1, message = "The ID has to be greater than 0") Integer id) {
        salesService.delete(id);
        return "redirect:/sales";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Sales sales = salesService.getById(id);
        model.addAttribute("sales", sales);
        model.addAttribute("modoEdicion", true);
        return "sales-form";
    }

    @PostMapping("/update/{id}")
    public String updateSales(@PathVariable Integer id, @Validated @ModelAttribute("sales") Sales sales,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", true);
            return "sales-form";
        }

        salesService.update(id, sales);
        return "redirect:/sales";
    }

}
