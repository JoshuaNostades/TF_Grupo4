/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.TecnicoBE;
import BusinessEntity.UsuarioBE;
import static DataAccessObject.ConexionMySQL.getConnection;
import DataAccessObject.TecnicoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author SOPORTE
 */
public class TecnicoBL implements IBaseBL<TecnicoBE>{

    @Override
    public boolean Create(TecnicoBE input) {
    
        TecnicoDAO DAO = new TecnicoDAO();
        return DAO.Create(input);
        
    
    }

    @Override
    public TecnicoBE Read(String input) {
     
        TecnicoDAO DAO = new TecnicoDAO();
        return DAO.Read(input);
        
    
    }

    @Override
    public ArrayList<TecnicoBE> ReadAll() {
    
        TecnicoDAO DAO = new TecnicoDAO();
        return DAO.ReadAll();
        
    
    }

    @Override
    public boolean Update(TecnicoBE input) {
     
        
        TecnicoDAO DAO = new TecnicoDAO();
        return DAO.Update(input);
        
    }

    @Override
    public boolean Delete(String input) {
     
    
        TecnicoDAO DAO = new TecnicoDAO();
        return DAO.Delete(input);
        
    }
    
     public ArrayList<TecnicoBE> listarTodos() throws Exception {
    ArrayList<TecnicoBE> lista = new ArrayList<>();

    String sql = "SELECT t.id_tecnico, t.id_usuario, t.especialidad, t.estado, " +
                 "u.nombre, u.correo, u.rol, u.fecha_registro " +
                 "FROM tecnicos t " +
                 "JOIN usuarios u ON t.id_usuario = u.id_usuario";

    try (Connection cn = getConnection();
         PreparedStatement ps = cn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            UsuarioBE usuario = new UsuarioBE();
            usuario.setIdUsuario(rs.getInt("id_usuario"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setCorreo(rs.getString("correo"));
            usuario.setRol(rs.getString("rol"));
            usuario.setFecha(rs.getTimestamp("fecha_registro"));

            TecnicoBE tecnico = new TecnicoBE();
            tecnico.setIdTecnico(rs.getInt("id_tecnico"));
            tecnico.setIdTecnico(rs.getInt("id_usuario"));
            tecnico.setEspecialidad(rs.getString("especialidad"));
            tecnico.setEstado(rs.getString("estado"));
            tecnico.setUsuario(usuario); // relación entre técnico y su usuario

            lista.add(tecnico);
        }
    }

    return lista;
}
    
}
