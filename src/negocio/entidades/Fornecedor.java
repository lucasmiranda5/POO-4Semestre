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
public class Fornecedor {
    
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String telefone;
    private String rua;
    private String bairro;
    private String cidade;
    private String responsavel;
    private String id;
    
    public Fornecedor(String cnpj, String razaoSocial, String nomeFantasia, String telefone, String rua, String bairro, String cidade, String responsavel){
        setCnpj(cnpj);
        setRazaoSocial(razaoSocial);
        setNomeFantasia(nomeFantasia);
        setTelefone(telefone);
        setRua(rua);
        setBairro(bairro);
        setCidade(cidade);
        setResponsavel(responsavel);
    }
    
    public Fornecedor(String id, String cnpj, String razaoSocial, String nomeFantasia, String telefone, String rua, String bairro, String cidade, String responsavel){
        setCnpj(cnpj);
        setRazaoSocial(razaoSocial);
        setNomeFantasia(nomeFantasia);
        setTelefone(telefone);
        setRua(rua);
        setBairro(bairro);
        setCidade(cidade);
        setResponsavel(responsavel);
        this.id = id;
    }

    public Fornecedor(int aInt, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getId(){
        return id;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    
    
    
    
}
