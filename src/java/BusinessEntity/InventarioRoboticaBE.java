
package BusinessEntity;


public class InventarioRoboticaBE {
    
     private int idInventario;
    private String numeroParte;
    private String series;
    private String procesador;
    private String ram;
    private String discoSolido;
    private String tarjetaVideo;
    private String modeloVideo;
    private String ramVideo;
    private String cargador;

    public InventarioRoboticaBE(int idInventario, String numeroParte, String series, String procesador, String ram, String discoSolido, String tarjetaVideo, String modeloVideo, String ramVideo, String cargador) {
        this.idInventario = idInventario;
        this.numeroParte = numeroParte;
        this.series = series;
        this.procesador = procesador;
        this.ram = ram;
        this.discoSolido = discoSolido;
        this.tarjetaVideo = tarjetaVideo;
        this.modeloVideo = modeloVideo;
        this.ramVideo = ramVideo;
        this.cargador = cargador;
    }

    public InventarioRoboticaBE() {
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getNumeroParte() {
        return numeroParte;
    }

    public void setNumeroParte(String numeroParte) {
        this.numeroParte = numeroParte;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
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

    public String getDiscoSolido() {
        return discoSolido;
    }

    public void setDiscoSolido(String discoSolido) {
        this.discoSolido = discoSolido;
    }

    public String getTarjetaVideo() {
        return tarjetaVideo;
    }

    public void setTarjetaVideo(String tarjetaVideo) {
        this.tarjetaVideo = tarjetaVideo;
    }

    public String getModeloVideo() {
        return modeloVideo;
    }

    public void setModeloVideo(String modeloVideo) {
        this.modeloVideo = modeloVideo;
    }

    public String getRamVideo() {
        return ramVideo;
    }

    public void setRamVideo(String ramVideo) {
        this.ramVideo = ramVideo;
    }

    public String getCargador() {
        return cargador;
    }

    public void setCargador(String cargador) {
        this.cargador = cargador;
    }
    
    
}
