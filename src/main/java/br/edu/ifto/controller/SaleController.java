/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.controller;

import br.edu.ifto.model.entity.Item;
import br.edu.ifto.model.entity.Product;
import br.edu.ifto.model.entity.Sale;
import br.edu.ifto.model.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author GuilhermeFCM
 */
@Scope("request")
@Controller
@Transactional
@RequestMapping("sales")
public class SaleController {
    
    @Autowired
    SaleRepository repository;
    
    @GetMapping
    public ModelAndView list(ModelMap model){
        model.addAttribute("sales", repository.findAll());
        return new ModelAndView("/sales/list", model);
    }

    @PostMapping("addItem")
    public ModelAndView addItem(Item item, final HttpServletRequest request){
        Sale sale = (Sale) request.getSession().getAttribute("SESSION_SALE");
        sale.addItem(item);
        return new ModelAndView("redirect:/");
    }
}
