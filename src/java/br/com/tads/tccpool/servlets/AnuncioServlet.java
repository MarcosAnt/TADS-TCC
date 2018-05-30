/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.servlets;

import br.com.tads.tccpool.beans.Anuncio;
import br.com.tads.tccpool.beans.Imovel;
import br.com.tads.tccpool.beans.Material;
import br.com.tads.tccpool.beans.Movel;
import br.com.tads.tccpool.exception.AcessoBdException;
import br.com.tads.tccpool.facade.AnuncioFacade;
import br.com.tads.tccpool.interfaces.Anunciavel;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
            throws ServletException, IOException, AcessoBdException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String action = request.getParameter("action");

            RequestDispatcher rd;
            
            switch (action) {
                case "ADDIMV":

                    Imovel im = new Imovel();
                    Anuncio a = new Anuncio();
                    int cat = 1;
                    String caminhoImovel = new String();

                    //String caminhoReal = "C:\\Users\\onurb\\Documents\\NetBeansProjects\\TCCPOOL\\web\\img";
                    List<String> listImovel = new ArrayList<String>();
                    /// if (ServletFileUpload.isMultipartContent(request)) {

                    try {
                        int i = 0;
                        /*Faz o parse do request*/
                        List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                        int nome;// = new String();

                        /*Escreve a o arquivo na pasta img*/
                        for (FileItem item : multiparts) {
                            if (item.isFormField()) {
                                if (item.getFieldName().equals("catImovel")) {
                                    im.setTipo(Integer.parseInt(item.getString()));
                                }
                                if (item.getFieldName().equals("titulo")) {
                                    im.setTitulo(item.getString());

                                }
                                if (item.getFieldName().equals("descricao")) {
                                    im.setDescricao(item.getString());

                                }
                                if (item.getFieldName().equals("quantidade")) {
                                    im.setQuantidade_pessoas(Integer.parseInt(item.getString()));
                                }
                                if (item.getFieldName().equals("optpet")) {
                                    im.setBoolean_pet(Integer.parseInt(item.getString()));
                                }
                                if (item.getFieldName().equals("valor")) {
                                    im.setPreco(Float.parseFloat(item.getString()));

                                }
                                if (item.getFieldName().equals("rua")) {
                                    im.setRua(item.getString());

                                }
                                if (item.getFieldName().equals("num")) {
                                    im.setNumero(Integer.parseInt(item.getString()));

                                }
                                if (item.getFieldName().equals("cep")) {
                                    im.setCep(item.getString());

                                }
                                if (item.getFieldName().equals("cidade")) {
                                    im.setCidade(item.getString());

                                }
                                if (item.getFieldName().equals("estado")) {
                                    im.setEstado(item.getString());

                                }
                                if (item.getFieldName().equals("comple")) {
                                    im.setComplemento(item.getString());

                                }
                                a.setObj(im);

                            } else {
                                // nome = AnuncioFacade.getId()+1;
                                // File imagem = new File(destino, nome);
                                // item.write(imagem);
                                //nome = multiparts.get(i).getName();
                                Random rand = new Random();
                                String nomeString = String.valueOf(rand.nextInt()) + ".jpg";
                                if (!item.getName().equals("")) {
                                    item.write(new File(request.getServletContext().getRealPath("imagens") + File.separator + nomeString));

                                    caminhoImovel = "imagens" + File.separator + nomeString;
                                    listImovel.add(caminhoImovel);
                                }
                                //item.getFieldName().equals("titulo");

                            }
                            //item.getString("titulo");
                        }
                        request.setAttribute("message", "Arquivo carregado com sucesso");
                    } catch (Exception ex) {
                        request.setAttribute("message", "Upload de arquivo falhou devido a " + ex);
                    }
                    try {
                        AnuncioFacade.insereImovel(im, cat, listImovel);
                        request.setAttribute("msg", "Anuncio Realizao Com Sucesso");
                    } catch (SQLException ex) {
                        Logger.getLogger(AnuncioServlet.class.getName()).log(Level.SEVERE, null, ex);
                        request.setAttribute("msg", "Falha ao Realizar Anuncio: " + ex);
                    } finally {
                        rd = request.getRequestDispatcher("home.jsp");
                        rd.forward(request, response);
                    }
                    break;
                case "ADDMOVEL":
                    Movel movel = new Movel();
                    Anuncio an = new Anuncio();
                    int cate = 2;
                    String caminhomovel = new String();
                    List lista = new ArrayList<String>();
                    try {
                        int i = 0;
                        /*Faz o parse do request*/
                        List<FileItem> multiparts2 = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                        int nome;// = new String();

                        for (FileItem item2 : multiparts2) {
                            if (item2.isFormField()) {
                                if (item2.getFieldName().equals("titulo")) {
                                    movel.setTitulo(item2.getString());
                                }
                                if (item2.getFieldName().equals("descricao")) {
                                    movel.setDescricao(item2.getString());
                                }
                                if (item2.getFieldName().equals("valor")) {
                                    movel.setPreco(Float.parseFloat(item2.getString()));
                                }
                                //  an.setObj(movel);
                            } else {
                                nome = AnuncioFacade.getId() + 1;
                                //String nomeString = String.valueOf(nome)+".jpg";
                                Random rand = new Random();
                                String nomeString = String.valueOf(-1 * (rand.nextInt())) + ".jpg";

                                item2.write(new File(request.getServletContext().getRealPath("imagens") + File.separator + nomeString));
                                caminhomovel = request.getServletContext().getRealPath("imagens") + File.separator + nomeString;
                                lista.add(caminhomovel);
                            }
                        }
                        request.setAttribute("message", "Arquivo carregado com sucesso");
                    } catch (Exception ex) {
                        request.setAttribute("message", "Upload de arquivo falhou devido a " + ex);
                    }
                    try {
                        AnuncioFacade.insereMovel(movel, cate, lista);
                    } catch (SQLException ex) {
                        Logger.getLogger(AnuncioServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                case "ADDMATERIAL":

                    Material material = new Material();
                    Anuncio anu = new Anuncio();
                    int categ = 3;
                    String caminhomaterial = new String();
                    try {
                        int i = 0;
                        /*Faz o parse do request*/
                        List<FileItem> multiparts2 = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                        int nome;// = new String();
                        for (FileItem item2 : multiparts2) {
                            if (item2.isFormField()) {
                                if (item2.getFieldName().equals("titulo")) {
                                    material.setTitulo(item2.getString());
                                }
                                if (item2.getFieldName().equals("descricao")) {
                                    material.setDescricao(item2.getString());
                                }
                                if (item2.getFieldName().equals("valor")) {
                                    material.setPreco(Float.parseFloat(item2.getString()));
                                }
                                if (item2.getFieldName().equals("select")) {
                                    material.setTipo(Integer.parseInt(item2.getString()));
                                }
                                // anu.setObj(material);
                            } else {
                                nome = AnuncioFacade.getId() + 1;
                                item2.write(new File(request.getServletContext().getRealPath("imagens") + File.separator + nome));
                                caminhomaterial = request.getServletContext().getRealPath("imagens") + File.separator + nome;
                                i++;
                            }
                        }
                        request.setAttribute("message", "Arquivo carregado com sucesso");
                    } catch (Exception ex) {
                        request.setAttribute("message", "Upload de arquivo falhou devido a " + ex);
                    }
                    try {
                        AnuncioFacade.insereMaterial(material, categ, caminhomaterial);
                    } catch (SQLException ex) {
                        Logger.getLogger(AnuncioServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "BUSCARIMOVEISPEND":
                    List<Imovel> listaImovel = new ArrayList<Imovel>();
                    listaImovel = AnuncioFacade.buscarPendente();
                    session.setAttribute("listaImovel", listaImovel);
                    rd = request.getRequestDispatcher("aprovarAnuncio.jsp");
                    rd.forward(request, response);
                    break;

                case "BUSCARPORID":
                    int id = Integer.parseInt(request.getParameter("id"));
                    Imovel imovel = new Imovel();
                    imovel = AnuncioFacade.buscarImovelPorId(id);
                    session.setAttribute("imovelBuscado", imovel);
                    rd = request.getRequestDispatcher("homeAnunciosPendentes.jsp");
                    rd.forward(request, response);
                    break;

                case "APROVIMV":
                    int idImv = Integer.parseInt(request.getParameter("id"));
                    String status = request.getParameter("optradio");
                    AnuncioFacade.alterarStatus(status, idImv);
                    response.sendRedirect("escolhaPendente.jsp");
                    break;
                
                case "BUSCAAPROVADOS":
                    List<Anuncio> anunciosAprovados = AnuncioFacade.buscarAnuncioAprovado();
                    String HTMLResponse = "";
                    if(anunciosAprovados != null) {
                        for (Anuncio anuncio : anunciosAprovados) {
                            HTMLResponse += "<div class=\"col-lg-4 col-md-6 mb-4\">\n" +
                                            "    <div class=\"card h-100\">\n" +
                                            "        <a href=\"#\"><img class=\"card-img-top\" src=\"" + anuncio.getCaminhoFoto() + "\" alt=\"\"></a>\n" +
                                            "        <div class=\"card-body\">\n" +
                                            "            <h4 class=\"card-title\">\n" +
                                            "                <a href=\"#\">" + anuncio.getTitulo() + "</a>\n" +
                                            "            </h4>\n" +
                                            "            <h5>$" + String.valueOf(anuncio.getValor()) + "</h5>\n" +
                                            "            <p class=\"card-text\">" + anuncio.getDescricao() + "</p>\n" +
                                            "        </div>\n" +
                                            "        <div class=\"card-footer\">\n" +
                                            "            <a href=\"#\">veja mais</a>\n" +
                                            "        </div>\n" +
                                            "    </div>\n" +
                                            "</div>";
                        }
                        out.write(HTMLResponse);
                    }
                    else {
                        out.write("Falha ao buscar an&uacute;ncios");
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
        } catch (AcessoBdException ex) {
            Logger.getLogger(AnuncioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
