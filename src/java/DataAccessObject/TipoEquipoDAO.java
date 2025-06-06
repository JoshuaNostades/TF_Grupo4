/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.TipoEquipoBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SOPORTE
 */

public class TipoEquipoDAO extends ConexionMySQL implements IBaseDAO<TipoEquipoBE>{

    @Override
    public boolean Create(TipoEquipoBE input) {
    
        String sql = "INSERT INTO tipo_equipo (nombre_tipo) VALUES (?)";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, input.getNombreTipo());
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    }

    @Override
    public TipoEquipoBE Read(String input) {
    
        String sql = "SELECT * FROM tipo_equipo WHERE id_tipo = ?";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql); 
            ps.setString(1, input);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new TipoEquipoBE(rs.getInt("id_tipo"), rs.getString("nombre_tipo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<TipoEquipoBE> ReadAll() {
    
    
       
        ArrayList<TipoEquipoBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM tipo_equipo ORDER BY id_tipo";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TipoEquipoBE te = new TipoEquipoBE(rs.getInt("id_tipo"), rs.getString("nombre_tipo"));
                lista.add(te);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    

    @Override
    public boolean Update(TipoEquipoBE input) {
   
        String sql = "UPDATE tipo_equipo SET nombre_tipo = ? WHERE id_tipo = ?";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql); 
            ps.setString(1, input.getNombreTipo());
            ps.setInt(2, input.getIdTipo());
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean Delete(String input) {
    
        String sql = "DELETE FROM tipo_equipo WHERE id_tipo = ?";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, input);
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
