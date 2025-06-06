
package BusinessEntity;


public class TecnicoBE {
    
    private int idTecnico;
    private UsuarioBE usuario;  // referencia al usuario base
    private String especialidad;
    private String estado;

    public TecnicoBE() {
    }

    public TecnicoBE(int idTecnico, UsuarioBE usuario, String especialidad, String estado) {
        this.idTecnico = idTecnico;
        this.usuario = usuario;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public UsuarioBE getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBE usuario) {
        this.usuario = usuario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
