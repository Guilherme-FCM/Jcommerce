/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.model.dao;

import br.edu.ifto.model.jdbc.MyConnection;
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
            String sql = "select * from products";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Product> pessoas = new ArrayList();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getLong("id"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));

                pessoas.add(p);
            }
            return pessoas;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean remove(Long id) {
        try {
            String sql = "delete from products where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setLong(1, id);
            
            if(ps.executeUpdate()==1) return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean save(Product product) {
        try {
            String sql = "insert into products (description, price) values (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, product.getDescription());
            ps.setDouble(2, product.getPrice());

            if(ps.executeUpdate()==1) return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(Product product) {
        try {
            String sql = "update products set description=?, price=? where id=?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, product.getDescription());
            ps.setDouble(2, product.getPrice());
            ps.setLong(3, product.getId());

            if (ps.executeUpdate()==1) return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Product listProducts(Long id) {
        try {
            String sql = "select * from products where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setId(rs.getLong("id"));
                p.setDescription(rs.getString("description"));
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
