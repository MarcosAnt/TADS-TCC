/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.facade;

import br.com.tads.tccpool.beans.Imovel;
import br.com.tads.tccpool.beans.Material;
import br.com.tads.tccpool.beans.Movel;
import br.com.tads.tccpool.dao.AnuncioDAO;
import br.com.tads.tccpool.exception.AcessoBdException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author onurb
 */
public class AnuncioFacade {
    public static Imovel insereImovel(Imovel i, int categoria, String caminho) throws AcessoBdException, SQLException{
        AnuncioDAO dao = new AnuncioDAO();
        dao.inserirImovel(i, categoria, caminho);
        dao.close();
        return i;
    }
    
    public static Movel insereMovel(Movel m, int categoria, List<String> caminho) throws AcessoBdException, SQLException{
        AnuncioDAO dao = new AnuncioDAO();
        dao.inserirMovel(m, categoria, caminho);
        dao.close();
        return m;
    }
    
    public static Material insereMaterial(Material m, int categoria, String caminho) throws AcessoBdException, SQLException{
        AnuncioDAO dao = new AnuncioDAO();
        dao.inserirMaterial(m, categoria, caminho);
        dao.close();
        return m;
    }
    
    public static int getId() throws SQLException{
        AnuncioDAO dao = new AnuncioDAO();
        int id = dao.getIdFoto();
        return id;
    }
    
    public static List<Imovel> buscarPendente() throws SQLException{
        AnuncioDAO dao = new AnuncioDAO();
        return dao.buscarPendente();
    }

}
