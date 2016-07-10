/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.List;
import model.Conexao;
import view.listaCliente;
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
public class materiaCtrl {
    private Conexao cone;
    public materiaCtrl() {
        cone = new Conexao();
    }
    public ArrayList<String[]> listar(){
        ResultSet a = cone.query("SELECT * from materiaprima ");
        ArrayList<String[]> arr;
        arr = new ArrayList<>();
        try {
            while(a.next()){
                String[] aa = new String[6];
                aa[0] = a.getString("id");
                aa[2] = a.getString("nome");
                aa[3] = a.getString("preco");
                aa[4] = a.getString("quantidade");
                ResultSet a2 = cone.query("SELECT * from fornecedor id ="+a.getString("fornecedor"));
                while(a2.next()){
                     aa[5] = a2.getString("nomeFantasia");
                }
                arr.add(aa);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(listaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public boolean adicionar(String nome, String preco, String quantidade, String fornecedor){
         String s = "INSERT INTO materiaprima (nome,preco,quantidade,fornecedor) VALUES ('"+nome+"','"+preco+"','"+quantidade+"','"+fornecedor+"')";
       
        return cone.query2(s);
        
    }
    
    public Map retornar(String id){
        ResultSet a = cone.query("SELECT * from materiaprima WHERE id = "+id);
        Map<String, String> arr = new HashMap<>();
        try {
            while(a.next()){
                arr.put("nome",a.getString("nome"));
                arr.put("preco",a.getString("preco"));
                arr.put("quantidade",a.getString("quantidade"));
                arr.put("fornecedor",a.getString("fornecedor"));
                              
            }
        } catch (SQLException ex) {
            Logger.getLogger(listaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arr;
    }
    
    public boolean editar(String id, String nome, String preco, String quantidade, String fornecedor){

         String s = "UPDATE materiaprima SET "
                 + "nome = '"+nome+"',"
                 + "preco = '"+preco+"',"
                 + "quantidade = '"+quantidade+"',"
                 + "fornecedor = '"+fornecedor+"' WHERE id = "+id;
        return  cone.query2(s);
        
    }
    
    public boolean existe(String id){
        ResultSet a = cone.query("SELECT * from materiaprima WHERE id = "+id);
        int tamanho = cone.tamanho(a);
        return tamanho == 1;
    }
    
    public boolean excluir(String id){
        if(this.existe(id)){
            boolean b = cone.query2("DELETE FROM materiaprima WHERE id = "+id);
            return b;
        }else{
            return false;
        }
    }
}
