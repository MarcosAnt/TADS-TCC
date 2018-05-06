/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.dao;

import br.com.tads.tccpool.beans.Anuncio;
import br.com.tads.tccpool.beans.Imovel;
import br.com.tads.tccpool.beans.Material;
import br.com.tads.tccpool.beans.Movel;
import br.com.tads.tccpool.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author onurb
 */
public class AnuncioDAO {
    private static final String QUERY_INSERT_IMOVEL_ANUNCIO = "INSERT INTO tb_anuncio (DS_DESCRICAO,NR_VALOR,TB_CATEGORIA_ID_CATEGORIA,TB_STATUS_ID_STATUS" +
                                                        ",TB_ENDERECO_ID_ENDERECO,DS_TITULO) VALUES" +
                                                        "(?,?,?,?,?,?)";
            
    
    private static final String QUERY_INSERT_END = "INSERT INTO tb_endereco_anuncio (DS_RUA, DS_ESTADO,NR_NUMERO,NR_CEP,DS_COMPLEMENTO,DS_CIDADE)"
                                                    + " VALUES (?,?,?,?,?,?)";
    
    private static final String QUERY_INSERT_CAMINHO = "INSERT INTO tb_fotos(ds_caminho,tb_anuncio_id_anuncio)VALUES(?,?)";
    
    private final String QUERY_INSERT_MOVEL_ANUNCIO = "INSERT INTO tb_anuncio (DS_DESCRICAO,NR_VALOR,TB_CATEGORIA_ID_CATEGORIA,TB_STATUS_ID_STATUS" +
                                                        ") VALUES(?,?,?,?)";

    private final String QUERY_INSERT_MATERIAL_ANUNCIO = "INSERT INTO tb_anuncio (DS_DESCRICAO,NR_VALOR,TB_CATEGORIA_ID_CATEGORIA,TB_STATUS_ID_STATUS" +
                                                        ") VALUES(?,?,?,?)";   
    
    private final String QUERY_CONSULTA_ID_FOTO = "select max(tb_anuncio_id_anuncio) as id from tb_fotos;";
   
    private final String QUERY_CONSULTA_PENDENTES = "SELECT" +
                                                    "   TB_ANUNCIO.ID_ANUNCIO," +
                                                    "   TB_ANUNCIO.DS_DESCRICAO," +
                                                    "   TB_ANUNCIO.NR_VALOR," +
                                                    "   TB_ANUNCIO.TB_CATEGORIA_ID_CATEGORIA," +
                                                    "   TB_ANUNCIO.TB_STATUS_ID_STATUS," +
                                                    "   TB_ANUNCIO.TB_ENDERECO_ID_ENDERECO," +
                                                    "   TB_ANUNCIO.DS_TITULO," +
                                                    "   tb_endereco_anuncio.ID_ENDERECO," +
                                                    "   tb_endereco_anuncio.DS_RUA," +
                                                    "   tb_endereco_anuncio.DS_ESTADO," +
                                                    "   tb_endereco_anuncio.NR_NUMERO," +
                                                    "   tb_endereco_anuncio.NR_CEP," +
                                                    "   tb_endereco_anuncio.DS_COMPLEMENTO," +
                                                    "   tb_endereco_anuncio.DS_CIDADE" +
                                                    " FROM" +
                                                    "   tb_anuncio" +
                                                    " INNER JOIN" +
                                                    "   tb_endereco_anuncio ON ID_ENDERECO = TB_ENDERECO_ID_ENDERECO" +
                                                    " WHERE" +
                                                    "       TB_ANUNCIO.TB_STATUS_ID_STATUS = ?" +
                                                    "   AND TB_ANUNCIO.TB_CATEGORIA_ID_CATEGORIA = ?";
    
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
    
    public int getIdFoto() throws SQLException {
        int id = 0;
        stmt = con.prepareStatement(QUERY_CONSULTA_ID_FOTO);
        rs = stmt.executeQuery();
        while (rs.next()) {
            id = rs.getInt("id");
        }
        return id;
    }
    
    public void inserirImovel(Imovel u, int cat, String caminho) throws SQLException {
        int id;
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
        if (rs.next()) {
            stmt = con.prepareStatement(QUERY_INSERT_IMOVEL_ANUNCIO);
            stmt.setString(1, u.getDescricao());
            stmt.setFloat(2, u.getPreco());
            stmt.setInt(3, cat);
            stmt.setInt(4, 1);
            stmt.setInt(5, rs.getInt("ID"));
            stmt.setString(6, u.getTitulo());
            stmt.executeUpdate();
        }
        stmt = con.prepareStatement("SELECT last_insert_id() as ID");
        rs = stmt.executeQuery();
        if (rs.next()) {
            stmt = con.prepareStatement(QUERY_INSERT_CAMINHO);
            stmt.setString(1, caminho);
            stmt.setInt(2, rs.getInt("ID"));
            stmt.executeUpdate();
        }
        con.close();
    }
    
    public void inserirMovel(Movel m, int cat, List<String> caminho) throws SQLException {
        stmt = con.prepareStatement(QUERY_INSERT_MOVEL_ANUNCIO);
        stmt.setString(1, m.getDescricao());
        stmt.setFloat(2, m.getPreco());
        stmt.setInt(3, cat);
        stmt.setInt(4, 1);
        stmt.executeUpdate();
        stmt = con.prepareStatement("SELECT last_insert_id() as ID");
        rs = stmt.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("ID");

            stmt = con.prepareStatement(QUERY_INSERT_CAMINHO);
            for (int i = 0; i <= caminho.size(); i++) {
                stmt.setString(1, caminho.get(i));
                stmt.setInt(2, id);
                stmt.executeUpdate();
            }
        }

        con.close();

    }
    
    public void inserirMaterial(Material m, int cat, String caminho) throws SQLException {
        stmt = con.prepareStatement(QUERY_INSERT_MATERIAL_ANUNCIO);
        stmt.setString(1, m.getDescricao());
        stmt.setFloat(2, m.getPreco());
        stmt.setInt(3, cat);
        stmt.setInt(4, 1);
        stmt.executeUpdate();
        stmt = con.prepareStatement("SELECT last_insert_id() as ID");
        rs = stmt.executeQuery();
        if (rs.next()) {
            stmt = con.prepareStatement(QUERY_INSERT_CAMINHO);
            stmt.setString(1, caminho);
            stmt.setInt(2, rs.getInt("ID"));
            stmt.executeUpdate();
        }
        con.close();
    }
    
    public List<Imovel> buscarPendente() throws SQLException {
        stmt = con.prepareStatement(QUERY_CONSULTA_PENDENTES);
        stmt.setInt(1, 1);
        stmt.setInt(2, 1);
        rs = stmt.executeQuery();
        List<Imovel> list = new ArrayList<Imovel>();

        while (rs.next()) {
            //DESCRICAO, TITULO, PRECO, RUA, NUMERO, ESTADO, CIDADE

            Imovel i = new Imovel();
            i.setDescricao(rs.getString("DS_DESCRICAO"));
            i.setPreco(rs.getFloat("NR_VALOR"));
            i.setRua(rs.getString("DS_RUA"));
            i.setNumero(rs.getInt("NR_NUMERO"));
            i.setTitulo(rs.getString("DS_TITULO"));
            i.setEstado(rs.getString("DS_ESTADO"));
            i.setCidade(rs.getString("DS_CIDADE"));
            i.setCep(rs.getString("NR_CEP"));
            list.add(i);

        }
        return list;
    }
}
