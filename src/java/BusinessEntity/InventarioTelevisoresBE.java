
package BusinessEntity;


public class InventarioTelevisoresBE {
    
    private int idInventario;
    private String direccionIp;
    private String direccionMac;

    public InventarioTelevisoresBE(int idInventario, String direccionIp, String direccionMac) {
        this.idInventario = idInventario;
        this.direccionIp = direccionIp;
        this.direccionMac = direccionMac;
    }

    public InventarioTelevisoresBE() {
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getDireccionIp() {
        return direccionIp;
    }

    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }

    public String getDireccionMac() {
        return direccionMac;
    }

    public void setDireccionMac(String direccionMac) {
        this.direccionMac = direccionMac;
    }
    
    
}
