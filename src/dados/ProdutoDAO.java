/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import GUI.listaProduto;
import negocio.entidades.Produto;
import excecoes.BancoDeDadosException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucasmiranda
 */
public class ProdutoDAO extends GenericoDAO{
    
    public void adicionar(Produto u) throws BancoDeDadosException{
        String query = "INSERT INTO produto(nome, preco,descricao,tipo) VALUES (?, ?, ?,?)";
        
        PreparedStatement ps = prepareStatement(query);
        
        try{
            ps.setString(1, u.getNome());           
            
            ps.setString(2, u.getPreco());
            
            ps.setString(3, u.getDescricao());
            
            ps.setString(4, u.getTipo());
            

            
            //executar o comando
            ps.executeUpdate();
            
            //fechar a conexao
            ps.close();
            
        }catch(SQLException ex){
            throw new BancoDeDadosException("erro ao inserir"+ex.getMessage());
        }
    }//adicionar usuario
    
    public void editar(Produto u) throws BancoDeDadosException{
        String query = "UPDATE produto SET nome = ?, descricao = ?,preco = ?,tipo = ? WHERE id = ?";
        
        PreparedStatement ps = prepareStatement(query);
        
        try{
            ps.setString(1, u.getNome());           
            
            ps.setString(2, u.getDescricao());
            
            ps.setString(3, u.getPreco());
            
            ps.setString(4, u.getTipo());
            
            ps.setString(5, u.getId());
            
            //executar o comando
            ps.executeUpdate();
            
            //fechar a conexao
            ps.close();
            
        }catch(SQLException ex){
            throw new BancoDeDadosException("erro ao editar"+ex.getMessage());
        }
    }
    
     public void excluir(String id) throws BancoDeDadosException{
        String query = "DELETE FROM produto WHERE id = ?";
        
        PreparedStatement ps = prepareStatement(query);
        
        try{
            ps.setString(1, id);
            
            //executar o comando
            ps.executeUpdate();
            
            //fechar a conexao
            ps.close();
            
        }catch(SQLException ex){
            throw new BancoDeDadosException("erro ao excluir"+ex.getMessage());
        }
    }
    
    
    public Produto procurar(String id)
            throws BancoDeDadosException, SQLException{
        String query="SELECT * FROM produto WHERE id = ?";
        
        PreparedStatement ps = prepareStatement(query);
        try{
            ps.setString(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Produto u=new Produto(
                    rs.getString("id"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getString("preco"),
                    rs.getString("tipo")
                );
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
    
    public ArrayList<Object> listar()
            throws BancoDeDadosException, SQLException{
        String query="SELECT * FROM produto";
        ArrayList <Produto> u = new ArrayList();
        
        PreparedStatement ps = prepareStatement(query);
        try{
            ResultSet rs=ps.executeQuery();
            ArrayList<Object> arr = new ArrayList<>();
                while(rs.next()){
                String[] aa = new String[3];
                aa[0] = rs.getString("id");
                aa[1] = rs.getString("produto");
                aa[2] = rs.getString("preco");               
                arr.add(aa);    
                }
                rs.close();
                ps.close();
                return arr;
            
        }
        catch(SQLException ex){
            throw new BancoDeDadosException("Erro ao procurar");
        }
    }
    
    public boolean existe(String id) throws BancoDeDadosException, SQLException{
        PreparedStatement ps =  prepareStatement("SELECT * from produto WHERE id = "+id);
        ResultSet a = ps.executeQuery();         
        int tamanho = tamanho(a);
        return tamanho == 1;
    }
    
     public Map retornar(String id) throws BancoDeDadosException, SQLException{
        PreparedStatement ps =  prepareStatement("SELECT * from produto WHERE id = "+id);
        ResultSet a = ps.executeQuery();
        Map<String, String> arr = new HashMap<>();
        try {
            while(a.next()){
                arr.put("nome",a.getString("nome"));
                arr.put("preco",a.getString("preco"));
                arr.put("descricao",a.getString("descricao"));
                arr.put("tipo",a.getString("tipo"));
               
                              
            }
        } catch (SQLException ex) {
            Logger.getLogger(listaProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arr;
    }



    
}
