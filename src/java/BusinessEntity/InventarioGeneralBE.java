
package BusinessEntity;

import java.sql.Date;

public class InventarioGeneralBE {
    
    private int idInventario;
    private int numero;
    private int idTipo;
    private String contrato;
    private int anioFabricacion;
    private String estado;
    private String marca;
    private String modelo;
    private String serie;
    private String piso;
    private String ubicacionArea;
    private java.sql.Date fechaInventario;
    private int idTecnicoResponsable;
    private String jefeSede;
    private String observaciones;

    public InventarioGeneralBE() {
    }

    public InventarioGeneralBE(int idInventario, int numero, int idTipo, String contrato, int anioFabricacion, String estado, String marca, String modelo, String serie, String piso, String ubicacionArea, Date fechaInventario, int idTecnicoResponsable, String jefeSede, String observaciones) {
        this.idInventario = idInventario;
        this.numero = numero;
        this.idTipo = idTipo;
        this.contrato = contrato;
        this.anioFabricacion = anioFabricacion;
        this.estado = estado;
        this.marca = marca;
        this.modelo = modelo;
        this.serie = serie;
        this.piso = piso;
        this.ubicacionArea = ubicacionArea;
        this.fechaInventario = fechaInventario;
        this.idTecnicoResponsable = idTecnicoResponsable;
        this.jefeSede = jefeSede;
        this.observaciones = observaciones;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getUbicacionArea() {
        return ubicacionArea;
    }

    public void setUbicacionArea(String ubicacionArea) {
        this.ubicacionArea = ubicacionArea;
    }

    public Date getFechaInventario() {
        return fechaInventario;
    }

    public void setFechaInventario(Date fechaInventario) {
        this.fechaInventario = fechaInventario;
    }

    public int getIdTecnicoResponsable() {
        return idTecnicoResponsable;
    }

    public void setIdTecnicoResponsable(int idTecnicoResponsable) {
        this.idTecnicoResponsable = idTecnicoResponsable;
    }

    public String getJefeSede() {
        return jefeSede;
    }

    public void setJefeSede(String jefeSede) {
        this.jefeSede = jefeSede;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}
