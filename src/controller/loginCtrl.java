/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.Conexao;
import view.loginAdm;
import view.homeAdm;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucasmiranda
 */
public class loginCtrl {
    private Conexao cone;
    public loginCtrl() {
        cone = new Conexao();
    }
    public boolean login(String usuario, String senha){
        int b = 0;
        ResultSet a = cone.query("SELECT * from administrador WHERE usuario = '"+usuario+"' and senha = '"+senha+"'");
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
