<%-- 
    Document   : editarPerfil
    Created on : 09/07/2018, 19:39:31
    Author     : onurb
--%>

<%@include file="head.jsp" %>
<c:if test="${(empty(user))}">
    <c:set var="msg" value="Faça login para acessar esta página!" scope="request"/>
    <c:redirect url="index.jsp" />
</c:if>

        <div class="container">
            <h1>Edite seu Perfil</h1>
            <hr>
            <div class="row">
                <!-- left column -->
                <div class="col-md-3">
                    <div class="text-center">
                        <img src="//placehold.it/100" class="avatar img-circle" alt="avatar">
                        <h6>Carregar uma foto nova...</h6>

                        <input type="file" class="form-control">
                    </div>
                </div>

                <!-- edit form column -->
                <div class="col-md-9 personal-info">

                    <h3>Informações pessoais</h3>

                    <form id="formEditar" class="form-horizontal" action="UserServlet?action=EDIT"  method="POST" role="form">
                        <input id="cdEndereco" type="hidden" name="cdEndereco" value="<c:out value="${userSearch.getCdEndereco()}"/>">
                        <div class="form-group">
                            <label class="col-lg-3 control-label">Nome Completo:</label>
                            <div class="col-lg-8">
                                <input class="form-control" name="nome" id="nome" type="text" value="<c:out value="${userSearch.getNome()}"/>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">CPF:</label>
                            <div class="col-lg-8">
                                <input class="form-control" name="cpf" id="cpf" type="text" value ="<c:out value="${userSearch.getCpf()}"/>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">E-mail:</label>
                            <div class="col-lg-8">
                                <input type="email" name="email" id="email" class="form-control" value="<c:out value="${userSearch.getEmail()}"/>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">Senha:</label>
                            <div class="col-lg-8">
                                <input class="form-control" name="senha" id="senha" type="password">
                            </div>
                        </div>
                        <div class="form-group">
                            <div id="alertaSenha" class="col-sm-5 col-lg-5 col-xs-12" style="display: none">
                                <p class="alert alert-danger" role="alert">As senhas não coincidem!</p>
                            </div>
                            <label class="col-lg-3 control-label">Confirmar Senha:</label>
                            <div class="col-lg-8">
                                <input class="form-control" type="password" name="confirmaSenha" id="confirmaSenha">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="select" class="col-sm-6 control-label">Selecione uma faculdade:</label>
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
                            <label class="col-md-3 control-label">Telefone:</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" name="tel" id="tel" value="<c:out value="${userSearch.getTel()}"/>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Celular:</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" name="cel" id="cel" value="<c:out value="${userSearch.getCel()}"/>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Logradouro:</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" name="rua" id="rua" value="<c:out value="${userSearch.getLogradouro()}"/>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Número:</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" name="num" id="num" value="<c:out value="${userSearch.getNumero()}"/>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Cep:</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" name="cep" id="cep" value="<c:out value="${userSearch.getCep()}"/>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Cidade:</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" name="cidade" id="cidade" value="<c:out value="${userSearch.getCidade()}"/>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Estado:</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" name="estado" id="estado" value="<c:out value="${userSearch.getEstado()}"/>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Complemento:</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" name="comple" id="comple" value="<c:out value="${userSearch.getComplemento()}"/>">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-9 col-lg-9 col-md-9 col-xs-9 col-sm-offset-3">
                                <button type="submit" class="btn btn-primary btn-block" onclick="confirm('Deseja mesmo alterar os dados?');">Salvar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
                <script type="text/javascript">
                    $(document).ready(function () {
                        var senha = $('#senha');
                        var confirmaSenha = $('#confirmaSenha');
                        $('#confirmaSenha').change(function () {
                            $(senha).attr('required', 'true');
                            $(confirmaSenha).attr('required', 'true');

                            if ($(senha).val() !== $(confirmaSenha).val()) {
                                $('#alertaSenha').css('display', 'block');
                            } else {
                                $('#alertaSenha').css('display', 'none');
                            }
                        });

                        $('#formEditar').submit(function (event) {
                            if ($(senha).val() !== $(confirmaSenha).val()) {
                                $('#alertaSenha').css('display', 'block');
                                event.preventDefault();
                                $(window).scrollTop($('#alertaSenha').scrollTop());
                            }
                        });
                    });
                </script>
                <%@include file="footer.jsp" %>
            
