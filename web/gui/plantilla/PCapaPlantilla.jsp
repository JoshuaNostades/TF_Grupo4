
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
         <%
            request.setAttribute("paginaActiva", "plantilla");
        %>
        <%@ include file="../Encabezado.jsp" %>
    </head>
    <body>
        <%@ include file="../Principal.jsp" %>
    </body>
</html>
