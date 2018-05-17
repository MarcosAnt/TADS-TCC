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
 * @author Diego
 */
public class Movel implements Serializable {
    private String titulo;
    private String descricao;
    private Float preco;
    private int tipo;

    public Movel() {}
    
    public void setDescricao(String s) {
        this.descricao = s;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }

    public String getTitulo() {
        return titulo;
    }

 
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
