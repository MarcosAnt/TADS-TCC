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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author onurb
 */
public class UserFacade {
    public static User insereUsuario(User u) throws AcessoBdException, SQLException{
        UserDAO dao = new UserDAO();
        try{
            dao.inserirUser(u);
        }catch(Exception e){
            return null;
        }
        dao.close();
        return u;
    }
    
    public static User buscarUsuario(int idUser) {
        UserDAO dao = new UserDAO();
        try{
            return dao.buscarUser(idUser);
        }catch(Exception e){
            return null;
        }
        finally {
            try {            
                dao.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}