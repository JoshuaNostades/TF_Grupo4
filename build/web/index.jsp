<%@page import="BusinessEntity.UsuarioBE"%>
<%@page import="DataAccessObject.UsuarioDAO"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Login - Sweet</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.4/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>

            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            /* El body y html deben ocupar toda la pantalla */
            html, body {
                height: 100%;
                overflow: hidden; /* Oculta cualquier scroll */
            }

            /* Asegura que el fondo y login-container usen altura completa */
            .full-screen-bg {
                height: 100vh;
                display: flex;
                flex-direction: column;
            }

            .login-container {
                flex-grow: 1;
                display: flex;
                align-items: center;
                justify-content: center;
            }


            body {
                background: linear-gradient(135deg, #f9f9f9 0%, #ffffff 100%);
                min-height: 100vh;
                font-family: 'Segoe UI', sans-serif;
            }

            .login-container {
                max-width: 400px;
                margin: 5% auto;
                padding: 40px;
                background: white;
                border-radius: 20px;
                box-shadow: 0 10px 30px rgba(0,0,0,0.1);
                text-align: center;
            }

            .brand-logo {
                width: 60px;
                margin-bottom: 20px;
            }

            .login-title {
                font-size: 32px;
                font-weight: bold;
                color: #444;
            }

            .forgot-link {
                color: #ec4d79;
                font-size: 14px;
                display: block;
                margin-top: 10px;
            }

            .btn-gradient {
                background: linear-gradient(to right, #EF7878, #EF7878);
                border: none;
                color: white;
                font-weight: bold;
            }

            .btn-gradient:hover {
                opacity: 0.9;
            }

            .top-right-links {
                position: absolute;
                top: 20px;
                right: 30px;
            }

            .top-right-links a {
                margin-left: 15px;
                color: #fff;
                font-weight: bold;
                text-decoration: none;
            }

            .top-banner {
                position: absolute;
                top: 0;
                right: 0;
                background: linear-gradient(135deg, #EF7878, #ff5c5c);
                width: 50%;
                height: 200px;
                border-bottom-left-radius: 50% 40%;
                z-index: -1;
            }

            .color-dots {
                position: absolute;
                bottom: 50px;
                right: 50px;
            }

            .circle {
                border-radius: 50%;
                position: absolute;
            }
            .top-right-links a {
                margin-left: 15px;
                color: #fff;
                font-weight: bold;
                text-decoration: none;
                position: relative;
                padding: 6px 10px;
                border-radius: 8px;
                transition: background-color 0.3s ease;
            }

            .top-right-links a:hover {
                background-color: #fff3cd; /* fondo amarillo claro tipo "highlight" */
                color: #000;               /* texto oscuro cuando se pasa el mouse */
            }

            .logo-top-left {
                position: absolute;
                top: 20px;
                left: 30px;
                z-index: 10;
            }

            .logo-text {
                font-size: 24px;
                font-weight: bold;
                color: #504e4e; /* morado elegante */
            }

            .login-heading {
                font-size: 32px;
                font-weight: 700;
                color: #3e3f5e;
                position: relative;
                display: inline-block;
                margin-bottom: 10px;
            }

            .login-heading::after {
                content: "";
                display: block;
                width: 100%;
                height: 4px;
                margin-top: 8px;
                border-radius: 2px;
                background: linear-gradient(to right, #ff9a9e, #fad0c4, #fad0c4, #a1c4fd, #c2e9fb);
            }

            .circle1 {
                background-color: #ffb347;
                width: 60px;
                height: 60px;
                right: 0;
                bottom: 60px;
            }
            .circle2 {
                background-color: #00c3ff;
                width: 100px;
                height: 100px;
                right: 80px;
                bottom: 0;
            }
            .circle3 {
                background-color: #0080ff;
                width: 60px;
                height: 60px;
                right: 130px;
                bottom: 80px;
            }
            .form-select:focus {
                border-color: #6f42c1;
                box-shadow: 0 0 0 0.25rem rgba(111, 66, 193, 0.25);
            }

            .form-check-input:checked {
                background-color: #dc3545; /* rojo Bootstrap */
                border-color: #dc3545;
            }

            /* Cambiar el color del checkbox en foco */
            .form-check-input:focus {
                border-color: #dc3545;
                box-shadow: 0 0 0 0.25rem rgba(220, 53, 69, 0.25);
            }
        </style>
    </head>


    <body class="full-screen-bg">


        <%
            UsuarioBE usuarioBE = null;

            if (session != null) {
                usuarioBE = (UsuarioBE) session.getAttribute("todoUsuario");
            }

            if (usuarioBE == null) {
                // Buscar cookie
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie c : cookies) {
                        if ("usuarioRecordado".equals(c.getName())) {
                            String correo = c.getValue();

                            UsuarioDAO dao = new UsuarioDAO();
                            usuarioBE = dao.buscarPorCorreo(correo);

                            if (usuarioBE != null) {
                                session.setAttribute("rolUsuario", usuarioBE.getRol());
                                session.setAttribute("todoUsuario", usuarioBE); // ← IMPORTANTE volver a setear

                                switch (usuarioBE.getRol()) {
                                    case "Administrativo":
                                        response.sendRedirect("RequerimientoController");
                                        return;
                                    case "Soporte tecnico":
                                        response.sendRedirect("gui/Principal.jsp");
                                        return;
                                    case "Soporte especializado":
                                        response.sendRedirect("ListarUsuarioController");
                                        return;
                                }
                            }
                        }
                    }
                }
            } else {
                // Si ya hay sesión activa
                String rol = usuarioBE.getRol();
                switch (rol) {
                    case "Administrativo":
                        response.sendRedirect("RequerimientoController");
                        return;
                    case "Soporte tecnico":
                        response.sendRedirect("gui/Principal.jsp");
                        return;
                    case "Soporte especializado":
                        response.sendRedirect("ListarUsuarioController");
                        return;
                }
            }

            // Si llegas aquí, no redirigiste, se mostrará el login
        %>


        <div class="logo-top-left d-flex align-items-center">
            <img src="irent.png" alt="Logo" class="me-2" style="width: 40px;">
            <span class="logo-text">Irent Perú</span>
        </div>

        <!-- Top banner with links -->
        <div class="top-banner"></div>
        <div class="top-right-links">
            <a href="#">Nostros</a>

            <a href="#">Activacion de cuenta</a>

        </div>

        <!-- Login Form -->
        <div class="login-container">
            <div class="login-card">
                <h2 class="login-heading">Inicio de sesión</h2>
                <p>Bienvenido a irentForms, configura tu sistema a tu gusto</p>

                <a href="#" class="forgot-link">¿Olvidaste tu contraseña?</a>

                <br>
                <%                    String error = request.getParameter("error");
                    if (error != null) {
                        String mensaje = "";
                        switch (error) {
                            case "campos":
                                mensaje = "⚠️ Todos los campos son obligatorios.";
                                break;
                            case "credenciales":
                                mensaje = "❌ Usuario, contraseña o rol incorrecto.";
                                break;
                            case "conexion":
                                mensaje = "❌ Error al conectar con la base de datos.";
                                break;
                            case "rol":
                                mensaje = "❌ El rol seleccionado no tiene acceso.";
                                break;
                            case "sesion":
                                mensaje = "⚠️ Debes iniciar sesión para acceder al sistema.";
                                break;
                            default:
                                mensaje = "❌ Ha ocurrido un error inesperado.";
                        }
                %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <%= mensaje%>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Cerrar"></button>
                </div>
                <%
                    }
                %>
                <form action="<%= request.getContextPath()%>/LoginUsuarioServlet" method="post">
                    <div class="form-floating mt-3">
                        <input type="text" class="form-control" id="username" name="username" placeholder="Username" required>
                        <label for="username">Correo</label>
                    </div>
                    <div class="form-floating mt-3">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                        <label for="password">Contraseña</label>
                    </div>

                    <div class="form-floating mt-3">
                        <select class="form-select" id="role" name="role" required>

                            <option value="Administrativo">Administrativo</option>
                            <option value="Soporte tecnico">Soporte técnico</option>
                            <option value="Soporte especializado">Soporte especializado</option>


                        </select>

                        <label for="role">Seleccione su area</label>
                    </div>

                    <div class="form-check text-start mt-3 ms-1">
                        <input class="form-check-input" type="checkbox" value="true" id="rememberMe" name="rememberMe">
                        <label class="form-check-label" for="rememberMe">
                            Mantener sesión iniciada
                        </label>
                    </div>

                    <button type="submit" class="btn btn-gradient btn-lg w-100 mt-4">Continuar</button>
                </form>
            </div>
        </div>

        <!-- Color dots decoration -->
        <div class="color-dots">
            <div class="circle circle1"></div>
            <div class="circle circle2"></div>
            <div class="circle circle3"></div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.4/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
