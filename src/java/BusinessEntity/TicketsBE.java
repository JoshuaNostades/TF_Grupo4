
package BusinessEntity;

import java.security.Timestamp;


public class TicketsBE {
    
    private int idTicket;
    private int idUsuario;   // cliente que genera el ticket
    private String asunto;
    private String descripcion;
    private String estado;   // Ej: "Abierto", "En proceso", "Cerrado"
    private java.sql.Timestamp fechaCreacion;

    public TicketsBE(int idTicket, int idUsuario, String asunto, String descripcion, String estado, java.sql.Timestamp fechaCreacion) {
        this.idTicket = idTicket;
        this.idUsuario = idUsuario;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public TicketsBE() {
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public java.sql.Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(java.sql.Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    
    
}
