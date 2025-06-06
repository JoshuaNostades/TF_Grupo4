
package BusinessEntity;

import java.util.Date;
import java.sql.Time;


public class AsistenciaBE {
    
    private int idAsistencia;
    private int idTecnico;
    private Date fecha;
    private Time horaEntrada;
    private Time horaSalida;
    private String ubicacion;

    public AsistenciaBE(int idAsistencia, int idTecnico, Date fecha, Time horaEntrada, Time horaSalida, String ubicacion) {
        this.idAsistencia = idAsistencia;
        this.idTecnico = idTecnico;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.ubicacion = ubicacion;
    }

    public AsistenciaBE() {
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Time horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
    
    
    
}
