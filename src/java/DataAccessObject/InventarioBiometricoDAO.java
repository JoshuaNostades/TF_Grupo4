
package DataAccessObject;

import BusinessEntity.InventarioBiometricoBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class InventarioBiometricoDAO extends ConexionMySQL implements IBaseDAO<InventarioBiometricoBE>{

    @Override
    public boolean Create(InventarioBiometricoBE input) {
    
    
        String sql = "INSERT INTO inventario_biometrico (id_inventario, ip_biometrico, direccion_mac, nombre_dispositivo) VALUES (?, ?, ?, ?)";
        try {

             PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, input.getIdInventario());
            ps.setString(2, input.getIpBiometrico());
            ps.setString(3, input.getDireccionMac());
            ps.setString(4, input.getNombreDispositivo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public InventarioBiometricoBE Read(String input) {
    
        String sql = "SELECT * FROM inventario_biometrico WHERE id_inventario=?";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new InventarioBiometricoBE(
                        rs.getInt("id_inventario"),
                        rs.getString("ip_biometrico"),
                        rs.getString("direccion_mac"),
                        rs.getString("nombre_dispositivo")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    
    }

    @Override
    public ArrayList<InventarioBiometricoBE> ReadAll() {
    
    
        ArrayList<InventarioBiometricoBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM inventario_biometrico";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery(); 

            while (rs.next()) {
                InventarioBiometricoBE biometrico = new InventarioBiometricoBE(
                    rs.getInt("id_inventario"),
                    rs.getString("ip_biometrico"),
                    rs.getString("direccion_mac"),
                    rs.getString("nombre_dispositivo")
                );
                lista.add(biometrico);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    
    }

    @Override
    public boolean Update(InventarioBiometricoBE input) {
    
        String sql = "UPDATE inventario_biometrico SET ip_biometrico=?, direccion_mac=?, nombre_dispositivo=? WHERE id_inventario=?";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input.getIpBiometrico());
            ps.setString(2, input.getDireccionMac());
            ps.setString(3, input.getNombreDispositivo());
            ps.setInt(4, input.getIdInventario());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    }

    @Override
    public boolean Delete(String input) {
    
        String sql = "DELETE FROM inventario_biometrico WHERE id_inventario=?";
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
