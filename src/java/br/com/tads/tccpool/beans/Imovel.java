/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.beans;

import br.com.tads.tccpool.interfaces.Anunciavel;
import java.io.Serializable;

/**
 *
 * @author onurb
 */
public class Imovel implements Anunciavel, Serializable {
    private String descricao;
    private String titulo;
    private float preco;
    private String rua;
    private int numero;
    private String estado;
    private String cidade;
    private String cep;
    private String complemento="";

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

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
