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
public class Administrador {
    
    private String nome;
    private String usuario;
    private String senha;
    private int id;

    public Administrador(String nome, String usuario, String senha){
        setNome(nome);
        setUsuario(usuario);
        setSenha(senha);
    }
    
    public Administrador(int id, String nome, String usuario, String senha){
        setNome(nome);
        setUsuario(usuario);
        setSenha(senha);
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    

  
    
    
}
