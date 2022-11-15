/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.model.repository;

import br.edu.ifto.model.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author GuilhermeFCM
 */
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByDateBetween(LocalDate date, LocalDate date2);
    List<Sale> findByDateBefore(LocalDate date);
    List<Sale> findByDateAfter(LocalDate date);
}
