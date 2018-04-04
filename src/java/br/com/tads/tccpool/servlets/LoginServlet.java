/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.servlets;

import br.com.tads.tccpool.beans.User;
import br.com.tads.tccpool.exception.AcessoBdException;
import br.com.tads.tccpool.facade.LoginFacade;
import br.com.tads.tccpool.utils.MD5;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String email = request.getParameter("login");
            String senha = MD5.criptografar(request.getParameter("senha"));
            
            try{
                User u = LoginFacade.verificaLogin(email, senha);
                //se houver algum retorno
                if(u != null){
                    HttpSession session = request.getSession();
                    //este dado na sessão indica que o usuário está logado
                    session.setAttribute("usuario", u);
                    //redireciona para a página inicial
                    RequestDispatcher rd = request.getRequestDispatcher("teste.jsp");
                    rd.forward(request, response);
                }else{
                    // redireciona para login passando mensagem
                    String param = URLEncoder.encode("Login ou Senha inválidos.", "UTF-8");
                    response.sendRedirect("index.jsp?msg=" + param);
                    return;
                }
            }catch(AcessoBdException e){
                 // para passar o parâmetro para o sendRedirect do jeito certo
                String param = URLEncoder.encode("Erro efetuando login [" + e.getMessage() + " - " + e.getCause().getMessage() + "]", "UTF-8");
                response.sendRedirect("index.jsp?msg=" + param);
                return;
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
