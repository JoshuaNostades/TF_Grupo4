/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BusinessEntity.UsuarioBE;
import BusinessLogic.UsuarioBL;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author SOPORTE
 */
@WebServlet(name = "ListarUsuarioController", urlPatterns = {"/ListarUsuarioController"})
public class ListarUsuarioController extends HttpServlet {

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
            out.println("<title>Servlet ListarUsuarioController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListarUsuarioController at " + request.getContextPath() + "</h1>");
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

        if (accion == null || accion.equals("administrativo")) {

            UsuarioBL usuarioBL = new UsuarioBL();
            ArrayList<UsuarioBE> listaUsuarios = usuarioBL.ReadAll();
            request.setAttribute("listaUsuarios", listaUsuarios);
            request.getRequestDispatcher("/usuarios/frmUsuario.jsp").forward(request, response);

        } else if (accion == null || accion.equals("soporte")) {

            UsuarioBL usuarioBL = new UsuarioBL();
            ArrayList<UsuarioBE> listaUsuarios = usuarioBL.ReadAllSoporte();
            request.setAttribute("listaUsuarios", listaUsuarios);
            request.getRequestDispatcher("/usuarios/frmUsuario.jsp").forward(request, response);

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
