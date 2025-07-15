<%-- 
    Document   : frmUsuario
    Created on : 12 jul. 2025, 9:13:10 p. m.
    Author     : SOPORTE
--%>

<%@page import="BusinessEntity.UsuarioBE"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ include file="/gui/Encabezado.jsp" %>
    </head>
    <body class="min-vh-100 d-flex">
        <div class="container-fluid">
            <div class="row h-100">
                <!-- Menú lateral -->
                <div class="col-md-2 bg-light p-3 border-end">
                    <%@ include file="/gui/Principal.jsp" %>
                </div>


                <div class="col-md-10 p-4 main-content">
                    <div class="card shadow-sm">
                        <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
                            <h4 class="mb-0">Lista de Usuarios administrativos</h4>
                            <i class="bi bi-person-plus fs-4"></i>
                        </div>
                        <div class="card-body">
                            <p class="text-muted"></p>

                            <h2 class="mb-4"></h2>
                            <table class="table table-bordered table-hover">
                                <thead class="table-dark">
                                    <tr>
                                        <th>ID</th>
                                        <th>Nombre</th>
                                        <th>Correo</th>
                                        <th>Rol</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        ArrayList<UsuarioBE> lista = (ArrayList<UsuarioBE>) request.getAttribute("listaUsuarios");
                                        if (lista != null) {
                                            for (UsuarioBE u : lista) {
                                    %>
                                    <tr>
                                        <td><%= u.getIdUsuario()%></td>
                                        <td><%= u.getNombre()%></td>
                                        <td><%= u.getCorreo()%></td>
                                        <td><%= u.getRol()%></td>
                                    </tr>
                                    <%
                                        }
                                    } else {
                                    %>
                                    <tr class="text-center align-middle"><td class="fw-bold"></td></tr>
                                    <tr class="text-center align-middle"><td class="fw-bold"></td></tr>
                                    <tr class="text-center align-middle"><td class="fw-bold"></td></tr>
                                    <tr class="text-center align-middle"><td class="fw-bold"></td></tr>
                                    <tr class="text-center align-middle"><td class="fw-bold"></td></tr>
                                <div class="alert alert-warning">No hay asignaciones disponibles.</div>
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
