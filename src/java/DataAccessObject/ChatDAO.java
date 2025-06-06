
package DataAccessObject;

import BusinessEntity.ChatBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ChatDAO extends ConexionMySQL implements IBaseDAO<ChatBE> {

    @Override
    public boolean Create(ChatBE input) {

        String sql = "INSERT INTO mensajes_chat (id_emisor, id_receptor, mensaje, fecha_envio, estado) VALUES (?, ?, ?, ?, 'activo')";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setInt(1, input.getIdEmisor());
            ps.setInt(2, input.getIdReceptor());
            ps.setString(3, input.getMensaje());
            ps.setTimestamp(4, input.getFechaEnvio());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ChatBE Read(String input) {

        ArrayList<ChatBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM mensajes_chat WHERE "
                + "((id_emisor = ? AND id_receptor = ?) OR (id_emisor = ? AND id_receptor = ?)) "
                + "AND mensaje LIKE ? AND estado = 'activo' ORDER BY fecha_envio ASC";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input);
            ps.setString(2, input);
            ps.setString(3, input);
            ps.setString(4, input);
            ps.setString(5, "%" + input + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ChatBE c = new ChatBE();
                    c.setIdMensaje(rs.getInt("id_mensaje"));
                    c.setIdEmisor(rs.getInt("id_emisor"));
                    c.setIdReceptor(rs.getInt("id_receptor"));
                    c.setMensaje(rs.getString("mensaje"));
                    c.setFechaEnvio(rs.getTimestamp("fecha_envio"));
                    lista.add(c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;

    }

    @Override
    public ArrayList<ChatBE> ReadAll() {

        ArrayList<ChatBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM mensajes_chat ORDER BY fecha_envio ASC";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChatBE c = new ChatBE();
                c.setIdMensaje(rs.getInt("id_mensaje"));
                c.setIdEmisor(rs.getInt("id_emisor"));
                c.setIdReceptor(rs.getInt("id_receptor"));
                c.setMensaje(rs.getString("mensaje"));
                c.setFechaEnvio(rs.getTimestamp("fecha_envio"));
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return lista;

    }

    @Override
    public boolean Update(ChatBE input) {

        String sql = "UPDATE mensajes_chat SET mensaje = ? WHERE id_mensaje = ? AND estado = 'activo'";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, input.getMensaje());
            ps.setInt(2, input.getIdMensaje());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }

    }

    @Override
    public boolean Delete(String input) {

        String sql = "UPDATE mensajes_chat SET estado = 'eliminado' WHERE id_mensaje = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
