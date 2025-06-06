/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.InventarioTelevisoresBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class InventarioTelevisoresDAO extends ConexionMySQL implements IBaseDAO<InventarioTelevisoresBE>{

    @Override
    public boolean Create(InventarioTelevisoresBE input) {
   
        String sql = "INSERT INTO inventario_televisores (id_inventario, direccion_ip, direccion_mac) VALUES (?, ?, ?)";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setInt(1, input.getIdInventario());
            ps.setString(2, input.getDireccionIp());
            ps.setString(3, input.getDireccionMac());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    }

    @Override
    public InventarioTelevisoresBE Read(String input) {
     String sql = "SELECT * FROM inventario_televisores WHERE id_inventario=?";
        try{
             PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new InventarioTelevisoresBE(
                        rs.getInt("id_inventario"),
                        rs.getString("direccion_ip"),
                        rs.getString("direccion_mac")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;}

    @Override
    public ArrayList<InventarioTelevisoresBE> ReadAll() {
    ArrayList<InventarioTelevisoresBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM inventario_televisores";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                InventarioTelevisoresBE televisor = new InventarioTelevisoresBE(
                    rs.getInt("id_inventario"),
                    rs.getString("direccion_ip"),
                    rs.getString("direccion_mac")
                );
                lista.add(televisor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    } 

    @Override
    public boolean Update(InventarioTelevisoresBE input) {
    String sql = "UPDATE inventario_televisores SET direccion_ip=?, direccion_mac=? WHERE id_inventario=?";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input.getDireccionIp());
            ps.setString(2, input.getDireccionMac());
            ps.setInt(3, input.getIdInventario());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }}

    @Override
    public boolean Delete(String input) {
   String sql = "DELETE FROM inventario_televisores WHERE id_inventario=?";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }}
    
}
