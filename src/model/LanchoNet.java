package model;


import model.Conexao;
import view.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucasmiranda
 */
public class LanchoNet {
    
      public static void main(String[] args) {
       loginAdm t = new loginAdm();
       homeAdm m = new homeAdm();
       Conexao con = new Conexao();
       m.setVisible(true);
    }    
}
