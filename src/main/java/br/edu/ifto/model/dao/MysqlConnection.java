/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.Products.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class MysqlConnection implements JDBC {

    @Override
    public Connection createConnection() {
        try {
            //carregar o driver de conexão
            Class.forName("com.mysql.cj.jdbc.Driver");
            //parâmetros
            String url = "jdbc:mysql://localhost:3306/Products";
            String user = "Guilherme";
            String password = "guifcm12";
            //retorna a conexão com o banco de dados
            return DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MysqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
