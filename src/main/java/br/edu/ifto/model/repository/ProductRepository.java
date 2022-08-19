/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.model.repository;

import br.edu.ifto.model.entity.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author GuilhermeFCM
 */
@Repository
public class ProductRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Product> findProducts(){
        Query query = em.createQuery("from Product");
        return query.getResultList();
    }
    
    public Product findProducts(Long id){
        return em.find(Product.class, id);
    }
    
    public void create(Product product){
        em.persist(product);
    }

    public void remove(Long id){
        Product product = em.find(Product.class, id);
        em.remove(product);
    }

    public void update(Product product){
        em.merge(product);
    }
}
