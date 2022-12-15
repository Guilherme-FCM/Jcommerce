package br.edu.ifto.controller;

import br.edu.ifto.model.entity.Item;
import br.edu.ifto.model.entity.Sale;
import br.edu.ifto.model.repository.ProductRepository;
import br.edu.ifto.model.repository.SaleRepository;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    SaleRepository saleRepository;

    @Autowired
    Sale sale;

    @GetMapping
    public ModelAndView cart(ModelMap model, Item item) {
        model.addAttribute("users", userRepository.findAll());
        return new ModelAndView("/store/cart", model);
    }

    @GetMapping("/finish")
    public ModelAndView finish(HttpServletRequest request, HttpSession session, RedirectAttributes attributes) {
        if (sale.getItems().size() == 0)
            attributes.addFlashAttribute("error", "A venda não pode ser finalizada com o carrinho vazio.");
        else {
            String userEmail = request.getUserPrincipal().getName();
            sale.setUser(userRepository.findByEmail(userEmail));
            saleRepository.save(sale);
            session.invalidate();
            attributes.addFlashAttribute("success", "Venda realizada com sucesso.");
        }
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/item")
    public ModelAndView addItem(@Validated Item item, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors())
            attributes.addFlashAttribute("error", "Não foi possível adicionar este produto ao carrinho");
        else {
            Long productId = item.getProduct().getId();
            item.setProduct(productRepository.findById(productId).get());
            sale.addItem(item);
            attributes.addFlashAttribute("success", item.getProduct().getDescription() + " adicionado ao carrinho");
        }
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/item/remove/{itemIndex}")
    public ModelAndView removeItem(@PathVariable int itemIndex, RedirectAttributes attributes) {
        sale.getItems().remove(itemIndex);
        attributes.addFlashAttribute("success", "Item removido do carrinho");
        return new ModelAndView("redirect:/cart");
    }

    @PostMapping("/item/updateAmount/{itemIndex}")
    public ModelAndView updateItem(@PathVariable int itemIndex, @Validated Item item, BindingResult result) {
        if (result.hasErrors())
            return cart(new ModelMap(), item);
        else
            sale.getItems().get(itemIndex).setAmount(item.getAmount());
        return new ModelAndView("redirect:/cart");
    }
}