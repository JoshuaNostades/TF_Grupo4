package DataAccessObject;

import BusinessEntity.InformeBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InformesDAO extends ConexionMySQL implements IBaseDAO<InformeBE> {

    @Override
    public boolean Create(InformeBE input) {

        String sql = "INSERT INTO informes (id_ticket, id_tecnico, descripcion, fecha_informe) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, input.getIdTicket());
            ps.setInt(2, input.getIdTecnico());
            ps.setString(3, input.getDescripcion());
            ps.setTimestamp(4, input.getFechaInforme());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        input.setIdInforme(rs.getInt(1));
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
    public InformeBE Read(String input) {

        String sql = "SELECT * FROM informes WHERE id_informe = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    InformeBE inf = new InformeBE();
                    inf.setIdInforme(rs.getInt("id_informe"));
                    inf.setIdTicket(rs.getInt("id_ticket"));
                    inf.setIdTecnico(rs.getInt("id_tecnico"));
                    inf.setDescripcion(rs.getString("descripcion"));
                    inf.setFechaInforme(rs.getTimestamp("fecha_informe"));
                    return inf;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }

    @Override
    public ArrayList<InformeBE> ReadAll() {

        ArrayList<InformeBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM informes ORDER BY fecha_informe DESC";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                InformeBE inf = new InformeBE();
                inf.setIdInforme(rs.getInt("id_informe"));
                inf.setIdTicket(rs.getInt("id_ticket"));
                inf.setIdTecnico(rs.getInt("id_tecnico"));
                inf.setDescripcion(rs.getString("descripcion"));
                inf.setFechaInforme(rs.getTimestamp("fecha_informe"));
                lista.add(inf);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return lista;

    }

    @Override
    public boolean Update(InformeBE input) {

        String sql = "UPDATE informes SET id_ticket = ?, id_tecnico = ?, descripcion = ?, fecha_informe = ? WHERE id_informe = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setInt(1, input.getIdTicket());
            ps.setInt(2, input.getIdTecnico());
            ps.setString(3, input.getDescripcion());
            ps.setTimestamp(4, input.getFechaInforme());
            ps.setInt(5, input.getIdInforme());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean Delete(String input) {

        String sql = "DELETE FROM informes WHERE id_informe = ?";
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
