<%-- 
    Document   : frmUsuario
    Created on : 12 jul. 2025, 9:13:10 p. m.
    Author     : SOPORTE
--%>

<%@page import="BusinessEntity.AsistenciaBE"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asistencia</title>
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
                            <h4 class="mb-0">Lista de Asistencia de tecnicos</h4>
                            <i class="bi bi-person-plus fs-4"></i>
                        </div>
                        <div class="card-body">
                            <p class="text-muted"></p>

                            <h2 class="mb-4"></h2>
                            <table class="table table-bordered table-hover">
                                <thead class="table-dark">
                                    <tr>
                                        <th>ID</th>
                                        <th>Tecnico</th>
                                        <th>Fecha</th>
                                        <th>Entrada</th>
                                        <th>Salida</th>
                                        <th>Ubicacion</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        ArrayList<AsistenciaBE> lista = (ArrayList<AsistenciaBE>) request.getAttribute("listaAsistencia");
                                        if (lista != null) {
                                            for (AsistenciaBE u : lista) {
                                    %>
                                    <tr>
                                        <td><%= u.getIdAsistencia()%></td>
                                        <td><%= u.getIdTecnico()%></td>
                                        <td><%= u.getFecha()%></td>
                                        <td><%= u.getHoraEntrada()%></td>
                                        <td><%= u.getHoraSalida()%></td>
                                        <td><%= u.getUbicacion()%></td>
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
                                <div class="alert alert-warning">No hay asistencias disponibles.</div>
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
