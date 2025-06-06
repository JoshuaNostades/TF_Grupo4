
package DataAccessObject;

import BusinessEntity.AsistenciaBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AsistenciaDAO extends ConexionMySQL implements IBaseDAO<AsistenciaBE> {

    @Override
    public boolean Create(AsistenciaBE input) {

        String sql = "INSERT INTO asistencias (id_tecnico, fecha, hora_entrada, hora_salida, ubicacion) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, input.getIdTecnico());
            ps.setDate(2, new java.sql.Date(input.getFecha().getTime()));
            ps.setTime(3, input.getHoraEntrada());
            ps.setTime(4, input.getHoraSalida());
            ps.setString(5, input.getUbicacion());

            int filas = ps.executeUpdate();
            return filas > 0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public AsistenciaBE Read(String input) {
    
    
        String sql = "SELECT * FROM asistencias WHERE id_asistencia = ?";
        try { PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, input);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    AsistenciaBE a = new AsistenciaBE();
                    a.setIdAsistencia(rs.getInt("id_asistencia"));
                    a.setIdTecnico(rs.getInt("id_tecnico"));
                    a.setFecha(rs.getDate("fecha"));
                    a.setHoraEntrada(rs.getTime("hora_entrada"));
                    a.setHoraSalida(rs.getTime("hora_salida"));
                    a.setUbicacion(rs.getString("ubicacion"));
                    return a;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public ArrayList<AsistenciaBE> ReadAll() {
     
        ArrayList<AsistenciaBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM asistencias ORDER BY fecha DESC, hora_entrada DESC";
        try { PreparedStatement ps = getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AsistenciaBE a = new AsistenciaBE();
                a.setIdAsistencia(rs.getInt("id_asistencia"));
                a.setIdTecnico(rs.getInt("id_tecnico"));
                a.setFecha(rs.getDate("fecha"));
                a.setHoraEntrada(rs.getTime("hora_entrada"));
                a.setHoraSalida(rs.getTime("hora_salida"));
                a.setUbicacion(rs.getString("ubicacion"));
                lista.add(a);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lista;
    
    }

    @Override
    public boolean Update(AsistenciaBE input) {
    
        String sql = "UPDATE asistencias SET id_tecnico = ?, fecha = ?, hora_entrada = ?, hora_salida = ?, ubicacion = ? WHERE id_asistencia = ?";
        try { PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, input.getIdTecnico());
            ps.setDate(2, new java.sql.Date(input.getFecha().getTime()));
            ps.setTime(3, input.getHoraEntrada());
            ps.setTime(4, input.getHoraSalida());
            ps.setString(5, input.getUbicacion());
            ps.setInt(6, input.getIdAsistencia());

            int filas = ps.executeUpdate();
            return filas > 0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    
    }

    @Override
    public boolean Delete(String input) {
   
    
        String sql = "DELETE FROM asistencias WHERE id_asistencia = ?";
        try { PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, input);
            int filas = ps.executeUpdate();
            return filas > 0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
