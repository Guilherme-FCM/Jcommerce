package br.edu.ifto.controller;

import br.edu.ifto.model.entity.Item;
import br.edu.ifto.model.repository.ProductRepository;
import br.edu.ifto.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
@RequestMapping("store")
public class StoreController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ModelAndView store(ModelMap model){
        model.addAttribute("products", productRepository.findAll());
        return new ModelAndView("/store/index", model);
    }

    @GetMapping("cart")
    public ModelAndView cart(ModelMap model, Item item){
        model.addAttribute("users", userRepository.findAll());
        return new ModelAndView("/store/cart", model);
    }
}
