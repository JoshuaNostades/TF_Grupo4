<%-- 
    Document   : frmUsuario
    Created on : 12 jul. 2025, 9:13:10 p. m.
    Author     : SOPORTE
--%>

<%@page import="BusinessEntity.TicketsBE"%>
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
                            <h4 class="mb-0">Historial de tickets</h4>
                            <i class="bi bi-person-plus fs-4"></i>
                        </div>
                        <div class="card-body">
                            <p class="text-muted"></p>

                            <h2 class="mb-4"></h2>
                            <table class="table table-sm table-bordered table-hover">
                                <thead class="table-dark">
                                    <tr>
                                        <th>ID</th>
                                        <th>Titulo</th>
                                        <th>Descripcion</th>
                                        <th>Estado</th>
                                        <th>Prioridad</th>
                                        <th>Usuario</th>
                                        <th>Tecnico</th>
                                        <th>Fecha Creacion</th>
                                        <th>Fecha Cierre</th>
                                    </tr>
                                </thead>
                                <tbody >
                                    <%
                                        ArrayList<TicketsBE> lista = (ArrayList<TicketsBE>) request.getAttribute("listaTickets");
                                        if (lista != null) {
                                            for (TicketsBE u : lista) {
                                    %>
                                    <tr>
                                        <td><%= u.getIdTicket()%></td>
                                        <td><%= u.getTitulo()%></td>
                                        <td class="fs-8 text-muted"><%= u.getDescripcion()%></td>


                                        <td>
                                            <%
                                                String estado = u.getEstado();
                                                String icono = "";
                                                String color = "";

                                                switch (estado) {
                                                    case "abierto":
                                                        icono = "bi-unlock";       // Icono de candado abierto
                                                        color = "text-success";    // Verde
                                                        break;
                                                    case "en_proceso":
                                                        icono = "bi-tools";        // Icono de herramientas
                                                        color = "text-info";       // Azul claro
                                                        break;
                                                    case "cerrado":
                                                        icono = "bi-check-circle"; // Icono de check
                                                        color = "text-danger";     // Rojo
                                                        break;
                                                    default:
                                                        icono = "bi-question-circle"; // Por defecto
                                                        color = "text-muted";
                                                }
                                            %>
                                            <i class="bi <%= icono%> <%= color%> me-1"></i>
                                            <span class="<%= color%>"><%= estado%></span>
                                        </td>




                                        <td class="text-center">
                                            <%
                                                String prioridad = u.getPrioridad();
                                                String colorClass = "";

                                                switch (prioridad) {
                                                    case "alta":
                                                        colorClass = "bg-danger";   // Rojo
                                                        break;
                                                    case "media":
                                                        colorClass = "bg-warning text-dark";  // Amarillo
                                                        break;
                                                    case "baja":
                                                        colorClass = "bg-success";  // Verde
                                                        break;
                                                    default:
                                                        colorClass = "bg-secondary"; // Por si acaso
                                                }
                                            %>
                                            <span class="badge <%= colorClass%>"><%= prioridad%></span>
                                        </td>

                                        <td><%= u.getIdUsuario()%></td>
                                        <td><%= u.getIdTecnico()%></td>
                                        <td><%= u.getFechaCreacion()%></td>
                                        <td><%= u.getFechaCierre()%></td>

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
                                <div class="alert alert-warning">No hay tickets disponibles.</div>
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
