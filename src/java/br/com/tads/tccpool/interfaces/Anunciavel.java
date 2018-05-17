/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.interfaces;

import java.util.List;

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
    public List<String> getFotos();
    public void setFotos(List<String> fotos);
    public int getId();
    public void setId(int id);
    public String getCidade();
    public void setCidade(String cidade);
    public String getRua();
    public void setRua(String rua);
    public int getNumero();
    public void setNumero(int numero);
    public String getEstado();
    public void setEstado(String estado);
    public String getCep();
    

}
