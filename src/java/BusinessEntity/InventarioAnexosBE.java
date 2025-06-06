
package BusinessEntity;

import java.sql.Date;


public class InventarioAnexosBE {
    
    private int idAnexo;
    private int idInventario;
    private String nombreArchivo;
    private String tipoArchivo;
    private String rutaArchivo;
    private java.sql.Date fechaSubida;

    public InventarioAnexosBE() {
    }

    public InventarioAnexosBE(int idAnexo, int idInventario, String nombreArchivo, String tipoArchivo, String rutaArchivo, Date fechaSubida) {
        this.idAnexo = idAnexo;
        this.idInventario = idInventario;
        this.nombreArchivo = nombreArchivo;
        this.tipoArchivo = tipoArchivo;
        this.rutaArchivo = rutaArchivo;
        this.fechaSubida = fechaSubida;
    }

    public int getIdAnexo() {
        return idAnexo;
    }

    public void setIdAnexo(int idAnexo) {
        this.idAnexo = idAnexo;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public Date getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
    }
    
    
}
