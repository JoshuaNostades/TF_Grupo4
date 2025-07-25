/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.TecnicoBE;
import BusinessEntity.TicketsBE;
import BusinessEntity.UsuarioBE;
import DataAccessObject.UsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SOPORTE
 */
public class TecnicoDAO extends ConexionMySQL implements IBaseDAO<TecnicoBE> {

    @Override
    public boolean Create(TecnicoBE input) {

        UsuarioDAO daoUsuario = new UsuarioDAO();
        try {

            getConnection().setAutoCommit(false);  // manejo transaccional

            // Crear usuario (rol = tecnico)
            input.getUsuario().setRol("tecnico");
            boolean creado = daoUsuario.Create(input.getUsuario());
            if (!creado) {
                getConnection().rollback();
                return false;
            }

            String sql = "INSERT INTO tecnicos (id_usuario, especialidad, estado) VALUES (?, ?, ?)";
            try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
                ps.setInt(1, input.getUsuario().getIdUsuario());
                ps.setString(2, input.getEspecialidad());
                ps.setString(3, input.getEstado());
                int filas = ps.executeUpdate();
                if (filas <= 0) {
                    getConnection().rollback();
                    return false;
                }
            }

            getConnection().commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public TecnicoBE Read(String input) {

        String sql = "SELECT u.id_usuario, u.nombre, u.correo, u.contrasena, u.rol, t.id_tecnico, t.especialidad, t.estado "
                + "FROM usuarios u JOIN tecnicos t ON u.id_usuario = t.id_usuario WHERE t.id_tecnico = ?";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, input);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    UsuarioBE u = new UsuarioBE();
                    u.setIdUsuario(rs.getInt("id_usuario"));
                    u.setNombre(rs.getString("nombre"));
                    u.setCorreo(rs.getString("correo"));
                    u.setContrasena(rs.getString("contrasena"));
                    u.setRol(rs.getString("rol"));

                    TecnicoBE t = new TecnicoBE();
                    t.setIdTecnico(rs.getInt("id_tecnico"));
                    t.setUsuario(u);
                    t.setEspecialidad(rs.getString("especialidad"));
                    t.setEstado(rs.getString("estado"));

                    return t;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public ArrayList<TecnicoBE> ReadAll() {

        ArrayList<TecnicoBE> lista = new ArrayList<>();
        String sql = "SELECT u.id_usuario, u.nombre, u.correo, u.contrasena, u.rol, t.id_tecnico, t.especialidad, t.estado "
                + "FROM usuarios u JOIN tecnicos t ON u.id_usuario = t.id_usuario ORDER BY u.nombre ASC";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UsuarioBE u = new UsuarioBE();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setContrasena(rs.getString("contrasena"));
                u.setRol(rs.getString("rol"));

                TecnicoBE t = new TecnicoBE();
                t.setIdTecnico(rs.getInt("id_tecnico"));
                t.setUsuario(u);
                t.setEspecialidad(rs.getString("especialidad"));
                t.setEstado(rs.getString("estado"));

                lista.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return lista;
    }

    @Override
    public boolean Update(TecnicoBE input) {
        UsuarioDAO daoUsuario = new UsuarioDAO();

        try {

            // Actualizar usuario
            boolean usuarioActualizado = daoUsuario.Update(input.getUsuario());
            if (!usuarioActualizado) {
                getConnection().rollback();
                return false;
            }

            // Actualizar tecnico
            String sql = "UPDATE tecnicos SET especialidad = ?, estado = ? WHERE id_tecnico = ?";
            try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
                ps.setString(1, input.getEspecialidad());
                ps.setString(2, input.getEstado());
                ps.setInt(3, input.getIdTecnico());

                int filas = ps.executeUpdate();
                if (filas <= 0) {
                    getConnection().rollback();
                    return false;
                }
            }

            getConnection().commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean Delete(String input) {

        try {

            getConnection().setAutoCommit(false);

            // Primero obtener el id_usuario relacionado con el tecnico
            int idUsuario = -1;
            String sqlIdUsuario = "SELECT id_usuario FROM tecnicos WHERE id_tecnico = ?";
            try (PreparedStatement ps = getConnection().prepareStatement(sqlIdUsuario)) {
                ps.setString(1, input);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        idUsuario = rs.getInt("id_usuario");
                    } else {
                        return false;  // técnico no encontrado
                    }
                }
            }

            // Eliminar tecnico
            String sqlEliminarTecnico = "DELETE FROM tecnicos WHERE id_tecnico = ?";
            try (PreparedStatement ps = getConnection().prepareStatement(sqlEliminarTecnico)) {
                ps.setString(1, input);
                int filas = ps.executeUpdate();
                if (filas <= 0) {
                    getConnection().rollback();
                    return false;
                }
            }

            // Eliminar usuario
            String sqlEliminarUsuario = "DELETE FROM usuarios WHERE id_usuario = ?";
            try (PreparedStatement ps = getConnection().prepareStatement(sqlEliminarUsuario)) {
                ps.setInt(1, idUsuario);
                int filas = ps.executeUpdate();
                if (filas <= 0) {
                    getConnection().rollback();
                    return false;
                }
            }

            getConnection().commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int obtenerIdTecnicoDesdeUsuario(int idUsuario) {
        int idTecnico = -1;
        try {
            String sql = "SELECT id_tecnico FROM tecnicos WHERE id_usuario = ?";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idTecnico = rs.getInt("id_tecnico");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idTecnico;
    }

    public ArrayList<UsuarioBE> listarTecnicos() {
        ArrayList<UsuarioBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios WHERE rol = 'Soporte tecnico'";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                UsuarioBE u = new UsuarioBE();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setRol(rs.getString("rol"));
                lista.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<TecnicoBE> listarTecnicosActivos() throws Exception {
        List<TecnicoBE> lista = new ArrayList<>();

        String sql = "SELECT t.id_tecnico, t.especialidad, t.estado, "
                + "u.id_usuario, u.nombre, u.correo "
                + "FROM tecnicos t "
                + "JOIN usuarios u ON t.id_usuario = u.id_usuario "
                + "WHERE t.estado = 'activo'";

        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TecnicoBE tecnico = new TecnicoBE();
                tecnico.setIdTecnico(rs.getInt("id_tecnico"));
                tecnico.setEspecialidad(rs.getString("especialidad"));
                tecnico.setEstado(rs.getString("estado"));

                UsuarioBE usuario = new UsuarioBE();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));

                tecnico.setUsuario(usuario);
                lista.add(tecnico);
            }
        }
        return lista;
    }
    
    
   
    
   
    

}
