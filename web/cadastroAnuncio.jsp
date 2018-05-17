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
<form class="form-horizontal"  action="UserServlet?action=ADD"  method="POST" role="form">
    <h2>Cadastro de Anuncio:</h2>
    <div class="form-group">
        <label for="select" class="col-sm-3 control-label">Selecione a categoria do anuncio:</label>
        <div class="col-sm-9">
            <c:set var="lista" value="${listaCat}"/>
            <select class="selectpicker" name="inst" id="select">
                <option value="0">Categorias</option>
                <c:forEach var="lista" items="${lista}">
                    <option value="${lista.id}"> ${lista.descricao}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="descricao" class="col-sm-3 control-label">Descrição:</label>
        <div class="col-sm-9">
            <textarea type="text" name="descricao" id="descricao" placeholder="" class="form-control" autofocus required></textarea> 
            <span class="help-block">Descreva seu anuncio</span>
        </div>
    </div>
    <div class="form-group">
        <label for="valor" class="col-sm-3 control-label">Preço:</label>
        <div class="col-sm-6">
            <input type="number" name="valor" id="cpf" placeholder="" class="form-control" min="0" autofocus>
            <span class="help-block">Insira um valor caso deseje.</span>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-9 col-sm-offset-3">
            <button type="submit" class="btn btn-primary btn-block">Cadastrar</button>
        </div>
    </div>

</form> <!-- /form -->

<!-- Rodapé -->
<%@include file="footer.jsp" %>
