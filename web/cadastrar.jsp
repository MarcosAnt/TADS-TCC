<%-- 
    Document   : cadastrar
    Created on : 25/03/2018, 18:55:52
    Author     : onurb
--%>

<!-- Cabeçalho -->
<%@include file="head.jsp" %>  
<div class="col-md-12 col-sm-12 col-xs-12">
    <form class="form-horizontal"  action="UserServlet?action=ADD"  method="POST" role="form">
        <h2>Cadastro de usuário</h2>
        <div class="form-group">
            <label for="nome" class="col-sm-3 control-label">Nome Completo:</label>
            <div class="col-sm-9">
                <input type="text" name="nome" id="nome" placeholder="" class="form-control" autofocus required>
                <span class="help-block">Nome completo por extenso</span>
            </div>
        </div>
        <div class="form-group">
            <label for="cpf" class="col-sm-3 control-label">CPF:</label>
            <div class="col-sm-9">
                <input type="text" name="cpf" id="cpf" placeholder="" class="form-control" autofocus required>
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-3 control-label">Email</label>
            <div class="col-sm-9">
                <input type="email" name="email" id="email" placeholder="Email" class="form-control" required>
            </div>
        </div>
        <div class="form-group">
            <label for="senha" class="col-sm-3 control-label">Password</label>
            <div class="col-sm-9">
                <input type="password" name="senha" id="senha" placeholder="Password" class="form-control" required>
            </div>
        </div>
        <div class="form-group">
            <label for="select" class="col-sm-3 control-label">Selecione uma faculdade:</label>
            <div class="col-sm-9">
                <c:set var="lista" value="${lista}"/>
                <select class="selectpicker" name="inst" id="select">
                    <option value="0">SELECIONE</option>
                    <c:forEach var="lista" items="${lista}">
                        <option value="${lista.id}"> ${lista.nome}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="tel" class="col-sm-3 control-label">Telefone:</label>
            <div class="col-sm-9">
                <input type="text" name="tel" id="tel" placeholder="" class="form-control" autofocus>
            </div>
        </div>
        <div class="form-group">
            <label for="cel" class="col-sm-3 control-label">Celular:</label>
            <div class="col-sm-9">
                <input type="text" name="cel" id="cel" placeholder="" class="form-control" autofocus>
            </div>
        </div>
        <div class="form-group">
            <label for="rua" class="col-sm-3 control-label">Logradouro:</label>
            <div class="col-sm-9">
                <input type="text" name="rua" id="rua" placeholder="" class="form-control" autofocus required>
            </div>
        </div>
        <div class="form-group">
            <label for="num" class="col-sm-3 control-label">Número:</label>
            <div class="col-sm-2">
                <input type="text" name="num" id="num" placeholder="" class="form-control" autofocus required>
            </div>
        </div>
        <div class="form-group">
            <label for="cep" class="col-sm-3 control-label">CEP:</label>
            <div class="col-sm-9">
                <input type="text" name="cep" id="cep" placeholder="" class="form-control" autofocus required>
            </div>
        </div>
        <div class="form-group">
            <label for="cidade" class="col-sm-3 control-label">Cidade:</label>
            <div class="col-sm-9">
                <input type="text" name="cidade" id="cidade" placeholder="" class="form-control" autofocus required>
            </div>
        </div> 
        <div class="form-group">
            <label for="estado" class="col-sm-3 control-label">Estado:</label>
            <div class="col-sm-2">
                <input type="text" name="estado" id="estado" placeholder="" class="form-control" autofocus required>
            </div>
        </div>
        <div class="form-group">
            <label for="comple" class="col-sm-3 control-label">Complemento:</label>
            <div class="col-sm-9">
                <input type="text" name="comple" id="comple" placeholder="" class="form-control" autofocus>
            </div>
        </div>      
        <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
                <button type="submit" class="btn btn-primary btn-block">Cadastrar</button>
            </div>
        </div>
</div>
</form> <!-- ./form -->

<!-- Rodapé -->
<%@include file="footer.jsp" %>
