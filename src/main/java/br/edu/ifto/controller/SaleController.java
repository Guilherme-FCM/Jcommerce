/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.controller;

import br.edu.ifto.model.entity.Item;
import br.edu.ifto.model.entity.Product;
import br.edu.ifto.model.entity.Sale;
import br.edu.ifto.model.entity.User;
import br.edu.ifto.model.repository.ProductRepository;
import br.edu.ifto.model.repository.SaleRepository;
import br.edu.ifto.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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
    UserRepository userRepository;

    @Autowired
    Sale sale;

    @GetMapping
    public ModelAndView list(ModelMap model){
        model.addAttribute("sales", repository.findAll());
        return new ModelAndView("/sales/list", model);
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(ModelMap model, @PathVariable Long id){
        model.addAttribute("sale", repository.findById(id).get());
        return new ModelAndView("sales/details");
    }

    @GetMapping("addItem/{productId}")
    public ModelAndView addItem(@PathVariable Long productId){
        Product product = productRepository.findById(productId).get();
        sale.addItem( new Item(product) );
        return new ModelAndView("redirect:/sales/store");
    }

    @GetMapping("removeItem/{itemIndex}")
    public ModelAndView removeItem(@PathVariable int itemIndex){
        sale.getItems().remove(itemIndex);
        return new ModelAndView("redirect:/sales/cart");
    }

    @PostMapping("updateItemAmount/{itemIndex}")
    public ModelAndView updateItem(@PathVariable int itemIndex, Item item){
        sale.getItems().get(itemIndex).setAmount(item.getAmount());
        return new ModelAndView("redirect:/sales/cart");
    }

    @GetMapping("store")
    public ModelAndView store(ModelMap model){
        model.addAttribute("products", productRepository.findAll());
        return new ModelAndView("/shopping/store", model);
    }

    @GetMapping("cart")
    public ModelAndView cart(ModelMap model, Item item){
        model.addAttribute("users", userRepository.findAll());
        return new ModelAndView("/shopping/cart", model);
    }

    @PostMapping("changeUser")
    public ModelAndView changeUser(User user){
        sale.setUser(user);
        return new ModelAndView("redirect:/sales/cart");
    }

    @GetMapping("finish")
    public ModelAndView finish(HttpSession session){
        repository.save(sale);
        session.invalidate();
        return new ModelAndView("redirect:/sales/store");
    }
}
