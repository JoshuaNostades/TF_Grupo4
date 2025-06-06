
package BusinessEntity;


public class InventarioBiometricoBE {
    
    private int idInventario;
    private String ipBiometrico;
    private String direccionMac;
    private String nombreDispositivo;

    public InventarioBiometricoBE(int idInventario, String ipBiometrico, String direccionMac, String nombreDispositivo) {
        this.idInventario = idInventario;
        this.ipBiometrico = ipBiometrico;
        this.direccionMac = direccionMac;
        this.nombreDispositivo = nombreDispositivo;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getIpBiometrico() {
        return ipBiometrico;
    }

    public void setIpBiometrico(String ipBiometrico) {
        this.ipBiometrico = ipBiometrico;
    }

    public String getDireccionMac() {
        return direccionMac;
    }

    public void setDireccionMac(String direccionMac) {
        this.direccionMac = direccionMac;
    }

    public String getNombreDispositivo() {
        return nombreDispositivo;
    }

    public void setNombreDispositivo(String nombreDispositivo) {
        this.nombreDispositivo = nombreDispositivo;
    }
    
    
}
