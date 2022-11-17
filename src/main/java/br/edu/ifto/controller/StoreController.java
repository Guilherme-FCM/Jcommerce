package br.edu.ifto.controller;

import br.edu.ifto.model.entity.Item;
import br.edu.ifto.model.entity.Product;
import br.edu.ifto.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Transactional
@RequestMapping("store")
public class StoreController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public ModelAndView store(ModelMap model, Item item, @RequestParam(required = false) String description){
        model.addAttribute("description", description);
        List<Product> products = description == null
                ? productRepository.findAll()
                : productRepository.findByDescriptionContaining(description);
        model.addAttribute("products", products);
        return new ModelAndView("/store/index", model);
    }
}
