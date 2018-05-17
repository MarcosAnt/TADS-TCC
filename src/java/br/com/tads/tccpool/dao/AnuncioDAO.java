/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.dao;

import br.com.tads.tccpool.beans.Anuncio;
import br.com.tads.tccpool.beans.Imovel;
import br.com.tads.tccpool.beans.Material;
import br.com.tads.tccpool.beans.Movel;
import br.com.tads.tccpool.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author onurb
 */
public class AnuncioDAO {




    
    
    private static final String QUERY_INSERT_IMOVEL ="INSERT INTO tb_imovel (NR_QNT_PESSOAS,NR_PET, TB_CATEGORIA_IMOVEL_ID_CATEGORIA_IMOVEL) VALUES (?,?,?);";
    private static final String QUERY_INSERT_END = "INSERT INTO tb_endereco_anuncio (DS_RUA, DS_ESTADO,NR_NUMERO,NR_CEP,DS_COMPLEMENTO,DS_CIDADE)"

            + " VALUES (?,?,?,?,?,?)";
    private static final String QUERY_INSERT_IMOVEL_ANUNCIO = "INSERT INTO tb_anuncio "
            + "(DS_DESCRICAO,NR_VALOR,TB_CATEGORIA_ID_CATEGORIA,TB_STATUS_ID_STATUS,TB_ENDERECO_ID_ENDERECO,TB_IMOVEL_idTB_IMOVEL,DS_TITULO) "
            + "VALUES " +
"             (?,?,?,?,?,(select max(id_imovel) from tb_imovel),?)";
    private final String QUERY_CONSULTA_PENDENTES_IMOVEL = "SELECT\n"
            + "             tb_imovel.ID_IMOVEL,\n"
            + "             tb_imovel.NR_PET,\n"
            + "             tb_imovel.NR_QNT_PESSOAS,\n"
            + "             tb_categoria_imovel.DS_DESCRICAO AS DESC_TIPO,\n"
            + "             TB_ANUNCIO.ID_ANUNCIO,\n"
            + "             TB_ANUNCIO.DS_DESCRICAO,\n"
            + "             TB_ANUNCIO.NR_VALOR,\n"
            + "			 TB_ANUNCIO.TB_CATEGORIA_ID_CATEGORIA,\n"
            + "             TB_ANUNCIO.TB_STATUS_ID_STATUS,\n"
            + "             TB_ANUNCIO.TB_ENDERECO_ID_ENDERECO,\n"
            + "             TB_ANUNCIO.DS_TITULO,\n"
            + "             tb_anuncio.TB_IMOVEL_idTB_IMOVEL,\n"
            + "             tb_endereco_anuncio.ID_ENDERECO,\n"
            + "             tb_endereco_anuncio.DS_RUA,\n"
            + "             tb_endereco_anuncio.DS_ESTADO,\n"
            + "             tb_endereco_anuncio.NR_NUMERO,\n"
            + "             tb_endereco_anuncio.NR_CEP,\n"
            + "             tb_endereco_anuncio.DS_COMPLEMENTO,\n"
            + "             tb_endereco_anuncio.DS_CIDADE\n"
            + "             FROM\n"
            + "             tb_anuncio\n"
            + "             INNER JOIN\n"
            + "             tb_endereco_anuncio ON ID_ENDERECO = TB_ENDERECO_ID_ENDERECO\n"
            + "             INNER JOIN\n"
            + "             tb_imovel ON ID_IMOVEL = TB_IMOVEL_idTB_IMOVEL\n"
            + "             INNER JOIN\n"
            + "             tb_categoria_imovel ON TB_CATEGORIA_IMOVEL_ID_CATEGORIA_IMOVEL = ID_CATEGORIA_IMOVEL\n"
            + "             WHERE\n"
            + "             TB_ANUNCIO.TB_STATUS_ID_STATUS = ?\n"
            + "             AND TB_ANUNCIO.TB_CATEGORIA_ID_CATEGORIA = ?";
    

          private final String QUERY_CONSULTA_IMOVEL_ID = "SELECT "
            + "tb_imovel.NR_PET, "
            + "tb_imovel.NR_QNT_PESSOAS, "
            + "tb_categoria_imovel.DS_DESCRICAO AS DESC_TIPO, "
            + "TB_ANUNCIO.DS_DESCRICAO, "
            + "TB_ANUNCIO.NR_VALOR, "
            + "TB_ANUNCIO.DS_TITULO, "
            + "TB_ANUNCIO.ID_ANUNCIO, "      
            + "tb_endereco_anuncio.DS_RUA, "
            + "tb_endereco_anuncio.DS_ESTADO, "
            + "tb_endereco_anuncio.NR_NUMERO, "
            + "tb_endereco_anuncio.NR_CEP, "
            + "tb_endereco_anuncio.DS_COMPLEMENTO, "
            + "tb_endereco_anuncio.DS_CIDADE "
            + "FROM "
            + "tb_anuncio "
            + "INNER JOIN "
            + "tb_endereco_anuncio ON ID_ENDERECO = TB_ENDERECO_ID_ENDERECO "
            + "INNER JOIN "
            + "tb_imovel ON ID_IMOVEL = TB_IMOVEL_idTB_IMOVEL "
            + "INNER JOIN "
            + "tb_categoria_imovel ON TB_CATEGORIA_IMOVEL_ID_CATEGORIA_IMOVEL = ID_CATEGORIA_IMOVEL "
            + "WHERE "
            + "tb_anuncio.ID_ANUNCIO = ?";
    





    
    
    
    
    
    
    /*private static final String QUERY_INSERT_IMOVEL_ANUNCIO = "INSERT INTO tb_anuncio (DS_DESCRICAO,NR_VALOR,TB_CATEGORIA_ID_CATEGORIA,TB_STATUS_ID_STATUS"
            + ",TB_ENDERECO_ID_ENDERECO,DS_TITULO) VALUES"
            + "(?,?,?,?,?,?)";*/

    

    private static final String QUERY_INSERT_CAMINHO = "INSERT INTO tb_fotos(ds_caminho,tb_anuncio_id_anuncio)VALUES(?,?)";

    private final String QUERY_INSERT_MOVEL_ANUNCIO = "INSERT INTO tb_anuncio (DS_DESCRICAO,NR_VALOR,TB_CATEGORIA_ID_CATEGORIA,TB_STATUS_ID_STATUS"
            + ") VALUES(?,?,?,?)";

    private final String QUERY_INSERT_MATERIAL_ANUNCIO = "INSERT INTO tb_anuncio (DS_DESCRICAO,NR_VALOR,TB_CATEGORIA_ID_CATEGORIA,TB_STATUS_ID_STATUS"
            + ") VALUES(?,?,?,?)";

    private final String QUERY_CONSULTA_ID_FOTO = "select max(tb_anuncio_id_anuncio) as id from tb_fotos;";

    private final String QUERY_BUSCAR_FOTOS_POR_ID = "SELECT * FROM TB_FOTOS WHERE TB_ANUNCIO_ID_ANUNCIO = ?";



    private final String UPDATE_STATUS = "UPDATE TB_ANUNCIO SET TB_STATUS_ID_STATUS = ? WHERE ID_ANUNCIO = ?";

   /* private final String QUERY_CONSULTA_IMOVEL_ID = "SELECT"
            + " TB_ANUNCIO.ID_ANUNCIO,"
            + " TB_ANUNCIO.DS_DESCRICAO,"
            + " TB_ANUNCIO.NR_VALOR,"
            + " TB_ANUNCIO.TB_CATEGORIA_ID_CATEGORIA,"
            + " TB_ANUNCIO.TB_STATUS_ID_STATUS,"
            + " TB_ANUNCIO.TB_ENDERECO_ID_ENDERECO,"

            + " TB_ANUNCIO.DS_TITULO,"
            + " tb_endereco_anuncio.ID_ENDERECO,"
            + " tb_endereco_anuncio.DS_RUA,"
            + " tb_endereco_anuncio.DS_ESTADO,"
            + " tb_endereco_anuncio.NR_NUMERO,"
            + " tb_endereco_anuncio.NR_CEP,"
            + " tb_endereco_anuncio.DS_COMPLEMENTO,"
            + " tb_endereco_anuncio.DS_CIDADE"



            + " FROM"
            + " tb_anuncio"
            + " INNER JOIN"
            + " tb_endereco_anuncio ON ID_ENDERECO = TB_ENDERECO_ID_ENDERECO"



            + " WHERE"
            + " ID_ANUNCIO = ?";*/
    
    /*private final String QUERY_CONSULTA_PENDENTES = "SELECT"
            + " TB_ANUNCIO.ID_ANUNCIO,"
            + " TB_ANUNCIO.DS_DESCRICAO,"
            + " TB_ANUNCIO.NR_VALOR,"
            + " TB_ANUNCIO.TB_CATEGORIA_ID_CATEGORIA,"
            + " TB_ANUNCIO.TB_STATUS_ID_STATUS,"
            + " TB_ANUNCIO.TB_ENDERECO_ID_ENDERECO,"
            + " TB_ANUNCIO.DS_TITULO,"
            + " tb_endereco_anuncio.ID_ENDERECO,"
            + " tb_endereco_anuncio.DS_RUA,"
            + " tb_endereco_anuncio.DS_ESTADO,"
            + " tb_endereco_anuncio.NR_NUMERO,"
            + " tb_endereco_anuncio.NR_CEP,"
            + " tb_endereco_anuncio.DS_COMPLEMENTO,"
            + " tb_endereco_anuncio.DS_CIDADE"
            + " FROM"
            + " tb_anuncio"
            + " INNER JOIN"
            + " tb_endereco_anuncio ON ID_ENDERECO = TB_ENDERECO_ID_ENDERECO"
            + " WHERE"
            + " TB_ANUNCIO.TB_STATUS_ID_STATUS = ?"
            + " AND TB_ANUNCIO.TB_CATEGORIA_ID_CATEGORIA = ?";*/

    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;


    public AnuncioDAO() {
        ConnectionFactory cf = new ConnectionFactory();
        con = cf.getConnection();
    }


    //método para fechar a conexão do bd
    public void close() throws SQLException {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {

            } finally {
                rs = null;
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {

            } finally {
                stmt = null;
            }
        }
        con.close();
        con = null;
    }


    public int getIdFoto() throws SQLException {
        int id = 0;
        stmt = con.prepareStatement(QUERY_CONSULTA_ID_FOTO);
        rs = stmt.executeQuery();
        while (rs.next()) {
            id = rs.getInt("id");
        }
        return id;
    }


    public void inserirImovel(Imovel u, int cat, List<String> caminho) throws SQLException {
        int id;
        stmt = con.prepareStatement(QUERY_INSERT_IMOVEL);
        stmt.setInt(1, u.getQuantidade_pessoas());
        stmt.setInt(2, u.getBoolean_pet());
        stmt.setInt(3, u.getTipo());
        stmt.executeUpdate();
        stmt.clearParameters();
        
        stmt = con.prepareStatement(QUERY_INSERT_END);
        stmt.setString(1, u.getRua());
        stmt.setString(2, u.getEstado());
        stmt.setInt(3, u.getNumero());
        stmt.setString(4, u.getCep());
        stmt.setString(5, u.getComplemento());
        stmt.setString(6, u.getCidade());
        stmt.executeUpdate();
        //pegando o id do endereço recem add
        stmt = con.prepareStatement("SELECT last_insert_id() as ID");
        rs = stmt.executeQuery();
        if (rs.next()) {
            stmt = con.prepareStatement(QUERY_INSERT_IMOVEL_ANUNCIO);
            stmt.setString(1, u.getDescricao());
            stmt.setFloat(2, u.getPreco());
            stmt.setInt(3, cat);
            stmt.setInt(4, 1);
            stmt.setInt(5, rs.getInt("ID"));
            stmt.setString(6, u.getTitulo());
            stmt.executeUpdate();
        }
        stmt = con.prepareStatement("SELECT last_insert_id() as ID");
        rs = stmt.executeQuery();
        if (rs.next()) {
            stmt = con.prepareStatement(QUERY_INSERT_CAMINHO);
             for (int i = 0; i <= caminho.size(); i++) {
            stmt.setString(1, caminho.get(i));
            stmt.setInt(2, rs.getInt("ID"));
            stmt.executeUpdate();
        }
        }
        con.close();


    }/////

    public void inserirMovel(Movel m, int cat, List<String> caminho) throws SQLException {
        stmt = con.prepareStatement(QUERY_INSERT_MOVEL_ANUNCIO);
        stmt.setString(1, m.getDescricao());
        stmt.setFloat(2, m.getPreco());
        stmt.setInt(3, cat);
        stmt.setInt(4, 1);
        stmt.executeUpdate();
        stmt = con.prepareStatement("SELECT last_insert_id() as ID");
        rs = stmt.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("ID");

            stmt = con.prepareStatement(QUERY_INSERT_CAMINHO);
            for (int i = 0; i <= caminho.size(); i++) {
                stmt.setString(1, caminho.get(i));
                stmt.setInt(2, id);
                stmt.executeUpdate();
            }
        }

        con.close();

    }


    public void inserirMaterial(Material m, int cat, String caminho) throws SQLException {
        stmt = con.prepareStatement(QUERY_INSERT_MATERIAL_ANUNCIO);
        stmt.setString(1, m.getDescricao());
        stmt.setFloat(2, m.getPreco());
        stmt.setInt(3, cat);
        stmt.setInt(4, 1);
        stmt.executeUpdate();
        stmt = con.prepareStatement("SELECT last_insert_id() as ID");
        rs = stmt.executeQuery();
        if (rs.next()) {
            stmt = con.prepareStatement(QUERY_INSERT_CAMINHO);
            stmt.setString(1, caminho);
            stmt.setInt(2, rs.getInt("ID"));
            stmt.executeUpdate();
        }
        con.close();
    }


    public List<Imovel> buscarPendente() throws SQLException {
        stmt = con.prepareStatement(QUERY_CONSULTA_PENDENTES_IMOVEL);
        stmt.setInt(1, 1);
        stmt.setInt(2, 1);
        rs = stmt.executeQuery();
        List<Imovel> list = new ArrayList<Imovel>();

        while (rs.next()) {
            //DESCRICAO, TITULO, PRECO, RUA, NUMERO, ESTADO, CIDADE

            Imovel i = new Imovel();
            i.setId(rs.getInt("ID_ANUNCIO"));
            i.setBoolean_pet(rs.getInt("NR_PET"));
            i.setQuantidade_pessoas(rs.getInt("NR_QNT_PESSOAS"));
            i.setTipoDesc(rs.getString("DESC_TIPO"));
            i.setDescricao(rs.getString("DS_DESCRICAO"));
            i.setPreco(rs.getFloat("NR_VALOR"));
            i.setRua(rs.getString("DS_RUA"));
            i.setNumero(rs.getInt("NR_NUMERO"));
            i.setTitulo(rs.getString("DS_TITULO"));
            i.setEstado(rs.getString("DS_ESTADO"));
            i.setCidade(rs.getString("DS_CIDADE"));
            i.setCep(rs.getString("NR_CEP"));
            i.setComplemento(rs.getString("DS_COMPLEMENTO"));
            
            list.add(i);

        }
        return list;
    }

    public Imovel buscarImovelPorId(int id) throws SQLException {
        stmt = con.prepareStatement(QUERY_CONSULTA_IMOVEL_ID);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        Imovel i = new Imovel();
        if (rs.next()) {
            i.setId(rs.getInt("ID_ANUNCIO"));
            i.setBoolean_pet(rs.getInt("NR_PET"));
            i.setQuantidade_pessoas(rs.getInt("NR_QNT_PESSOAS"));
            i.setTipoDesc(rs.getString("DESC_TIPO"));
            i.setDescricao(rs.getString("DS_DESCRICAO"));
            i.setPreco(rs.getFloat("NR_VALOR"));
            i.setRua(rs.getString("DS_RUA"));
            i.setNumero(rs.getInt("NR_NUMERO"));
            i.setTitulo(rs.getString("DS_TITULO"));
            i.setEstado(rs.getString("DS_ESTADO"));
            i.setCidade(rs.getString("DS_CIDADE"));
            i.setCep(rs.getString("NR_CEP"));
            i.setComplemento(rs.getString("DS_COMPLEMENTO"));
            stmt = con.prepareStatement(QUERY_BUSCAR_FOTOS_POR_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            List<String> f = new ArrayList<>();
            while(rs.next()){
                f.add( rs.getString("DS_CAMINHO"));
            }
           i.setFotos(f);
        }
        con.close();
        return i;
    }
    
    public void aprovarAnuncio(String status, int id) throws SQLException{
        if(status.equalsIgnoreCase("sim")){
            stmt = con.prepareStatement(UPDATE_STATUS);
            stmt.setInt(1, 2);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }else{
            stmt = con.prepareStatement(UPDATE_STATUS);
            stmt.setInt(1, 4);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }
    
}
