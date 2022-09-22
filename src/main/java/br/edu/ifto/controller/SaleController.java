/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.controller;

import br.edu.ifto.model.entity.Item;
import br.edu.ifto.model.entity.Product;
import br.edu.ifto.model.entity.Sale;
import br.edu.ifto.model.repository.ProductRepository;
import br.edu.ifto.model.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author GuilhermeFCM
 */
@Controller
@Scope("request")
@Transactional
@RequestMapping("sales")
public class SaleController {

    @Autowired
    SaleRepository repository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private Sale sale;

    @GetMapping
    public ModelAndView list(ModelMap model){
        model.addAttribute("sales", repository.findAll());
        return new ModelAndView("/sales/list", model);
    }

    @GetMapping("addItem/{productId}")
    public ModelAndView addItem(@PathVariable Long productId){
        Product product = productRepository.findProducts(productId);
        Item item = new Item();
        item.setProduct(product);
        sale.addItem(item);
        return new ModelAndView("redirect:/");
    }
}
