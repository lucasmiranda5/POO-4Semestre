/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import dados.ProdutoDAO;
import excecoes.BancoDeDadosException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import negocio.entidades.Administrador;
import negocio.entidades.Produto;

/**
 *
 * @author lucasmiranda
 */
public class ProdutoCtrl {
     public boolean inserir(String nome, String preco, String descricao, String tipo) throws BancoDeDadosException{
        
        Produto a = new Produto(nome,preco,descricao,tipo);
        ProdutoDAO m = new ProdutoDAO();
        m.adicionar(a);
        return true;
    }
    
    public boolean editar(String id, String nome, String preco, String descricao, String tipo) throws BancoDeDadosException{
        
        Produto a = new Produto(id,nome,preco,descricao,tipo);
        ProdutoDAO m = new ProdutoDAO();
        m.editar(a);
        return true;
    }
    
    public Produto buscar(String id) throws BancoDeDadosException, SQLException{
        ProdutoDAO m = new ProdutoDAO();
        return m.procurar(id);
    }
    
    public ArrayList listarTodos() throws BancoDeDadosException, SQLException{
        ProdutoDAO m = new ProdutoDAO();
        return m.listar();
    }
    
    public boolean excluir(String id) throws BancoDeDadosException{        
        ProdutoDAO m = new ProdutoDAO();
        m.excluir(id);
        return true;
    }


    
    public boolean existe(String id) throws BancoDeDadosException, SQLException{
         ProdutoDAO m = new ProdutoDAO();
        return m.existe(id);
    }



}
