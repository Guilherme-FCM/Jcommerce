/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.controller;

import br.edu.ifto.model.entity.User;
import br.edu.ifto.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

/**
 *
 * @author GuilhermeFCM
 */
@Controller
@Transactional
@RequestMapping("users")
public class UserController {
    @Autowired
    UserRepository repository;

    @GetMapping
    public ModelAndView findAll(ModelMap model) {
        model.addAttribute("users", repository.findAll());
        return new ModelAndView("/users/list", model);
    }

    @GetMapping("/form")
    public ModelAndView form(User user) {
        return new ModelAndView("/users/form");
    }

    @PostMapping("/save")
    public ModelAndView save(@Validated User user, BindingResult result, RedirectAttributes attributes) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        if (result.hasErrors())
            return form(user);
        repository.save(user);
        attributes.addFlashAttribute("success", "Usuário " + user.getName() + " cadastrado com sucesso.");
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id, ModelMap model) {
        model.addAttribute("user", repository.findById(id).get());
        return new ModelAndView("/users/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(@Validated User user, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors())
            return form(user);
        repository.save(user);
        attributes.addFlashAttribute("success", "Usuário " + user.getName() + " atualizado com sucesso.");
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable Long id, RedirectAttributes attributes) {
        repository.deleteById(id);
        attributes.addFlashAttribute("success", "Usuário removido com sucesso.");
        return new ModelAndView("redirect:/users");
    }
}
