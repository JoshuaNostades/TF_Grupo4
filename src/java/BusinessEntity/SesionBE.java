/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessEntity;

import java.sql.Timestamp;

/**
 *
 * @author Smile Consulting
 */
public class SesionBE {
    
private int idSesion;
    private int idUsuario;
    private java.sql.Timestamp fechaInicio;
    private java.sql.Timestamp fechaFin;
    private String ipUsuario;
    private String navegador;
    private String tokenSesion;

    public SesionBE(int idSesion, int idUsuario, Timestamp fechaInicio, Timestamp fechaFin, String ipUsuario, String navegador, String tokenSesion) {
        this.idSesion = idSesion;
        this.idUsuario = idUsuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ipUsuario = ipUsuario;
        this.navegador = navegador;
        this.tokenSesion = tokenSesion;
    }

    public SesionBE() {
    }

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getIpUsuario() {
        return ipUsuario;
    }

    public void setIpUsuario(String ipUsuario) {
        this.ipUsuario = ipUsuario;
    }

    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    public String getTokenSesion() {
        return tokenSesion;
    }

    public void setTokenSesion(String tokenSesion) {
        this.tokenSesion = tokenSesion;
    }
    
    
    
    
    
    
}