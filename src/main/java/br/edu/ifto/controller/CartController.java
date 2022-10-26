package br.edu.ifto.controller;

import br.edu.ifto.model.entity.Item;
import br.edu.ifto.model.entity.Product;
import br.edu.ifto.model.entity.Sale;
import br.edu.ifto.model.repository.ProductRepository;
import br.edu.ifto.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
@Scope("request")
@RequestMapping("cart")
public class CartController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Sale sale;

    @GetMapping
    public ModelAndView cart(ModelMap model, Item item) {
        model.addAttribute("users", userRepository.findAll());
        return new ModelAndView("/store/cart", model);
    }

    @GetMapping("addItem/{productId}")
    public ModelAndView addItem(@PathVariable Long productId) {
        Product product = productRepository.findById(productId).get();
        sale.addItem(new Item(product));
        return new ModelAndView("redirect:/store");
    }

    @GetMapping("removeItem/{itemIndex}")
    public ModelAndView removeItem(@PathVariable int itemIndex) {
        sale.getItems().remove(itemIndex);
        return new ModelAndView("redirect:/cart");
    }

    @PostMapping("updateItemAmount/{itemIndex}")
    public ModelAndView updateItem(@PathVariable int itemIndex, Item item) {
        sale.getItems().get(itemIndex).setAmount(item.getAmount());
        return new ModelAndView("redirect:/cart");
    }
}