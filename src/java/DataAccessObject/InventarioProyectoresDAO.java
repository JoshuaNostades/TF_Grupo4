/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.InventarioProyectoresBE;
import java.util.ArrayList;
import java.beans.Statement;
import java.sql.*;
import java.util.List;

/**
 *
 * @author HP
 */
public class InventarioProyectoresDAO extends ConexionMySQL implements  IBaseDAO<InventarioProyectoresBE>{

    @Override
    public boolean Create(InventarioProyectoresBE input) {
    
        String sql = "INSERT INTO inventario_proyectores (id_inventario, ip_proyector, direccion_mac, ubicacion) VALUES (?, ?, ?, ?)";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setInt(1, input.getIdInventario());
            ps.setString(2, input.getIpProyector());
            ps.setString(3, input.getDireccionMac());
            ps.setString(4, input.getUbicacion());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    }

    @Override
    public InventarioProyectoresBE Read(String input) {
    
    
        String sql = "SELECT * FROM inventario_proyectores WHERE id_inventario=?";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new InventarioProyectoresBE(
                        rs.getInt("id_inventario"),
                        rs.getString("ip_proyector"),
                        rs.getString("direccion_mac"),
                        rs.getString("ubicacion")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<InventarioProyectoresBE> ReadAll() {
     
    
        ArrayList<InventarioProyectoresBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM inventario_proyectores";
        try  {
             PreparedStatement ps = getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                InventarioProyectoresBE proyector = new InventarioProyectoresBE(
                    rs.getInt("id_inventario"),
                    rs.getString("ip_proyector"),
                    rs.getString("direccion_mac"),
                    rs.getString("ubicacion")
                );
                lista.add(proyector);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean Update(InventarioProyectoresBE input) {
    
    
         String sql = "UPDATE inventario_proyectores SET ip_proyector=?, direccion_mac=?, ubicacion=? WHERE id_inventario=?";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input.getIpProyector());
            ps.setString(2, input.getDireccionMac());
            ps.setString(3, input.getUbicacion());
            ps.setInt(4, input.getIdInventario());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean Delete(String input) {
    
         String sql = "DELETE FROM inventario_proyectores WHERE id_inventario=?";
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
