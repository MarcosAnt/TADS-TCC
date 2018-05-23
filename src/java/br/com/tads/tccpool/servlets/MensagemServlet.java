/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
            String msg = (String) request.getParameter("DS_MSG").trim();
            int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
            int idAnuncio = Integer.parseInt(request.getParameter("ID_ANUNCIO"));
            
            Calendar data = Calendar.getInstance();
            int horas = data.get(Calendar.HOUR_OF_DAY);
            int minutos = data.get(Calendar.MINUTE);
            try {
                out.write("<div class=\"row p-1 pt-3 pr-4\">\n" +
                          "    <div class=\"col-lg-2 col-3 user-img text-center\">\n" +
                          "        <img src=\"img/profile.jpg\" class=\"main-cmt-img\">\n" +
                          "    </div>\n" +
                          "    <div class=\"col-lg-10 col-9 user-comment bg-light rounded pb-1\">\n" +
                          "        <div class=\"row\">\n" +
                          "            <div class=\"col-lg-8 col-6 border-bottom pr-0\">\n" +
                          "                <p class=\"w-100 p-2 m-0\">Mensagem: " + msg + ", Usuario: " + idUsuario + ", Anúncio: " + idAnuncio + "</p>\n" +
                          "            </div>\n" +
                          "            <div class=\"col-lg-4 col-6 border-bottom\">\n" +
                          "                <p class=\"w-100 p-2 m-0\"><span class=\"float-right\"><i class=\"fa fa-clock-o mr-1\" aria-hidden=\"true\"></i>" + String.valueOf(horas) + ":" + String.valueOf(minutos) + "</span></p>\n" +
                          "            </div>\n" +
                          "        </div>\n" +
                          "        <div class=\"user-comment-desc p-1 pl-2\">\n" +
                          "            <p class=\"m-0 mr-2\"><span><i class=\"fa fa-thumbs-up mr-1\" aria-hidden=\"true\"></i></span>490</p>\n" +
                          "            <p class=\"m-0 mr-2\"><span><i class=\"fa fa-thumbs-down mr-1\" aria-hidden=\"true\"></i></span>450</p>\n" +
                          "        </div>\n" +
                          "    </div>\n" +
                          "</div>");
            }
            catch(Exception e) {
                out.write("Todos os campos devem ser preenchidos!!");
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
