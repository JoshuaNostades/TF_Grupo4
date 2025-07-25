/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.UsuarioBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SOPORTE
 */
public class UsuarioDAO extends ConexionMySQL implements IBaseDAO<UsuarioBE> {

    @Override
    public boolean Create(UsuarioBE usuario) {

        try {

            String sql = "INSERT INTO usuarios (nombre, correo, contrasena, rol) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());
            ps.setString(4, usuario.getRol());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        usuario.setIdUsuario(rs.getInt(1));
                    }
                }
            }
            return filas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public UsuarioBE Read(String usuario) {

        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, usuario);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    UsuarioBE u = new UsuarioBE();
                    u.setIdUsuario(rs.getInt("id_usuario"));
                    u.setNombre(rs.getString("nombre"));
                    u.setCorreo(rs.getString("correo"));
                    u.setContrasena(rs.getString("contrasena"));
                    u.setRol(rs.getString("rol"));
                    return u;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }

    @Override
    public ArrayList<UsuarioBE> ReadAll() {

        ArrayList<UsuarioBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios where rol = 'Administrativo'";
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
                lista.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return lista;
    }

    public ArrayList<UsuarioBE> ReadAllSoporte() {

        ArrayList<UsuarioBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios where rol = 'Soporte tecnico'";
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
                lista.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return lista;
    }

    @Override
    public boolean Update(UsuarioBE usuario) {

        String sql = "UPDATE usuarios SET nombre = ?, correo = ?, contrasena = ?, rol = ? WHERE id_usuario = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());
            ps.setString(4, usuario.getRol());
            ps.setInt(5, usuario.getIdUsuario());

            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean Delete(String usuario) {

        boolean r = false;
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, usuario);
            r = pst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return r;
    }

    public boolean validarUsuario(String username, String password, String role) {
        String sql = "SELECT * FROM usuarios WHERE correo=? AND contrasena=? AND rol=?";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);

            ResultSet rs = ps.executeQuery();
            return rs.next(); // Retorna true si encuentra el usuario
        } catch (SQLException e) {
            System.out.println("Error al validar usuario: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public UsuarioBE buscarPorCorreo(String correo) {
        String sql = "SELECT * FROM usuarios WHERE correo = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UsuarioBE u = new UsuarioBE();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setContrasena(rs.getString("contrasena"));
                u.setRol(rs.getString("rol"));
                return u;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void registrarCierreSesion(int idSesion) {
        String sql = "UPDATE sesion SET fecha_fin = NOW() WHERE id_sesion = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, idSesion);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int registrarInicioSesion(int idUsuario, String ip, String navegador, String token) {
        int idGenerado = -1;
        String sql = "INSERT INTO sesion (id_usuario, ip_usuario, navegador, token_sesion) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idUsuario);
            ps.setString(2, ip);
            ps.setString(3, navegador);
            ps.setString(4, token);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1); // ID de la nueva sesión
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idGenerado;
    }

    public UsuarioBE obtenerUsuarioPorCredenciales(String correo, String contrasena, String rol) throws Exception {
        UsuarioBE usuario = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection(); // O el método que uses para conectarte
            String sql = "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ? AND rol = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contrasena);
            ps.setString(3, rol);

            rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new UsuarioBE();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setRol(rs.getString("rol"));
                usuario.setFecha(rs.getDate("fecha_registro"));
            }

        } catch (SQLException e) {
            throw new Exception("Error al obtener usuario: " + e.getMessage(), e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return usuario;
    }

    public List<UsuarioBE> listarTodosMenos(int idActual) {
        List<UsuarioBE> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios WHERE id_usuario != ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idActual);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioBE u = new UsuarioBE();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setRol(rs.getString("rol"));
                lista.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public UsuarioBE obtenerUsuarioPorId(int idUsuario) {
        String sql = "SELECT id_usuario, nombre, correo, contrasena, rol FROM usuarios WHERE id_usuario = ?";
        UsuarioBE usuario = null;

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new UsuarioBE();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setRol(rs.getString("rol")); // Asegúrate de tener este campo en el modelo
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public boolean actualizarAdministrativo(UsuarioBE usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, correo = ?, contrasena = ?, rol = ? WHERE id_usuario = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());
            ps.setString(4, usuario.getRol());
            ps.setInt(5, usuario.getIdUsuario());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
