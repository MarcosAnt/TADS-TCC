<%-- 
    Document   : aprovarAnuncio
    Created on : 05/05/2018, 15:28:04
    Author     : onurb
--%>
<%@include file="head.jsp" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="listaImovel" value="${listaImovel}"/>
        <c:forEach var="listaImovel" items="${listaImovel}">
            <div class="card">
                <h3 class="card-header primary-color white-text">Anuncio Pendente</h3>
                <div class="card-body">
                    <h4 class="card-title">Título: ${listaImovel.titulo}</h4>
                    <p class="card-text">Descrição :${listaImovel.descricao}</p>
                    <p class="card-text">Preço: ${listaImovel.preco}</p>
                    <a href="home.jsp?teste=${listaImovel.preco}" class="btn btn-primary">Veja mais</a>
                </div>
            </div>
                               
                  
        </c:forEach>
    </body>
</html>
