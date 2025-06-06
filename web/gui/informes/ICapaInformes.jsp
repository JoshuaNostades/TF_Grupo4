<%-- 
    Document   : ICapaInformes
    Created on : 08/05/2025, 11:30:57 AM
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
         <%
            request.setAttribute("paginaActiva", "informes");
        %>
        <%@ include file="../Encabezado.jsp" %>
    </head>
    <body>
         <%@ include file="../Principal.jsp" %>
    </body>
</html>
