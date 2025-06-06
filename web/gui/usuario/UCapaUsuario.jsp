<%-- 
    Document   : UCapaUsuario
    Created on : 08/05/2025, 12:44:51 PM
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


        <%
            request.setAttribute("paginaActiva", "perfil");
        %>
        <%@ include file="../Encabezado.jsp" %>
        
    </head>
    <body>
       <%@ include file="../Principal.jsp" %>
        <div class="container my-4">
            <div class="row align-items-start">
                <!-- Izquierda: icono y título -->
                <div class="col-md-2 text-center">
                    <div class="fs-1 mb-2">👤</div>
                    <h3>Empleado</h3>
                </div>

                <!-- Centro: formulario -->
                <div class="col-md-7">
                    <form id="empleadoForm" action="tuServletEditar" method="post">
                        <div class="mb-3">
                            <label for="correo" class="form-label">Correo</label>
                            <input type="email" class="form-control" id="correo" name="correo" required />
                        </div>
                        <div class="mb-3">
                            <label for="rol" class="form-label">Rol</label>
                            <input type="text" class="form-control" id="rol" name="rol" required />
                        </div>
                        <div class="mb-3">
                            <label for="registro" class="form-label">Registro</label>
                            <input type="text" class="form-control" id="registro" name="registro" required />
                        </div>
                        <div class="mb-3">
                            <label for="especialidad" class="form-label">Especialidad</label>
                            <input type="text" class="form-control" id="especialidad" name="especialidad" required />
                        </div>
                        <div class="mb-3">
                            <label for="nombre" class="form-label">Nombre</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" required />
                        </div>
                        <div class="mb-3">
                            <label for="apellido" class="form-label">Apellido</label>
                            <input type="text" class="form-control" id="apellido" name="apellido" required />
                        </div>
                    </form>
                </div>

                <!-- Derecha: botones -->
                <div class="col-md-3 d-flex flex-column align-items-center">
                    <button type="submit" form="empleadoForm" class="btn btn-primary mb-2 w-100">Editar correo</button>
                    <button type="button" class="btn btn-secondary w-100" onclick="location.href = 'cambiarContrasena.jsp'">Cambiar contraseña</button>
                </div>
            </div>
        </div>

        <!-- Bootstrap 5.1.3 JS Bundle -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    </body>
</html>
