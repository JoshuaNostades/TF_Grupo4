<%-- 
    Document   : frmUsuario
    Created on : 12 jul. 2025, 9:13:10 p. m.
    Author     : SOPORTE
--%>

<%@page import="BusinessEntity.SesionBE"%>
<%@page import="java.util.List"%>
<%@page import="BusinessEntity.UsuarioBE"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sesion</title>
        <%@ include file="/gui/Encabezado.jsp" %>
    </head>
    <body class="min-vh-100 d-flex">
        <div class="container-fluid">
            <div class="row h-100">
                <!-- Menú lateral -->
                <div class="col-md-2 bg-dark p-4 border-end">
                    <%@ include file="/gui/Principal.jsp" %>
                </div>


                <div class="col-md-10 p-4 main-content">
                    <div class="card shadow-sm">
                        <div class="card-header bg-secondary text-white d-flex justify-content-between align-items-center">
                            <h4 class="mb-0">Lista de sesiones</h4>
                            <i class="bi bi-person-plus fs-4"></i>
                        </div>
                        <div class="card-body">
                            <p class="text-muted"></p>

                            <h2 class="mb-4"></h2>



                           <table class="table table-sm table-bordered table-striped small">
                                <thead class="table-dark text-center table table-bordered rounded">
                                    <tr>
                                        <th>ID</th>
                                        <th>ID Usuario</th>
                                        <th>Inicio</th>
                                        <th>Fin</th>
                                        <th>IP</th>
                                        <th>Navegador</th>
                                        <th>Token</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        List<SesionBE> sesiones = (List<SesionBE>) request.getAttribute("listaSesiones");
                                        if (sesiones != null && !sesiones.isEmpty()) {
                                            for (SesionBE s : sesiones) {
                                    %>
                                    <tr>
                                        <td class="text-center"><%= s.getIdSesion()%></td>
                                        <td class="text-center"><%= s.getIdUsuario()%></td>
                                        <td><%= s.getFechaInicio()%></td>
                                        <td><%= s.getFechaFin() != null ? s.getFechaFin() : "Activa"%></td>
                                        <td><%= s.getIpUsuario()%></td>
                                        <td><%= s.getNavegador()%></td>
                                        <td style="max-width: 200px; overflow-wrap: break-word;"><%= s.getTokenSesion()%></td>
                                    </tr>
                                    <%  }
                                    } else {
                                    %>
                                    <tr>
                                        <td colspan="7" class="text-center">No hay sesiones registradas</td>
                                    </tr>
                                    <% }%>
                                </tbody>
                            </table>





                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
