package com.luisargueta.tiendajurasic3.controller;

import com.luisargueta.tiendajurasic3.entity.Sales;
import com.luisargueta.tiendajurasic3.entity.SalesDetails;
import com.luisargueta.tiendajurasic3.service.SalesDetailsService;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sales-details")

public class SalesDetailsController {

    private final SalesDetailsService salesDetailsService;


    public SalesDetailsController(SalesDetailsService salesDetailsService) {
        this.salesDetailsService = salesDetailsService;
    }


    @GetMapping
    public String showSalesDetails(Model model){
        model.addAttribute("sales",salesDetailsService.listSalesDetails());
        model.addAttribute("sale", new SalesDetails());
        return "salesDetails";
    }

    @GetMapping("/new")
    public String showFormNew(Model model) {
        model.addAttribute("salesDetails", new SalesDetails());
        model.addAttribute("modoEdicion", false);
        return "salesDetails-form";
    }

    @PostMapping("/create")
    public String createSaleDetails(@Validated @ModelAttribute("sales") SalesDetails salesDetails, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", false);
            return "sales-form";
        }

        salesDetailsService.create(salesDetails);
        return "redirect:/salesDetails";
    }

    @GetMapping("/delete/{id}")
    public String deleteSalesDetails(@PathVariable @Min(value = 1, message = "The ID has to be greater than 0") Integer id) {
        salesDetailsService.delete(id);
        return "redirect:/salesDetails";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        SalesDetails salesDetails = salesDetailsService.getById(id);
        model.addAttribute("salesDetails", salesDetails);
        model.addAttribute("modoEdicion", true);
        return "salesDetails-form";
    }

    @PostMapping("/update/{id}")
    public String updateSalesDetails(@PathVariable Integer id, @Validated @ModelAttribute("salesDetails") SalesDetails salesDetails,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", true);
            return "salesDetails-form";
        }

        salesDetailsService.update(id, salesDetails);
        return "redirect:/salesDetails";
    }



}
