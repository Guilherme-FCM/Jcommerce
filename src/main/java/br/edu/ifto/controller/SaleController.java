/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.controller;

import br.edu.ifto.model.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    
    @GetMapping("/list")
    public ModelAndView list(ModelMap model){
        model.addAttribute("sales", repository.findAll());
        return new ModelAndView("/sales/list", model);
    }
}
