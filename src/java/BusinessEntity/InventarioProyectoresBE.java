
package BusinessEntity;


public class InventarioProyectoresBE {
    
    private int idInventario;
    private String ipProyector;
    private String direccionMac;
    private String ubicacion;

    public InventarioProyectoresBE(int idInventario, String ipProyector, String direccionMac, String ubicacion) {
        this.idInventario = idInventario;
        this.ipProyector = ipProyector;
        this.direccionMac = direccionMac;
        this.ubicacion = ubicacion;
    }

    public InventarioProyectoresBE() {
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getIpProyector() {
        return ipProyector;
    }

    public void setIpProyector(String ipProyector) {
        this.ipProyector = ipProyector;
    }

    public String getDireccionMac() {
        return direccionMac;
    }

    public void setDireccionMac(String direccionMac) {
        this.direccionMac = direccionMac;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
}
