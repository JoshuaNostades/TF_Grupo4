<%-- 
    Document   : frmInforme
    Created on : 15 jul. 2025, 2:01:40 p. m.
    Author     : SOPORTE
--%>

<%@page import="BusinessEntity.InformeBE"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ include file="/gui/Encabezado.jsp" %>
    </head>
<div class="container mt-4">
    <h4 class="mb-3">Historial de Informes del Ticket</h4>
    <div class="list-group">
        <%
            ArrayList<InformeBE> informes = (ArrayList<InformeBE>) request.getAttribute("listaInformes");
            for (InformeBE inf : informes) {
        %>
        <div class="list-group-item">
            <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1">Informe por Técnico #<%= inf.getIdTecnico()%></h5>
                <small><%= inf.getFechaInforme()%></small>
            </div>
            <p class="mb-1"><%= inf.getDescripcion()%></p>
        </div>
        <% } %>
    </div>

    <div class="accordion" id="accordionInformes">
        <% for (int i = 0; i < informes.size(); i++) {
          InformeBE inf = informes.get(i);%>
        <div class="accordion-item">
            <h2 class="accordion-header" id="heading<%=i%>">
                <button class="accordion-button <%= i > 0 ? "collapsed" : ""%>" type="button" data-bs-toggle="collapse" data-bs-target="#collapse<%=i%>">
                    Informe por Técnico #<%= inf.getIdTecnico()%> - <%= inf.getFechaInforme()%>
                </button>
            </h2>
            <div id="collapse<%=i%>" class="accordion-collapse collapse <%= i == 0 ? "show" : ""%>" data-bs-parent="#accordionInformes">
                <div class="accordion-body">
                    <%= inf.getDescripcion()%>
                </div>
            </div>
        </div>
        <% }%>
    </div>

    <form action="InformeServlet" method="post" class="mt-4">
        <input type="hidden" name="id_ticket" value="aaa>
               <input type="hidden" name="id_tecnico" value="bbb">
        <div class="mb-3">
            <label for="contenido" class="form-label">Nuevo Informe</label>
            <textarea class="form-control" name="contenido" id="contenido" rows="4" required></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Guardar Informe</button>
    </form>


</div>
