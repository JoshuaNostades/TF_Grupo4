
package DataAccessObject;

import BusinessEntity.TicketsBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class TicketsDAO extends ConexionMySQL implements IBaseDAO<TicketsBE> {

    @Override
    public boolean Create(TicketsBE input) {

        String sql = "INSERT INTO tickets (id_usuario, asunto, descripcion, estado, fecha_creacion) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setInt(1, input.getIdUsuario());
            ps.setString(2, input.getAsunto());
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

    @Override
    public TicketsBE Read(String input) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<TicketsBE> ReadAll() {

        ArrayList<TicketsBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM tickets ORDER BY fecha_creacion DESC";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TicketsBE t = new TicketsBE();
                t.setIdTicket(rs.getInt("id_ticket"));
                t.setIdUsuario(rs.getInt("id_usuario"));
                t.setAsunto(rs.getString("asunto"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setEstado(rs.getString("estado"));
                t.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
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

            ps.setString(1, input.getAsunto());
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
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    
    }

}
