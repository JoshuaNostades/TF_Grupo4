/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.InventarioRoboticaBE;
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
public class InventarioRoboticaDAO extends ConexionMySQL implements IBaseDAO<InventarioRoboticaBE> {

    @Override
    public boolean Create(InventarioRoboticaBE input) {

        String sql = "INSERT INTO inventario_robotica (id_inventario, numero_parte, series, procesador, ram, disco_solido, tarjeta_video, modelo_video, ram_video, cargador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, input.getIdInventario());
            ps.setString(2, input.getNumeroParte());
            ps.setString(3, input.getSeries());
            ps.setString(4, input.getProcesador());
            ps.setString(5, input.getRam());
            ps.setString(6, input.getDiscoSolido());
            ps.setString(7, input.getTarjetaVideo());
            ps.setString(8, input.getModeloVideo());
            ps.setString(9, input.getRamVideo());
            ps.setString(10, input.getCargador());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public InventarioRoboticaBE Read(String input) {

        String sql = "SELECT * FROM inventario_robotica WHERE id_inventario=?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, input);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    InventarioRoboticaBE robotica = new InventarioRoboticaBE();
                    robotica.setIdInventario(rs.getInt("id_inventario"));
                    robotica.setNumeroParte(rs.getString("numero_parte"));
                    robotica.setSeries(rs.getString("series"));
                    robotica.setProcesador(rs.getString("procesador"));
                    robotica.setRam(rs.getString("ram"));
                    robotica.setDiscoSolido(rs.getString("disco_solido"));
                    robotica.setTarjetaVideo(rs.getString("tarjeta_video"));
                    robotica.setModeloVideo(rs.getString("modelo_video"));
                    robotica.setRamVideo(rs.getString("ram_video"));
                    robotica.setCargador(rs.getString("cargador"));
                    return robotica;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public ArrayList<InventarioRoboticaBE> ReadAll() {
        ArrayList<InventarioRoboticaBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM inventario_robotica";
        try (PreparedStatement ps = getConnection().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                InventarioRoboticaBE robotica = new InventarioRoboticaBE();
                robotica.setIdInventario(rs.getInt("id_inventario"));
                robotica.setNumeroParte(rs.getString("numero_parte"));
                robotica.setSeries(rs.getString("series"));
                robotica.setProcesador(rs.getString("procesador"));
                robotica.setRam(rs.getString("ram"));
                robotica.setDiscoSolido(rs.getString("disco_solido"));
                robotica.setTarjetaVideo(rs.getString("tarjeta_video"));
                robotica.setModeloVideo(rs.getString("modelo_video"));
                robotica.setRamVideo(rs.getString("ram_video"));
                robotica.setCargador(rs.getString("cargador"));
                lista.add(robotica);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean Update(InventarioRoboticaBE input) {

        String sql = "UPDATE inventario_robotica SET numero_parte=?, series=?, procesador=?, ram=?, disco_solido=?, tarjeta_video=?, modelo_video=?, ram_video=?, cargador=? WHERE id_inventario=?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, input.getNumeroParte());
            ps.setString(2, input.getSeries());
            ps.setString(3, input.getProcesador());
            ps.setString(4, input.getRam());
            ps.setString(5, input.getDiscoSolido());
            ps.setString(6, input.getTarjetaVideo());
            ps.setString(7, input.getModeloVideo());
            ps.setString(8, input.getRamVideo());
            ps.setString(9, input.getCargador());
            ps.setInt(10, input.getIdInventario());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean Delete(String input) {
        String sql = "DELETE FROM inventario_robotica WHERE id_inventario=?";
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
