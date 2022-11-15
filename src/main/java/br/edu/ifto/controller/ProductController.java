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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
    public ModelAndView listProducts(ModelMap model, @RequestParam(required = false) String description) {
        model.addAttribute("description", description);
        List<Product> products = description == null ? repository.findAll() : repository.findByDescriptionContaining(description);
        model.addAttribute("products", products);
        return new ModelAndView("/products/list", model);
    }


    @GetMapping("/form")
    public ModelAndView form(Product product){
        return new ModelAndView("/products/form");
    }
    
    @PostMapping("/save")
    public ModelAndView save(@Validated Product product, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()) return form(product);
        repository.save(product);
        attributes.addFlashAttribute("success", "Produto " + product.getDescription() + " cadastrado com sucesso.");
        return new ModelAndView("redirect:/products");
    }

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id, RedirectAttributes attributes){
        repository.deleteById(id);
        attributes.addFlashAttribute("success", "Produto removido com sucesso.");
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
        model.addAttribute("product", repository.findById(id).get());
        return new ModelAndView("/products/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(@Validated Product product, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()) return form(product);
        repository.save(product);
        attributes.addFlashAttribute("success", "Produto " + product.getDescription() + " atualizado com sucesso.");
        return new ModelAndView("redirect:/products");
    }
}
