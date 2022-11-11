/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.model.repository;

import br.edu.ifto.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 *
 * @author GuilhermeFCM
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByDescriptionContaining(String description);
}
