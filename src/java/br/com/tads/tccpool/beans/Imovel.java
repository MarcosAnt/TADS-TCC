/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.beans;

import br.com.tads.tccpool.interfaces.Anunciavel;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author onurb
 */
public class Imovel implements Anunciavel, Serializable {

    private int id;
    private int tipo;
    private String tipoDesc;
    private int quantidade_pessoas;
    private int boolean_pet;  
    private String descricao;
    private String titulo;
    private float preco;
    private String rua;
    private int numero;
    private String estado;
    private String cidade;
    private String cep;
    private String complemento = "";
    private List<String> fotos;

    
    public String getTipoDesc() {
        return tipoDesc;
    }

    public void setTipoDesc(String tipoDesc) {
        this.tipoDesc = tipoDesc;
    }
    
     public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade_pessoas() {
        return quantidade_pessoas;
    }

    public void setQuantidade_pessoas(int quantidade_pessoas) {
        this.quantidade_pessoas = quantidade_pessoas;
    }

    public int getBoolean_pet() {
        return boolean_pet;
    }

    public void setBoolean_pet(int boolean_pet) {
        this.boolean_pet = boolean_pet;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<String> getFotos() {
        return fotos;
    }
    @Override
    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String getCidade() {
        return cidade;
    }
    @Override
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    @Override
    public String getRua() {
        return rua;
    }
    @Override
    public void setRua(String rua) {
        this.rua = rua;
    }
    @Override
    public int getNumero() {
        return numero;
    }
    @Override
    public void setNumero(int numero) {
        this.numero = numero;
    }
    @Override
    public String getEstado() {
        return estado;
    }
    @Override
    public void setEstado(String estado) {
        this.estado = estado;
    }
    @Override
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public float getPreco() {
        return preco;
    }

    @Override
    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public void setDescricao(String desc) {
        this.descricao = desc;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

}
