/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BusinessEntity.TecnicoBE;
import BusinessEntity.TicketsBE;
import BusinessEntity.UsuarioBE;
import BusinessLogic.TecnicoBL;
import BusinessLogic.TicketsBL;
import DataAccessObject.TecnicoDAO;
import DataAccessObject.TicketsDAO;
import DataAccessObject.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Smile Consulting
 */
@WebServlet(name = "TicketsController", urlPatterns = {"/TicketsController"})
public class TicketsController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TicketsController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TicketsController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null || accion.equals("especializado")) {

            TicketsBL BL = new TicketsBL();
            ArrayList<TicketsBE> listaTickets = BL.ReadAll();
            request.setAttribute("listaTickets", listaTickets);
            request.getRequestDispatcher("/usuarios/frmTickets.jsp").forward(request, response);

        } else if (accion.equals("asignar")) {

            TicketsBL BL = new TicketsBL();
            ArrayList<TicketsBE> listaTickets = BL.ReadAll();
            TecnicoDAO daos = new TecnicoDAO();
            ArrayList<UsuarioBE> listaTecnicos = daos.listarTecnicos();

            request.setAttribute("listaTecnicos", listaTecnicos);
            request.setAttribute("listaTicketsAsignar", listaTickets);

            try {
                TecnicoBL tecnicoBL = new TecnicoBL();
                ArrayList<TecnicoBE> listaDeTecnicos = tecnicoBL.listarTodos();
                request.setAttribute("listaTecnicoBE", listaDeTecnicos);
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "Error al obtener la lista de técnicos: " + e.getMessage());
            }

            request.getRequestDispatcher("/usuarios/frmAsignar.jsp").forward(request, response);

        } else if (accion.equals("filtrar")) {

            ArrayList<TicketsBE> listaFiltrada;
            String estadoFiltro = request.getParameter("estadoFiltro");

            if (estadoFiltro == null || estadoFiltro.equals("todos")) {
                listaFiltrada = new TicketsDAO().ReadAll();
            } else {
                listaFiltrada = TicketsDAO.obtenerTicketsPorEstado(estadoFiltro);
            }

            request.setAttribute("listaTicketsAsignar", listaFiltrada);

            request.getRequestDispatcher("TicketsController?accion=asignar").forward(request, response);

        } else {
            // Otra acción o acción desconocida
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Acción no reconocida");
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null || accion.trim().isEmpty()) {
            response.sendRedirect("RequerimientoController?msg=accion_no_valida");
            return;
        }

        // ACCIÓN: REGISTRAR
        if ("registrar".equals(accion)) {
            try {
                int idUsuario = 0;
                try {
                    idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                    if (idUsuario == 0) {
                        response.sendRedirect("RequerimientoController?msg=idUsuario_vacio");
                        return;
                    }
                } catch (NumberFormatException e) {
                    response.sendRedirect("RequerimientoController?msg=idUsuario_invalido");
                    return;
                }

                String titulo = request.getParameter("titulo");
                String descripcion = request.getParameter("descripcion");

                if (titulo == null || titulo.trim().isEmpty()
                        || descripcion == null || descripcion.trim().isEmpty()) {
                    response.sendRedirect("RequerimientoController?msg=campos_vacios");
                    return;
                }

                HttpSession sesion = request.getSession();
                UsuarioBE usuario = (UsuarioBE) sesion.getAttribute("usuario");

                TicketsBE ticket = new TicketsBE();
                ticket.setTitulo(titulo);
                ticket.setDescripcion(descripcion);
                ticket.setEstado("Solicitado");
                ticket.setPrioridad("sin evaluar");
                ticket.setIdUsuario(idUsuario);
                ticket.setIdTecnico(0);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date soloFecha = sdf.parse(sdf.format(new Date()));
                ticket.setFechaCreacion(soloFecha);

                TicketsDAO dao = new TicketsDAO();
                dao.insertarTicket(ticket);

                response.sendRedirect("RequerimientoController?msg=exito");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("RequerimientoController?msg=error");
            }

        } else if ("actualizar".equals(accion)) {
            try {
                int idTicket = Integer.parseInt(request.getParameter("idTicket"));
                int idTecnico = Integer.parseInt(request.getParameter("idTecnicos"));
                String prioridad = request.getParameter("prioridad");

                if (prioridad == null || prioridad.trim().isEmpty()) {
                    request.setAttribute("mensaje", "⚠️ Prioridad no especificada.");
                } else {
                    String estado = "derivado";
                    TicketsDAO dao = new TicketsDAO();
                    boolean actualizado = dao.actualizarAsignacionTecnico(idTicket, estado, prioridad, idTecnico);

                    if (actualizado) {
                        request.setAttribute("mensaje", "✅ Ticket actualizado correctamente.");
                    } else {
                        request.setAttribute("mensaje", "⚠️ No se pudo actualizar el ticket.");
                    }
                }
            } catch (NumberFormatException e) {
                request.setAttribute("mensaje", "❌ Error: ID inválido.");
            } catch (Exception e) {
                request.setAttribute("mensaje", "❌ Error inesperado al actualizar el ticket.");
                e.printStackTrace();
            }

            response.sendRedirect("TicketsController?accion=asignar&mensaje=Ticket actualizado correctamente");

        } else {
            response.sendRedirect("RequerimientoController?msg=accion_desconocida");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
