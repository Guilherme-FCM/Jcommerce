/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.model.repository;

import br.edu.ifto.model.entity.Company;
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
public class CompanyRepository {
    @PersistenceContext
    EntityManager em;

    public List<Company> findAll(){
        Query query = em.createQuery("from Company");
        return query.getResultList();
    }

    public Company find(Long id){ return em.find(Company.class, id); }

    public void create(Company company){ em.persist(company); }

    public Company update(Company company){ return em.merge(company); }

    public void remove(Long id) { em.remove( this.find(id) ); }
}
