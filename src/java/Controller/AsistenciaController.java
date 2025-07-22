/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BusinessEntity.AsistenciaBE;
import BusinessLogic.AsistenciaBL;
import DataAccessObject.AsistenciaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Smile Consulting
 */
@WebServlet(name = "AsistenciaController", urlPatterns = {"/AsistenciaController"})
public class AsistenciaController extends HttpServlet {

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
            out.println("<title>Servlet AsistenciaController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AsistenciaController at " + request.getContextPath() + "</h1>");
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

        if (accion == null || accion.equals("listarAsistencia")) {

            AsistenciaBL bl = new AsistenciaBL();
            ArrayList<AsistenciaBE> listaUsuarios = bl.ReadAll();
            request.setAttribute("listaAsistencia", listaUsuarios);
            request.getRequestDispatcher("/usuarios/frmListarAsistencia.jsp").forward(request, response);

        } else if (accion == null || accion.equals("registrarAsistencia")) {

            HttpSession session = request.getSession();
            Integer idTecnico = (Integer) session.getAttribute("idTecnico");

            if (idTecnico != null) {
                AsistenciaDAO asistenciaDAO = new AsistenciaDAO();
                AsistenciaBE asistencia = asistenciaDAO.obtenerAsistenciaDelDia(idTecnico);

                // Verificar si ya marcó entrada y salida
                boolean tieneEntrada = asistencia != null && asistencia.getHoraEntrada() != null;
                boolean tieneSalida = asistencia != null && asistencia.getHoraSalida() != null;

                // Enviar al JSP
                request.setAttribute("asistencia", asistencia);
                request.setAttribute("tieneEntrada", tieneEntrada);
                request.setAttribute("tieneSalida", tieneSalida);

                // Fecha de hoy en formato bonito
                LocalDate hoy = LocalDate.now();
                request.setAttribute("fechaHoy", hoy.toString());

                request.getRequestDispatcher("usuarios/frmRegistrarAsistencia.jsp").forward(request, response);
            } else {
                response.sendRedirect("/login.jsp?msg=sin_sesion");
            }

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

        try {
            AsistenciaDAO asistenciaBL = new AsistenciaDAO();
            HttpSession session = request.getSession(false);
            int idTecnico = (int) session.getAttribute("idTecnico");
            // Convertir la fecha en formato seguro

            LocalDate localFecha = LocalDate.now();
            Date fecha = Date.valueOf(localFecha);

            if (accion == null || accion.equals("registrarEntrada")) {

                // Manejo seguro de la hora de entrada
                LocalTime localHoraEntrada = LocalTime.now(); // hora actual
                Time horaEntrada = Time.valueOf(localHoraEntrada);

                String ubicacion = request.getParameter("ubicacion");

                // Crear el BE
                AsistenciaBE asistencia = new AsistenciaBE();
                asistencia.setIdTecnico(idTecnico);
                asistencia.setFecha(fecha);
                asistencia.setHoraEntrada(horaEntrada);
                asistencia.setUbicacion(ubicacion);

                boolean registrado = asistenciaBL.registrarAsistencia(asistencia);

                if (registrado) {
                    response.sendRedirect("AsistenciaController?accion=registrarAsistencia");
                } else {
                    response.sendRedirect("usuarios/frmRegistrarAsistencia.jsp?msg=entrada_error");
                }

            } else if (accion.equals("registrarSalida")) {

                LocalTime localHorasalida = LocalTime.now(); // hora actual
                Time horaSalida = Time.valueOf(localHorasalida);

                boolean actualizado = asistenciaBL.registrarSalida(idTecnico, fecha, horaSalida);

                if (actualizado) {
                    response.sendRedirect("AsistenciaController?accion=registrarAsistencia");
                } else {
                    response.sendRedirect("usuarios/frmRegistrarAsistencia.jsp?msg=salida_error");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("usuarios/frmRegistrarAsistencia.jsp?msg=exception");
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
