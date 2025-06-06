
package DataAccessObject;

import BusinessEntity.InventarioAnexosBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class InventarioAnexosDAO extends ConexionMySQL implements IBaseDAO<InventarioAnexosBE>{

    @Override
    public boolean Create(InventarioAnexosBE input) {
    
    
        String sql = "INSERT INTO inventario_anexos (id_inventario, nombre_archivo, tipo_archivo, ruta_archivo, fecha_subida) VALUES (?, ?, ?, ?, ?)";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setInt(1, input.getIdInventario());
            ps.setString(2, input.getNombreArchivo());
            ps.setString(3, input.getTipoArchivo());
            ps.setString(4, input.getRutaArchivo());
            ps.setDate(5, new java.sql.Date(input.getFechaSubida().getTime()));

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public InventarioAnexosBE Read(String input) {
     
    
        String sql = "SELECT * FROM inventario_anexos WHERE id_anexo = ?";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    InventarioAnexosBE anexo = new InventarioAnexosBE();
                    anexo.setIdAnexo(rs.getInt("id_anexo"));
                    anexo.setIdInventario(rs.getInt("id_inventario"));
                    anexo.setNombreArchivo(rs.getString("nombre_archivo"));
                    anexo.setTipoArchivo(rs.getString("tipo_archivo"));
                    anexo.setRutaArchivo(rs.getString("ruta_archivo"));
                    anexo.setFechaSubida(rs.getDate("fecha_subida"));
                    return anexo;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<InventarioAnexosBE> ReadAll() {
    
    
        ArrayList<InventarioAnexosBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM inventario_anexos";
        try {
             PreparedStatement ps = getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                InventarioAnexosBE anexo = new InventarioAnexosBE();
                anexo.setIdAnexo(rs.getInt("id_anexo"));
                anexo.setIdInventario(rs.getInt("id_inventario"));
                anexo.setNombreArchivo(rs.getString("nombre_archivo"));
                anexo.setTipoArchivo(rs.getString("tipo_archivo"));
                anexo.setRutaArchivo(rs.getString("ruta_archivo"));
                anexo.setFechaSubida(rs.getDate("fecha_subida"));
                lista.add(anexo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean Update(InventarioAnexosBE input) {
    
    
        String sql = "UPDATE inventario_anexos SET id_inventario = ?, nombre_archivo = ?, tipo_archivo = ?, ruta_archivo = ?, fecha_subida = ? WHERE id_anexo = ?";
        try  {
             PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setInt(1, input.getIdInventario());
            ps.setString(2, input.getNombreArchivo());
            ps.setString(3, input.getTipoArchivo());
            ps.setString(4, input.getRutaArchivo());
            ps.setDate(5, new java.sql.Date(input.getFechaSubida().getTime()));
            ps.setInt(6, input.getIdAnexo());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean Delete(String input) {
    
        String sql = "DELETE FROM inventario_anexos WHERE id_anexo = ?";
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
