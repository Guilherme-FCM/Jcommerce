/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.model.repository;

import br.edu.ifto.model.entity.Item;
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
public class SaleRepository {
    @PersistenceContext
    EntityManager em;
    
    public List<Item> findAll(){
        Query query = em.createQuery("from Sale");
        return query.getResultList();
    }
}
