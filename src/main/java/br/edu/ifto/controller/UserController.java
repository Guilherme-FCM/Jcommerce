/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.controller;

import br.edu.ifto.model.entity.User;
import br.edu.ifto.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView findAll(ModelMap model){
        model.addAttribute("users", repository.findAll());
        return new ModelAndView("/users/list", model);
    }

    @GetMapping("/form")
    public String form(User user){
        return "/users/form";
    }

    @PostMapping("/save")
    public ModelAndView save(User user){
        repository.create(user);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id, ModelMap model) {
        model.addAttribute("user", repository.find(id));
        return new ModelAndView("/users/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(User user){
        repository.update(user);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/users");
    }
}
