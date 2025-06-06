
package DataAccessObject;

import BusinessEntity.InventarioEquiposBE;
import BusinessLogic.IBaseBL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class InventarioEquiposDAO extends ConexionMySQL implements IBaseDAO<InventarioEquiposBE>{

    @Override
    public boolean Create(InventarioEquiposBE input) {
    
         String sql = "INSERT INTO inventario_equipos (id_inventario, procesador, ram, disco_duro, antivirus, nombre_usuario, nombre_equipo, mac_address, seguridad, teclado, mouse, adaptadores, red_hdmi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, input.getIdInventario());
            ps.setString(2, input.getProcesador());
            ps.setString(3, input.getRam());
            ps.setString(4, input.getDiscoDuro());
            ps.setString(5, input.getAntivirus());
            ps.setString(6, input.getNombreUsuario());
            ps.setString(7, input.getNombreEquipo());
            ps.setString(8, input.getMacAddress());
            ps.setString(9, input.getSeguridad());
            ps.setString(10, input.getTeclado());
            ps.setString(11, input.getMouse());
            ps.setString(12, input.getAdaptadores());
            ps.setString(13, input.getRedHdmi());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public InventarioEquiposBE Read(String input) {
     
    
        String sql = "SELECT * FROM inventario_equipos WHERE id_inventario=?";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, input);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    InventarioEquiposBE equipo = new InventarioEquiposBE();
                    equipo.setIdInventario(rs.getInt("id_inventario"));
                    equipo.setProcesador(rs.getString("procesador"));
                    equipo.setRam(rs.getString("ram"));
                    equipo.setDiscoDuro(rs.getString("disco_duro"));
                    equipo.setAntivirus(rs.getString("antivirus"));
                    equipo.setNombreUsuario(rs.getString("nombre_usuario"));
                    equipo.setNombreEquipo(rs.getString("nombre_equipo"));
                    equipo.setMacAddress(rs.getString("mac_address"));
                    equipo.setSeguridad(rs.getString("seguridad"));
                    equipo.setTeclado(rs.getString("teclado"));
                    equipo.setMouse(rs.getString("mouse"));
                    equipo.setAdaptadores(rs.getString("adaptadores"));
                    equipo.setRedHdmi(rs.getString("red_hdmi"));
                    return equipo;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<InventarioEquiposBE> ReadAll() {
    
    
         ArrayList<InventarioEquiposBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM inventario_equipos";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                InventarioEquiposBE equipo = new InventarioEquiposBE();
                equipo.setIdInventario(rs.getInt("id_inventario"));
                equipo.setProcesador(rs.getString("procesador"));
                equipo.setRam(rs.getString("ram"));
                equipo.setDiscoDuro(rs.getString("disco_duro"));
                equipo.setAntivirus(rs.getString("antivirus"));
                equipo.setNombreUsuario(rs.getString("nombre_usuario"));
                equipo.setNombreEquipo(rs.getString("nombre_equipo"));
                equipo.setMacAddress(rs.getString("mac_address"));
                equipo.setSeguridad(rs.getString("seguridad"));
                equipo.setTeclado(rs.getString("teclado"));
                equipo.setMouse(rs.getString("mouse"));
                equipo.setAdaptadores(rs.getString("adaptadores"));
                equipo.setRedHdmi(rs.getString("red_hdmi"));
                lista.add(equipo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean Update(InventarioEquiposBE input) {
    
    
        String sql = "UPDATE inventario_equipos SET procesador=?, ram=?, disco_duro=?, antivirus=?, nombre_usuario=?, nombre_equipo=?, mac_address=?, seguridad=?, teclado=?, mouse=?, adaptadores=?, red_hdmi=? WHERE id_inventario=?";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, input.getProcesador());
            ps.setString(2, input.getRam());
            ps.setString(3, input.getDiscoDuro());
            ps.setString(4, input.getAntivirus());
            ps.setString(5, input.getNombreUsuario());
            ps.setString(6, input.getNombreEquipo());
            ps.setString(7, input.getMacAddress());
            ps.setString(8, input.getSeguridad());
            ps.setString(9, input.getTeclado());
            ps.setString(10, input.getMouse());
            ps.setString(11, input.getAdaptadores());
            ps.setString(12, input.getRedHdmi());
            ps.setInt(13, input.getIdInventario());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean Delete(String input) {
    
        String sql = "DELETE FROM inventario_equipos WHERE id_inventario=?";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql); 
            ps.setString(1, input);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    }
    
}
