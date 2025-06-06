
package DataAccessObject;

import BusinessEntity.EventoCalendarioBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EventoCalendarioDAO extends ConexionMySQL implements IBaseDAO<EventoCalendarioBE> {

    @Override
    public boolean Create(EventoCalendarioBE input) {

        String sql = "INSERT INTO eventos_calendario (id_plantilla, fecha_evento, descripcion) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, input.getIdPlantilla());
            ps.setDate(2, new java.sql.Date(input.getFechaEvento().getTime()));
            ps.setString(3, input.getDescripcion());

            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public EventoCalendarioBE Read(String input) {

        String sql = "SELECT * FROM eventos_calendario WHERE id_evento = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, input);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    EventoCalendarioBE evento = new EventoCalendarioBE();
                    evento.setIdEvento(rs.getInt("id_evento"));
                    evento.setIdPlantilla(rs.getInt("id_plantilla"));
                    evento.setFechaEvento(rs.getDate("fecha_evento"));
                    evento.setDescripcion(rs.getString("descripcion"));
                    return evento;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public ArrayList<EventoCalendarioBE> ReadAll() {
    
    
        ArrayList<EventoCalendarioBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM eventos_calendario ORDER BY fecha_evento DESC";
        try  {
             PreparedStatement ps = getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EventoCalendarioBE evento = new EventoCalendarioBE();
                evento.setIdEvento(rs.getInt("id_evento"));
                evento.setIdPlantilla(rs.getInt("id_plantilla"));
                evento.setFechaEvento(rs.getDate("fecha_evento"));
                evento.setDescripcion(rs.getString("descripcion"));
                lista.add(evento);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lista;
    }

    @Override
    public boolean Update(EventoCalendarioBE input) {

        String sql = "UPDATE eventos_calendario SET id_plantilla = ?, fecha_evento = ?, descripcion = ? WHERE id_evento = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, input.getIdPlantilla());
            ps.setDate(2, new java.sql.Date(input.getFechaEvento().getTime()));
            ps.setString(3, input.getDescripcion());
            ps.setInt(4, input.getIdEvento());

            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean Delete(String input) {

        String sql = "DELETE FROM eventos_calendario WHERE id_evento = ?";
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

}
