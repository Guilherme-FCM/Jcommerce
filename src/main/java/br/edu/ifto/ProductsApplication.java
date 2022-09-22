package br.edu.ifto;

import br.edu.ifto.model.entity.Product;
import br.edu.ifto.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
        
    @GetMapping("store")
    public ModelAndView store(ModelMap model, Product product){
        model.addAttribute("products", repository.findProducts());
        return new ModelAndView("/shopping/store", model);
    }

    @GetMapping("cart")
    public String cart(){
        return "/shopping/cart";
    }
}
