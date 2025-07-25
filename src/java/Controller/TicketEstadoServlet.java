/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DataAccessObject.TicketsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.sql.*;

/**
 *
 * @author SOPORTE
 */
@WebServlet(name = "TicketEstadoServlet", urlPatterns = {"/TicketEstadoServlet"})
public class TicketEstadoServlet extends HttpServlet {

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
            out.println("<title>Servlet TicketEstadoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TicketEstadoServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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


        
         try {
            int idTicket = Integer.parseInt(request.getParameter("id_ticket"));
            String nuevoEstado = request.getParameter("nuevo_estado");

            TicketsDAO dao = new TicketsDAO();

            if ("cerrado".equalsIgnoreCase(nuevoEstado)) {
                // Si se cierra el ticket, también se actualiza la fecha de cierre con Date
                Date ahora = new Date();
                dao.actualizarEstadoYFechaCierre(idTicket, nuevoEstado, ahora);
            } else {
                // Para otros estados, solo se actualiza el estado
                dao.actualizarEstado(idTicket, nuevoEstado);
            }

            // Redirige al listado de tickets (ajusta si es otra vista)
            response.sendRedirect("ListarTicketsdeTecnicosController");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Error al actualizar el estado del ticket.");
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
