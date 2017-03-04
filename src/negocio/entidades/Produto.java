/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.entidades;

/**
 *
 * @author lucasmiranda
 */
public class Produto {
    
    private String nome;
    private String preco;
    private String descricao;
    private String tipo;
    private String id;
    
    public Produto(String nome, String preco, String descricao, String tipo){
        setNome(nome);
        setPreco(preco);
        setDescricao(descricao);
        setTipo(tipo);
    }
    
    public Produto(String id,String nome, String preco, String descricao, String tipo){
        setNome(nome);
        setPreco(preco);
        setDescricao(descricao);
        setTipo(tipo);
        this.id = id;
    }    

    public Produto(int aInt, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the preco
     */
    public String getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(String preco) {
        this.preco = preco;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    
    
    
    
    
}
