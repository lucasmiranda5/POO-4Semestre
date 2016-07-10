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
public class clienteCtrl {
    private Conexao cone;
    public clienteCtrl() {
        cone = new Conexao();
    }
    public ArrayList<String[]> listar(){
        ResultSet a = cone.query("SELECT * from cliente ");
        ArrayList<String[]> arr;
        arr = new ArrayList<>();
        try {
            while(a.next()){
                String[] aa = new String[3];
                aa[0] = a.getString("id");
                aa[1] = a.getString("nome");
                aa[2] = a.getString("telefone");               
                arr.add(aa);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(listaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public boolean adicionar(String cpf, String nome, String telefone, String rua,String bairro, String numero){
         ResultSet a = cone.query("SELECT * from cliente WHERE cpf = '"+cpf+"'");
         int tamanho = cone.tamanho(a);
         String s = "INSERT INTO cliente (cpf,nome,telefone,rua,bairro,numero) VALUES ('"+cpf+"','"+nome+"','"+telefone+"','"+rua+"','"+bairro+"','"+numero+"')";
         System.out.print(s);
        if(tamanho == 0 ){
             boolean b = cone.query2(s);
        }else{
         return false;
        }
        return true;
    }
    
    public Map retornar(String id){
        ResultSet a = cone.query("SELECT * from cliente WHERE id = "+id);
        Map<String, String> arr = new HashMap<>();
        try {
            while(a.next()){
                arr.put("cpf",a.getString("cpf"));
                arr.put("nome",a.getString("nome"));
                arr.put("telefone",a.getString("telefone"));
                arr.put("rua",a.getString("rua"));
                arr.put("bairro",a.getString("bairro"));
                arr.put("numero",a.getString("numero"));
                              
            }
        } catch (SQLException ex) {
            Logger.getLogger(listaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arr;
    }
    
    public boolean editar(String id, String cpf, String nome, String telefone, String rua,String bairro, String numero){
         ResultSet a = cone.query("SELECT * from cliente WHERE cpf = '"+cpf+"' and id <> "+id);
         int tamanho = cone.tamanho(a);
         String s = "UPDATE cliente SET "
                 + "cpf = '"+cpf+"',"
                 + "nome = '"+nome+"',"
                 + "telefone = '"+telefone+"',"
                 + "rua = '"+rua+"',"
                 + "bairro = '"+bairro+"',"
                 + "numero = '"+numero+"' WHERE id = "+id;
         System.out.print(s);
        if(tamanho == 0 ){
             boolean b = cone.query2(s);
        }else{
         return false;
        }
        return true;
    }
    
    public boolean existe(String id){
        ResultSet a = cone.query("SELECT * from cliente WHERE id = "+id);
        int tamanho = cone.tamanho(a);
        return tamanho == 1;
    }
    
    public boolean excluir(String id){
        if(this.existe(id)){
            boolean b = cone.query2("DELETE FROM cliente WHERE id = "+id);
            return b;
        }else{
            return false;
        }
    }
}
