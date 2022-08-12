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
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        dao.remove(id);
        return new ModelAndView("redirect:/products/list");
    }

    /**
     * @param id
     * @param model
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("product", dao.listProducts(id));
        return new ModelAndView("/products/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Product product) {
        dao.update(product);
        return new ModelAndView("redirect:/products/list");
    }
}
