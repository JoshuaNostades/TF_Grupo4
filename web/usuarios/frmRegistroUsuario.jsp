<%-- 
    Document   : frmUsuario
    Created on : 12 jul. 2025, 9:13:10 p. m.
    Author     : SOPORTE
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
                <div class="col-md-2 bg-dark p-4 border-end">
                    <%@ include file="/gui/Principal.jsp" %>
                </div>


                <div class="col-md-10 p-4 main-content">
                    <div class="card shadow-sm">
                        <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
                            <h4 class="mb-0">Registro de usuarios</h4>
                            <i class="bi bi-person-plus fs-4"></i>
                        </div>
                        <div class="card-body">
                            <p class="text-muted"></p>

                            <h2 class="mb-4"></h2>





                            <div class="container mt-5">
                                <div class="card shadow-lg mx-auto" style="max-width: 600px;">
                                    <div class="card-header bg-dark text-white text-center">
                                        <h4 class="mb-0">Registro de Usuario</h4>
                                    </div>
                                    <div class="card-body">

                                        <form method="post" action="<%= request.getContextPath()%>/UsuarioController">
                                            <div class="mb-3">
                                                <label class="form-label">Nombre completo:</label>
                                                <input type="text" name="nombre" class="form-control" required>
                                            </div>

                                            <div class="mb-3">
                                                <label class="form-label">Correo electrónico:</label>
                                                <input type="email" name="correo" class="form-control" required>
                                            </div>

                                            <div class="mb-3">
                                                <label class="form-label">Contraseña:</label>
                                                <input type="password" name="contrasena" class="form-control" required>
                                            </div>

                                            <div class="mb-3">
                                                <label class="form-label">Rol:</label>
                                                <select name="rol" class="form-select" required>
                                                    <option value="" disabled selected>Seleccione un rol</option>
                                                    <option value="Soporte especializado">Soporte especializado</option>
                                                    <option value="Soporte tecnico">Soporte técnico</option>
                                                    <option value="Administrativo">Administrativo</option>
                                                </select>
                                            </div>

                                            <%
                                                // Obtener fecha actual y formatear
                                                Date fechaActual = new Date();
                                                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                                String fechaFormateada = formato.format(fechaActual);
                                            %>
                                            <input type="hidden" name="fecha_registro" value="<%= fechaFormateada%>">

                                            <div class="text-center">
                                                <button type="submit" class="btn btn-primary w-50">Registrar</button>
                                            </div>
                                        </form>

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
