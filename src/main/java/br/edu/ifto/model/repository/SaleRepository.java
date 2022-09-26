/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.model.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.edu.ifto.model.entity.Sale;
import org.springframework.stereotype.Repository;

/**
 *
 * @author GuilhermeFCM
 */
@Repository
public class SaleRepository {
    @PersistenceContext
    EntityManager em;
    
    public List<Sale> findAll(){
        Query query = em.createQuery("from Sale");
        return query.getResultList();
    }

    public void create(Sale sale){ em.persist(sale); }
}
