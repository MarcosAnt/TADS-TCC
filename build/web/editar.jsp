<%-- 
    Document   : editar
    Created on : 21/04/2018, 12:31:38
    Author     : onurb
--%>
<!-- Cabeçalho -->
<%@include file="head.jsp" %>
<c:if test="${(empty(user))}">
    <c:set var="msg" value="Faça login para acessar esta página!" scope="request"/>
    <c:redirect url="index.jsp" />
</c:if>

<div class="col-md-12 col-sm-12 col-xs-12 col-lg-12">
    <form class="form-horizontal"  action="UserServlet?action=ADD"  method="POST" role="form">
        <h2>Cadastro de usuário</h2>
        <div class="form-group">
            <label for="nome" class="col-sm-3 control-label">Nome Completo:</label>
            <div class="col-sm-9">
                <input type="text" name="nome" id="nome" value="<c:out value="${userSearch.getNome()}"/>" placeholder="Nome completo por extenso" class="form-control" autofocus required>
            </div>
        </div>
        <div class="form-group">
            <label for="cpf" class="col-sm-3 control-label">CPF:</label>
            <div class="col-sm-9">
                <input type="text" name="cpf" id="cpf" value ="<c:out value="${userSearch.getCpf()}"/>" placeholder="CPF" class="form-control" autofocus required>
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-3 control-label">Email</label>
            <div class="col-sm-9">
                <input type="email" name="email" id="email" value="<c:out value="${userSearch.getEmail()}"/>" placeholder="Email" class="form-control" required>
            </div>
        </div>
        <div class="form-group">
            <label for="senha" class="col-sm-3 control-label">Password</label>
            <div class="col-sm-9">
                <input type="password" name="senha" id="senha" value="<c:out value="${userSearch.getSenha()}"/>" placeholder="Password" class="form-control" required>
            </div>
        </div>
        <div class="form-group">
            <label for="select" class="col-sm-3 control-label">Selecione uma faculdade:</label>
            <div class="col-sm-9">
                <c:set var="lista" value="${lista}"/>
                <select class="selectpicker" name="inst" id="select">
                    <option value="0">SELECIONE</option>
                    <c:forEach var="lista" items="${lista}">
                       
                        <option value="${lista.id}"
                                 <c:if test="${lista.id == userSearch.getInstituicao()}">selected="true"</c:if>
                                > ${lista.nome}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="tel" class="col-sm-3 control-label">Telefone:</label>
            <div class="col-sm-9">
                <input type="text" name="tel" id="tel" value="<c:out value="${userSearch.getTel()}"/>" placeholder="" class="form-control" autofocus>
            </div>
        </div>
        <div class="form-group">
            <label for="cel" class="col-sm-3 control-label">Celular:</label>
            <div class="col-sm-9">
                <input type="text" name="cel" id="cel" value="<c:out value="${userSearch.getCel()}"/>" placeholder="" class="form-control" autofocus>
            </div>
        </div>
        <div class="form-group">
            <label for="rua" class="col-sm-3 control-label">Logradouro:</label>
            <div class="col-sm-9">
                <input type="text" name="rua" id="rua" value="<c:out value="${userSearch.getLogradouro()}"/>" placeholder="" class="form-control" autofocus required>
            </div>
        </div>
        <div class="form-group">
            <label for="num" class="col-sm-3 control-label">Número:</label>
            <div class="col-sm-2">
                <input type="text" name="num" id="num" value="<c:out value="${userSearch.getNumero()}"/>" placeholder="" class="form-control" autofocus required>
            </div>
        </div>
        <div class="form-group">
            <label for="cep" class="col-sm-3 control-label">CEP:</label>
            <div class="col-sm-9">
                <input type="text" name="cep" id="cep" value="<c:out value="${userSearch.getCep()}"/>" placeholder="" class="form-control" autofocus required>
            </div>
        </div>
        <div class="form-group">
            <label for="cidade" class="col-sm-3 control-label">Cidade:</label>
            <div class="col-sm-9">
                <input type="text" name="cidade" id="cidade" value="<c:out value="${userSearch.getCidade()}"/>"placeholder="" class="form-control" autofocus required>
            </div>
        </div> 
        <div class="form-group">
            <label for="estado" class="col-sm-3 control-label">Estado:</label>
            <div class="col-sm-2">
                <input type="text" name="estado" id="estado" value="<c:out value="${userSearch.getEstado()}"/>" placeholder="" class="form-control" autofocus required>
            </div>
        </div>
        <div class="form-group">
            <label for="comple" class="col-sm-3 control-label">Complemento:</label>
            <div class="col-sm-9">
                <input type="text" name="comple" id="comple" value="<c:out value="${userSearch.getComplemento()}"/>" placeholder="" class="form-control" autofocus>
            </div>
        </div>      
        <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
                <button type="submit" class="btn btn-primary btn-block" onclick="confirm('Deseja mesmo alterar os dados?');">Salvar</button>
            </div>
        </div>
</form> <!-- ./form -->
</div>
<!-- Rodapé -->
<%@include file="footer.jsp" %>