/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.dao;

import br.com.tads.tccpool.beans.Categoria;
import br.com.tads.tccpool.beans.Instituicao;
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
public class CategoriaDAO {
    private static final String QUERY_CAT = "SELECT * FROM TB_CATEGORIA";
    private static final String QUERY_CAT_IMV = "SELECT * FROM TB_CATEGORIA_IMOVEL";
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public CategoriaDAO() {
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
    
    public List<Categoria> getCategorias() throws SQLException{
        List<Categoria> list = new ArrayList<>();
        try{
           stmt= con.prepareStatement(QUERY_CAT);
           rs = stmt.executeQuery();
           if(rs!=null){              
               while(rs.next()){
                   Categoria  cat = new Categoria();
                  cat.setDescricao(rs.getString("DS_DESCRICAO"));
                   cat.setId(Integer.parseInt(rs.getString("ID_CATEGORIA")));
                   list.add(cat);
               }
           }
        }catch(SQLException e){
          //  throw new AcessoBdException("erro dao instituicao", e);
          System.out.println(e.getMessage());
        }
        stmt=null;
        con.close();
       return list;
    }
    
    public List<Categoria> getCategoriasImovel() throws SQLException{
        List<Categoria> list = new ArrayList<>();
        try{
           stmt= con.prepareStatement(QUERY_CAT_IMV);
           rs = stmt.executeQuery();
           if(rs!=null){              
               while(rs.next()){
                   Categoria  cat = new Categoria();
                  cat.setDescricao(rs.getString("DS_DESCRICAO"));
                   cat.setId(Integer.parseInt(rs.getString("ID_CATEGORIA_IMOVEL")));
                   list.add(cat);
               }
           }
        }catch(SQLException e){
          //  throw new AcessoBdException("erro dao instituicao", e);
          System.out.println(e.getMessage());
        }
        stmt=null;
        con.close();
       return list;
    }
}
