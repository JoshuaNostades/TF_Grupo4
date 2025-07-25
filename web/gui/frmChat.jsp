<%-- 
    Document   : frmUsuario
    Created on : 12 jul. 2025, 9:13:10 p. m.
    Author     : SOPORTE
--%>

<%@page import="DataAccessObject.UsuarioDAO"%>
<%@page import="DataAccessObject.MensajeDAO"%>
<%@page import="java.util.List"%>
<%@page import="BusinessEntity.MensajeBE"%>
<%@page import="BusinessEntity.UsuarioBE"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat</title>
        <%@ include file="/gui/Encabezado.jsp" %>
    </head>
    <body class="min-vh-100 d-flex">
        <div class="container-fluid">
            <div class="row h-100">
                <!-- Menú lateral -->
                <div class="col-md-2 bg-dark p-4 border-end">
                    <%@ include file="/gui/Principal.jsp" %>
                </div>

                <%
                    // Obtener IDs del emisor y receptor desde la sesión y parámetros
                    Integer idEmisor = (Integer) session.getAttribute("idUsuario");
                    String nombreUsuario = (String) session.getAttribute("nombreUsuario");
                    String rolUsuario = (String) session.getAttribute("rolUsuario");

                    int idReceptor = request.getParameter("receptor") != null
                            ? Integer.parseInt(request.getParameter("receptor"))
                            : -1; // valor por defecto si no se envía el receptor

                    // Verificar si se está chateando con alguien
                    boolean mostrarChat = idEmisor != null && idReceptor != -1;

                    List<MensajeBE> mensajes = null;
                    if (mostrarChat) {
                        MensajeDAO dao = new MensajeDAO();
                        mensajes = dao.listarMensajesPorUsuarios(idEmisor, idReceptor);
                    }
                %>


                <div class="col-md-10 p-4 main-content">
                    <div class="card shadow-sm">
                        <div class="card-header bg-secondary text-white d-flex justify-content-between align-items-center">
                            <h4 class="mb-0">Chat</h4>
                            <i class="bi bi-person-plus fs-4"></i>
                        </div>
                        <div class="card-body">
                            <p class="text-muted"></p>

                            <h2 class="mb-4"></h2>




                            <ul>
                                <%
                                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                                    List<UsuarioBE> usuarios = usuarioDAO.listarTodosMenos(idEmisor); // Este método lo creas tú
                                    for (UsuarioBE u : usuarios) {
                                %>

                                <%
                                    }
                                %>
                            </ul>







                            <h4>Selecciona un usuario para chatear:</h4>

                            <form method="get" action="<%= request.getContextPath()%>/MensajeController" class="row g-3 mb-4">
                                <div class="col-md-5">
                                    <label class="form-label">Usuarios:</label>
                                    <select id="usuarioSelect" name="receptor" class="form-select" required onchange="actualizarArea()">
                                        <option value="" selected disabled>Seleccione un usuario</option>
                                        <%

                                            for (UsuarioBE u : usuarios) {
                                        %>
                                        <option value="<%= u.getIdUsuario()%>" data-area="<%= u.getRol()%>">
                                            <%= u.getNombre()%>
                                        </option>
                                        <% }%>
                                    </select>
                                </div>

                                <div class="col-md-5">
                                    <label class="form-label">Área:</label>
                                    <select id="areaSelect" class="form-select" disabled>
                                        <option value="">Seleccione un usuario primero</option>
                                    </select>
                                </div>

                                <div class="col-md-2 d-flex align-items-end">
                                    <button type="submit" class="btn btn-success w-100">Iniciar Chat</button>
                                </div>
                            </form>

                            <script>
                                function actualizarArea() {
                                    const usuarioSelect = document.getElementById("usuarioSelect");
                                    const areaSelect = document.getElementById("areaSelect");

                                    const selectedOption = usuarioSelect.options[usuarioSelect.selectedIndex];
                                    const area = selectedOption.getAttribute("data-area");

                                    // Limpiar el select de área
                                    areaSelect.innerHTML = "";

                                    // Agregar la nueva opción
                                    if (area) {
                                        const option = document.createElement("option");
                                        option.text = area;
                                        option.value = area;
                                        areaSelect.appendChild(option);
                                    }

                                    // Habilitar el select de área
                                    areaSelect.disabled = false;
                                }
                            </script>



                            <div class="card shadow border-0">
                                <!-- Encabezado del chat -->
                                <div class="card-header bg-dark text-white d-flex justify-content-between align-items-center">
                                    <h5 class="mb-0">Conversación con Usuario ID <%= idReceptor%></h5>
                                    <span class="badge bg-secondary"><%= nombreUsuario%> - <%= rolUsuario%></span>
                                </div>

                                <% if (mostrarChat) { %>
                                <!-- Cuerpo del chat con mensajes -->
                                <div class="card-body p-4 bg-red" id="chat-mensajes" style="height: 500px; overflow-y: auto; border-radius: 0 0 10px 10px;">
                                    <% if (mensajes != null && !mensajes.isEmpty()) {
                                            for (MensajeBE m : mensajes) {
                                                boolean esEmisor = m.getEmisor() == idEmisor;
                                    %>
                                    <div class="mb-3">
                                        <div class="d-flex <%= esEmisor ? "justify-content-end" : "justify-content-start"%>">
                                            <div class="<%= esEmisor ? "bg-warning text-white" : "bg-white border"%> p-3 rounded" style="max-width: 70%;">
                                                <div class="fw-bold mb-1 "><%= esEmisor ? "Tú" : "Usuario " + m.getEmisor()%></div>
                                                <div><%= m.getMensaje()%></div>
                                                <small class="text-muted d-block text-end mt-1 text-white text-white" style="font-size: 0.75rem;"><%= m.getFechaEnvio()%></small>
                                            </div>
                                        </div>
                                    </div>
                                    <%  }
                                    } else { %>
                                    <p class="text-center text-muted">No hay mensajes aún.</p>
                                    <% }%>
                                </div>

                                <!-- Formulario para enviar mensaje -->
                                <div class="card-footer bg-white border-top">
                                    <form action="<%= request.getContextPath()%>/MensajeController" method="post" class="row g-2 align-items-center">
                                        <input type="hidden" name="emisor" value="<%= idEmisor%>">
                                        <input type="hidden" name="receptor" value="<%= idReceptor%>">

                                        <div class="col-10">
                                            <textarea class="form-control" name="mensaje" placeholder="Escribe tu mensaje..." required rows="2" style="resize: none;"></textarea>
                                        </div>
                                        <div class="col-2 d-grid">
                                            <button type="submit" class="btn btn-danger">
                                                <i class="bi bi-send-fill"></i> Enviar
                                            </button>
                                        </div>
                                    </form>
                                </div>
                                <% } else { %>
                                <div class="alert alert-warning text-center m-4">
                                    Debes seleccionar un receptor para iniciar el chat.
                                </div>
                                <% }%>
                            </div>








                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>



</html>
