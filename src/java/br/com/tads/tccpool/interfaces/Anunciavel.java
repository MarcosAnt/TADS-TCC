/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.interfaces;

/**
 *
 * @author onurb
 */
public interface Anunciavel {
    public void setDescricao( String s);
    public String getDescricao();
    public void setPreco(float preco);
    public float getPreco();
    public String getTitulo();
    public void setTitulo(String titulo);
}
