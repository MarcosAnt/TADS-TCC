package br.com.tads.tccpool.beans;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Bean para comentários privados e públicos
 * @author Marcos
 */
public class Mensagem implements Serializable {
    private int idComentario;
    private String conteudo;
    private int idOrigem;
    private int idAnuncio;
    private Calendar data;
    
    public Mensagem(){}

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getIdOrigem() {
        return idOrigem;
    }

    public void setIdOrigem(int idOrigem) {
        this.idOrigem = idOrigem;
    }

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
    
}
