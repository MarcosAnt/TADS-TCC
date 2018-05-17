<%-- 
    Document   : escolhaAnuncio
    Created on : 14/04/2018, 14:36:39
    Author     : onurb
--%>

<!-- Cabeçalho -->
<%@include file="head.jsp" %>
<c:if test="${(empty(user))}">
    <c:redirect url="index.jsp">
        <c:param name="msg" value="Faça login para acessar esta página!"></c:param>
    </c:redirect>
</c:if>
<div class="list-group">
    <a class="list-group-item" href="MainPageServlet?action=ANUNCIO&tipo=imovel">Imóvel</a>
    <a class="list-group-item" href="MainPageServlet?action=ANUNCIO&tipo=movel">Móvel</a>
    <a class="list-group-item" href="MainPageServlet?action=ANUNCIO&tipo=material">Material</a>
</div>
<!-- Rodapé -->
<%@include file="footer.jsp" %>
