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
public class UserFacade {
    public static User insereUsuario(User u, int tipo) throws AcessoBdException, SQLException{
        UserDAO dao = new UserDAO();
        dao.InserirUser(u, tipo);
        dao.close();
        return u;
    }
}
