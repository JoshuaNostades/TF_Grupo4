/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.InventarioImpresorasBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class InventarioImpresorasDAO extends ConexionMySQL implements IBaseDAO<InventarioImpresorasBE> {

    @Override
    public boolean Create(InventarioImpresorasBE input) {

        String sql = "INSERT INTO inventario_impresoras (id_inventario, ip_impresora, direccion_mac, hostname) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setInt(1, input.getIdInventario());
            ps.setString(2, input.getIpImpresora());
            ps.setString(3, input.getDireccionMac());
            ps.setString(4, input.getHostname());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public InventarioImpresorasBE Read(String input) {
    
        
        String sql = "SELECT * FROM inventario_impresoras WHERE id_inventario=?";
        try{ PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new InventarioImpresorasBE(
                            rs.getInt("id_inventario"),
                            rs.getString("ip_impresora"),
                            rs.getString("direccion_mac"),
                            rs.getString("hostname")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<InventarioImpresorasBE> ReadAll() {
     
    
         ArrayList<InventarioImpresorasBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM inventario_impresoras";
        try { PreparedStatement ps = getConnection().prepareStatement(sql); ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                InventarioImpresorasBE impresora = new InventarioImpresorasBE(
                        rs.getInt("id_inventario"),
                        rs.getString("ip_impresora"),
                        rs.getString("direccion_mac"),
                        rs.getString("hostname")
                );
                lista.add(impresora);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean Update(InventarioImpresorasBE input) {
    
        String sql = "UPDATE inventario_impresoras SET ip_impresora=?, direccion_mac=?, hostname=? WHERE id_inventario=?";
        try { PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input.getIpImpresora());
            ps.setString(2, input.getDireccionMac());
            ps.setString(3, input.getHostname());
            ps.setInt(4, input.getIdInventario());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    
    }

    @Override
    public boolean Delete(String input) {
    
        String sql = "DELETE FROM inventario_impresoras WHERE id_inventario=?";
        try { PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    }

}
