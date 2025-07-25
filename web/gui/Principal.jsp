<!-- Bootstrap 5 CSS y JS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">





<div class="d-flex flex-column p-3 bg-dark text-light" style="width: 100%; height: 100%;">


    <div href="#" class="align-items-center text-center">
        <i class="bi bi-person-circle fs-1 me-2 text-light"></i>

    </div>
    <div href="#" class="align-items-center text-center">

        <span class="fs-2 fw-semibold text-light text-center">IrentForms</span>
    </div>

    <div class="text-muted mb-3 text-center fs-7 fw-semibold">

        <a class="text-light text-center"><%= session.getAttribute("correoUsuario")%></a>

    </div>
    <hr>
    <%
        String rol = (String) session.getAttribute("rolUsuario");
        int id = (Integer) session.getAttribute("idTecnico");
    %>
    <ul class="nav nav-pills flex-column gap-1" >

        <% if ("Soporte especializado".equals(rol)) {%>
        <!-- INICIO -->


        <!-- GESTI�N -->
        <li class="nav-item">
            <a class="nav-link d-flex justify-content-between align-items-center text-light px-3 py-2"
               data-bs-toggle="collapse" href="#gestionMenu" role="button" aria-expanded="false" aria-controls="gestionMenu">
                <span><i class="bi bi-gear me-2"></i> Gesti�n</span>
                <i class="bi bi-chevron-down"></i>
            </a>
            <div class="collapse" id="gestionMenu">
                <ul class="nav flex-column ms-4">
                    <li><a href="<%= request.getContextPath()%>/MensajeController" class="nav-link text-light px-3 py-1"><i class="bi bi-chat-dots me-2"></i> IrentChat</a></li>

                </ul>
            </div>
        </li>

        <!-- TICKETS -->
        <li class="nav-item">
            <a class="nav-link d-flex justify-content-between align-items-center text-light px-3 py-2"
               data-bs-toggle="collapse" href="#ticketsMenu" role="button" aria-expanded="false" aria-controls="ticketsMenu">
                <span><i class="bi bi-ticket-perforated-fill me-2"></i> Tickets</span>
                <i class="bi bi-chevron-down"></i>
            </a>
            <div class="collapse" id="ticketsMenu">
                <ul class="nav flex-column ms-4">
                    <li><a href="#" class="nav-link text-light px-3 py-1"><i class="bi bi-tools me-2"></i> Gestionar</a></li>
                    <li><a href="<%= request.getContextPath()%>/TicketsController?accion=asignar" class="nav-link text-light px-3 py-1"><i class="bi bi-person-plus me-2"></i> Asignar</a></li>
                    <li><a href="<%= request.getContextPath()%>/TicketsController?accion=especializado" class="nav-link text-light px-3 py-1"><i class="bi bi-clock-history me-2 text-light"></i> Historial</a></li>
                </ul>
            </div>
        </li>

        <!-- USUARIOS -->
        <li class="nav-item">
            <a class="nav-link d-flex justify-content-between align-items-center text-light px-3 py-2"
               data-bs-toggle="collapse" href="#usuariosMenu" role="button" aria-expanded="false" aria-controls="usuariosMenu">
                <span><i class="bi bi-people me-2"></i> Usuarios</span>
                <i class="bi bi-chevron-down"></i>
            </a>
            <div class="collapse" id="usuariosMenu">
                <ul class="nav flex-column ms-4">
                    <li><a href="<%= request.getContextPath()%>/ListarUsuarioController?accion=administrativo" class="nav-link text-light px-3 py-1"><i class="bi bi-list-ul me-2"></i> Listar</a></li>
                    <li><a href="<%= request.getContextPath()%>/RegistroUsuarioServlet" class="nav-link text-light px-3 py-1"><i class="bi bi-person-plus-fill me-2"></i> Asignar</a></li>
                </ul>
            </div>
        </li>

        <!-- T�CNICOS -->
        <li class="nav-item">
            <a class="nav-link d-flex justify-content-between align-items-center text-light px-3 py-2"
               data-bs-toggle="collapse" href="#tecnicosMenu" role="button" aria-expanded="false" aria-controls="tecnicosMenu">
                <span><i class="bi bi-person-badge me-2"></i> T�cnicos</span>
                <i class="bi bi-chevron-down"></i>
            </a>
            <div class="collapse" id="tecnicosMenu">
                <ul class="nav flex-column ms-4">
                    <li><a href="<%= request.getContextPath()%>/ListarUsuarioController?accion=soporte" class="nav-link text-light px-3 py-1"><i class="bi bi-eye me-2"></i> Visualizaci�n</a></li>
                    
                    <li><a href="<%= request.getContextPath()%>/AsistenciaController?accion=listarAsistencia" class="nav-link text-light px-3 py-1"><i class="bi bi-check-circle me-2"></i> Asistencia</a></li>
                </ul>
            </div>
        </li>

        <!-- INVENTARIO -->
        <li class="nav-item">
            <a class="nav-link d-flex justify-content-between align-items-center text-dark px-3 py-2"
               data-bs-toggle="collapse" href="#inventarioMenu" role="button" aria-expanded="false" aria-controls="inventarioMenu">
                <span><i class="bi bi-box-seam me-2"></i> Inventario</span>
                <i class="bi bi-chevron-down"></i>
            </a>
            <div class="collapse" id="inventarioMenu">
                <ul class="nav flex-column ms-4">
                    <li><a href="#" class="nav-link text-dark px-3 py-1"><i class="bi bi-paperclip me-2"></i> Anexos</a></li>
                    <li><a href="#" class="nav-link text-dark px-3 py-1"><i class="bi bi-printer me-2"></i> Impresoras</a></li>
                    <li><a href="#" class="nav-link text-dark px-3 py-1"><i class="bi bi-cpu me-2"></i> Rob�tica</a></li>
                    <li><a href="#" class="nav-link text-dark px-3 py-1"><i class="bi bi-tv me-2"></i> TV</a></li>
                    <li><a href="#" class="nav-link text-dark px-3 py-1"><i class="bi bi-hdd-network me-2"></i> Equipos</a></li>
                    <li><a href="#" class="nav-link text-dark px-3 py-1"><i class="bi bi-fingerprint me-2"></i> Biom�trico</a></li>
                    <li><a href="#" class="nav-link text-dark px-3 py-1"><i class="bi bi-easel3 me-2"></i> Proyectores</a></li>
                    <li><a href="#" class="nav-link text-dark px-3 py-1"><i class="bi bi-camera-video me-2"></i> Panacast</a></li>
                </ul>
            </div>
        </li>


        <% } else if ("Soporte tecnico".equals(rol)) {%>


        <!-- INICIO -->
        <li class="nav-item">
            <a class="nav-link d-flex justify-content-between align-items-center text-light px-3 py-2"
               data-bs-toggle="collapse" href="#inicioMenu" role="button" aria-expanded="false" aria-controls="inicioMenu">
                <span><i class="bi bi-house-door me-2"></i> Inicio</span>
                <i class="bi bi-chevron-down"></i>
            </a>
            <div class="collapse" id="inicioMenu">
                <ul class="nav flex-column ms-4">
                    <li><a href="<%= request.getContextPath()%>/ListarGuiaController" class="nav-link text-light px-3 py-1"><i class="bi bi-journal-code me-2"></i> Gu�a</a></li>
                    <li><a href="<%= request.getContextPath()%>/MensajeController" class="nav-link text-light px-3 py-1"><i class="bi bi-chat-dots me-2"></i> IrentChat</a></li>
                </ul>
            </div>

        </li>


        <%-- Solo ver TICKETS para Soporte t�cnico --%>
        <li class="nav-item">
            <a class="nav-link d-flex justify-content-between align-items-center text-light px-3 py-2"
               data-bs-toggle="collapse" href="#ticketsMenu" role="button" aria-expanded="false" aria-controls="ticketsMenu">
                <span><i class="bi bi-ticket-perforated-fill me-2"></i> Tickets</span>
                <i class="bi bi-chevron-down"></i>
            </a>
            <div class="collapse" id="ticketsMenu">
                <ul class="nav flex-column ms-4">
                    <li><a href="<%= request.getContextPath()%>/ListarTicketsdeTecnicosController?accion=misTickets" class="nav-link text-light px-3 py-1"><i class="bi bi-tools me-2"></i> Gestion</a></li>
                    <li><a href="<%= request.getContextPath()%>/ListarTablaTicketTecnico" class="nav-link text-light px-3 py-1"><i class="bi bi-clock-history me-2"></i> Historial</a></li>
                </ul>
            </div>
        </li>




        <!-- T�CNICOS -->
        <li class="nav-item">
            <a class="nav-link d-flex justify-content-between align-items-center text-light px-3 py-2"
               data-bs-toggle="collapse" href="#tecnicosMenu" role="button" aria-expanded="false" aria-controls="tecnicosMenu">
                <span><i class="bi bi-person-badge me-2"></i> Perfil</span>
                <i class="bi bi-chevron-down"></i>
            </a>
            <div class="collapse" id="tecnicosMenu">
                <ul class="nav flex-column ms-4">
                    <li><a href="<%= request.getContextPath()%>/SesionController" class="nav-link text-light px-3 py-1"><i class="bi bi-laptop me-2"></i> Sesiones</a></li>
                    <li><a href="<%= request.getContextPath()%>/AsistenciaController?accion=registrarAsistencia" class="nav-link text-light px-3 py-1"><i class="bi bi-check-circle me-2"></i> Asistencia</a></li>

                </ul>
            </div>
        </li>




        <% } else if ("Administrativo".equals(rol)) {%>


        <!-- INICIO -->
        <li class="nav-item">
            <a class="nav-link d-flex justify-content-between align-items-center text-light px-3 py-2"
               data-bs-toggle="collapse" href="#inicioMenu" role="button" aria-expanded="false" aria-controls="inicioMenu">
                <span><i class="bi bi-house-door me-2"></i> Mi perfil</span>
                <i class="bi bi-chevron-down"></i>
            </a>
            <div class="collapse" id="inicioMenu">
                <ul class="nav flex-column ms-4">
                    <li><a href="<%= request.getContextPath()%>/ConfigAdminController" class="nav-link text-light px-3 py-1"><i class="bi bi-journal-code me-2"></i> Configuracion</a></li>

                </ul>
            </div>
        </li>

        <%-- Solo ver TICKETS para Soporte t�cnico --%>
        <li class="nav-item">
            <a class="nav-link d-flex justify-content-between align-items-center text-light px-3 py-2"
               data-bs-toggle="collapse" href="#ticketsMenu" role="button" aria-expanded="false" aria-controls="ticketsMenu">
                <span><i class="bi bi-ticket-perforated-fill me-2"></i> Gestion</span>
                <i class="bi bi-chevron-down"></i>
            </a>
            <div class="collapse" id="ticketsMenu">
                <ul class="nav flex-column ms-4">
                    <li><a href="<%= request.getContextPath()%>/RequerimientoController" class="nav-link text-light px-3 py-1"><i class="bi bi-chat-dots me-2"></i>Requerimiento</a></li>
                    <li><a href="<%= request.getContextPath()%>/RequerimientoController" class="nav-link text-light px-3 py-1"><i class="bi bi-chat-dots me-2"></i>Mis tickets</a></li>    
                    <li><a href="<%= request.getContextPath()%>/MensajeController" class="nav-link text-light px-3 py-1"><i class="bi bi-chat-dots me-2"></i>Chat</a></li>

                </ul>
            </div>
        </li>




        <% }%>


        <%-- CERRAR SESI�N: todos los roles --%>
        <li class="nav-item mt-3">
            <a href="<%= request.getContextPath()%>/CerrarSesionController" class="nav-link d-flex align-items-center px-3 py-2 text-light">
                <i class="bi bi-box-arrow-right me-2"></i> Cerrar sesi�n
            </a>
        </li>
    </ul>
</div>