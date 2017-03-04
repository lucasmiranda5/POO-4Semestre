/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import negocio.entidades.Administrador;
import excecoes.BancoDeDadosException;
import GUI.loginAdm;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucasmiranda
 */
public class AdministradorDAO extends GenericoDAO{
    
    public void adicionar(Administrador u) throws BancoDeDadosException{
        String query = "INSERT INTO administrador(nome, usuario,senha) VALUES (?, ?, ?)";
        
        PreparedStatement ps = prepareStatement(query);
        
        try{
            ps.setString(1, u.getNome());
            
            
            ps.setString(2, u.getUsuario());
            
            ps.setString(3, u.getSenha());
            
            //executar o comando
            ps.executeUpdate();
            
            //fechar a conexao
            ps.close();
            
        }catch(SQLException ex){
            throw new BancoDeDadosException("erro ao inserir"+ex.getMessage());
        }
    }//adicionar usuario
    
    public void editar(Administrador u) throws BancoDeDadosException{
        String query = "UPDATE administrador SET nome = ?, usuario = ?, senha = ? WHERE id = ?";
        
        PreparedStatement ps = prepareStatement(query);
        
        try{
            ps.setString(1, u.getNome());            
            
            ps.setString(2, u.getUsuario());
            
            ps.setString(3, u.getSenha());
            
            ps.setInt(4, u.getId());
            
            //executar o comando
            ps.executeUpdate();
            
            //fechar a conexao
            ps.close();
            
        }catch(SQLException ex){
            throw new BancoDeDadosException("erro ao editar"+ex.getMessage());
        }
    }
    
     public void excluir(int id) throws BancoDeDadosException{
        String query = "DELETE FROM administrador WHERE id = ?";
        
        PreparedStatement ps = prepareStatement(query);
        
        try{
            ps.setInt(1, id);
            
            //executar o comando
            ps.executeUpdate();
            
            //fechar a conexao
            ps.close();
            
        }catch(SQLException ex){
            throw new BancoDeDadosException("erro ao excluir"+ex.getMessage());
        }
    }
    
    
    public Administrador procurar(int id)
            throws BancoDeDadosException, SQLException{
        String query="SELECT * FROM administrador WHERE id = ?";
        
        PreparedStatement ps = prepareStatement(query);
        try{
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Administrador u=new Administrador(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("usuario"),
                    rs.getString("senha"));
                rs.close();
                ps.close();
                return u;
            }
            return null;
        }
        catch(SQLException ex){
            throw new BancoDeDadosException("Erro ao procurar");
        }
    }
    
    public ArrayList<Administrador> listar()
            throws BancoDeDadosException, SQLException{
        String query="SELECT * FROM administrador";
        ArrayList <Administrador> u = new ArrayList();
        
        PreparedStatement ps = prepareStatement(query);
        try{
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                u.add(new Administrador(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("usuario"),
                    rs.getString("senha")));
                rs.close();
                ps.close();
                return u;
            }
            return null;
        }
        catch(SQLException ex){
            throw new BancoDeDadosException("Erro ao procurar");
        }
    }
    
    public boolean login(String usuario, String senha) throws BancoDeDadosException, SQLException{
         int b = 0;
         String query="SELECT * from administrador WHERE usuario = '"+usuario+"' and senha = '"+senha+"'";
         PreparedStatement ps = prepareStatement(query);
         ResultSet a=ps.executeQuery();
         try {
             while(a.next()){
                 b++;
             }
         } catch (SQLException ex) {
             Logger.getLogger(loginAdm.class.getName()).log(Level.SEVERE, null, ex);
         }
         return b > 0;
     }
}
