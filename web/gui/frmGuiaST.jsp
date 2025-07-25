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
        <title>Guia</title>
        <%@ include file="/gui/Encabezado.jsp" %>
        <style>
            .card {
                border-radius: 20px;
                box-shadow: 0 8px 25px rgba(0,0,0,0.1);
            }
            .lottie-box {
                height: 250px;
                margin-bottom: 20px;
            }
            
            
            
        </style><style>
    .card {
        border-radius: 20px;
        box-shadow: 0 8px 25px rgba(0,0,0,0.1);
        min-height: 600px; /* Ajusta según tu contenido */
    }
    .lottie-box {
        height: 250px;
        margin-bottom: 20px;
    }
</style>
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
                            <h4 class="mb-0">Guia para personal de soporte</h4>
                            <i class="bi bi-person-plus fs-4"></i>
                        </div>



                        <%
                            int paso = request.getAttribute("paso") != null ? (Integer) request.getAttribute("paso") : 1;
                            String mensaje = request.getAttribute("mensaje") != null ? (String) request.getAttribute("mensaje") : "";
                        %>


                        <div class="container mt-5">
                            <div class="card p-4 mx-auto" style="max-width: 1000px;">
                                <h3 class="text-center mb-4 text-primary">🛠️ Guía Interactiva del Soporte Técnico</h3>

                                <% if (!mensaje.isEmpty()) {%>
                                <div class="alert alert-success text-center"><%= mensaje%></div>
                                <% } %>

                                <div class="row">
                                    <!-- Columna izquierda: Animación -->
                                    <div class="col-md-6 text-center">
                                        <% if (paso == 1) { %>
                                        <lottie-player class="lottie-box"
                                                       src="paso1.json"
                                                       background="transparent"
                                                       speed="1"
                                                       loop
                                                       autoplay>
                                        </lottie-player>
                                        <h5>Paso 1: Registro de Requerimiento</h5>
                                        <p class="text-muted">El personal administrativo registra una solicitud o problema que necesita atención técnica.</p>

                                        <% } else if (paso == 2) { %>
                                        <lottie-player class="lottie-box"
                                                       src="paso2.json"
                                                       background="transparent"
                                                       speed="1"
                                                       loop
                                                       autoplay>
                                        </lottie-player>
                                        <h5>Paso 2: Generación del Ticket</h5>
                                        <p class="text-muted">Ese requerimiento se convierte en un ticket dentro del sistema.</p>

                                        <% } else if (paso == 3) { %>
                                        <lottie-player class="lottie-box"
                                                       src="paso3.json"
                                                       background="transparent"
                                                       speed="1"
                                                       loop
                                                       autoplay>
                                        </lottie-player>
                                        <h5>Paso 3: Asignación del Ticket</h5>
                                        <p class="text-muted">El supervisor asigna el ticket al soporte correspondiente.</p>

                                        <% } else if (paso == 4) { %>
                                        <lottie-player class="lottie-box"
                                                       src="paso4.json"
                                                       background="transparent"
                                                       speed="1"
                                                       loop
                                                       autoplay>
                                        </lottie-player>
                                        <h5>Paso 4: Atención del Ticket</h5>
                                        <p class="text-muted">El técnico resuelve el ticket y deja comentarios.</p>
                                        <% }%>
                                    </div>

                                    <!-- Columna derecha: Explicación larga -->
                                    <div class="col-md-6">
                                        <h5>¿Cómo funciona el flujo del sistema?</h5>
                                        <p class="text-justify">
                                            Esta guía interactiva te explica paso a paso cómo se gestiona una solicitud técnica dentro del sistema. El proceso inicia cuando un usuario administrativo registra una necesidad o problema. Este se transforma en un ticket dentro de la plataforma para ser gestionado.
                                        </p>
                                        <p class="text-justify">
                                            Luego, el supervisor del área revisa las solicitudes entrantes y asigna cada una de ellas al técnico más adecuado, según la naturaleza del requerimiento. Finalmente, tú como soporte técnico puedes registrar tus avances, observaciones, y dar solución a los tickets pendientes.
                                        </p>
                                        <p class="text-justify">
                                            El objetivo de este flujo es garantizar una atención ordenada, con seguimiento y trazabilidad, promoviendo una experiencia más eficiente para todos los usuarios del sistema.
                                        </p>
                                    </div>
                                </div>

                                <!-- Botón siguiente y barra -->
                                <form method="post" action="GuiaController" class="text-center mt-4">
                                    <input type="hidden" name="paso" value="<%= paso + 1%>" />
                                    <button type="submit" class="btn btn-primary">
                                        <%= paso == 4 ? "Finalizar" : "Siguiente"%>
                                    </button>
                                </form>

                                <div class="text-center mt-3">
                                    <span class="badge bg-secondary">Paso <%= paso%> de 4</span>
                                </div>

                                <div class="progress mt-2" style="height: 10px;">
                                    <div class="progress-bar bg-info" role="progressbar" style="width: <%= paso * 25%>%;" aria-valuenow="<%= paso * 25%>" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>
                        </div>







                    </div>
                </div>
            </div>
        </div>
        <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>

    </body>
</html>
