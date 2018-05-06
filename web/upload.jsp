<%-- 
    Document   : upload
    Created on : 28/04/2018, 11:02:53
    Author     : onurb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>upload</title>
    </head>
    <body>
        <h1>faça o pload da sua imagem do anuncio</h1>
        <form enctype='multipart/form-data' method='POST' action='/myservlet'>
           <input type='file' NAME='mptest'>
           <input type='submit' VALUE='upload'>
        </form>
    </body>
</html>
