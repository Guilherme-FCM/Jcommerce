/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.model.repository;

import br.edu.ifto.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author GuilhermeFCM
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
  Role findByName(String name);
}
