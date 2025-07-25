/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.TicketsBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Types;
import java.util.Date;

/**
 *
 * @author SOPORTE
 */
public class TicketsDAO extends ConexionMySQL implements IBaseDAO<TicketsBE> {

    @Override
    public boolean Create(TicketsBE input) {

        String sql = "INSERT INTO tickets (id_usuario, asunto, descripcion, estado, fecha_creacion) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setInt(1, input.getIdUsuario());

            ps.setString(3, input.getDescripcion());
            ps.setString(4, input.getEstado());
            ps.setTimestamp(5, new java.sql.Timestamp(input.getFechaCreacion().getTime()));

            int filas = ps.executeUpdate();

            if (filas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        input.setIdTicket(rs.getInt(1));
                    }
                }
            }

            return filas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public ArrayList<TicketsBE> listarTicketsPorTecnico(int idTecnico) throws Exception {
        ArrayList<TicketsBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM tickets WHERE id_tecnico = ? && (estado = 'en_proceso' || estado = 'derivado')";

        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, idTecnico);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TicketsBE t = new TicketsBE();
                t.setIdTicket(rs.getInt("id_ticket"));
                t.setTitulo(rs.getString("titulo"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setEstado(rs.getString("estado"));
                t.setPrioridad(rs.getString("prioridad"));
                t.setIdUsuario(rs.getInt("id_usuario"));
                t.setIdTecnico(rs.getInt("id_tecnico"));
                t.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
                t.setFechaCierre(rs.getTimestamp("fecha_cierre"));
                lista.add(t);
            }
        } catch (SQLException e) {
            throw new Exception("Error al listar tickets: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public TicketsBE Read(String input) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<TicketsBE> ReadAll() {
        ArrayList<TicketsBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM tickets";

        try (
                Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                TicketsBE t = new TicketsBE();
                t.setIdTicket(rs.getInt("id_ticket"));
                t.setTitulo(rs.getString("titulo"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setEstado(rs.getString("estado"));
                t.setPrioridad(rs.getString("prioridad"));
                t.setIdUsuario(rs.getInt("id_usuario"));
                t.setIdTecnico(rs.getInt("id_tecnico"));
                t.setFechaCreacion(rs.getDate("fecha_creacion"));
                t.setFechaCierre(rs.getDate("fecha_cierre"));

                lista.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public boolean Update(TicketsBE input) {

        String sql = "UPDATE tickets SET asunto = ?, descripcion = ?, estado = ? WHERE id_ticket = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(2, input.getDescripcion());
            ps.setString(3, input.getEstado());
            ps.setInt(4, input.getIdTicket());

            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean Delete(String input) {

        String sql = "DELETE FROM tickets WHERE id_ticket = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input);
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean actualizarAsignacionTecnico(int idTicket, String estado, String prioridad, int idTecnico) {
        String sql = "UPDATE tickets SET estado = ?, prioridad = ?, id_tecnico = ? WHERE id_ticket = ?";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, estado);
            ps.setString(2, prioridad);
            ps.setInt(3, idTecnico);
            ps.setInt(4, idTicket);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar ticket: " + e.getMessage());
            return false;
        }
    }

    public boolean insertarTicket(TicketsBE ticket) {
        String sql = "INSERT INTO tickets (titulo, descripcion, estado, prioridad, id_usuario, id_tecnico, fecha_creacion) "
                + "VALUES (?, ?, ?, ?, ?, ?,?)";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ticket.getTitulo());
            ps.setString(2, ticket.getDescripcion());
            ps.setString(3, ticket.getEstado());
            ps.setString(4, ticket.getPrioridad());
            ps.setInt(5, ticket.getIdUsuario());
            ps.setInt(6, ticket.getIdTecnico());

            ps.setDate(7, new java.sql.Date(ticket.getFechaCreacion().getTime()));

            if (ticket.getIdTecnico() == 0) {
                ps.setNull(6, Types.INTEGER);
            } else {
                ps.setInt(6, ticket.getIdTecnico());
            }

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<TicketsBE> obtenerTicketsPorEstado(String estado) {
        ArrayList<TicketsBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM tickets WHERE estado = ?";

        try (Connection cn = getConnection(); PreparedStatement pst = cn.prepareStatement(sql)) {

            pst.setString(1, estado);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                TicketsBE t = new TicketsBE();
                t.setIdTicket(rs.getInt("id_ticket"));
                t.setTitulo(rs.getString("titulo"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setEstado(rs.getString("estado"));
                t.setPrioridad(rs.getString("prioridad"));
                t.setIdUsuario(rs.getInt("id_usuario"));
                t.setIdTecnico(rs.getInt("id_tecnico"));
                t.setFechaCreacion(rs.getDate("fecha_creacion"));
                lista.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public ArrayList<TicketsBE> listarPorTecnico(int idTecnico) throws Exception {
        ArrayList<TicketsBE> lista = new ArrayList<>();

        String sql = "SELECT * FROM tickets WHERE id_tecnico = ?";

        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, idTecnico);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TicketsBE t = new TicketsBE();
                t.setIdTicket(rs.getInt("id_ticket"));
                t.setTitulo(rs.getString("titulo"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
                t.setEstado(rs.getString("estado"));
                t.setPrioridad(rs.getString("prioridad"));
                t.setIdTecnico(rs.getInt("id_tecnico"));
                lista.add(t);
            }

        } catch (Exception e) {
            throw new Exception("Error al listar tickets asignados al técnico", e);
        }

        return lista;
    }

    public ArrayList<TicketsBE> listarTicketsPorEstadoYtecnico(int idTecnico, String estado) throws Exception {
        ArrayList<TicketsBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM tickets WHERE id_tecnico = ? AND estado = ?";
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, idTecnico);
            ps.setString(2, estado);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TicketsBE t = new TicketsBE();
                t.setIdTicket(rs.getInt("id_ticket"));
                t.setTitulo(rs.getString("titulo"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setEstado(rs.getString("estado"));
                t.setPrioridad(rs.getString("prioridad"));
                t.setIdUsuario(rs.getInt("id_usuario"));
                t.setIdTecnico(rs.getInt("id_tecnico"));
                t.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
                t.setFechaCierre(rs.getTimestamp("fecha_cierre"));
                lista.add(t);
            }
        }
        return lista;
    }

    public void actualizarEstado(int idTicket, String nuevoEstado) throws Exception {
        String sql = "UPDATE tickets SET estado = ? WHERE id_ticket = ?";
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nuevoEstado);
            ps.setInt(2, idTicket);
            ps.executeUpdate();
        }
    }

   
public void actualizarEstadoYFechaCierre(int idTicket, String nuevoEstado, java.util.Date fechaCierre) throws Exception {
    String sql = "UPDATE tickets SET estado = ?, fecha_cierre = ? WHERE id_ticket = ?";
    try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, nuevoEstado);
        ps.setTimestamp(2, new java.sql.Timestamp(fechaCierre.getTime())); // conversión aquí
        ps.setInt(3, idTicket);
        ps.executeUpdate();
    }
}
}
