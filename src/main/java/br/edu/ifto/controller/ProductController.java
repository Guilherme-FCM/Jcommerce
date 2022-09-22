/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.controller;

import br.edu.ifto.model.entity.Product;
import br.edu.ifto.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author aluno
 */

@Controller
@Transactional
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductRepository repository;
    
    @GetMapping
    public ModelAndView listProducts(ModelMap model) {
        model.addAttribute("products", repository.findProducts());
        return new ModelAndView("/products/list", model);
    }
    
    @GetMapping("/form")
    public String form(Product product){
        return "/products/form";
    }
    
    @PostMapping("/save")
    public ModelAndView save(Product product){
        repository.create(product);
        return new ModelAndView("redirect:/products");
    }

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/products");
    }

    /**
     * @param id
     * @param model
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("product", repository.findProducts(id));
        return new ModelAndView("/products/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Product product) {
        repository.update(product);
        return new ModelAndView("redirect:/products");
    }
}
