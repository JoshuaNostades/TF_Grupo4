
package BusinessEntity;

import java.util.Date;


public class EventoCalendarioBE {
    
    private int idEvento;
    private int idPlantilla;
    private Date fechaEvento;
    private String descripcion;

    public EventoCalendarioBE() {
    }

    public EventoCalendarioBE(int idEvento, int idPlantilla, Date fechaEvento, String descripcion) {
        this.idEvento = idEvento;
        this.idPlantilla = idPlantilla;
        this.fechaEvento = fechaEvento;
        this.descripcion = descripcion;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdPlantilla() {
        return idPlantilla;
    }

    public void setIdPlantilla(int idPlantilla) {
        this.idPlantilla = idPlantilla;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
