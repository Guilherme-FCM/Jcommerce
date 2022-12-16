/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.controller;

import br.edu.ifto.model.entity.Sale;
import br.edu.ifto.model.entity.User;
import br.edu.ifto.model.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author GuilhermeFCM
 */
@Controller
@Transactional
@RequestMapping("sales")
public class SaleController {

    @Autowired
    SaleRepository repository;

    @GetMapping
    public ModelAndView list(
            ModelMap model,
            @RequestParam(required = false) String initial_date,
            @RequestParam(required = false) String final_date
    ){
        model.addAttribute("initial_date", initial_date);
        model.addAttribute("final_date", final_date);

        List<Sale> sales;
        try {
            if (!initial_date.isEmpty() && !final_date.isEmpty())
                sales = repository.findByDateBetween(
                    parseStringToLocalDate(initial_date),
                    parseStringToLocalDate(final_date)
                );
            else if (!initial_date.isEmpty())
                sales = repository.findByDateAfter(
                    parseStringToLocalDate(initial_date)
                );
            else if (!final_date.isEmpty())
                sales = repository.findByDateBefore(
                    parseStringToLocalDate(final_date)
                );
            else sales = repository.findAll();
        } catch (Exception error) {
            sales = repository.findAll();
        }

        model.addAttribute("sales", sales);
        return new ModelAndView("/sales/list", model);
    }

    @GetMapping("/{id}")
    public ModelAndView details(ModelMap model, @PathVariable Long id){
        model.addAttribute("sale", repository.findById(id).get());
        return new ModelAndView("/sales/details");
    }

    @GetMapping("user/")
    public ModelAndView getUserSales(ModelMap model, @PathVariable Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("sales", repository.findByUserEmail(auth.getName()));
        return new ModelAndView("/sales/userList");
    }

    private LocalDate parseStringToLocalDate(String date) throws Exception {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
