/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.facade;

import br.com.tads.tccpool.beans.Instituicao;
import br.com.tads.tccpool.dao.InstituicaoDAO;
import br.com.tads.tccpool.exception.AcessoBdException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author onurb
 */
public class MainPageFacade {
     public static List<Instituicao> listaInstituicao() throws AcessoBdException, SQLException{
        InstituicaoDAO dao = new InstituicaoDAO();
        try{
            return dao.getInstituicoes();
        }catch(SQLException e){
            e.printStackTrace();
            throw new AcessoBdException("Erro na facade do cadastro", e);
        }finally{
            dao.close();
        }
    }
}
