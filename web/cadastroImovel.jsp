<%-- 
    Document   : cadastrar
    Created on : 25/03/2018, 18:55:52
    Author     : onurb
--%>

<!-- Cabeçalho -->
<%@include file="head.jsp" %>
<c:if test="${(empty(user))}">
    <c:redirect url="index.jsp">
        <c:param name="msg" value="Faça login para acessar esta página!"></c:param>
    </c:redirect>
</c:if>

<form class="form-horizontal"  action="AnuncioServlet?action=ADDIMV"  method="POST" role="form" enctype="multipart/form-data">
    <h2>Cadastro de Anuncio: Imóvel</h2>
    <div class="form-group">
        <label for="select" class="col-sm-3 control-label">Qual a categoria do seu Imovel ?:</label>
        <div class="col-sm-9">
            <c:set var="lista" value="${listaCatImovel}"/>
            <select class="selectpicker" name="catImovel" id="select">
                <option value="0">SELECIONE</option>
                <c:forEach var="lista" items="${lista}">
                    <option value="${lista.id}"> ${lista.descricao}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for=titulo class="col-sm-3 control-label">Titulo:</label>
        <div class="col-sm-9">
            <input type="text" name="titulo" id="titulo" placeholder="" class="form-control" autofocus required> 
        </div>
    </div>
    <div class="form-group">
        <label for="descricao" class="col-sm-3 control-label">Descrição:</label>
        <div class="col-sm-9">
            <input type="text" name="descricao" id="descricao" placeholder="" class="form-control" autofocus required> 
            <span class="help-block">Descreva seu anuncio</span>
        </div>
    </div>
    <div class="form-group">
        <label for="quantidade" class="col-sm-3 control-label">Quantidade de pessoas que podem dividr:</label>
        <div class="col-sm-2">
            <input type="text" name="quantidade" id="quantidade" placeholder="" class="form-control" autofocus required>
        </div>
    </div>
    <div class="form-group">
        <label for="" class="col-sm-3 control-label">É autorizado pets na residencia?:</label>   
        <label class="radio-inline"><input type="radio" name="optpet" value="1">Sim</label>
        <label class="radio-inline"><input type="radio" name="optpet" value="0">Não</label>
    </div>
    <div class="form-group">
        <label for="valor" class="col-sm-3 control-label">Preço:</label>
        <div class="col-sm-6">
            <input type="number" name="valor" id="valor" placeholder="" class="form-control" min="0" autofocus>
            <span class="help-block">Insira um valor caso deseje.</span>
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
        <label for="file" class="col-sm-3 control-label">Selecione uma Imagem</label>
        <div class="col-sm-9">
            <input type="file" name="file" id="file" placeholder="" class="form-control" autofocus required>
        </div>
    </div>
    <div class="form-group" id="1" style="display:none;">
        <label for="file" class="col-sm-3 control-label"></label> 
        <div class="col-sm-9" >
            <input type="file" name="file"  placeholder="" class="form-control" autofocus >
        </div>
    </div>
    <div class="form-group" id="2" style="display:none;">
        <label for="file" class="col-sm-3 control-label"></label> 
        <div class="col-sm-9" >
            <input type="file" name="file"  placeholder="" class="form-control" autofocus >
        </div>
    </div>
    <div class="form-group" id="3" style="display:none;">
        <label for="file" class="col-sm-3 control-label"></label> 
        <div class="col-sm-9" >
            <input type="file" name="file"  placeholder="" class="form-control" autofocus >
        </div>
    </div>
    <div class="form-group" id="4" style="display:none;">
        <label for="file" class="col-sm-3 control-label"></label> 
        <div class="col-sm-9" >
            <input type="file" name="file"  placeholder="" class="form-control" autofocus >
        </div>
    </div>
    <div class="form-group">
        <label for="file" class="col-sm-3 control-label"></label>
        <div class="col-sm-9">
            <button type="button" name="button" id="button" class="form-control" onclick="myFunction()">Adicionar Imagem</button>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-9 col-sm-offset-3">
            <button type="submit" class="btn btn-primary btn-block">Cadastrar</button>
        </div>
    </div>
    <script>
        i = 1;
        function myFunction() {
            var x = document.getElementById(i);
            x.style.display = 'inline'
            i++;
        }
    </script>
</form>   <!-- /form -->

<!-- Rodapé -->
<%@include file="footer.jsp" %>
