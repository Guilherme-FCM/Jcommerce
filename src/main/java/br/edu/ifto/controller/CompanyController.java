/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.controller;

import br.edu.ifto.model.entity.Company;
import br.edu.ifto.model.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 *
 * @author GuilhermeFCM
 */
@Controller
@Transactional
@RequestMapping("companies")
public class CompanyController {
    @Autowired
    CompanyRepository repository;

    @GetMapping
    public ModelAndView findAll(ModelMap model){
        model.addAttribute("companies", repository.findAll());
        return new ModelAndView("/companies/list", model);
    }

    @GetMapping("/form")
    public ModelAndView form(Company company){
        return new ModelAndView("/companies/form");
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid Company company, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()) return form(company);
        repository.save(company);
        attributes.addFlashAttribute("success", "Empresa " + company.getName() + " cadastrada com sucesso.");
        return new ModelAndView("redirect:/companies");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id, ModelMap model) {
        model.addAttribute("company", repository.findById(id).get());
        return new ModelAndView("/companies/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(@Valid Company company, BindingResult result){
        if(result.hasErrors()) return form(company);
        repository.save(company);
        return new ModelAndView("redirect:/companies");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable Long id){
        repository.deleteById(id);
        return new ModelAndView("redirect:/companies");
    }
}
