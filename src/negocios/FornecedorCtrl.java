/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import dados.AdministradorDAO;
import dados.FornecedorDAO;
import excecoes.BancoDeDadosException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import negocio.entidades.Administrador;
import negocio.entidades.Fornecedor;

/**
 *
 * @author lucasmiranda
 */
public class FornecedorCtrl {
     public boolean inserir(String cnpj, String razaoSocial, String nomeFantasia, String telefone, String rua, String bairro, String cidade, String responsavel) throws BancoDeDadosException{
        
        Fornecedor a = new Fornecedor(cnpj, razaoSocial,nomeFantasia,telefone,rua,bairro,cidade,responsavel);
        FornecedorDAO m = new FornecedorDAO();
        m.adicionar(a);
        return true;
    }
    
    public boolean editar(String id, String cnpj, String razaoSocial, String nomeFantasia, String telefone, String rua, String bairro, String cidade, String responsavel) throws BancoDeDadosException{
        
        Fornecedor a = new Fornecedor(id,cnpj, razaoSocial,nomeFantasia,telefone,rua,bairro,cidade,responsavel);
        FornecedorDAO m = new FornecedorDAO();
        m.editar(a);
        return true;
    }
    
    public Fornecedor buscar(String id) throws BancoDeDadosException, SQLException{
        FornecedorDAO m = new FornecedorDAO();
        return m.procurar(id);
    }
    
    public ArrayList listarTodos() throws BancoDeDadosException, SQLException{
        FornecedorDAO m = new FornecedorDAO();
        return m.listar();
    }
    
    public boolean excluir(String id) throws BancoDeDadosException{        
        FornecedorDAO m = new FornecedorDAO();
        m.excluir(id);
        return true;
    }


    
    public boolean existe(String id) throws BancoDeDadosException, SQLException{
         FornecedorDAO m = new FornecedorDAO();
        return m.existe(id);
    }



}
