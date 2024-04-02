public class cliente <fecha> {
    private String nombre;
    private int cedula;
    private NivelIngresos nivelIngresos;
    private fecha fechaDeCreacion;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCedula() {
        return cedula;
    }
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public NivelIngresos getNivelIngresos() {
        return nivelIngresos;
    }
    public void setNivelIngresos(NivelIngresos nivelIngresos) {
        this.nivelIngresos = nivelIngresos;
    }
    public fecha getFechaDeCreacion() {
        return fechaDeCreacion;
    }
    public void setFechaDeCreacion(fecha fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

}


