
package BusinessEntity;

import java.security.Timestamp;
import java.sql.Date;


public class TicketsBE {
    
    private int idTicket;
    private String titulo;
    private String descripcion;
    private String estado;  
    private String prioridad;
    private int idUsuario;
    private int idTecnico;
    private java.sql.Date fechaCreacion;
    private java.sql.Date fechaCierre;

    public TicketsBE(int idTicket, String titulo, String descripcion, String estado, String prioridad, int idUsuario, int idTecnico, Date fechaCreacion, Date fechaCierre) {
        this.idTicket = idTicket;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.idUsuario = idUsuario;
        this.idTecnico = idTecnico;
        this.fechaCreacion = fechaCreacion;
        this.fechaCierre = fechaCierre;
    }

    public TicketsBE(String titulo, String descripcion, String estado, String prioridad, int idUsuario, int idTecnico, Date fechaCreacion, Date fechaCierre) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.idUsuario = idUsuario;
        this.idTecnico = idTecnico;
        this.fechaCreacion = fechaCreacion;
        this.fechaCierre = fechaCierre;
    }

    public TicketsBE() {
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
    
    
    
    
    

    
}
