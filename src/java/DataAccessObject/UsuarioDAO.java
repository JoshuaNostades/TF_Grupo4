
package DataAccessObject;

import BusinessEntity.UsuarioBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
        String sql = "SELECT * FROM usuarios ORDER BY nombre ASC";
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

}
