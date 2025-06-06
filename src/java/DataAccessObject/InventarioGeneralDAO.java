
package DataAccessObject;

import BusinessEntity.InventarioGeneralBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class InventarioGeneralDAO extends ConexionMySQL implements IBaseDAO<InventarioGeneralBE>{

    @Override
    public boolean Create(InventarioGeneralBE input) {
    
        String sql = "INSERT INTO inventario_general (numero, id_tipo, contrato, anio_fabricacion, estado, marca, modelo, serie, piso, ubicacion_area, fecha_inventario, id_tecnico_responsable, jefe_sede, observaciones) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, input.getNumero());
            ps.setInt(2, input.getIdTipo());
            ps.setString(3, input.getContrato());
            ps.setInt(4, input.getAnioFabricacion());
            ps.setString(5, input.getEstado());
            ps.setString(6, input.getMarca());
            ps.setString(7, input.getModelo());
            ps.setString(8, input.getSerie());
            ps.setString(9, input.getPiso());
            ps.setString(10, input.getUbicacionArea());
            ps.setDate(11, input.getFechaInventario());
            ps.setInt(12, input.getIdTecnicoResponsable());
            ps.setString(13, input.getJefeSede());
            ps.setString(14, input.getObservaciones());

            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    }

    @Override
    public InventarioGeneralBE Read(String input) {
    
    
        String sql = "SELECT * FROM inventario_general WHERE id_inventario = ?";
        try  {
             PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, input);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new InventarioGeneralBE(
                    rs.getInt("id_inventario"),
                    rs.getInt("numero"),
                    rs.getInt("id_tipo"),
                    rs.getString("contrato"),
                    rs.getInt("anio_fabricacion"),
                    rs.getString("estado"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getString("serie"),
                    rs.getString("piso"),
                    rs.getString("ubicacion_area"),
                    rs.getDate("fecha_inventario"),
                    rs.getInt("id_tecnico_responsable"),
                    rs.getString("jefe_sede"),
                    rs.getString("observaciones")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<InventarioGeneralBE> ReadAll() {
    
    
        ArrayList<InventarioGeneralBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM inventario_general ORDER BY id_inventario";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery(); 
            while (rs.next()) {
                InventarioGeneralBE inv = new InventarioGeneralBE(
                    rs.getInt("id_inventario"),
                    rs.getInt("numero"),
                    rs.getInt("id_tipo"),
                    rs.getString("contrato"),
                    rs.getInt("anio_fabricacion"),
                    rs.getString("estado"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getString("serie"),
                    rs.getString("piso"),
                    rs.getString("ubicacion_area"),
                    rs.getDate("fecha_inventario"),
                    rs.getInt("id_tecnico_responsable"),
                    rs.getString("jefe_sede"),
                    rs.getString("observaciones")
                );
                lista.add(inv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean Update(InventarioGeneralBE input) {
    
        String sql = "UPDATE inventario_general SET numero = ?, id_tipo = ?, contrato = ?, anio_fabricacion = ?, estado = ?, marca = ?, modelo = ?, serie = ?, piso = ?, ubicacion_area = ?, fecha_inventario = ?, id_tecnico_responsable = ?, jefe_sede = ?, observaciones = ? WHERE id_inventario = ?";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, input.getNumero());
            ps.setInt(2, input.getIdTipo());
            ps.setString(3, input.getContrato());
            ps.setInt(4, input.getAnioFabricacion());
            ps.setString(5, input.getEstado());
            ps.setString(6, input.getMarca());
            ps.setString(7, input.getModelo());
            ps.setString(8, input.getSerie());
            ps.setString(9, input.getPiso());
            ps.setString(10, input.getUbicacionArea());
            ps.setDate(11, input.getFechaInventario());
            ps.setInt(12, input.getIdTecnicoResponsable());
            ps.setString(13, input.getJefeSede());
            ps.setString(14, input.getObservaciones());
            ps.setInt(15, input.getIdInventario());

            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    }

    @Override
    public boolean Delete(String input) {
    
    
          String sql = "DELETE FROM inventario_general WHERE id_inventario = ?";
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
