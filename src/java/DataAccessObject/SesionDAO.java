/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.SesionBE;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Smile Consulting
 */
public class SesionDAO extends ConexionMySQL {

    public int registrarSesion(int idUsuario, String ip, String navegador, String token) throws SQLException {
        int idGenerado = -1;
        String sql = "INSERT INTO sesion (id_usuario, ip_usuario, navegador, token_sesion) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, idUsuario);
            stmt.setString(2, ip);
            stmt.setString(3, navegador);
            stmt.setString(4, token);

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    idGenerado = rs.getInt(1); // Este es el ID de sesión
                }
            }
        }
        return idGenerado;
    }

    public void cerrarSesion(String token) {
        try (Connection con = getConnection()) {
            String sql = "UPDATE sesion SET fecha_fin = NOW() WHERE token_sesion = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, token);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SesionBE> listarSesiones() {
        List<SesionBE> lista = new ArrayList<>();

        String sql = "SELECT * FROM sesion";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                SesionBE s = new SesionBE();
                s.setIdSesion(rs.getInt("id_sesion"));
                s.setIdUsuario(rs.getInt("id_usuario"));
                s.setFechaInicio(rs.getTimestamp("fecha_inicio"));
                s.setFechaFin(rs.getTimestamp("fecha_fin"));
                s.setIpUsuario(rs.getString("ip_usuario"));
                s.setNavegador(rs.getString("navegador"));
                s.setTokenSesion(rs.getString("token_sesion"));
                lista.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
