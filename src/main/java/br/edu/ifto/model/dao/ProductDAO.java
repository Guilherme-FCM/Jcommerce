/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.model.dao;

import br.edu.ifto.model.entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class ProductDAO {
    Connection connection;
    
    public ProductDAO(){
        connection = MyConnection.connect();
    }

    public List<Product> listProducts() {
        try {
            //comando sql
            String sql = "select * from products";
            PreparedStatement ps = connection.prepareStatement(sql);
            //ResultSet, representa o resultado do comando SQL
            ResultSet rs = ps.executeQuery();
            //cria uma lista de pessoas para retornar
            List<Product> pessoas = new ArrayList();
            //laço para buscar todas as pessoas do banco
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getLong("id"));
                p.setName(rs.getString("name"));
                //add pessoa na lista
                pessoas.add(p);
            }
            //retorna a lista de pessoas
            return pessoas;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
