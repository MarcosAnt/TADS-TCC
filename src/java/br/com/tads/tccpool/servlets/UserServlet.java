/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.servlets;

import br.com.tads.tccpool.beans.User;
import br.com.tads.tccpool.exception.AcessoBdException;
import br.com.tads.tccpool.facade.UserFacade;
import br.com.tads.tccpool.utils.MD5;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

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
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            User u = new User();
            switch(action){
                case "ADD":{
                    
                    u.setNome(request.getParameter("nome"));
                    u.setCpf(request.getParameter("cpf"));
                    u.setEmail(request.getParameter("email"));
                    u.setSenha(MD5.criptografar(request.getParameter("senha")));
                    u.setInstituicao(Integer.parseInt(request.getParameter("inst")));
                    u.setTel(request.getParameter("tel"));
                    if(!(request.getParameter("cel").equalsIgnoreCase("")))
                        u.setCel(request.getParameter("cel"));
                    else
                        u.setCel("");
                    u.setLogradouro(request.getParameter("rua"));
                    u.setNumero(Integer.parseInt(request.getParameter("num")));
                    u.setCep(request.getParameter("cep"));
                    u.setCidade(request.getParameter("cidade"));
                    u.setEstado(request.getParameter("estado"));
                    if(!(request.getParameter("comple").equalsIgnoreCase("")))
                        u.setComplemento(request.getParameter("comple"));
                    else
                        u.setComplemento(null);
                    
                    try {
                        User userLogado = UserFacade.insereUsuario(u);
                        if(userLogado == null) {
                            response.sendRedirect("erro.jsp");
                        }
                        else {
                            response.sendRedirect("login.jsp");
                        }
                        
                    } catch (AcessoBdException ex) {
                         throw new RuntimeException(ex);
                    } catch (SQLException ex) {
                         throw new RuntimeException(ex);
                    }
            
                    
                    break;
                }
                case "EDIT":{
                    User userSearch = (User) session.getAttribute("userSearch");
                    
                    u.setId(userSearch.getId());
                    u.setNome(request.getParameter("nome"));
                    u.setCpf(request.getParameter("cpf"));
                    u.setEmail(request.getParameter("email"));
                    
                    String senha = MD5.criptografar(request.getParameter("senha"));
                    String confirmaSenha = MD5.criptografar(request.getParameter("confirmaSenha"));
                    
                    if(senha.equals(confirmaSenha)) {
                        u.setSenha(senha);
                    }
                    else {
                        //Se o campo senha não foi preenchido seta a senha para a mesma q está na session
                        senha = userSearch.getSenha();
                        u.setSenha(senha);
                    }
                        
                    u.setInstituicao(Integer.parseInt(request.getParameter("inst")));
                    u.setTel(request.getParameter("tel"));
                    if(!(request.getParameter("cel").equalsIgnoreCase("")))
                        u.setCel(request.getParameter("cel"));
                    else
                        u.setCel("");
                    //CdEndereco necessário para editar o registro no banco de dados
                    u.setCdEndereco(Integer.parseInt(request.getParameter("cdEndereco")));
                    u.setLogradouro(request.getParameter("rua"));
                    u.setNumero(Integer.parseInt(request.getParameter("num")));
                    u.setCep(request.getParameter("cep"));
                    u.setCidade(request.getParameter("cidade"));
                    u.setEstado(request.getParameter("estado"));
                    if(!(request.getParameter("comple").equalsIgnoreCase("")))
                        u.setComplemento(request.getParameter("comple"));
                    else
                        u.setComplemento(null);
                    
                    Boolean editOK = UserFacade.editarUsuario(u, userSearch.getCpf());
                    
                    if(editOK) {
                        response.sendRedirect("home.jsp");
                        //return para evitar loops
                        return;
                    }
                    else {
                        response.sendRedirect("UserServlet?action=SEARCH");
                    }
                    
                    break;
                }
                case "SEARCH":{
                    User userSession = (User) session.getAttribute("user");
                    User userSearch = UserFacade.buscarUsuario(userSession.getId());
                    session.setAttribute("userSearch", userSearch);
                    RequestDispatcher rd = request.getRequestDispatcher("MainPageServlet?action=EDITAR");
                    rd.forward(request, response);
                    break;
                }
                case "REMOVE":{
                    break;
                }
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
