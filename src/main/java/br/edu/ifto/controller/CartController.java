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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("addItem")
    public ModelAndView addItem(@Validated Item item, BindingResult result, RedirectAttributes tributes) {
        if (result.hasErrors())
            tributes.addFlashAttribute("error", "Não foi possível adicionar este produto ao carrinho");
        else {
            Long productId = item.getProduct().getId();
            item.setProduct(productRepository.findById(productId).get());
            sale.addItem(item);
        }
        return new ModelAndView("redirect:/store");
    }

    @GetMapping("removeItem/{itemIndex}")
    public ModelAndView removeItem(@PathVariable int itemIndex) {
        sale.getItems().remove(itemIndex);
        return new ModelAndView("redirect:/cart");
    }

    @PostMapping("updateItemAmount/{itemIndex}")
    public ModelAndView updateItem(@PathVariable int itemIndex, @Validated Item item, BindingResult result) {
        if (result.hasErrors()) return cart(new ModelMap(), item);
        else sale.getItems().get(itemIndex).setAmount(item.getAmount());
        return new ModelAndView("redirect:/cart");
    }
}