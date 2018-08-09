<%-- 
    Document   : editarPerfil
    Created on : 09/07/2018, 19:39:31
    Author     : onurb
--%>

<%@include file="head.jsp" %>


<div class="container">
    <h3>Editar Perfil</h3>
    <div class="row">
        <!-- left column -->
        <div class="col-md-3">
            <div class="text-center">
                <img src="${sessionScope.user.foto}" class="avatar img-circle" alt="avatar">
                <h6>Foto do Perfil</h6>
                <a class="nav-link" href="#">Atualizar foto.</a>
            </div>
        </div>

        <!-- edit form column -->
        <div class="col-md-9 personal-info">
            <form id="formEditar" class="form-horizontal" action="UserServlet?action=EDIT"  method="POST" role="form">
                <div class="form-group">
                    <label class="col-lg-3 control-label">Nome Completo:</label>
                    <div class="col-lg-8">
                        <input class="form-control" name="nome" id="nome" type="text" value="<c:out value="${sessionScope.user.nome}"/>">
                    </div>
                </div>
                <!-- <div class="form-group"> 
                     <label class="col-lg-3 control-label">E-mail:</label>
                     <div class="col-lg-8">
                         <input type="email" name="email" id="email" class="form-control" value="<c:out value="${sessionScope.user.email}"/>">
                     </div>
                 </div> -->
                <div class="form-group">
                    <label class="col-lg-3 control-label">Descrição sobre você:</label>
                    <div class="col-lg-8 control-label">
                        <textarea class="form-control" rows="5"></textarea>
                    </div>
                </div> 
            </form>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>

