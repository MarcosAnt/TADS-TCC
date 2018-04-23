/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.servlets;

import br.com.tads.tccpool.beans.Anuncio;
import br.com.tads.tccpool.beans.Imovel;
import br.com.tads.tccpool.exception.AcessoBdException;
import br.com.tads.tccpool.facade.AnuncioFacade;
import br.com.tads.tccpool.interfaces.Anunciavel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author onurb
 */
@WebServlet(name = "AnuncioServlet", urlPatterns = {"/AnuncioServlet"})
public class AnuncioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, AcessoBdException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            switch(action){
                case "ADDIMV":
                    Imovel im = new Imovel();
                    Anuncio a = new Anuncio();
                    int cat = 1;
                 
                    im.setTitulo(request.getParameter("titulo"));
                    im.setDescricao(request.getParameter("descricao"));
                    im.setPreco(Float.parseFloat(request.getParameter("valor")));
                    im.setRua(request.getParameter("rua"));
                    im.setNumero(Integer.parseInt(request.getParameter("num")));
                    im.setCep(request.getParameter("cep"));
                    im.setCidade(request.getParameter("cidade"));
                    im.setEstado(request.getParameter("estado"));
                    im.setComplemento(request.getParameter("comple"));
                    a.setObj(im);
                    
            {
                try {
                    AnuncioFacade.insereUsuario(im, cat);
                } catch (SQLException ex) {
                    Logger.getLogger(AnuncioServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;
                default:
                        break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (AcessoBdException ex) {
            Logger.getLogger(AnuncioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (AcessoBdException ex) {
            Logger.getLogger(AnuncioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
