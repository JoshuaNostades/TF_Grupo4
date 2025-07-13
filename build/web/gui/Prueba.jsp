<%-- 
    Document   : Prueba
    Created on : 12 jul. 2025, 7:43:15 p. m.
    Author     : SOPORTE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ include file="Encabezado.jsp" %>
    </head>
    <body class="min-vh-100 d-flex">
        <div class="container-fluid">
            <div class="row h-100">
                <!-- Menú lateral -->
                <div class="col-md-2 bg-light p-3 border-end">
                    <%@ include file="Principal.jsp" %>
                </div>


                <div class="col-md-10 p-4 main-content">

                    hola

                </div>
            </div>
        </div>
    </body>
</html>
