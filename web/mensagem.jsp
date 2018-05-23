<%-- 
    Document   : mensagem
    Created on : 22/05/2018, 14:18:31
    Author     : Marcos
--%>

<!-- Cabeçalho -->
<%@include file="head.jsp" %>
<c:if test="${(empty(user))}">
    <c:redirect url="index.jsp">
        <c:param name="msg" value="Faça login para acessar esta página!"></c:param>
    </c:redirect>
</c:if>

<div class="col-lg-10">
    <form id="mensagemAjax">
        <input name="ID_ANUNCIO" value="1" type="hidden">
        <input name="ID_USUARIO" value="<c:out value="${user.getId()}"/>" type="hidden">
        <div class="form-group">
            <label for="DS_MSG">Mensagem:</label>
            <textarea id="DS_MSG" name="DS_MSG" class="form-control" cols="25" rows="5"></textarea>
        </div>
        <div class="form-group">
            <button name="BTN_ENVIAR" type="submit" class="btn btn-success pull-right" value="Enviar">Enviar</button>
        </div>
    </form>
    <div id="respostaAjax">
        
    </div>
</div>
<!-- Rodapé -->
<%@include file="footer.jsp" %>
