<%-- 
    Document   : login
    Created on : 25/03/2018, 18:49:51
    Author     : onurb
--%>

<!-- Cabeçalho -->
<%@ include file="head.jsp" %>
<div class="col-md-12 col-sm-12 col-xs-12">
        <c:if test="${(!empty(msg))}">
            <div class="alert alert-warning" role="alert">
                <c:out value="${msg}"/>
            </div>
        </c:if>
    <br>
    <div class="jumbotron">
        <form id="frmLogin" action="LoginServlet" method="POST">
            <div class="form-group">
                <label for="email">Email:</label>
                <input name="login" type="email" class="form-control" id="email" required="true">
            </div>
            <div class="form-group">
                <label for="pwd">Senha:</label>
                <input name="senha" type="password" class="form-control" id="pwd" required="true">
            </div>
            <div class="checkbox">
                <label><input id="remember" type="checkbox"> Lembre-se de mim</label>
            </div>
            <button type="submit" class="btn btn-success">Logar</button>
        </form>
        <small>Ou, se ainda n&abreve;o possu&iacute; uma conta, <a href="MainPageServlet?action=CLIENTE">clique aqui e cadastre-se</a>!</small>
    </div>
</div>    

<!-- Rodapé -->
<%@ include file="footer.jsp" %>
