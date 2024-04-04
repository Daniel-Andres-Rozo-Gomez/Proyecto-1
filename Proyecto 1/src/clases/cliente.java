package clases;
public class cliente{
    private String nombre;
    private int cedula;
    private long dinero_ahorrado = 0;
    private NivelIngresos nivelIngresos;
    private String fechaDeCreacion;

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
    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }
    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }
    public long getDinero_ahorrado() {
        return dinero_ahorrado;
    }
    public void setDinero_ahorrado(long dinero_ahorrado) {
        this.dinero_ahorrado = dinero_ahorrado;
    }
}