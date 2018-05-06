<%-- 
    Document   : cadastrar
    Created on : 25/03/2018, 18:55:52
    Author     : onurb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
      <div class="container">
          <form class="form-horizontal"  action="AnuncioServlet?action=ADDMOVEL"  method="POST" role="form" enctype="multipart/form-data">
                <h2>Cadastro de Anuncio: Móvel</h2>
                <div class="form-group">
                    <label for=titulo class="col-sm-3 control-label">Titulo:</label>
                    <div class="col-sm-9">
                        <input type="text" name="titulo" id="titulo" placeholder="" class="form-control" autofocus required> 
                    </div>
                </div>
                <div class="form-group">
                    <label for="descricao" class="col-sm-3 control-label">Descrição:</label>
                    <div class="col-sm-9">
                        <input type="text" name="descricao" id="descricao" placeholder="" class="form-control" autofocus required> 
                        <span class="help-block">Descreva seu anuncio</span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="valor" class="col-sm-3 control-label">Preço:</label>
                    <div class="col-sm-6">
                        <input type="number" name="valor" id="valor" placeholder="" class="form-control" min="0" autofocus>
                        <span class="help-block">Insira um valor caso deseje.</span>
                    </div>
                </div>
                 <div class="form-group">
                    <label for="file" class="col-sm-3 control-label">Selecione uma Imagem</label>
                    <div class="col-sm-9">
                        <input type="file" name="file" id="file" placeholder="" class="form-control" autofocus required>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="file" class="col-sm-3 control-label">Selecione uma Imagem</label>
                    <div class="col-sm-9">
                        <input type="file" name="file" id="file" placeholder="" class="form-control" autofocus required>
                    </div>
                </div>
              
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <button type="submit" class="btn btn-primary btn-block">Cadastrar</button>
                    </div>
                </div>
   
       
                            

          </form>   <!-- /form -->
                    
      
        </div> <!-- ./container -->
    </body>
</html>
