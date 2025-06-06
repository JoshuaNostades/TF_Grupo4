
package BusinessEntity;


public class InventarioEquiposBE {
    
    private int idInventario;
    private String procesador;
    private String ram;
    private String discoDuro;
    private String antivirus;
    private String nombreUsuario;
    private String nombreEquipo;
    private String macAddress;
    private String seguridad;
    private String teclado;
    private String mouse;
    private String adaptadores;
    private String redHdmi;

    public InventarioEquiposBE() {
    }

    public InventarioEquiposBE(int idInventario, String procesador, String ram, String discoDuro, String antivirus, String nombreUsuario, String nombreEquipo, String macAddress, String seguridad, String teclado, String mouse, String adaptadores, String redHdmi) {
        this.idInventario = idInventario;
        this.procesador = procesador;
        this.ram = ram;
        this.discoDuro = discoDuro;
        this.antivirus = antivirus;
        this.nombreUsuario = nombreUsuario;
        this.nombreEquipo = nombreEquipo;
        this.macAddress = macAddress;
        this.seguridad = seguridad;
        this.teclado = teclado;
        this.mouse = mouse;
        this.adaptadores = adaptadores;
        this.redHdmi = redHdmi;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(String discoDuro) {
        this.discoDuro = discoDuro;
    }

    public String getAntivirus() {
        return antivirus;
    }

    public void setAntivirus(String antivirus) {
        this.antivirus = antivirus;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(String seguridad) {
        this.seguridad = seguridad;
    }

    public String getTeclado() {
        return teclado;
    }

    public void setTeclado(String teclado) {
        this.teclado = teclado;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public String getAdaptadores() {
        return adaptadores;
    }

    public void setAdaptadores(String adaptadores) {
        this.adaptadores = adaptadores;
    }

    public String getRedHdmi() {
        return redHdmi;
    }

    public void setRedHdmi(String redHdmi) {
        this.redHdmi = redHdmi;
    }
    
    
}
