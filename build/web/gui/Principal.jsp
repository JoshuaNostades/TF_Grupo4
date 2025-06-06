

<%-- Solo usarla si no fue definida antes --%>
<%
    String paginaActiva = request.getParameter("paginaActiva");

    if (request.getAttribute("paginaActiva") != null) {
        paginaActiva = (String) request.getAttribute("paginaActiva");
    } else {
        paginaActiva = "perfil";
    }
%>


<div class="d-flex flex-column flex-shrink-0 p-3 bg-light" style="width: 250px; height: 100vh;">
    <a href="#" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-decoration-none mx-auto">
        <i class="bi bi-person-circle me-2 fs-4"></i>
        <span class="fs-4 mx-auto">iRent Peru</span>
    </a>
    <span class="fs-4 mx-auto">Mi usuario</span>
    <hr>
    <ul class="nav flex-column gap-2">
        <li class="nav-item mb-3">
            <a href="<%= request.getContextPath()%>/gui/usuario/UCapaUsuario.jsp"
               class="nav-link d-flex align-items-center rounded shadow-sm px-3 py-2 
               <%= "perfil".equals(paginaActiva) ? "active bg-primary text-white" : "bg-light"%>">
                <i class="bi bi-person me-2"></i> Mi perfil
            </a>
        </li>

        <li class="nav-item mb-3">
            <a href="<%= request.getContextPath()%>/gui/tickets/TCapaTickets.jsp"
               class="nav-link d-flex align-items-center rounded shadow-sm px-3 py-2 
               <%= "tickets".equals(paginaActiva) ? "active bg-primary text-white" : "bg-light"%>">
                <i class="bi bi-card-list me-2"></i> Tickets
            </a>
        </li>

        <li class="nav-item mb-3">
            <a href="<%= request.getContextPath()%>/gui/asistencia/ACapaAsistencia.jsp"
               class="nav-link d-flex align-items-center rounded shadow-sm px-3 py-2 
               <%= "asistencia".equals(paginaActiva) ? "active bg-primary text-white" : "bg-light"%>">
                <i class="bi bi-tools me-2"></i> Asistencias
            </a>
        </li>

        <li class="nav-item mb-3">
            <a href="<%= request.getContextPath()%>/gui/informes/ICapaInformes.jsp"
               class="nav-link d-flex align-items-center rounded shadow-sm px-3 py-2 
               <%= "informes".equals(paginaActiva) ? "active bg-primary text-white" : "bg-light"%>">
                <i class="bi bi-bar-chart-line me-2"></i> Informes
            </a>
        </li>

        <li class="nav-item mb-3">
            <a href=""
               class="nav-link d-flex align-items-center rounded shadow-sm px-3 py-2 
               <%= "inventario".equals(paginaActiva) ? "active bg-primary text-white" : "bg-light"%>">
                <i class="bi bi-box-seam me-2"></i> Inventario
            </a>
        </li>

        <li class="nav-item mb-3">
            <a href="<%= request.getContextPath()%>/gui/plantilla/PCapaPlantilla.jsp"
               class="nav-link d-flex align-items-center rounded shadow-sm px-3 py-2 
               <%= "plantilla".equals(paginaActiva) ? "active bg-primary text-white" : "bg-light"%>">
                <i class="bi bi-calendar-week me-2"></i> Mi Plantilla
            </a>
        </li>

        <li class="nav-item mb-3">
            <a href="#" class="nav-link d-flex align-items-center bg-light text-danger rounded shadow-sm px-3 py-2">
                <i class="bi bi-box-arrow-right me-2"></i> Cerrar sesión
                </a>

    </ul>
</div>
