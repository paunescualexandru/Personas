/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Dinamo
 */
public class MyConnection {
    
    
    public static Connection getConnection(){
        String user = "test";
        String password = "1234";
        String url = "jdbc:derby://localhost:1527/persoane;create=true";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        Connection connection = null;
        PreparedStatement statement = null; // we need it for insert or update
        ResultSet resultSet = null;
               
        try{
        Class driverClass = Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
        }catch(Exception ex){
            System.out.println("From MyConnection Class"+ex);
        }
        return connection;
    }
}
