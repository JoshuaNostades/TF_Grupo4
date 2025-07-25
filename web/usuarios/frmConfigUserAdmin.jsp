<%-- 
    Document   : frmUsuario
    Created on : 12 jul. 2025, 9:13:10 p. m.
    Author     : SOPORTE
--%>

<%@page import="DataAccessObject.UsuarioDAO"%>
<%@page import="BusinessEntity.UsuarioBE"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Configuracion</title>
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
                            <h4 class="mb-0">Configuracion</h4>
                            <i class="bi bi-person-plus fs-4"></i>
                        </div>
                        <div class="card-body">



                            <%
                                String exito = request.getParameter("exito");
                                String error = request.getParameter("error");
                            %>

                            <% if (exito != null) { %>
                            <div class="alert alert-success">Perfil actualizado correctamente.</div>
                            <% } %>

                            <% if (error != null) { %>
                            <div class="alert alert-danger">Ocurrió un error al actualizar el perfil.</div>
                            <% } %>



                            <p class="text-muted"></p>

                            <h2 class="mb-4"></h2>

                            <%
                                UsuarioBE usuarioAd = null;
                                Integer idUsuario = (Integer) session.getAttribute("idUsuario");
                                if (idUsuario == null) {
                                    response.sendRedirect("index.jsp?error=sinSesion");
                                    return;
                                }

                                UsuarioDAO dao = new UsuarioDAO();
                                usuarioAd = dao.obtenerUsuarioPorId(idUsuario);

                                if (usuarioAd == null) {
                                    response.sendRedirect("login.jsp?error=usuarioNoEncontrado");
                                    return;
                                }


                            %>



                           
                                <div class="card-body">
                                    <form method="post" action="<%= request.getContextPath()%>/ConfigAdminController">
                                        <input type="hidden" name="id_usuario" value="<%= idUsuario%>">

                                        <div class="mb-3">
                                            <label class="form-label">Nombre completo:</label>
                                            <input type="text" name="nombre" class="form-control" value="<%= usuarioAd.getNombre()%>" required>
                                        </div>


                                        <div class="mb-3">
                                            <label class="form-label">Correo electrónico:</label>
                                            <input type="email" name="correo" class="form-control" value="<%= usuarioAd.getCorreo()%>" required>
                                        </div>


                                        <div class="mb-3">
                                            <label class="form-label">Contraseña:</label>
                                            <div class="input-group">
                                                <input type="password" name="contrasena" class="form-control" id="inputContrasena" value="<%= usuarioAd.getContrasena()%>" required>
                                                <button class="btn btn-outline-secondary" type="button" onclick="toggleContrasena()">
                                                    <i class="bi bi-eye-slash" id="iconoOjo"></i>
                                                </button>
                                            </div>
                                        </div>


                                        <script>
                                            function toggleContrasena() {
                                                const input = document.getElementById("inputContrasena");
                                                const icono = document.getElementById("iconoOjo");

                                                if (input.type === "password") {
                                                    input.type = "text";
                                                    icono.classList.remove("bi-eye-slash");
                                                    icono.classList.add("bi-eye");
                                                } else {
                                                    input.type = "password";
                                                    icono.classList.remove("bi-eye");
                                                    icono.classList.add("bi-eye-slash");
                                                }
                                            }
                                        </script>                  

                                        <div class="mb-3">
                                            <label class="form-label">Rol:</label>
                                            <input type="text" class="form-control" name="rol" value="<%= usuarioAd.getRol()%>" readonly>
                                        </div>

                                        <input type="hidden" name="fecha_registro" value="<%= usuarioAd.getFecha()%>">

                                        <div class="text">
                                            <button type="submit" class="btn btn-md btn-primary">Actualizar</button>
                                        </div>
                                    </form>
                                </div>
                        








                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
