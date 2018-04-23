/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.dao;

import br.com.tads.tccpool.beans.Imovel;
import br.com.tads.tccpool.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author onurb
 */
public class AnuncioDAO {
    private static final String QUERY_INSERT_ANUNCIO = "INSERT INTO tb_anuncio (DS_DESCRICAO,NR_VALOR,TB_CATEGORIA_ID_CATEGORIA,TB_STATUS_ID_STATUS" +
                                                        ",TB_ENDERECO_ID_ENDERECO) VALUES" +
                                                        "(?,?,?,?,?)";
            
    
    private static final String QUERY_INSERT_END = "INSERT INTO tb_endereco_anuncio (DS_RUA, DS_ESTADO,NR_NUMERO,NR_CEP,DS_COMPLEMENTO,DS_CIDADE)"
                                                    + " VALUES (?,?,?,?,?,?)";
            
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    
    public AnuncioDAO(){
        ConnectionFactory cf = new ConnectionFactory();
        con = cf.getConnection();
    }
    
     //método para fechar a conexão do bd
    public void close() throws SQLException {
        if (rs!=null) {
            try { rs.close(); }
            catch (Exception e) {}
            finally { rs = null; }
        }
        if (stmt!=null) {
            try { stmt.close(); }
            catch (Exception e) {}
            finally { stmt = null; }
        }
        con.close();
        con = null;
    }
    
    public void inserirImovel( Imovel u, int cat) throws SQLException{
         stmt = con.prepareStatement(QUERY_INSERT_END);
            stmt.setString(1, u.getRua());
            stmt.setString(2, u.getEstado());
            stmt.setInt(3, u.getNumero());
            stmt.setString(4, u.getCep());
            stmt.setString(5, u.getComplemento());
            stmt.setString(6, u.getCidade());
            stmt.executeUpdate();
            //pegando o id do endereço recem add
            stmt = con.prepareStatement("SELECT last_insert_id() as ID");
            rs = stmt.executeQuery();
            if(rs.next()){
                stmt = con.prepareStatement(QUERY_INSERT_ANUNCIO);
                stmt.setString(1, u.getDescricao());
                stmt.setFloat(2, u.getPreco());
                stmt.setInt(3, cat);
                stmt.setInt(4, 1);
                stmt.setInt(5, rs.getInt("ID"));
                stmt.executeUpdate();
            }
            con.close();
    }/////
    
}
