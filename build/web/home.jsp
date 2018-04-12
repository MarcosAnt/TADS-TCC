<%-- 
    Document   : teste
    Created on : 24/03/2018, 17:42:30
    Author     : onurb
--%>

<!-- Cabeçalho -->
<%@include file="head.jsp" %>
<c:if test="${(empty(usuario))}">
    <c:set var="msg" value="Faça login para acessar esta página!" scope="request"/>
    <c:redirect url="index.jsp" />
</c:if>
<div class="col-md-10 col-sm-10 col-xs-12">
  
</div>

<!-- Rodapé -->
<%@include file="footer.jsp" %>

