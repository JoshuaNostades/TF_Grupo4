
package BusinessEntity;


public class InventarioPanacastBE {
    
     private int idInventario;
    private String marca;
    private String modelo;
    private String serie;
    private String cableUsb;
    private String tripode;
    private String hubUsb;
    private String cablePoder;
    private String adaptadorCorriente;

    public InventarioPanacastBE() {
    }

    public InventarioPanacastBE(int idInventario, String marca, String modelo, String serie, String cableUsb, String tripode, String hubUsb, String cablePoder, String adaptadorCorriente) {
        this.idInventario = idInventario;
        this.marca = marca;
        this.modelo = modelo;
        this.serie = serie;
        this.cableUsb = cableUsb;
        this.tripode = tripode;
        this.hubUsb = hubUsb;
        this.cablePoder = cablePoder;
        this.adaptadorCorriente = adaptadorCorriente;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
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

    public String getCableUsb() {
        return cableUsb;
    }

    public void setCableUsb(String cableUsb) {
        this.cableUsb = cableUsb;
    }

    public String getTripode() {
        return tripode;
    }

    public void setTripode(String tripode) {
        this.tripode = tripode;
    }

    public String getHubUsb() {
        return hubUsb;
    }

    public void setHubUsb(String hubUsb) {
        this.hubUsb = hubUsb;
    }

    public String getCablePoder() {
        return cablePoder;
    }

    public void setCablePoder(String cablePoder) {
        this.cablePoder = cablePoder;
    }

    public String getAdaptadorCorriente() {
        return adaptadorCorriente;
    }

    public void setAdaptadorCorriente(String adaptadorCorriente) {
        this.adaptadorCorriente = adaptadorCorriente;
    }
    
    
}
