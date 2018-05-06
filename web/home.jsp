<%-- 
    Document   : teste
    Created on : 24/03/2018, 17:42:30
    Author     : onurb
--%>

<!-- Cabeçalho -->
<%@include file="head.jsp" %>
<c:if test="${(empty(user))}">
    <c:set var="msg" value="Faça login para acessar esta página!" scope="request"/>
    <c:redirect url="index.jsp" />
</c:if>
<div class="col-md-10 col-sm-10 col-xs-12">
    <div class="col-sm-12 col-md-10 col-lg-4 col-xs-4">
        <div class="list-group">
            <a class="list-group-item" href="UserServlet?action=SEARCH">Editar Perfil</a>
            <a class="list-group-item" href="escolhaAnuncio.jsp">Realizar um Anuncio</a>
            <a class="list-group-item" href="escolhaPendente.jsp">Aprovar Anuncio(só vai aparecer para ADM)</a>
            <a class="list-group-item list-group-item-danger" href="LoginServlet?action=LOGOUT">Logout</a>
        </div>o.jsp">Aprovar Anuncio(só vai aparecer para ADM)</a>
    </div>
</div>

<!-- Rodapé -->
<%@include file="footer.jsp" %>

