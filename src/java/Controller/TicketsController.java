/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BusinessEntity.TecnicoBE;
import BusinessEntity.TicketsBE;
import BusinessEntity.UsuarioBE;
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

        } else if (accion == null || accion.equals("asignar")) {

            TicketsBL BL = new TicketsBL();
            ArrayList<TicketsBE> listaTickets = BL.ReadAll();
            TecnicoDAO daos = new TecnicoDAO();
            ArrayList<UsuarioBE> listaTecnicos = daos.listarTecnicos();
            request.setAttribute("listaTecnicos", listaTecnicos);

            request.setAttribute("listaTicketsAsignar", listaTickets);
            request.getRequestDispatcher("/usuarios/frmAsignar.jsp").forward(request, response);
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

        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

        if ("registrar".equals(accion)) {
            try {
                // Recoge datos del formulario
                String titulo = request.getParameter("titulo");
                String descripcion = request.getParameter("descripcion");

                // Obtiene el usuario desde la sesión
                HttpSession sesion = request.getSession();
                UsuarioBE usuario = (UsuarioBE) sesion.getAttribute("usuario");

                // Crea el nuevo ticket
                TicketsBE ticket = new TicketsBE();
                ticket.setTitulo(titulo);
                ticket.setDescripcion(descripcion);
                ticket.setEstado("Solicitado");
                ticket.setPrioridad("sin evaluar"); // si quieres dejarlo sin prioridad inicialmente
                ticket.setIdUsuario(idUsuario);
                ticket.setIdTecnico(1); // o null si tu BE lo soporta
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date soloFecha = sdf.parse(sdf.format(new Date()));
                ticket.setFechaCreacion(soloFecha);

                // Guardar en la BD
                TicketsDAO dao = new TicketsDAO();
                dao.insertarTicket(ticket);

                // Redirigir o mostrar mensaje
                response.sendRedirect("RequerimientoController?msg=exito");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("RequerimientoController?msg=error");
            }
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
