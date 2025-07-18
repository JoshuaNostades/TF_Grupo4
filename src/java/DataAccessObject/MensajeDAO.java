/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;
import BusinessEntity.MensajeBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Smile Consulting
 */
public class MensajeDAO extends ConexionMySQL{
    
    public void insertarMensaje(int emisor, int receptor, String mensaje) throws SQLException {
    String sql = "INSERT INTO mensajes_chat (emisor, receptor, mensaje) VALUES (?, ?, ?)";
    try (Connection con = getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, emisor);
        ps.setInt(2, receptor);
        ps.setString(3, mensaje);
        ps.executeUpdate();
    }
}
    
    public List<MensajeBE> obtenerMensajesEntre(int id1, int id2) throws SQLException {
        List<MensajeBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM mensajes_chat WHERE "
                + "(emisor = ? AND receptor = ?) OR (emisor = ? AND receptor = ?) ORDER BY fecha_envio";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id1);
            ps.setInt(2, id2);
            ps.setInt(3, id2);
            ps.setInt(4, id1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MensajeBE m = new MensajeBE();
                m.setEmisor(rs.getInt("emisor"));
                m.setReceptor(rs.getInt("receptor"));
                m.setMensaje(rs.getString("mensaje"));
                m.setFechaEnvio(rs.getTimestamp("fecha_envio"));
                lista.add(m);
            }
        }
        return lista;
    }
    
    public List<MensajeBE> listarMensajesPorUsuarios(int emisorId, int receptorId) {
        List<MensajeBE> mensajes = new ArrayList<>();

        String sql = "SELECT * FROM mensajes_chat " +
                     "WHERE (emisor = ? AND receptor = ?) OR (emisor = ? AND receptor = ?) " +
                     "ORDER BY fecha_envio ASC";

        try (Connection con =getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, emisorId);
            ps.setInt(2, receptorId);
            ps.setInt(3, receptorId);
            ps.setInt(4, emisorId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MensajeBE msg = new MensajeBE();
                msg.setIdMensaje(rs.getInt("id_mensaje"));
                msg.setEmisor(rs.getInt("emisor"));
                msg.setReceptor(rs.getInt("receptor"));
                msg.setMensaje(rs.getString("mensaje"));
                msg.setFechaEnvio(rs.getTimestamp("fecha_envio"));
                mensajes.add(msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mensajes;
    }
    
}
