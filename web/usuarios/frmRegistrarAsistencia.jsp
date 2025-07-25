<%-- 
    Document   : frmUsuario
    Created on : 12 jul. 2025, 9:13:10 p. m.
    Author     : SOPORTE
--%>

<%@page import="BusinessEntity.AsistenciaBE"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="BusinessEntity.UsuarioBE"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    // Suponiendo que tienes el id_tecnico en sesión
    Integer idTecnico = (Integer) session.getAttribute("idTecnico");
    if (idTecnico == null) {
        response.sendRedirect("index.jsp"); // Redirecciona si no hay sesión
        return;
    }

    // Fecha actual
    // Simulación de consulta a la base (debes reemplazar por acceso real)
    // Suponiendo que tienes un método que obtiene la asistencia de hoy para el técnico
    // Ejemplo: Asistencia asistencia = AsistenciaDAO.obtenerAsistenciaDelDia(idTecnico, fechaHoy);
    // Esto es un mock temporal
    class Asistencia {

        public String horaEntrada = null;
        public String horaSalida = null;
    }

    // Si ya existe en la base, estos valores se llenan
    // asistencia.horaEntrada = "08:00:00";
    // asistencia.horaSalida = null;

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ include file="/gui/Encabezado.jsp" %>
        <!-- Bootstrap 5.3.0 CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Bootstrap Icons -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

        <%    boolean tieneEntrada = Boolean.TRUE.equals(request.getAttribute("tieneEntrada"));
            boolean tieneSalida = Boolean.TRUE.equals(request.getAttribute("tieneSalida"));
            AsistenciaBE asistencia = (AsistenciaBE) request.getAttribute("asistencia");
            String fechaHoy = (String) request.getAttribute("fechaHoy");
        %>



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
                        <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
                            <h4 class="mb-0">Lista de Usuarios administrativos</h4>
                            <i class="bi bi-person-plus fs-4"></i>
                        </div>
                        <div class="card-body">
                            <p class="text-muted"></p>

                            <h2 class="mb-4"></h2>












                            <div class="container my-5 ">
                                <div class="card shadow-sm rounded-4 ">
                                    <div class="card-body">
                                        <div class="row">

                                            <!-- Botones laterales -->
                                            <div class="col-md-3 d-flex flex-column align-items-start justify-content-center gap-3 px-4 border-end">
                                                <h5 class="fw-bold">Opciones</h5>
                                                <button class="btn btn-outline-primary w-100"><i class="bi bi-person-check me-2"></i> Asistencia</button>
                                                <button class="btn btn-outline-secondary w-100"><i class="bi bi-clock-history me-2"></i> Historial</button>
                                                <button class="btn btn-outline-success w-100"><i class="bi bi-clipboard-data me-2"></i> Reportes</button>
                                            </div>


                                          
                                            
                                            
                                            
                                            <!-- iPhone Entrada -->
                                            <div class="bg-dark p-2 rounded-4 mb-4 ms-5" style="width: 360px; border: 14px solid #000; border-radius: 40px; ">
                                                <div class="bg-white rounded-4 overflow-hidden" style="height: 550px;">
                                                    <div class="bg-dark text-white text-center py-2">
                                                        <strong>Entrada</strong>
                                                    </div>
                                                    <div class="p-4">
                                                        <h5 class="fw-bold text-center">Registro de Entrada</h5>
                                                        <p class="mb-2"><i class="bi bi-calendar-date-fill me-2"></i><strong>Fecha:</strong> <%= fechaHoy%></p>
                                                        <p class="mb-4"><i class="bi bi-clock me-2"></i><strong>Hora:</strong> <%= tieneEntrada ? asistencia.getHoraEntrada() : "No registrada"%></p>

                                                        <% if (!tieneEntrada) {%>
                                                        <form action="<%= request.getContextPath()%>/AsistenciaController?accion=registrarEntrada" method="post">
                                                            <input type="hidden" name="accion" value="entrada">
                                                            <button type="submit" class="btn btn-success btn-lg w-100">
                                                                <i class="bi bi-box-arrow-in-right me-2"></i> Marcar Entrada
                                                            </button>
                                                        </form>
                                                        <% } else { %>
                                                        <div class="alert alert-info text-center mt-3">
                                                            <i class="bi bi-check-circle-fill me-2"></i> Entrada registrada
                                                        </div>
                                                        <% }%>
                                                    </div>
                                                    <div class="text-center py-2">
                                                        <div style="width: 60px; height: 6px; background: #bbb; border-radius: 3px; margin: 0 auto;"></div>
                                                    </div>
                                                </div>
                                            </div>

                                            <!-- iPhone Salida -->
                                            <div class="bg-dark p-2 rounded-4 mb-4 ms-5" style="width: 360px; border: 14px solid #000; border-radius: 40px;  opacity: <%= tieneEntrada ? "1" : "0.5"%>;">
                                                <div class="bg-white rounded-4 overflow-hidden" style="height: 550px;">
                                                    <div class="bg-dark text-white text-center py-2">
                                                        <strong>Salida</strong>
                                                    </div>
                                                    <div class="p-4">
                                                        <h5 class="fw-bold text-center">Registro de Salida</h5>
                                                        <p class="mb-2"><i class="bi bi-calendar-date-fill me-2"></i><strong>Fecha:</strong> <%= fechaHoy%></p>
                                                        <p class="mb-4"><i class="bi bi-clock-history me-2"></i><strong>Hora:</strong> <%= tieneSalida ? asistencia.getHoraSalida() : "No registrada"%></p>

                                                        <% if (tieneEntrada && !tieneSalida) {%>
                                                        <form action="<%= request.getContextPath()%>/AsistenciaController?accion=registrarSalida" method="post">
                                                            <input type="hidden" name="accion" value="salida">
                                                            <button type="submit" class="btn btn-danger btn-lg w-100">
                                                                <i class="bi bi-box-arrow-right me-2"></i> Marcar Salida
                                                            </button>
                                                        </form>
                                                        <% } else if (!tieneEntrada) { %>
                                                        <div class="alert alert-warning text-center mt-3">
                                                            <i class="bi bi-exclamation-triangle me-2"></i> Debes registrar tu entrada primero
                                                        </div>
                                                        <% } else { %>
                                                        <div class="alert alert-info text-center mt-3">
                                                            <i class="bi bi-check-circle-fill me-2"></i> Salida registrada
                                                        </div>
                                                        <% }%>
                                                    </div>
                                                    <div class="text-center py-2">
                                                        <div style="width: 60px; height: 6px; background: #bbb; border-radius: 3px; margin: 0 auto;"></div>
                                                    </div>
                                                </div>
                                            </div>


                                        </div>
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
