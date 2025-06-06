
package BusinessEntity;

import java.sql.Timestamp;


public class PlantillaBE {
    
    private int idPlantilla;
    private String titulo;
    private String contenido;
    private java.sql.Timestamp fechaCreacion;

    public PlantillaBE() {
    }

    public PlantillaBE(int idPlantilla, String titulo, String contenido, Timestamp fechaCreacion) {
        this.idPlantilla = idPlantilla;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdPlantilla() {
        return idPlantilla;
    }

    public void setIdPlantilla(int idPlantilla) {
        this.idPlantilla = idPlantilla;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
}
