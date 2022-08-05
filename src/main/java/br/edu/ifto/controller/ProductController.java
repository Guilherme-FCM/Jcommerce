/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.Products.controller;

import br.edu.ifto.Products.model.dao.ProductDAO;
import br.edu.ifto.Products.model.entity.Product;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author aluno
 */

@Controller
@RequestMapping("produtos")
public class ProductController {
    ProductDAO dao;

    public ProductController() {
        dao = new ProductDAO();
    }
    
    @ResponseBody
    @GetMapping("/list")
    public List<Product> listProducts(){
        return dao.listProducts();
    }
}
