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
public class MensajeBE {
    private int idMensaje;
    private int emisor;
    private int receptor;
    private String mensaje;
    private java.sql.Timestamp fechaEnvio;

    public MensajeBE() {
    }

    public MensajeBE(int emisor, int receptor, String mensaje) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.mensaje = mensaje;
    }
    

    public MensajeBE(int idMensaje, int emisor, int receptor, String mensaje, Timestamp fechaEnvio) {
        this.idMensaje = idMensaje;
        this.emisor = emisor;
        this.receptor = receptor;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public int getEmisor() {
        return emisor;
    }

    public void setEmisor(int emisor) {
        this.emisor = emisor;
    }

    public int getReceptor() {
        return receptor;
    }

    public void setReceptor(int receptor) {
        this.receptor = receptor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Timestamp getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Timestamp fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
    
    
    
}
