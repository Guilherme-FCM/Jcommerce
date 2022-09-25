/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.model.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author GuilhermeFCM
 */
@Entity
@Table(name = "items")
public class Item implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    
    private int amount;
    
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    @OneToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;


    public Item(Product product) {
        this.product = product;
        this.amount = 1;
    }

    public double total(){
        return product.getPrice() * amount; 
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
