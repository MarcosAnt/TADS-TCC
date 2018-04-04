/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.dao;

import br.com.tads.tccpool.beans.Instituicao;
import br.com.tads.tccpool.exception.AcessoBdException;
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
public class InstituicaoDAO {
    private static final String QUERY_INST = "SELECT NR_SEQ,NM_INST FROM TBL_INSTITUICOES";
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    
    public InstituicaoDAO(){
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
    
    public List<Instituicao> getInstituicoes() throws SQLException, AcessoBdException{
         List<Instituicao>lista = new ArrayList<Instituicao>();
        try{
           stmt= con.prepareStatement(QUERY_INST);
           rs = stmt.executeQuery();
           if(rs!=null){              
               while(rs.next()){
                   Instituicao inst = new Instituicao();
                   inst.setNome(rs.getString("NM_INST"));
                   inst.setId(Integer.parseInt(rs.getString("NR_SEQ")));
                   lista.add(inst);
               }
           }
        }catch(SQLException e){
          //  throw new AcessoBdException("erro dao instituicao", e);
          System.out.println(e.getMessage());
        }
       return lista;
    }
    
}
