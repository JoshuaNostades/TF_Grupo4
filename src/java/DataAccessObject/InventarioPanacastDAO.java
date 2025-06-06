/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.InventarioPanacastBE;
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
public class InventarioPanacastDAO extends ConexionMySQL implements IBaseDAO<InventarioPanacastBE>{

    @Override
    public boolean Create(InventarioPanacastBE input) {
    
    
         String sql = "INSERT INTO inventario_panacast (id_inventario, marca, modelo, serie, cable_usb, tripode, hub_usb, cable_poder, adaptador_corriente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setInt(1, input.getIdInventario());
            ps.setString(2, input.getMarca());
            ps.setString(3, input.getModelo());
            ps.setString(4, input.getSerie());
            ps.setString(5, input.getCableUsb());
            ps.setString(6, input.getTripode());
            ps.setString(7, input.getHubUsb());
            ps.setString(8, input.getCablePoder());
            ps.setString(9, input.getAdaptadorCorriente());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public InventarioPanacastBE Read(String input) {
    
    
        String sql = "SELECT * FROM inventario_panacast WHERE id_inventario=?";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    InventarioPanacastBE panacast = new InventarioPanacastBE();
                    panacast.setIdInventario(rs.getInt("id_inventario"));
                    panacast.setMarca(rs.getString("marca"));
                    panacast.setModelo(rs.getString("modelo"));
                    panacast.setSerie(rs.getString("serie"));
                    panacast.setCableUsb(rs.getString("cable_usb"));
                    panacast.setTripode(rs.getString("tripode"));
                    panacast.setHubUsb(rs.getString("hub_usb"));
                    panacast.setCablePoder(rs.getString("cable_poder"));
                    panacast.setAdaptadorCorriente(rs.getString("adaptador_corriente"));
                    return panacast;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<InventarioPanacastBE> ReadAll() {
    
         ArrayList<InventarioPanacastBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM inventario_panacast";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                InventarioPanacastBE panacast = new InventarioPanacastBE();
                panacast.setIdInventario(rs.getInt("id_inventario"));
                panacast.setMarca(rs.getString("marca"));
                panacast.setModelo(rs.getString("modelo"));
                panacast.setSerie(rs.getString("serie"));
                panacast.setCableUsb(rs.getString("cable_usb"));
                panacast.setTripode(rs.getString("tripode"));
                panacast.setHubUsb(rs.getString("hub_usb"));
                panacast.setCablePoder(rs.getString("cable_poder"));
                panacast.setAdaptadorCorriente(rs.getString("adaptador_corriente"));
                lista.add(panacast);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    
    }

    @Override
    public boolean Update(InventarioPanacastBE input) {
    
    
        String sql = "UPDATE inventario_panacast SET marca=?, modelo=?, serie=?, cable_usb=?, tripode=?, hub_usb=?, cable_poder=?, adaptador_corriente=? WHERE id_inventario=?";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input.getMarca());
            ps.setString(2, input.getModelo());
            ps.setString(3, input.getSerie());
            ps.setString(4, input.getCableUsb());
            ps.setString(5, input.getTripode());
            ps.setString(6, input.getHubUsb());
            ps.setString(7, input.getCablePoder());
            ps.setString(8, input.getAdaptadorCorriente());
            ps.setInt(9, input.getIdInventario());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean Delete(String input) {
    
        String sql = "DELETE FROM inventario_panacast WHERE id_inventario=?";
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
