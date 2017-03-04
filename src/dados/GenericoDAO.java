/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import excecoes.BancoDeDadosException;
import java.sql.ResultSet;

/**
 *
 * @author ALUNO
 */
public abstract class GenericoDAO {
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String BD = "lanchonet";
    private final String CONEXAO = "jdbc:mysql://localhost:3306/" + BD;
    private final String USUARIO = "lucasmiranda";
    private final String SENHA = "pirapora";
    
    public Connection getConnection() throws BancoDeDadosException {
            
        try {
            //carregar o driver
            Class.forName(DRIVER);
            
            //pegando a conexao com o BD
            Connection cx = DriverManager.getConnection(CONEXAO, USUARIO, SENHA);
            
            return cx;
            
        } catch (ClassNotFoundException ex) {
            throw  new BancoDeDadosException("Erro ao ler o driver mysql!");
        } catch (SQLException ex){
            throw  new BancoDeDadosException("Erro ao conectar ao mysql! ");
        }
    }//getConnection
    
    public PreparedStatement prepareStatement(String query) throws BancoDeDadosException {
        try {
            return getConnection().prepareStatement(query);
        }catch (SQLException ex){
            throw new BancoDeDadosException("Erro no statement");
        }
    }
    
    public int tamanho(ResultSet a){
        int b = 0;
        try {
            while(a.next()){
               b++;                
            }
        } catch (SQLException ex) {
           System.out.print("Erro");
        }
        return b;
    }
    
    /*public static void main(String[] args) throws BancoDeDadosException {
        GenericDAO gd = new GenericDAO();
        
        gd.getConnection();
    }*/
}