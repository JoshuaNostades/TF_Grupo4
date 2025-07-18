<%-- 
    Document   : frmUsuario
    Created on : 12 jul. 2025, 9:13:10 p. m.
    Author     : SOPORTE
--%>

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
                                            ArrayList<UsuarioBE> listaTecnicos = (ArrayList<UsuarioBE>) request.getAttribute("listaTecnicos"); // Asume que esto existe

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
                                                    <!-- Botón que abre el modal -->
                                                    <button class="btn btn-outline-success w-100" data-bs-toggle="modal" data-bs-target="#modalAsignar<%=id%>">
                                                        Asignar
                                                    </button>
                                                </div>
                                                <div class="card-footer text-muted text-end">
                                                    <small>Creado: <%= ticket.getFechaCreacion()%></small>
                                                </div>
                                            </div>
                                        </div>







                                        <!-- Modal para este ticket -->
                                        <div class="modal fade" id="modalAsignar<%=id%>" tabindex="-1" aria-labelledby="modalLabel<%=id%>" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <form action="<%= request.getContextPath()%>/TicketsController" method="post">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="modalLabel<%=id%>">Asignar Técnico</h5>
                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <input type="hidden" name="idTicket" value="<%=id%>">
                                                            <div class="mb-3">
                                                                <label for="tecnico" class="form-label">Seleccionar técnico:</label>
                                                                <select class="form-select" name="idTecnico" required>
                                                                    <option value="" disabled selected>-- Selecciona --</option>

                                                                    <%
                                                                        if (listaTecnicos != null && !listaTecnicos.isEmpty()) {
                                                                            for (UsuarioBE tecnico : listaTecnicos) {
                                                                    %>
                                                                    <option value="<%= tecnico.getIdUsuario()%>">
                                                                        <%= tecnico.getNombre()%> (<%= tecnico.getCorreo()%>)
                                                                    </option>
                                                                    <%
                                                                        }
                                                                    } else {
                                                                    %>
                                                                    <option disabled>No hay técnicos disponibles</option>
                                                                    <%
                                                                        }
                                                                    %>


                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="submit" name="accion" value="asignar" class="btn btn-success">Asignar</button>
                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                                        </div>
                                                    </form>
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
