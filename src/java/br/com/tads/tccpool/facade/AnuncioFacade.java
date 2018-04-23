/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.facade;

import br.com.tads.tccpool.beans.Imovel;
import br.com.tads.tccpool.dao.AnuncioDAO;
import br.com.tads.tccpool.exception.AcessoBdException;
import java.sql.SQLException;

/**
 *
 * @author onurb
 */
public class AnuncioFacade {
    public static Imovel insereUsuario(Imovel i, int categoria) throws AcessoBdException, SQLException{
        AnuncioDAO dao = new AnuncioDAO();
        dao.inserirImovel(i, categoria);
        dao.close();
        return i;
    }

}
