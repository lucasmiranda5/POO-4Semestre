/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucasmiranda
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    private Connection con;
    private Statement stmt;
    
    public Conexao(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println("Error: "+ e.getMessage());
        }
         
        String url = "jdbc:mysql://127.0.0.1:3306/lanchonet";
        String user = "root";
        String password = "pirapora";
         
        try{
        con = DriverManager.getConnection(url,user,password);
        stmt = con.createStatement();
         
        }catch(SQLException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }
    
    public ResultSet query(String q){
        ResultSet a = null;
        try{
            a = stmt.executeQuery(q);         
            
        }catch(SQLException e){
            System.out.println("Error: "+ e.getMessage());            
        }
        
        return a;
    }
    
}
