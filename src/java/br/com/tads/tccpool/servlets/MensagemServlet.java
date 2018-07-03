/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.servlets;

import br.com.tads.tccpool.beans.Mensagem;
import br.com.tads.tccpool.facade.MensagemFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcos
 */
@WebServlet(name = "MensagemServlet", urlPatterns = {"/MensagemServlet"})
public class MensagemServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = (String) request.getParameter("action").trim();
            
            switch(action) {
                case "ADD":
                    String msg = (String) request.getParameter("DS_MSG").trim();
                    int idUsario = Integer.parseInt(request.getParameter("ID_USUARIO"));
                    int idAnuncio = Integer.parseInt(request.getParameter("ID_ANUNCIO"));
                    Mensagem mensagem = new Mensagem();
                    mensagem.setIdAnuncio(idAnuncio);
                    mensagem.setIdOrigem(idUsario);
                    mensagem.setConteudo(msg);
                    mensagem.setData(Calendar.getInstance());
                    
                    String retorno = MensagemFacade.insereComentario(mensagem);
                    //Escreve o retorno da execução na resposta da requisição e limpa o stream
                    out.write(retorno);
                    out.flush();
                    break;
                    
                case "LIST":
                    /*ArrayList<Mensagem> mensagemList = new ArrayList<Mensagem>();
                    mensagemList = MensagemFacade.listarComentarios();*/
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
        processRequest(request, response);
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
        processRequest(request, response);
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
