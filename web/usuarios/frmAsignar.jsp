<%@page import="BusinessEntity.TecnicoBE"%>
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
    <title>Lista de Tickets</title>
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
                <div class="card-header bg-danger text-white d-flex justify-content-between align-items-center">
                    <h4 class="mb-0">Lista de tickets abiertos</h4>
                    <i class="bi bi-person-plus fs-4"></i>
                </div>

                <% String estado = ""; %>

                <div class="card-body">
                    <form method="get" action="TicketsController">
                        <input type="hidden" name="accion" value="filtrar">
                        <div class="mb-4">
                            <label class="form-label fw-bold">Filtrar por estado:</label>
                            <div class="d-flex flex-wrap gap-3">
                                <%
                                    String estadoFiltro = request.getParameter("estadoFiltro");
                                    String[] estados = {"todos", "solicitado", "abierto", "en_proceso", "cerrado", "derivado"};
                                    for (String e : estados) {
                                %>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="estadoFiltro" value="<%= e %>"
                                        <%= e.equals(estadoFiltro) || (estadoFiltro == null && "todos".equals(e)) ? "checked" : "" %>>
                                    <label class="form-check-label"><%= e.substring(0,1).toUpperCase() + e.substring(1).replace("_", " ") %></label>
                                </div>
                                <% } %>
                            </div>
                            <button type="submit" class="btn btn-primary mt-3">Filtrar</button>
                        </div>
                    </form>

                    <div class="row g-4">
                        <%
                            ArrayList<TicketsBE> lista = (ArrayList<TicketsBE>) request.getAttribute("listaTicketsAsignar");
                            ArrayList<UsuarioBE> listaTecnicos = (ArrayList<UsuarioBE>) request.getAttribute("listaTecnicos");
                            if (lista != null && !lista.isEmpty()) {
                                for (TicketsBE ticket : lista) {
                                    estado = ticket.getEstado();
                                     id = ticket.getIdTicket();
                                    if (estadoFiltro == null || estadoFiltro.equals("todos") || estadoFiltro.equals(estado)) {
                        %>
                        <div class="col-sm-6 col-md-4">
                            <div class="card h-100 shadow-sm ">
                                <div class="card-body  p-2">
                                    <h4 class="card-title">
                                        <span class="badge bg-dark fs-6 px-3 py-2 rounded-pill shadow-sm">
                                            JDT-<%= id %>
                                        </span>
                                    </h4>
                                    <h5 class="card-title"><%= ticket.getTitulo() %></h5>
                                    <%
                                        Integer idTecnico = ticket.getIdTecnico();
                                        boolean sinAsignar = (idTecnico == null || idTecnico == 0);
                                    %>
                                    <h5 class="card-title">
                                        Técnico asignado:
                                        <% if (sinAsignar) { %>
                                        <span class="badge bg-danger">No asignado</span>
                                        <span class="text-muted">(Libre para asignar)</span>
                                        <% } else { %>
                                        <span class="badge bg-success">ID <%= idTecnico %></span>
                                        <% } %>
                                    </h5>
                                    <p class="card-text"><%= ticket.getDescripcion() %></p>
                                    <p>
                                        <span class="badge bg-<%= "abierto".equals(estado) ? "warning" : "primary" %>">
                                            <%= estado %>
                                        </span>
                                        <span class="badge bg-<%=
                                            "alta".equals(ticket.getPrioridad()) ? "danger"
                                            : "media".equals(ticket.getPrioridad()) ? "secondary" : "success"
                                        %>">
                                            <%= ticket.getPrioridad() %>
                                        </span>
                                    </p>
                                    <button class="btn btn-secondary w-100 text-light" data-bs-toggle="modal" data-bs-target="#modalAsignar<%= id %>">
                                        Asignar
                                    </button>
                                </div>
                                <div class="card-footer text-muted text-end">
                                    <small>Creado: <%= ticket.getFechaCreacion() %></small>
                                </div>
                            </div>
                        </div>

                        <!-- MODAL -->
                        <div class="modal fade" id="modalAsignar<%= id %>" tabindex="-1" aria-labelledby="modalLabel<%= id %>" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form action="TicketsController?accion=actualizar" method="post">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="modalLabel<%= id %>">Asignar Técnico</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
                                        </div>
                                        <div class="modal-body">
                                            <input type="hidden" name="accion" value="asignar">
                                            <input type="hidden" name="idTicket" value="<%= id %>">

                                            <div class="mb-3">
                                                <label class="form-label">Seleccionar técnico:</label>
                                                <select class="form-select" name="idTecnicos" required>
                                                    <option value="" disabled selected>-- Selecciona --</option>
                                                    <%
                                                        if (listaTecnicos != null) {
                                                            for (UsuarioBE tecnico : listaTecnicos) {
                                                    %>
                                                    <option value="<%= tecnico.getIdUsuario() %>">
                                                        <%= tecnico.getIdUsuario() %>
                                                    </option>
                                                    <%
                                                            }
                                                        } else {
                                                    %>
                                                    <option disabled>No hay técnicos disponibles</option>
                                                    <% } %>
                                                </select>
                                            </div>

                                            <div class="mb-3">
                                                <label class="form-label">Seleccionar prioridad:</label>
                                                <select class="form-select" name="prioridad" required>
                                                    <option value="" disabled selected>-- Selecciona --</option>
                                                    <option value="alta">Alta</option>
                                                    <option value="media">Media</option>
                                                    <option value="baja">Baja</option>
                                                    <option value="sin evaluar">Sin evaluar</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="submit" class="btn btn-success"
                                                <%= (listaTecnicos == null || listaTecnicos.isEmpty()) ? "disabled" : "" %>>Asignar</button>
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <% } } } else { %>
                        <p>No hay tickets para mostrar.</p>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
