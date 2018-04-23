<%-- 
    Document   : index
    Created on : 21/03/2018, 21:42:41
    Author     : onurb
--%>

<!-- Cabeçalho -->
<%@ include file="head.jsp" %>
  
<div class="col-md-12 col-xs-12 col-sm-12">
    <div class="row col-md-12 col-sm-12 col-lg-12">
        <c:if test="${(!empty(msg))}">
            <div class="alert alert-warning" role="alert">
                <c:out value="${msg}"/>
            </div>
        </c:if>
        <div class="list-group">
            <a class="list-group-item" href="login.jsp">Login</a>
            <a class="list-group-item" href="MainPageServlet?action=CLIENTE">Cadastrar</a>
        </div>
    </div>
</div>

<!-- Rodapé -->
<%@ include file="footer.jsp" %>