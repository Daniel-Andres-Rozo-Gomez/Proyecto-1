package clases;
import java.util.Scanner;

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

    public void Insertar_dinero(){
        System.out.print("Digite la cantidad que desea ingresar a su cuenta de ahorro: ");
        Scanner cantidad = new Scanner(System.in);
        long nuevo_monto = cantidad.nextLong();
        cantidad.nextLine();
        cantidad.close();
        setDinero_ahorrado(dinero_ahorrado + nuevo_monto);
        System.out.println();
        System.out.println("La cantidad de dinero ahorrado actualmente es de: " + dinero_ahorrado);
        Establecer_nivel_de_ingresos();
    }

    public void Eliminar_dinero(){
        System.out.println("Este es el dinero que hay actualmente en su cuenta de ahorro: " + dinero_ahorrado);
        System.out.print("Digite la cantidad que desea eliminar de su cuenta de ahorro: ");
        Scanner cantidad = new Scanner(System.in);
        long monto_a_eliminar = cantidad.nextLong();
        cantidad.nextLine();
        cantidad.close();
        setDinero_ahorrado(dinero_ahorrado - monto_a_eliminar);
        System.out.println();
        System.out.println("La cantidad de dinero ahorrado actualmente es de: " + dinero_ahorrado);
    }

    public void Registro_cliente(){
        Scanner leer = new Scanner(System.in);
        System.out.print("Digite el nombre del cliente: ");
        setNombre(leer.nextLine());
        System.out.print("Digite la cedula del cliente: ");
        setCedula(leer.nextInt());
        leer.nextLine();
        System.out.println("Ahora estableceremos la cantidad de dinero inicial de su cuenta de ahorros.");
        Insertar_dinero();
        System.out.println("Para terminar con la creación del cliente digite la fecha actual.");
        System.out.print("Digite el día: ");
        String dia = leer.nextLine();
        System.out.print("Digite el mes: ");
        String mes = leer.nextLine();
        System.out.print("Digite el año: ");
        String año = leer.nextLine();
        leer.close();
        setFechaDeCreacion(dia + "/" + mes + "/" + año);
        System.out.print("El cliente ha sido creado y añadido a la lista de clientes correctamente.");
    }

    public void Establecer_nivel_de_ingresos(){
        if (dinero_ahorrado < 420000){
            nivelIngresos = NivelIngresos.Clase_Baja;
        }
        else if (dinero_ahorrado >= 420000 && dinero_ahorrado <= 780000) {
            nivelIngresos = NivelIngresos.Vulnerables;
        }
        else if (dinero_ahorrado > 780000 && dinero_ahorrado <= 4200000){
            nivelIngresos = NivelIngresos.Clase_Media;
        }
        else if (dinero_ahorrado > 4200000){
            nivelIngresos = NivelIngresos.Clase_Alta;
        }
    }
}


