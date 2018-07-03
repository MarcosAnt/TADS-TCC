package br.com.tads.tccpool.facade;

import br.com.tads.tccpool.beans.Mensagem;
import br.com.tads.tccpool.dao.MensagemDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class MensagemFacade {
    public static String insereComentario(Mensagem mensagem) {
        MensagemDAO mensagemDao = new MensagemDAO();
        try {
            mensagemDao.inserir(mensagem);
            return "Mensagem inserida com sucesso!";
        } catch (SQLException ex) {
            Logger.getLogger(MensagemFacade.class.getName()).log(Level.SEVERE, null, ex);
            return "Falha ao inserir mensagem!";
        }
    }
    
    /*public static ArrayList<Mensagem> listarComentarios() {
        ArrayList<Mensagem> mensagemList = new ArrayList<Mensagem>();
        String mensagemHTML = "";
        Calendar data = Calendar.getInstance();
        int horas = data.get(Calendar.HOUR_OF_DAY);
        int minutos = data.get(Calendar.MINUTE);
        try {
            mensagens += "<div class=\"row p-1 pt-3 pr-4\">\n"
                        + "    <div class=\"col-lg-2 col-3 user-img text-center\">\n"
                        + "        <img src=\"img/profile.jpg\" class=\"main-cmt-img\">\n"
                        + "    </div>\n"
                        + "    <div class=\"col-lg-10 col-9 user-comment bg-light rounded pb-1\">\n"
                        + "        <div class=\"row\">\n"
                        + "            <div class=\"col-lg-8 col-6 border-bottom pr-0\">\n"
                        + "                <p class=\"w-100 p-2 m-0\">Mensagem: " + msg + ", Usuario: " + idUsuario + ", Anúncio: " + idAnuncio + "</p>\n"
                        + "            </div>\n"
                        + "            <div class=\"col-lg-4 col-6 border-bottom\">\n"
                        + "                <p class=\"w-100 p-2 m-0\"><span class=\"float-right\"><i class=\"fa fa-clock-o mr-1\" aria-hidden=\"true\"></i>" + String.valueOf(horas) + ":" + String.valueOf(minutos) + "</span></p>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "        <div class=\"user-comment-desc p-1 pl-2\">\n"
                        + "            <p class=\"m-0 mr-2\"><span><i class=\"fa fa-thumbs-up mr-1\" aria-hidden=\"true\"></i></span>490</p>\n"
                        + "            <p class=\"m-0 mr-2\"><span><i class=\"fa fa-thumbs-down mr-1\" aria-hidden=\"true\"></i></span>450</p>\n"
                        + "        </div>\n"
                        + "    </div>\n"
                        + "</div>";
        } catch (Exception e) {
            mensagens = "Falha ao buscar mensagens!";
        }
        
        return mensagemList;
    }*/
}
