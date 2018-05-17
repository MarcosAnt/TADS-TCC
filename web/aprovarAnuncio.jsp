<%-- 
    Document   : aprovarAnuncio
    Created on : 05/05/2018, 15:28:04
    Author     : onurb
--%>
<!-- Cabeçalho -->
<%@include file="head.jsp" %>
<c:if test="${(empty(user))}">
    <c:redirect url="index.jsp">
        <c:param name="msg" value="Faça login para acessar esta página!"></c:param>
    </c:redirect>
</c:if>
<c:set var="listaImovel" value="${listaImovel}"/>
<c:forEach var="listaImovel" items="${listaImovel}">
    <div class="card">
        <h3 class="card-header primary-color white-text">Anuncio Pendente</h3>
        <div class="card-body">
            <h4 class="card-title">Título: ${listaImovel.titulo}</h4>
            <p class="card-text">Descrição :${listaImovel.descricao}</p>
            <p class="card-text">Preço: ${listaImovel.preco}</p>
            <a href="AnuncioServlet?action=BUSCARPORID&id=${listaImovel.id}" class="btn btn-primary">Veja mais</a>
        </div>
    </div>
</c:forEach>

<!-- Rodapé -->
<%@include file="footer.jsp" %>
