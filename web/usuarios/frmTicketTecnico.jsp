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
        <title>Ticket</title>
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
                            <h4 class="mb-0">Lista de tickets</h4>
                            <i class="bi bi-person-plus fs-4"></i>
                        </div>
                        <div class="card-body">
                            <p class="text-muted"></p>

                            <h2 class="mb-4"></h2>
                            
                            
                               
                            
                            
                            <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
    <%
        ArrayList<TicketsBE> tickets = (ArrayList<TicketsBE>) request.getAttribute("listaTickets");
        if (tickets != null && !tickets.isEmpty()) {
            for (TicketsBE t : tickets) {
    %>
        <div class="col">
            
            
            
            <div class="card h-100 shadow-sm">

    <!-- ===== ENCABEZADO DEL TICKET ===== -->
    <div class="card-header bg-dark text-white d-flex justify-content-between align-items-center">
        <h5 class="mb-0"><%= t.getTitulo() %></h5>
        <span class="badge 
            <%= t.getEstado().equals("abierto") ? "bg-success" : 
                t.getEstado().equals("en_proceso") ? "bg-warning text-dark" : 
                t.getEstado().equals("cerrado") ? "bg-danger" : 
                "bg-secondary" %>">
            <%= t.getEstado() %>
        </span>
    </div>

    <!-- ===== CUERPO DEL TICKET ===== -->
    <div class="card-body">
        <p class="mb-2"><strong>ID:</strong> <%= t.getIdTicket() %></p>
        <p class="mb-2"><strong>Descripción:</strong> <%= t.getDescripcion() %></p>
        <p class="mb-2"><strong>Prioridad:</strong> <%= t.getPrioridad() %></p>
        <p class="mb-2"><strong>Fecha de Creación:</strong> <%= t.getFechaCreacion() %></p>
        <p class="mb-0"><strong>Fecha de Cierre:</strong> <%= t.getFechaCierre() != null ? t.getFechaCierre() : "—" %></p>
    </div>

    <!-- ===== PIE DEL TICKET ===== -->
    
<div class="card-footer bg-light text-center">
    <% if (!t.getEstado().equals("cerrado")) { %>
        <!-- Botón para abrir el modal -->
        <button type="button" class="btn btn-outline-secondary w-100" data-bs-toggle="modal" data-bs-target="#modalEstado<%= t.getIdTicket() %>">
            Gestionar estado
        </button>

        <!-- Modal -->
        <div class="modal fade" id="modalEstado<%= t.getIdTicket() %>" tabindex="-1" aria-labelledby="modalLabel<%= t.getIdTicket() %>" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header bg-light text-dark">
                        <h5 class="modal-title" id="modalLabel<%= t.getIdTicket() %>">Gestionar estado del Ticket #<%= t.getIdTicket() %></h5>
                    </div>
                    <div class="modal-body">
                        <form action="TicketEstadoServlet" method="post" class="d-grid gap-2">
                            <input type="hidden" name="id_ticket" value="<%= t.getIdTicket() %>">

                            <% if (!t.getEstado().equals("en_proceso")) { %>
                                <button type="submit" name="nuevo_estado" value="en_proceso" class="btn btn-warning text-light">
                                    Marcar en proceso
                                </button>
                            <% } %>

                            <button type="submit" name="nuevo_estado" value="cerrado" class="btn btn-info text-light">
                                Cerrar ticket
                            </button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>
                    </div>
                </div>
            </div>
        </div>
    <% } else { %>
        <!-- Ya está cerrado -->
        <span class="badge bg-secondary w-100">Ticket cerrado</span>
    <% } %>
</div>
</div>
            
            
            
            
        </div>
    <%
            }
        } else {
    %>
        <div class="alert alert-info text-center">No hay tickets asignados actualmente.</div>
    <%
        }
    %>
    </div>
                            
                            
                            
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
