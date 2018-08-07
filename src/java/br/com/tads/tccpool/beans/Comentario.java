package br.com.tads.tccpool.beans;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Bean para comentários privados e públicos
 * @author Marcos
 */
public class Comentario implements Serializable {
    private int idComentario;
    private String conteudo;
    private int idOrigem;
    private int idAnuncio;
    private int idPai;
    private int qtdeLikes;
    private int qtdeUnlikes;
    private Calendar data;
    
    public Comentario(){}

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

    public int getQtdeLikes() {
        return qtdeLikes;
    }

    public void setQtdeLikes(int qtdeLikes) {
        this.qtdeLikes = qtdeLikes;
    }

    public int getQtdeUnlikes() {
        return qtdeUnlikes;
    }

    public void setQtdeUnlikes(int qtdeUnlikes) {
        this.qtdeUnlikes = qtdeUnlikes;
    }

    public int getIdPai() {
        return idPai;
    }

    public void setIdPai(int idPai) {
        this.idPai = idPai;
    }
            
}
