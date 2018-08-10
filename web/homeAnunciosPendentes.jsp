<%-- 
    Document   : cadastrar
    Created on : 25/03/2018, 18:55:52
    Author     : onurb
--%>

<!-- Cabeçalho -->
<%@include file="head.jsp" %>
<c:if test="${(empty(user))}">
    <c:redirect url="index.jsp">
        <c:param name="msg" value="Faça login para acessar esta página!"></c:param>
    </c:redirect>
</c:if>
<form class="form-horizontal"  action="AnuncioServlet?action=APROVIMV&id=${imovelBuscado.id}"  method="POST" role="form">
    <h2>Avaliação de Anuncio: ${imovelBuscado.id} </h2>
    <h2> Fotos:</h2></br></br>



    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->

        <c:set var="lista" value="${imovelBuscado.fotos}"/>
        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <c:set var="counter" value="0" />
            <c:forEach var="lista" items="${imovelBuscado.fotos}">
                <c:choose>
                    <c:when test="${counter == 0}">

                        <div class="item active">
                            <img src="${lista}" alt="Fotos do anuncio">
                        </div>
                    </c:when> 
                    <c:otherwise>
                        <div class="item">
                            <img src="${lista}" alt="Fotos do anuncio">
                        </div>
                    </c:otherwise>

                </c:choose>     
                <c:set var="counter" value="${counter+1}" />
            </c:forEach>

        </div>
        </br>
        </br>
        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <div class="form-group">
        <label for=tipo class="col-sm-3 control-label">Tipo Imovel:</label>
        <div class="col-sm-9">
            <input type="text" name="tipo" id="titulo" placeholder="${imovelBuscado.tipoDesc}" class="form-control" autofocus disabled> 
        </div>
    </div>
    <div class="form-group">
        <label for=titulo class="col-sm-3 control-label">Titulo:</label>
        <div class="col-sm-9">
            <input type="text" name="titulo" id="titulo" placeholder="${imovelBuscado.titulo}" class="form-control" autofocus disabled> 
        </div>
    </div>
    <div class="form-group">
        <label for="descricao" class="col-sm-3 control-label">Descrição:</label>
        <div class="col-sm-9">
            <input type="text" name="descricao" id="descricao" placeholder="${imovelBuscado.descricao}" class="form-control" autofocus disabled> 
            <span class="help-block">Descreva seu anuncio</span>
        </div>
    </div>
    <div class="form-group">
        <label for="descricao" class="col-sm-3 control-label">Quantidade de pessoas:</label>
        <div class="col-sm-9">
            <input type="text" name="descricao" id="descricao" placeholder="${imovelBuscado.quantidade_pessoas}" class="form-control" autofocus disabled> 
            <span class="help-block">Descreva seu anuncio</span>
        </div>
    </div>
    <div class="form-group">
        <label for="descricao" class="col-sm-3 control-label">Pet:</label>
        <div class="col-sm-9">
            <c:if test="${imovelBuscado.boolean_pet < 1}">
                <input type="text" name="descricao" id="descricao" placeholder="não" class="form-control" autofocus disabled>
            </c:if>
            <c:if test="${imovelBuscado.boolean_pet == 1}">
                <input type="text" name="descricao" id="descricao" placeholder="sim" class="form-control" autofocus disabled>
            </c:if>
        </div>
    </div>
    <div class="form-group">
        <label for="valor" class="col-sm-3 control-label">Preço:</label>
        <div class="col-sm-6">
            <input type="number" name="valor" id="valor" placeholder="${imovelBuscado.preco}" class="form-control" min="0" autofocus disabled>

        </div>
    </div>
    <div class="form-group">
        <label for="rua" class="col-sm-3 control-label">Logradouro:</label>
        <div class="col-sm-9">
            <input type="text" name="rua" id="rua" placeholder="${imovelBuscado.rua}" class="form-control" autofocus disabled>
        </div>
    </div>
    <div class="form-group">
        <label for="num" class="col-sm-3 control-label">Número:</label>
        <div class="col-sm-2">
            <input type="text" name="num" id="num" placeholder="${imovelBuscado.numero}" class="form-control" autofocus disabled>
        </div>
    </div>
    <div class="form-group">
        <label for="cep" class="col-sm-3 control-label">CEP:</label>
        <div class="col-sm-9">
            <input type="text" name="cep" id="cep" placeholder="${imovelBuscado.cep}" class="form-control" autofocus disabled>
        </div>
    </div>
    <div class="form-group">
        <label for="cidade" class="col-sm-3 control-label">Cidade:</label>
        <div class="col-sm-9">
            <input type="text" name="cidade" id="cidade" placeholder="${imovelBuscado.cidade}" class="form-control" autofocus disabled>
        </div>
    </div> 
    <div class="form-group">
        <label for="estado" class="col-sm-3 control-label">Estado:</label>
        <div class="col-sm-2">
            <input type="text" name="estado" id="estado" placeholder="${imovelBuscado.estado}" class="form-control" autofocus disabled>
        </div>
    </div>
    <div class="form-group">
        <label for="comple" class="col-sm-3 control-label">Complemento:</label>
        <div class="col-sm-9">
            <input type="text" name="comple" id="comple" placeholder="${imovelBuscado.complemento}" class="form-control" autofocus disabled>
        </div>
    </div>
    <div class="form-group">
        <label for="" class="col-sm-3 control-label">Aprovar:</label>   
        <label class="radio-inline"><input type="radio" name="optradio" value="sim">Sim</label>
        <label class="radio-inline"><input type="radio" name="optradio" value="nao">Não</label>
    </div>

    <div class="form-group">
        <div class="col-sm-9 col-sm-offset-3">
            <button type="submit" class="btn btn-primary btn-block">Confirmar</button>
        </div>
    </div>




</form>   <!-- /form -->
<%@include file="comentario.jsp"%>
<!-- Rodapé -->
<%@include file="footer.jsp" %>
