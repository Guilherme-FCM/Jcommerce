package br.edu.ifto;

import br.edu.ifto.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@SpringBootApplication
public class ProductsApplication {
    @Autowired
    ProductRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(ProductsApplication.class, args);
    }
        
    @GetMapping
    public ModelAndView index(ModelMap model){
        model.addAttribute("products", repository.findProducts());
        return new ModelAndView("/home", model);
    }
}
