/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;
import negocios.AdministradorCtrl;
import negocio.entidades.Administrador;
import excecoes.BancoDeDadosException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lucasmiranda
 */
public class AdministradorTeste {
    
   public static void main(String[] args) throws BancoDeDadosException, SQLException{
       AdministradorCtrl ctrl = new AdministradorCtrl();
       int i;
       //inserir
       ctrl.inserir("Lucas", "miranda", "123");
       
       //buscar
       Administrador ad = ctrl.buscar(1);
       
       //Pesquisar
       ArrayList<Administrador>  listas = ctrl.listarTodos();
       
       //editar
       ctrl.editar(1,"Lucas","teste2","sass");
       
       //Excluir
       ctrl.excluir(1);
       
       
   }
    
}
