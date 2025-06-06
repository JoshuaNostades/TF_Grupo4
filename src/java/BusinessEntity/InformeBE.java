
package BusinessEntity;

import java.security.Timestamp;


public class InformeBE {
    
    private int idInforme;
    private int idTicket;    // referencia al ticket
    private int idTecnico;   // técnico que genera el informe
    private String descripcion;
    private java.sql.Timestamp fechaInforme;

    public InformeBE() {
    }

    public InformeBE(int idInforme, int idTicket, int idTecnico, String descripcion, java.sql.Timestamp fechaInforme) {
        this.idInforme = idInforme;
        this.idTicket = idTicket;
        this.idTecnico = idTecnico;
        this.descripcion = descripcion;
        this.fechaInforme = fechaInforme;
    }

    public int getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(int idInforme) {
        this.idInforme = idInforme;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public java.sql.Timestamp getFechaInforme() {
        return fechaInforme;
    }

    public void setFechaInforme(java.sql.Timestamp fechaInforme) {
        this.fechaInforme = fechaInforme;
    }

    
    
}
