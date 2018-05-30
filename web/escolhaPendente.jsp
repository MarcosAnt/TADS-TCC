<!-- Cabeçalho -->
<%@include file="head.jsp" %>
<c:if test="${(empty(user))}">
    <c:redirect url="index.jsp">
        <c:param name="msg" value="Faça login para acessar esta página!"></c:param>
    </c:redirect>
</c:if>
<div class="row justify-content-center">
    <div class="list-group">
        <a class="list-group-item" href="AnuncioServlet?action=BUSCARIMOVEISPEND">Im&oacute;vel</a>
        <a class="list-group-item" href="AnuncioServlet?action=BUSCARMOVEL">M&oacute;vel</a>
        <a class="list-group-item" href="AnuncioServlet?action=BUSCARMATERIAL">Material</a>
    </div>    
</div>
<!-- Rodapé -->
<%@include file="footer.jsp" %>