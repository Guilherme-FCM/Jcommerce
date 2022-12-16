/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.controller;

import br.edu.ifto.model.entity.User;
import br.edu.ifto.model.repository.RoleRepository;
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
 * @author GuilhermeFCM
 */
@Controller
@Transactional
@RequestMapping("users")
public class UserController {
    @Autowired
    UserRepository repository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping
    public ModelAndView findAll(ModelMap model) {
        model.addAttribute("users", repository.findAll());
        return new ModelAndView("/users/list", model);
    }

    @GetMapping("/form")
    public ModelAndView form(User user, ModelMap model) {
        model.addAttribute("roles", roleRepository.findAll());
        return new ModelAndView("/users/form", model);
    }

    @PostMapping("/save")
    public ModelAndView save(@Validated User user, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors())
            return form(user, new ModelMap());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        repository.save(user);
        attributes.addFlashAttribute("success", "Usuário " + user.getName() + " cadastrado com sucesso.");
        return new ModelAndView("redirect:/users");
    }

    @PostMapping("/register")
    public ModelAndView register(@Validated User user, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("error", "Não foi possível finalizar o cadastro, tente novamente.");
            return new ModelAndView("redirect:/signup");
        }
        if (repository.findByEmail(user.getEmail()) != null){
            attributes.addFlashAttribute("error", "Este e-mail já está sendo utilizado.");
            return new ModelAndView("redirect:/signup");
        }
        user.getRoles().add(roleRepository.findByName("ROLE_USER"));
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        repository.save(user);

        attributes.addFlashAttribute("success", "Cadastro finalizado, faça o login para acessar.");
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id, ModelMap model) {
        User user = repository.findById(id).get();
        model.addAttribute("user", user);
        model.addAttribute("roles", roleRepository.findAll());
        return new ModelAndView("/users/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(@Validated User user, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors())
            return form(user, new ModelMap());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
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
