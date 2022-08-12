/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifto.model.dao;

import java.sql.Connection;

/**
 *
 * @author aluno
 */
public class MyConnection {
    public static Connection connect(){
        JDBC connection = new MysqlConnection();
        return connection.createConnection();
    }
}
