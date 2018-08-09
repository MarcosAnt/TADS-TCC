/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.dao;

import br.com.tads.tccpool.beans.User;
import br.com.tads.tccpool.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author onurb
 */
public class UserDAO {
    private static final String QUERY_LOGIN = "SELECT NR_SEQ, DS_EMAIL, NM_NOME, TP_USUARIO FROM TB_USUARIO WHERE DS_EMAIL = ? AND DS_SENHA = ?";
    private static final String QUERY_LOGIN_GOOGLE = "SELECT NR_SEQ, NM_NOME, DS_EMAIL, DS_FOTO,TP_USUARIO FROM TB_USUARIO WHERE DS_EMAIL = ?";
    private static final String QUERY_SIMPLE_INSERT_USR = "INSERT INTO TB_USUARIO"
            + " (NM_NOME,DS_EMAIL,DS_SENHA,TP_USUARIO)"
            + " VALUES (?,?,?,?)";
    private static final String QUERY_SIMPLE_INSERT_GOOGLE = "INSERT INTO TB_USUARIO"
            + " (NM_NOME,DS_EMAIL,DS_FOTO,TP_USUARIO)"
            + " VALUES (?,?,?,?)";
    private static final String QUERY_INSERT_END = "INSERT INTO TB_ENDERECO (NM_RUA,NM_ESTADO,NR_RUA,NR_CEP,DS_COMPLEMENTO,NM_CIDADE)"
            + " values(?,?,?,?,?,?)";
    private static final String QUERY_SELECT_USR = "SELECT\n" +
                                                        "user.NR_SEQ,\n" +
                                                        "user.NR_CPF,\n" +
                                                        "user.NM_NOME,\n" +
                                                        "user.DS_EMAIL,\n" +
                                                        "user.NR_TELEFONE, \n" +
                                                        "user.NR_CELULAR,\n" +
                                                        "user.DS_SENHA, \n" +
                                                        "user.CD_INST, \n" +
                                                        "user.CD_ENDERECO, \n" +
                                                        "endr.NM_RUA,\n" +
                                                        "endr.NM_ESTADO,\n" +
                                                        "endr.NR_RUA,\n" +
                                                        "endr.NR_CEP,\n" +
                                                        "endr.DS_COMPLEMENTO,\n" +
                                                        "endr.NM_CIDADE\n" +
                                                    "FROM tcc1.tb_usuario AS user \n" +
                                                    "INNER JOIN tcc1.tb_endereco AS endr ON user.CD_ENDERECO = endr.NR_SEQ \n" +
                                                    "WHERE \n" +
                                                        "user.NR_SEQ = ? AND user.TP_USUARIO = 2";
    private static final String QUERY_EDIT_USR = "UPDATE tb_usuario SET\n" +
                                                      "NR_CPF = ?," +
                                                      "NM_NOME = ?," +
                                                      "DS_EMAIL = ?," +
                                                      "NR_TELEFONE = ?," +
                                                      "NR_CELULAR = ?," +
                                                      "CD_INST = ?," +
                                                      "DS_SENHA = ?" +
                                                 "WHERE\n" +
                                                          "NR_SEQ = ?\n" +
                                                      "AND NR_CPF = ?";
    
    private static final String QUERY_EDIT_END = "UPDATE tb_endereco SET\n" +
                                                    "NM_RUA = ?," +
                                                    "NM_ESTADO = ?," +
                                                    "NR_RUA = ?," +
                                                    "NR_CEP = ?," +
                                                    "DS_COMPLEMENTO = ?," +
                                                    "NM_CIDADE = ?\n" +
                                                "WHERE NR_SEQ = ?";
    
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    
    public UserDAO(){
        ConnectionFactory  cf = new ConnectionFactory();
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
    
    public void inserirUser(User u) throws SQLException{
        try{
                stmt = con.prepareStatement(QUERY_SIMPLE_INSERT_USR);
                stmt.setString(1, u.getNome());
                stmt.setString(2, u.getEmail());
                stmt.setString(3, u.getSenha());
                stmt.setInt(4, u.getTipoUusario());
                stmt.executeUpdate();
                con.close();
                stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void inserirUserGoogle(User u) throws SQLException{
        try{
                stmt = con.prepareStatement(QUERY_SIMPLE_INSERT_GOOGLE);
                stmt.setString(1, u.getNome());
                stmt.setString(2, u.getEmail());
                stmt.setString(3, u.getFoto());
                stmt.setInt(4, u.getTipoUusario());
                stmt.executeUpdate();
                con.close();
                stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    
    public User verificaEmail(String email) throws SQLException{
        User u = null;
        try{
            stmt = con.prepareStatement(QUERY_LOGIN_GOOGLE);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            while(rs.next()){
                u = new User();
                u.setId(rs.getInt("NR_SEQ"));
                u.setEmail(rs.getString("DS_EMAIL"));
                u.setNome(rs.getString("NM_NOME"));
                u.setFoto(rs.getString("DS_FOTO"));
                u.setTipoUusario(rs.getInt("TP_USUARIO"));
            }
        }catch(SQLException e){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
            u = null;
        }
        return u;
    }
    
    /**
     * 
     * @param login
     * @param senha
     * @return
     * @throws SQLException 
     */
    public User verificaLogin(String login, String senha) throws SQLException{
        User u = null;
        try{
            stmt = con.prepareStatement(QUERY_LOGIN);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                u = new User();
                u.setId(rs.getInt("NR_SEQ"));
                u.setEmail(rs.getString("DS_EMAIL"));
                u.setNome(rs.getString("NM_NOME"));
                u.setTipoUusario(rs.getInt("TP_USUARIO"));
            }
        }catch(SQLException e){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
            u = null;
        }
        return u;
    }
    
    public User buscarUser(int idUser) {
        try {
            stmt = con.prepareStatement(QUERY_SELECT_USR);
            stmt.setInt(1, idUser);
            rs = stmt.executeQuery();
            if(rs.next()) {
                User u = new User();
                u.setId(rs.getInt("NR_SEQ"));
             //   u.setCpf(rs.getString("NR_CPF"));
                u.setNome(rs.getString("NM_NOME"));
                u.setEmail(rs.getString("DS_EMAIL"));
                u.setSenha(rs.getString("DS_SENHA"));
                u.setTel(rs.getString("NR_TELEFONE"));
                u.setCel(rs.getString("NR_CELULAR"));
                u.setCep(rs.getString("NR_CEP"));
                u.setNumero(rs.getInt("NR_RUA"));
                u.setLogradouro(rs.getString("NM_RUA"));
                u.setComplemento(rs.getString("DS_COMPLEMENTO"));
                u.setEstado(rs.getString("NM_ESTADO"));
                u.setCidade(rs.getString("NM_CIDADE"));
             //   u.setInstituicao(rs.getInt("CD_INST"));
                u.setCdEndereco(rs.getInt("CD_ENDERECO"));
                
                return u;
            }
            else {
                throw new SQLException();
            }
        }
        catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        finally {
            try {
                con.close();
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void editarUser(User u, String CPFUser) {
        try{
            stmt = con.prepareStatement(QUERY_EDIT_END);
            stmt.setString(1, u.getLogradouro());
            stmt.setString(2, u.getEstado());
            stmt.setInt(3, u.getNumero());
            stmt.setString(4, u.getCep());
            stmt.setString(5, u.getComplemento());
            stmt.setString(6, u.getCidade());
            stmt.setInt(7, u.getCdEndereco());
            stmt.executeUpdate();
            
            int editEndOK = stmt.executeUpdate();
            
            stmt = con.prepareStatement(QUERY_EDIT_USR);
           // stmt.setString(1, u.getCpf());
            stmt.setString(2, u.getNome());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getTel());
            stmt.setString(5, u.getCel());
          //  stmt.setInt(6, u.getInstituicao());
            stmt.setString(7, u.getSenha());
            stmt.setInt(8, u.getId());
            stmt.setString(9, CPFUser);
            int editUsrOK = stmt.executeUpdate();            
            
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            try {
                con.close();
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
            
}
