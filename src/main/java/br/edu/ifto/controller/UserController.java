/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.controller;

import br.edu.ifto.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @GetMapping()
    public ModelAndView findAll(ModelMap model){
        model.addAttribute("users", repository.findAll());
        return new ModelAndView("/users/list", model);
    }
}
