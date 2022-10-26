/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Configuration para indicar ao Spring que essa é uma classe de configuração.
 * Em seguida, é preciso estender a classe WebMvcConfigurerAdapter.
 * @author fagno
 */
@Configuration
public class ConfigurationSpringMvc implements WebMvcConfigurer{

    
    /**
     * Com a chamada a registry.addViewController(), estamos registrando um controller automático,
     * definido pelo próprio Spring, para atender a requisições direcionadas à URL / e /home. E com a chamada 
     * a setViewName(), sempre que a aplicação receber uma requisição para um desses endereços, a view home, 
     * criada na última aula, será exibida.
     * @param registry 
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/store");
        registry.addRedirectViewController("/home", "/store");
    }

}