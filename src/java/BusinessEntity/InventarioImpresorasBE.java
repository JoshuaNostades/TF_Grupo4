
package BusinessEntity;


public class InventarioImpresorasBE {
    
    private int idInventario;
    private String ipImpresora;
    private String direccionMac;
    private String hostname;

    public InventarioImpresorasBE() {
    }

    public InventarioImpresorasBE(int idInventario, String ipImpresora, String direccionMac, String hostname) {
        this.idInventario = idInventario;
        this.ipImpresora = ipImpresora;
        this.direccionMac = direccionMac;
        this.hostname = hostname;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getIpImpresora() {
        return ipImpresora;
    }

    public void setIpImpresora(String ipImpresora) {
        this.ipImpresora = ipImpresora;
    }

    public String getDireccionMac() {
        return direccionMac;
    }

    public void setDireccionMac(String direccionMac) {
        this.direccionMac = direccionMac;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
    
    
}
