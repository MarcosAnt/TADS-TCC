<%-- 
    Document   : index
    Created on : 21/03/2018, 21:42:41
    Author     : onurb
--%>

<!-- Cabeçalho -->
<%@ include file="head.jsp" %>
<c:if test="${!(empty(user))}">
    <c:redirect url="home.jsp"/>
</c:if>
<div class="col-lg-3">
    <c:if test="${(!empty(msg))}">
        <div class="alert alert-warning col-lg-12 col-sm-12 col-md-12 col-xs-12" role="alert">
            <c:out value="${msg}"/>
        </div>
    </c:if>
    <div class="list-group">
        <a class="list-group-item" href="login.jsp">Login</a>
        <a class="list-group-item" href="MainPageServlet?action=CLIENTE">Cadastrar</a>
    </div>
</div>
<div class="col-lg-9">
    <div id="pageContent" class="row">
        
    </div> <!-- fim .row -->
</div> <!-- End col-lg-9 -->

<script type="text/javascript" lang="UTF-8">
    $(document).ready(function() {
        $.ajax({
            url : "AnuncioServlet?action=BUSCAAPROVADOS",
            method : "POST",
            dataType : "html",
            success : function(resp) {
                $("#pageContent").html(resp);
            },
            error : function(resp) {
                console.log(resp);
                $("#pageContent").html(resp);
            }
        });        
    });
</script>

<!-- Rodapé -->
<%@ include file="footer.jsp" %>