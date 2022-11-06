/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.controller;

import br.edu.ifto.model.entity.Sale;
import br.edu.ifto.model.entity.User;
import br.edu.ifto.model.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    Sale sale;

    @GetMapping
    public ModelAndView list(ModelMap model){
        model.addAttribute("sales", repository.findAll());
        return new ModelAndView("/sales/list", model);
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(ModelMap model, @PathVariable Long id){
        model.addAttribute("sale", repository.findById(id).get());
        return new ModelAndView("/sales/details");
    }

    @PostMapping("/changeUser")
    public ModelAndView changeUser(User user, RedirectAttributes attributes){
        sale.setUser(user);
        attributes.addFlashAttribute("success", "Usuário " + user.getName() + " selecionado.");
        return new ModelAndView("redirect:/cart");
    }

    @GetMapping("/finish")
    public ModelAndView finish(HttpSession session, RedirectAttributes attributes){
        if (sale.getItems().size() == 0)
            attributes.addFlashAttribute("error", "A venda não pode ser finalizada com o carrinho vazio.");
        else if (sale.getUser().getId() == null) {
            attributes.addFlashAttribute("error", "Selecione um usuário para finalizar a venda.");
            return new ModelAndView("redirect:/cart");
        } else {
            repository.save(sale);
            session.invalidate();
            attributes.addFlashAttribute("success", "Venda realizada com sucesso.");
        }
        return new ModelAndView("redirect:/store");
    }
}
