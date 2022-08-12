/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.controller;

import br.edu.ifto.model.dao.ProductDAO;
import br.edu.ifto.model.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author aluno
 */

@Controller
@RequestMapping("products")
public class ProductController {
    ProductDAO dao;

    public ProductController() {
        dao = new ProductDAO();
    }
    
    @GetMapping("/list")
    public ModelAndView listProducts(ModelMap model){
        model.addAttribute("products", dao.listProducts());
        return new ModelAndView("/products/list", model);
    }
    
    @GetMapping("/form")
    public String form(Product product){
        return "/products/form";
    }
    
    @PostMapping("/save")
    public ModelAndView save(Product product){
        dao.save(product);
        return new ModelAndView("redirect:/products/list");
    }
}
