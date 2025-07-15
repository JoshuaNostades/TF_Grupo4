<%-- 
    Document   : frmUsuario
    Created on : 12 jul. 2025, 9:13:10 p. m.
    Author     : SOPORTE
--%>

<%@page import="java.util.List"%>
<%@page import="BusinessLogic.TicketsBL"%>
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



                        <div class="col-md-12 p-4 main-content">
                            <div class="card shadow-sm">
                                <div class="card-header bg-danger text-white d-flex justify-content-between align-items-center">
                                    <h4 class="mb-0">Lista de tickets abiertos</h4>
                                    <i class="bi bi-person-plus fs-4"></i>
                                </div>
                                <div class="card-body">






                                    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
                                        <%
                                            ArrayList<TicketsBE> lista = (ArrayList<TicketsBE>) request.getAttribute("listaTicketsAsignar");
                                            if (lista != null) {
                                                for (TicketsBE ticket : lista) {
                                                    String estado = ticket.getEstado();
                                                    if ("abierto".equals(estado)) {
                                        %>
                                        <div class="col">
                                            <div class="card h-100 shadow-sm">
                                                <div class="card-body">
                                                    <h5 class="card-title"><%= ticket.getTitulo()%></h5>
                                                    <p class="card-text"><%= ticket.getDescripcion()%></p>
                                                    <p>
                                                        <span class="badge bg-<%= "abierto".equals(estado) ? "warning" : "primary"%>">
                                                            <%= estado%>
                                                        </span>
                                                              <span class="badge bg-<%="alta".equals(ticket.getPrioridad()) ? "danger"
                                                                      : "media".equals(ticket.getPrioridad()) ? "secondary" : "success"%>">
                                                            <%= ticket.getPrioridad()%>
                                                        </span>
                                                    </p>
                                                    <button class="btn btn-outline-success w-100">Asignar</button>
                                                </div>
                                                <div class="card-footer text-muted text-end">
                                                    <small>Creado: <%= ticket.getFechaCreacion()%></small>
                                                </div>
                                            </div>
                                        </div>
                                        <%
                                                }
                                            }
                                        } else {
                                        %>
                                        <p>No hay tickets para mostrar.</p>
                                        <%
                                            }
                                        %>
                                    </div>









                                </div>
                            </div>

                        </div>





                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
