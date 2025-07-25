/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BusinessEntity.UsuarioBE;
import DataAccessObject.SesionDAO;
import DataAccessObject.TecnicoDAO;
import DataAccessObject.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.UUID;

/**
 *
 * @author Smile Consulting
 */
@WebServlet(name = "LoginUsuarioServlet", urlPatterns = {"/LoginUsuarioServlet"})
public class LoginUsuarioServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginUsuarioServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginUsuarioServlet at " + request.getContextPath() + "</h1>");
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

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String recordar = request.getParameter("rememberMe");

        if (username == null || username.isEmpty()
                || password == null || password.isEmpty()
                || role == null || role.isEmpty()) {
            response.sendRedirect("index.jsp?error=campos");
            return;
        }

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            UsuarioBE usuario = new UsuarioBE();

            usuario = usuarioDAO.obtenerUsuarioPorCredenciales(username, password, role);

            if (usuario != null) {
                HttpSession session = request.getSession();

                String ip = request.getRemoteAddr();
                String userAgent = request.getHeader("User-Agent");
                String navegador = "Desconocido";

                if (userAgent.contains("Edg")) {
                    navegador = "Microsoft Edge";
                } else if (userAgent.contains("OPR") || userAgent.contains("Opera")) {
                    navegador = "Opera";
                } else if (userAgent.contains("Chrome")) {
                    navegador = "Google Chrome";
                } else if (userAgent.contains("Firefox")) {
                    navegador = "Mozilla Firefox";
                } else if (userAgent.contains("Safari")) {
                    navegador = "Safari";
                }

                String token = UUID.randomUUID().toString(); // o el ID de la sesión

                SesionDAO sesionDAO = new SesionDAO();
                int idSesion = sesionDAO.registrarSesion(usuario.getIdUsuario(), ip, navegador, token);

                if (role.equals("Soporte tecnico") || role.equals("Soporte especializado")) {
                    TecnicoDAO tecnicoDAO = new TecnicoDAO();

                    int idTecnico = tecnicoDAO.obtenerIdTecnicoDesdeUsuario(usuario.getIdUsuario());

                    session.setAttribute("tokenSesion", token);
                    session.setAttribute("idSesion", idSesion);

                    session.setAttribute("nombreUsuario", usuario.getNombre());
                    session.setAttribute("correoUsuario", usuario.getCorreo());
                    session.setAttribute("rolUsuario", usuario.getRol());
                    session.setAttribute("idUsuario", usuario.getIdUsuario());

                    session.setAttribute("idTecnico", idTecnico);

                } else if (role.equals("Administrativo")) {
                    int idSesion2 = sesionDAO.registrarSesion(usuario.getIdUsuario(), ip, navegador, token);

                    session.setAttribute("tokenSesion", token);
                    session.setAttribute("idSesion", idSesion2);

                    session.setAttribute("nombreUsuario", usuario.getNombre());
                    session.setAttribute("correoUsuario", usuario.getCorreo());
                    session.setAttribute("rolUsuario", usuario.getRol());
                    session.setAttribute("idUsuario", usuario.getIdUsuario());
                    session.setAttribute("todoUsuario", usuario);

                                    }

                if ("true".equals(recordar)) {
                    Cookie cookie = new Cookie("usuarioRecordado", usuario.getCorreo());
                    cookie.setMaxAge(60 * 60 * 24 * 7); // 7 días
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }

                switch (usuario.getRol()) {
                    case "Administrativo":
                        response.sendRedirect("RequerimientoController");
                        break;
                    case "Soporte tecnico":
                        response.sendRedirect("SesionController");
                        break;
                    case "Soporte especializado":
                        response.sendRedirect("ListarUsuarioController");
                        break;
                    default:
                        response.sendRedirect("index.jsp?error=rol");
                        break;
                }

            } else {
                response.sendRedirect("index.jsp?error=credenciales");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp?error=conexion");
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
