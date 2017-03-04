/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;
import negocio.entidades.Administrador;
import dados.AdministradorDAO;
import excecoes.BancoDeDadosException;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author lucasmiranda
 */
public class AdministradorCtrl{
    
    public void inserir(String nome, String usuario, String senha) throws BancoDeDadosException{
        
        Administrador a = new Administrador(nome, usuario, senha);
        AdministradorDAO m = new AdministradorDAO();
        m.adicionar(a);
    }
    
    public boolean editar(int id, String nome, String usuario, String senha) throws BancoDeDadosException{
        
        Administrador a = new Administrador(id,nome, usuario, senha);
        AdministradorDAO m = new AdministradorDAO();
        m.editar(a);
        return true;
    }
    
    public boolean excluir(int id) throws BancoDeDadosException{        
        AdministradorDAO m = new AdministradorDAO();
        m.excluir(id);
        return true;
    }
    
    public Administrador buscar(int id) throws BancoDeDadosException, SQLException{
        AdministradorDAO m = new AdministradorDAO();
        return m.procurar(id);
    }
    
    public ArrayList listarTodos() throws BancoDeDadosException, SQLException{
        AdministradorDAO m = new AdministradorDAO();
        return m.listar();
    }
    
    public boolean login(String login, String senha) throws BancoDeDadosException, SQLException{
        AdministradorDAO m = new AdministradorDAO();
        return m.login(login,senha);
    }
}
