<%-- 
    Document   : login
    Created on : 25/03/2018, 18:49:51
    Author     : onurb
--%>

<!-- Cabe�alho -->
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
                <input name="login" type="email" class="form-control" id="emailLogin" required="true">
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
<!-- Importando plugin JSCookie para trabalhar com cookies do navegador -->
<script src="assets/jquery/plugins/js-cookie.js" type="text/javascript"></script>
<script type="text/javascript">    
    var cookieValue = getCookieValue("emailUser"); 
    if(typeof cookieValue !== "undefined" || cookieValue !== false) {
        $('#remember').prop('checked', 'true');
        //Se já existe um cookie setado, recupera os dados do mesmo e coloca no input
        $("#emailLogin").val(cookieValue);
    }
    //Adiciona evento no formulário de login para salvar o cookie caso 
    $('#frmLogin').submit(function(event){
        var inputChecked = $('#remember').prop('checked');
        var emailUser = $('#emailLogin').val();
        if(inputChecked && emailUser !== getCookieValue("emailUser")) {
            setCookie("emailUser", emailUser, 365);
            event.preventDefault();
        }
        else {
            //Se o campo "Lembre-se de mim" não estiver marcado então remove o cookie caso exista
            removeCookie("emailUser");
        }
    });
</script>

<!-- Rodap� -->
<%@ include file="footer.jsp" %>
