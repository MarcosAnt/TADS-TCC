/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.facade;

import br.com.tads.tccpool.beans.User;
import br.com.tads.tccpool.dao.UserDAO;
import br.com.tads.tccpool.exception.AcessoBdException;
import java.sql.SQLException;

/**
 *
 * @author onurb
 */
public class LoginFacade {
    
    public static User verificaLogin(String login, String senha) throws AcessoBdException{
        try{
            UserDAO dao = new UserDAO();
            return dao.verificaLogin(login, senha);
        }catch(SQLException e){
            throw new AcessoBdException("Erro de acesso so bd pela facede", e);
        }
    }

}
