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
}
