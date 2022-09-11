/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.model.repository;

import br.edu.ifto.model.entity.User;
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
public class UserRepository {
    @PersistenceContext
    EntityManager em;
    
    public List<User> findAll(){
        Query query = em.createQuery("from User");
        return query.getResultList();
    }

    public User find(Long id){ return em.find(User.class, id); }

    public void create(User user){ em.persist(user); }

    public User update(User user){ return em.merge(user); }
}
