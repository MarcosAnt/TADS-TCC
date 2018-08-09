/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.tads.tccpool.dao;

import br.com.tads.tccpool.utils.ConnectionFactory;
import br.com.tads.tccpool.beans.Mensagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;

/**
 *
 * @author Marcos
 */
public class MensagemDAO {
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private final String QUERY_SELECT = "SELECT * FROM TB_COMENTARIO WHERE TB_ANUNCIO_ID_ANUNCIO = ?";
    private final String QUERY_INSERT = "INSERT INTO TB_COMENTARIO (\n" +
                                        "   TB_ANUNCIO_ID_ANUNCIO,\n" +
                                        "   DS_CONTEUDO,\n" +
                                        "   ID_ORIGEM,\n" +
                                        "   DT_DATA\n" +
                                        ") VALUES (?, ?, ?, ?)";

    public MensagemDAO() {
        ConnectionFactory cf = new ConnectionFactory();
        con = cf.getConnection();
    }
    
    public int inserir(Mensagem mensagem) throws SQLException {
        stmt = con.prepareStatement(QUERY_INSERT);
        stmt.setInt(1, mensagem.getIdAnuncio());
        stmt.setString(2, mensagem.getConteudo());
        stmt.setInt(3, mensagem.getIdOrigem());
        //Formata a data para inserir no banco de dados
        stmt.setString(4, DateFormat.getInstance().format(mensagem.getData().getTime()));
        
        return stmt.executeUpdate();
    }
    
    
}
