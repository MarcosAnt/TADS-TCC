/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.servlets;

import br.com.tads.tccpool.beans.Categoria;
import br.com.tads.tccpool.beans.Instituicao;
import br.com.tads.tccpool.exception.AcessoBdException;
import br.com.tads.tccpool.facade.MainPageFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "MainPageServlet", urlPatterns = {"/MainPageServlet"})
public class MainPageServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            String tipo = request.getParameter("tipo");
            switch(action){
                case "EDITAR":
                case "CLIENTE":
                        List<Instituicao> lista = new ArrayList<Instituicao>();
                        try{
                            lista = MainPageFacade.listaInstituicao();
                        }catch(AcessoBdException e){
                            e.printStackTrace();
                            String param = URLEncoder.encode("Erro na servlet cadastro " + e.getMessage() + " - " + e.getCause().getMessage() + "]", "UTF-8");
                            response.sendRedirect("index.jsp?msg=" + param);
                        }
                        session.setAttribute("lista", lista);
                        if("EDITAR".equals(action)) {
                            RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
                            rd.forward(request, response);
                        }
                        else {
                            RequestDispatcher rd = request.getRequestDispatcher("cadastrar.jsp");
                            rd.forward(request, response);
                        }
                            
                    break;
                case "ANUNCIO":
                    List<Categoria> listaCategoria = new ArrayList<Categoria>();
                    try{
                        listaCategoria = MainPageFacade.listaCategorias();
                    }catch(AcessoBdException e){
                        e.printStackTrace();
                        String param = URLEncoder.encode("Erro na servlet cadastro " + e.getMessage() + " - " + e.getCause().getMessage() + "]", "UTF-8");
                        response.sendRedirect("index.jsp?msg=" + param);
                    }
                    session.setAttribute("listaCat", listaCategoria);
                    RequestDispatcher rd2;
                            
                      switch(tipo){
                        case "imovel":
                            rd2 = request.getRequestDispatcher("cadastroImovel.jsp");
                            rd2.forward(request, response);
                            break;
                        case "movel":
                            rd2 = request.getRequestDispatcher("cadastroMovel.jsp");
                            rd2.forward(request, response);
                            break;
                        case "material":
                            rd2 = request.getRequestDispatcher("cadastroMaterial.jsp");
                            rd2.forward(request, response);
                            break;
                    }
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
        } catch (SQLException ex) {
            Logger.getLogger(MainPageServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(MainPageServlet.class.getName()).log(Level.SEVERE, null, ex);
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
