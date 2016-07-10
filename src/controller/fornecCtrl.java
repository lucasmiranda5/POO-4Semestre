/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.List;
import model.Conexao;
import view.listaFornec;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author lucasmiranda
 */
public class fornecCtrl {
    private Conexao cone;
    public fornecCtrl() {
        cone = new Conexao();
    }
    public ArrayList<String[]> listar(){
        ResultSet a = cone.query("SELECT * from fornecedor ");
        ArrayList<String[]> arr;
        arr = new ArrayList<>();
        try {
            while(a.next()){
                String[] aa = new String[3];
                aa[0] = a.getString("id");
                aa[1] = a.getString("razaoSocial");
                aa[2] = a.getString("cnpj");               
                arr.add(aa);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(listaFornec.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public boolean adicionar(String cnpj, String razaoSocial, String nomeFantasia, String telefone, String rua,String bairro, String cidade,String responsavel){
         ResultSet a = cone.query("SELECT * from fornecedor WHERE cnpj = '"+cnpj+"'");
         int tamanho = cone.tamanho(a);
         String s = "INSERT INTO fornecedor (cnpj,razaoSocial,nomeFantasia,telefone,rua,bairro,cidade,responsavel) VALUES ('"+cnpj+"','"+razaoSocial+"','"+nomeFantasia+"','"+telefone+"','"+rua+"','"+bairro+"','"+cidade+"','"+responsavel+"')";
         System.out.print(s);
        if(tamanho == 0 ){
             boolean b = cone.query2(s);
        }else{
         return false;
        }
        return true;
    }
    
    public Map retornar(String id){
        ResultSet a = cone.query("SELECT * from fornecedor WHERE id = "+id);
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
    
    public boolean editar(String id, String cnpj, String razaoSocial, String nomeFantasia, String telefone, String rua,String bairro, String cidade,String responsavel){
         ResultSet a = cone.query("SELECT * from fornecedor WHERE cnpj = '"+cnpj+"' and id <> "+id);
         int tamanho = cone.tamanho(a);
         String s = "UPDATE fornecedor SET "
                 + "cnpj = '"+cnpj+"',"
                 + "razaoSocial = '"+razaoSocial+"',"
                 + "nomeFantasia = '"+nomeFantasia+"',"
                 + "telefone = '"+telefone+"',"
                 + "rua = '"+rua+"',"
                 + "bairro = '"+bairro+"',"
                 + "cidade = '"+cidade+"',"
                 + "responsavel = '"+responsavel+"' WHERE id = "+id;
         System.out.print(s);
        if(tamanho == 0 ){
             boolean b = cone.query2(s);
        }else{
         return false;
        }
        return true;
    }
    
    public boolean existe(String id){
        ResultSet a = cone.query("SELECT * from fornecedor WHERE id = "+id);
        int tamanho = cone.tamanho(a);
        return tamanho == 1;
    }
    
    public boolean excluir(String id){
        if(this.existe(id)){
            boolean b = cone.query2("DELETE FROM fornecedor WHERE id = "+id);
            return b;
        }else{
            return false;
        }
    }
}
