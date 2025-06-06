/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.PlantillaBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SOPORTE
 */
public class PlantillaDAO extends ConexionMySQL implements IBaseDAO<PlantillaBE>{

    @Override
    public boolean Create(PlantillaBE input) {
    
    
        String sql = "INSERT INTO plantillas (titulo, contenido, fecha_creacion) VALUES (?, ?, ?)";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, input.getTitulo());
            ps.setString(2, input.getContenido());
            ps.setTimestamp(3, input.getFechaCreacion());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        input.setIdPlantilla(rs.getInt(1));
                    }
                }
            }

            return filas > 0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public PlantillaBE Read(String input) {
    
    
        String sql = "SELECT * FROM plantillas WHERE id_plantilla = ?";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    PlantillaBE p = new PlantillaBE();
                    p.setIdPlantilla(rs.getInt("id_plantilla"));
                    p.setTitulo(rs.getString("titulo"));
                    p.setContenido(rs.getString("contenido"));
                    p.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
                    return p;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            
        }
        return null;
    }

    @Override
    public ArrayList<PlantillaBE> ReadAll() {
    
        ArrayList<PlantillaBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM plantillas ORDER BY fecha_creacion DESC";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PlantillaBE p = new PlantillaBE();
                p.setIdPlantilla(rs.getInt("id_plantilla"));
                p.setTitulo(rs.getString("titulo"));
                p.setContenido(rs.getString("contenido"));
                p.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
                lista.add(p);
            }
        }catch (Exception e) {
            e.printStackTrace();
            
        }
        return lista;
    
    }

    @Override
    public boolean Update(PlantillaBE input) {
    
    
         String sql = "UPDATE plantillas SET titulo = ?, contenido = ?, fecha_creacion = ? WHERE id_plantilla = ?";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input.getTitulo());
            ps.setString(2, input.getContenido());
            ps.setTimestamp(3, input.getFechaCreacion());
            ps.setInt(4, input.getIdPlantilla());

            return ps.executeUpdate() > 0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean Delete(String input) {
    
         String sql = "DELETE FROM plantillas WHERE id_plantilla = ?";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input);
            return ps.executeUpdate() > 0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    
    }
    
}
