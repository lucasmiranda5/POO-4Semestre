/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import GUI.listaFornec;
import negocio.entidades.Fornecedor;
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
public class FornecedorDAO extends GenericoDAO{
    
    public void adicionar(Fornecedor u) throws BancoDeDadosException{
        String query = "INSERT INTO fornecedor(cnpj, razaoSocial,nomeFantasia,telefone,rua,bairro,cidade,responsavel) VALUES (?, ?, ?,?,?,?,?,?)";
        
        PreparedStatement ps = prepareStatement(query);
        
        try{
            ps.setString(1, u.getCnpj());           
            
            ps.setString(2, u.getRazaoSocial());
            
            ps.setString(3, u.getNomeFantasia());
            
            ps.setString(4, u.getTelefone());
            
            ps.setString(5, u.getRua());
             
            ps.setString(6, u.getBairro());
              
            ps.setString(7, u.getCidade());
            
            ps.setString(8, u.getResponsavel());
            
            //executar o comando
            ps.executeUpdate();
            
            //fechar a conexao
            ps.close();
            
        }catch(SQLException ex){
            throw new BancoDeDadosException("erro ao inserir"+ex.getMessage());
        }
    }//adicionar usuario
    
    public void editar(Fornecedor u) throws BancoDeDadosException{
        String query = "UPDATE fornecedor SET cnpj = ?, razaoSocial = ?,nomeFantasia = ?,telefone = ?,rua = ?,bairro = ?,cidade = ?,responsavel = ? WHERE id = ?";
        
        PreparedStatement ps = prepareStatement(query);
        
        try{
            ps.setString(1, u.getCnpj());           
            
            ps.setString(2, u.getRazaoSocial());
            
            ps.setString(3, u.getNomeFantasia());
            
            ps.setString(4, u.getTelefone());
            
            ps.setString(5, u.getRua());
             
            ps.setString(6, u.getBairro());
              
            ps.setString(7, u.getCidade());
            
            ps.setString(8, u.getResponsavel());
            
            ps.setString(9, u.getId());
            
            //executar o comando
            ps.executeUpdate();
            
            //fechar a conexao
            ps.close();
            
        }catch(SQLException ex){
            throw new BancoDeDadosException("erro ao editar"+ex.getMessage());
        }
    }
    
     public void excluir(String id) throws BancoDeDadosException{
        String query = "DELETE FROM fornecedor WHERE id = ?";
        
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
    
    
    public Fornecedor procurar(String id)
            throws BancoDeDadosException, SQLException{
        String query="SELECT * FROM fornecedor WHERE id = ?";
        
        PreparedStatement ps = prepareStatement(query);
        try{
            ps.setString(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Fornecedor u=new Fornecedor(
                    rs.getString("id"),
                    rs.getString("cnpj"),
                    rs.getString("razaoSocial"),
                    rs.getString("nomeFantasia"),
                    rs.getString("telefone"),
                    rs.getString("rua"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("responsavel")
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
        String query="SELECT * FROM fornecedor";
        ArrayList <Fornecedor> u = new ArrayList();
        
        PreparedStatement ps = prepareStatement(query);
        try{
            ResultSet rs=ps.executeQuery();
            ArrayList<Object> arr = new ArrayList<>();
                while(rs.next()){
                String[] aa = new String[3];
                aa[0] = rs.getString("id");
                aa[1] = rs.getString("razaoSocial");
                aa[2] = rs.getString("cnpj");               
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
        PreparedStatement ps =  prepareStatement("SELECT * from fornecedor WHERE id = "+id);
        ResultSet a = ps.executeQuery();         
        int tamanho = tamanho(a);
        return tamanho == 1;
    }
    
     public Map retornar(String id) throws BancoDeDadosException, SQLException{
        PreparedStatement ps =  prepareStatement("SELECT * from fornecedor WHERE id = "+id);
        ResultSet a = ps.executeQuery();
        Map<String, String> arr = new HashMap<>();
        try {
            while(a.next()){
                arr.put("razaoSocial",a.getString("razaoSocial"));
                arr.put("cnpj",a.getString("cnpj"));
                arr.put("nomeFantasia",a.getString("nomeFantasia"));
                arr.put("telefone",a.getString("telefone"));
                arr.put("rua",a.getString("rua"));
                arr.put("bairro",a.getString("bairro"));
                arr.put("cidade",a.getString("cidade"));
                arr.put("responsavel",a.getString("responsavel"));                
                              
            }
        } catch (SQLException ex) {
            Logger.getLogger(listaFornec.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arr;
    }



    
}
