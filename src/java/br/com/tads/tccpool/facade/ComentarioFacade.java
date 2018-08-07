package br.com.tads.tccpool.facade;

import br.com.tads.tccpool.beans.Comentario;
import br.com.tads.tccpool.dao.ComentarioDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class ComentarioFacade {
    public static String insereComentario(Comentario comentario) {
        ComentarioDAO mensagemDAO = new ComentarioDAO();
        try {
            mensagemDAO.inserir(comentario);
            return "Comentario inserido com sucesso!";
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioFacade.class.getName()).log(Level.SEVERE, null, ex);
            return "Falha ao inserir comentario!";
        }
    }
    
    public static String listarComentarios(int IdAnuncio) {
        ArrayList<Comentario> comentarioList = new ArrayList<>();
        String comentarioHTML = "";
        ComentarioDAO comentarioDAO = new ComentarioDAO();
        
        
        try {
            comentarioList = comentarioDAO.listar(IdAnuncio);
            for (Comentario comentario : comentarioList) {
                comentarioHTML += ComentarioFacade.HTMLComentario(comentario);
                if(comentarioDAO.verificaReply(comentario.getIdComentario())) {
                    comentarioHTML += ComentarioFacade.listarReply(comentario);
                }
            }
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(ComentarioFacade.class.getName()).log(Level.SEVERE, null, ex);
            comentarioHTML = "Falha ao buscar comentarios!";
        }
        
        return comentarioHTML;
    }
    
    public static String listarReply(Comentario comentarioPai) throws SQLException {
        ArrayList<Comentario> comentarioList = new ArrayList<>();
        String comentarioHTML = "";
        ComentarioDAO comentarioDAO = new ComentarioDAO();
        comentarioList = comentarioDAO.listarReply(comentarioPai.getIdAnuncio(), comentarioPai.getIdComentario());
        for (Comentario comentario : comentarioList) {
            comentarioHTML += ComentarioFacade.HTMLReply(comentario);
        }
        return comentarioHTML;
    }
    
    public static void setLike(int idComentario) {
        try {
            ComentarioDAO comentarioDAO = new ComentarioDAO();
            comentarioDAO.setLike(idComentario);
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setUnlike(int idComentario) {
        try {
            ComentarioDAO comentarioDAO = new ComentarioDAO();
            comentarioDAO.setUnlike(idComentario);
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String HTMLComentario(Comentario comentario) {
        return   "<div class=\"row p-1 pt-3 pr-4\">\n"
               + "    <div class=\"col-lg-2 col-3 user-img text-center\">\n"
               + "        <img src=\"img/profile.jpg\" class=\"main-cmt-img\">\n"
               + "    </div>\n"
               + "    <div class=\"col-lg-10 col-9 user-comment bg-light rounded pb-1\">\n"
               + "        <div class=\"row\">\n"
               + "            <div class=\"col-lg-8 col-6 border-bottom pr-0\">\n"
               + "                <p class=\"w-100 p-2 m-0\">Mensagem: " + comentario.getConteudo() + ", Usuario: " + comentario.getIdOrigem() + ", Anúncio: " + comentario.getIdAnuncio() + "</p>\n"
               + "            </div>\n"
               + "            <div class=\"col-lg-4 col-6 border-bottom\">\n"
               + "                <p class=\"w-100 p-2 m-0\"><span class=\"float-right\"><i class=\"fa fa-clock-o mr-1\" aria-hidden=\"true\"></i>Sem data por enquanto</span></p>\n"
               + "            </div>\n"
               + "        </div>\n"
               + "        <div class=\"user-comment-desc p-1 pl-2\">\n"
               + "            <div class=\"like\" data-comentario=\"" + comentario.getIdComentario() + "\" onClick=\"avaliarComentario('LIKE_COMENTARIO', this)\">\n"
               + "                <a class=\"m-0 mr-2\"><i class=\"fa fa-thumbs-up mr-1\" aria-hidden=\"true\"></i> " + String.valueOf(comentario.getQtdeLikes()) + "</a>\n"
               + "            </div>\n"
               + "            <div class=\"unlike\" data-comentario=\"" + comentario.getIdComentario() + "\" onClick=\"avaliarComentario('UNLIKE_COMENTARIO', this)\">\n"                        
               + "                <a class=\"m-0 mr-2\"><i class=\"fa fa-thumbs-down mr-1\" aria-hidden=\"true\"></i> " + String.valueOf(comentario.getQtdeUnlikes()) + "</a>\n"     
               + "            </div>\n"                        
               + "            <div class=\"reply\" data-comentario=\"" + comentario.getIdComentario() + "\" onClick=\"replyComentario(this)\">\n"                
               + "                <a><i class=\"fa fa-mail-reply reply\"></i> Responder</a>\n"                        
               + "            </div>\n"                        
               + "        </div>\n"
               + "    </div>\n"
               + "</div>";
    }
    
    public static String HTMLReply(Comentario comentario) {
        return   "<div class=\"row p-1 pt-3 pr-4 offset-md-1\">\n"
               + "    <div class=\"col-lg-2 col-3 float-right user-img text-center\">\n"
               + "        <img src=\"img/profile.jpg\" class=\"main-cmt-img\">\n"
               + "    </div>\n"
               + "    <div class=\"col-lg-10 col-9 user-comment bg-light rounded pb-1\">\n"
               + "        <div class=\"row\">\n"
               + "            <div class=\"col-lg-8 col-6 border-bottom pr-0\">\n"
               + "                <p class=\"w-100 p-2 m-0\">Mensagem: " + comentario.getConteudo() + ", Usuario: " + comentario.getIdOrigem() + ", Anúncio: " + comentario.getIdAnuncio() + "</p>\n"
               + "            </div>\n"
               + "            <div class=\"col-lg-4 col-6 border-bottom\">\n"
               + "                <p class=\"w-100 p-2 m-0\"><span class=\"float-right\"><i class=\"fa fa-clock-o mr-1\" aria-hidden=\"true\"></i>Sem data por enquanto</span></p>\n"
               + "            </div>\n"
               + "        </div>\n"
               + "        <div class=\"user-comment-desc p-1 pl-2\">\n"
               + "            <div class=\"like\" data-comentario=\"" + comentario.getIdComentario() + "\" onClick=\"avaliarComentario('LIKE_COMENTARIO', this)\">\n"
               + "                <a class=\"m-0 mr-2\"><i class=\"fa fa-thumbs-up mr-1\" aria-hidden=\"true\"></i> " + String.valueOf(comentario.getQtdeLikes()) + "</a>\n"
               + "            </div>\n"
               + "            <div class=\"unlike\" data-comentario=\"" + comentario.getIdComentario() + "\" onClick=\"avaliarComentario('UNLIKE_COMENTARIO', this)\">\n"                        
               + "                <a class=\"m-0 mr-2\"><i class=\"fa fa-thumbs-down mr-1\" aria-hidden=\"true\"></i> " + String.valueOf(comentario.getQtdeUnlikes()) + "</a>\n"     
               + "            </div>\n"                        
               + "        </div>\n"
               + "    </div>\n"
               + "</div>";
    }
    
}
