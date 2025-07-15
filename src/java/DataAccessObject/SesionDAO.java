/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;
import java.sql.*;
/**
 *
 * @author Smile Consulting
 */
public class SesionDAO extends ConexionMySQL{
    public void registrarSesion(int idUsuario, String ip, String navegador, String token) {
    String sql = "INSERT INTO sesion (id_usuario, fecha_inicio, ip_usuario, navegador, token_sesion) VALUES (?, NOW(), ?, ?, ?)";
    try {
         PreparedStatement pst = getConnection().prepareStatement(sql);
        
        pst.setInt(1, idUsuario);
        pst.setString(2, ip);
        pst.setString(3, navegador);
        pst.setString(4, token);
        pst.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
