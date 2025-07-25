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
        <title>Requerimiento</title>
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
                            <h4 class="mb-0">Registro de requerimiento</h4>
                            <i class="bi bi-person-plus fs-4"></i>
                        </div>
                        <div class="card-body">
                            <p class="text-muted"></p>

                            <h2 class="mb-4"></h2>

                            
                            <%  
                                int idUsuario = 0;
                                Integer idUsuarioObj = (Integer) session.getAttribute("idUsuario");
                                if (idUsuarioObj != null) {
                                     idUsuario = idUsuarioObj.intValue();
                                    // Aquí ya puedes usar idUsuario con seguridad
                                } else {
                                    // Redirigir al login si no hay sesión activa
                                    response.sendRedirect("../index.jsp?error=sinSesion");
                                }
                            %>
                           
                            <form action="<%= request.getContextPath()%>/TicketsController?accion=registrar" method="post">
                                <div class="card-body">
                                    <input type="hidden" name="accion" value="registrar">
                                    <input type="hidden" name="idUsuario" value="<%= idUsuario%>">

                                    <div class="mb-3">
                                        <label for="titulo" class="form-label">Título del ticket</label>
                                        <input type="text" class="form-control" name="titulo" id="titulo" required>
                                    </div>

                                    <div class="mb-3">
                                        <label for="descripcion" class="form-label">Descripción del problema</label>
                                        <textarea class="form-control" name="descripcion" id="descripcion" rows="4" required></textarea>
                                    </div>

                                    <button type="submit" class="btn btn-primary w-100">Registrar Ticket</button>
                                </div>
                                <div class="card-footer text-muted text-center">
                                    Los campos como prioridad y técnico serán asignados posteriormente.
                                </div>
                            </form>










                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
