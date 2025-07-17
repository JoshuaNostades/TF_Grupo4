package DataAccessObject;

import BusinessEntity.AsistenciaBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

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
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public AsistenciaBE Read(String input) {

        String sql = "SELECT * FROM asistencias WHERE id_asistencia = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public ArrayList<AsistenciaBE> ReadAll() {

        ArrayList<AsistenciaBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM asistencias ORDER BY fecha DESC, hora_entrada DESC";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lista;

    }

    @Override
    public boolean Update(AsistenciaBE input) {

        String sql = "UPDATE asistencias SET id_tecnico = ?, fecha = ?, hora_entrada = ?, hora_salida = ?, ubicacion = ? WHERE id_asistencia = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, input.getIdTecnico());
            ps.setDate(2, new java.sql.Date(input.getFecha().getTime()));
            ps.setTime(3, input.getHoraEntrada());
            ps.setTime(4, input.getHoraSalida());
            ps.setString(5, input.getUbicacion());
            ps.setInt(6, input.getIdAsistencia());

            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean Delete(String input) {

        String sql = "DELETE FROM asistencias WHERE id_asistencia = ?";
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

    public boolean registrarAsistencia(AsistenciaBE asistencia) throws Exception {
        String sql = "INSERT INTO asistencias (id_tecnico, fecha, hora_entrada, ubicacion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, asistencia.getIdTecnico());
            ps.setDate(2, asistencia.getFecha());
            ps.setTime(3, asistencia.getHoraEntrada());
            ps.setString(4, asistencia.getUbicacion());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean registrarSalida(int idTecnico, Date fecha, Time horaSalida) throws Exception {
        try (Connection cn = getConnection()) {
            String sql = "UPDATE asistencias SET hora_salida = ? "
                    + "WHERE id_tecnico = ? AND fecha = ? AND hora_salida IS NULL";

            try (PreparedStatement ps = cn.prepareStatement(sql)) {
                ps.setTime(1, horaSalida);      // ej. 17:30:00
                ps.setInt(2, idTecnico);        // id del técnico
                ps.setDate(3, (java.sql.Date) fecha);           // java.sql.Date (yyyy-MM-dd)
                return ps.executeUpdate() > 0;
            }
        }
    }
}
