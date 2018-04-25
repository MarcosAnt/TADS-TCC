<%-- 
    Document   : head
    Created on : 03/04/2018, 21:01:22
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:choose>
            <c:when test="${title != null}">
                <title>Sistema <c:out value="| ${title}"/></title>
            </c:when>
            <c:otherwise>
                <title>Sistema | &Iacute;nicio</title>
            </c:otherwise>
        </c:choose>
        

        <link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/shop-homepage.css" rel="stylesheet">
        
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="index.jsp">"Nome Sistema ou Logo"</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <c:choose>
                                <c:when test="${user != null}">
                                    <a class="nav-link" href="home.jsp">Home</a>                                    
                                </c:when>
                                <c:otherwise>
                                    <a class="nav-link" href="index.jsp">Home</a>                                    
                                </c:otherwise>
                            </c:choose>
                        </li>
                        <li class="nav-item">
                            <c:choose>
                                <c:when test="${user != null}">
                                    <a class="nav-link" href="login.jsp?action=logout">Logout</a>                                    
                                </c:when>
                                <c:otherwise>
                                    <a class="nav-link" href="login.jsp">Login</a>                                    
                                </c:otherwise>
                            </c:choose>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="MainPageServlet?action=CLIENTE">Cadastrar</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
      
        <div class="container">
            <div class="row">