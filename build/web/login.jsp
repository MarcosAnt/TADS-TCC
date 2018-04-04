<%-- 
    Document   : login
    Created on : 25/03/2018, 18:49:51
    Author     : onurb
--%>

<!-- Cabeçalho -->
<%@ include file="head.jsp" %>

<div class="container">
    <div class="jumbotron">
        <form action="LoginServlet">
            <div class="form-group">
                <label for="email">Email:</label>
                <input name="login" type="email" class="form-control" id="email">
            </div>
            <div class="form-group">
                <label for="pwd">Senha:</label>
                <input name="senha" type="password" class="form-control" id="pwd">
            </div>
            <div class="checkbox">
                <label><input type="checkbox"> Remember me</label>
            </div>
            <button type="submit" class="btn btn-success">Logar</button>
        </form>
    </div>
</div>    

<!-- Rodapé -->
<%@ include file="footer.jsp" %>
