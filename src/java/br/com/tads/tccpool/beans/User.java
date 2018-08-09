/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.beans;

import java.io.Serializable;

/**
 *
 * @author onurb
 */
public class User implements Serializable {
    private int id;             //Número identificador do usuário
    private int tipoUusario;    //Define se o Usuário é ADM ou não
    private String email;       //E-mail do usuário
    private String nome;        //Nome do usuário
    private String GoogleToken; //Token de login Google
    private String foto;        //Caminho da foto do usuario
    private String senha;       //Senha do usuário
    private String tel;         //Número de telefone do usuário
    private String cel;         //Número de telefone celular do usuário
    private int cdEndereco;     //Número identificador do endereço do usuário
    private String logradouro;  //Nome da rua do usuário
    private int numero;         //Número da casa do usuário
    private String CEP;         //CEP do usuário
    private String complemento; //Complemento do endereço do usuário
    private String cidade;      //Nome da cidade do usuário
    private String estado;      //Nome do estado do usuário

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getTipoUusario() {
        return tipoUusario;
    }

    public void setTipoUusario(int tipoUusario) {
        this.tipoUusario = tipoUusario;
    }

    public String getGoogleToken() {
        return GoogleToken;
    }

    public void setGoogleToken(String GoogleToken) {
        this.GoogleToken = GoogleToken;
    }
    
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public int getCdEndereco() {
        return cdEndereco;
    }

    public void setCdEndereco(int cdEndereco) {
        this.cdEndereco = cdEndereco;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return CEP;
    }

    public void setCep(String cep) {
        this.CEP = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
