package clases;
import java.util.Scanner;

public class cliente{
    private String nombre;
    private int cedula;
    private int dinero_ahorrado = 0;
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
    public int getDinero_ahorrado() {
        return dinero_ahorrado;
    }
    public void setDinero_ahorrado(int dinero_ahorrado) {
        this.dinero_ahorrado = dinero_ahorrado;
    }

    public void Insertar_dinero(){
        System.err.print("Digite la cantidad que desea ingresar a su cuenta de ahorro: ");
        Scanner cantidad = new Scanner(System.in);
        int nuevo_monto = (int)cantidad.nextInt();
        int nueva_cantidad = dinero_ahorrado + nuevo_monto;
        System.err.println();
        System.err.println("La cantidad de dinero ahorrado actualmente es de: " + nueva_cantidad);
        setDinero_ahorrado(nueva_cantidad);
        cantidad.close();
        Establecer_nivel_de_ingresos();
    }

    public void Eliminar_dinero(){
        System.err.println("Este es el dinero que hay actualmente en su cuenta de ahorro: " + dinero_ahorrado);
        System.err.print("Digite la cantidad que desea eliminar de su cuenta de ahorro: ");
        Scanner cantidad = new Scanner(System.in);
        int monto_a_eliminar = (int)cantidad.nextInt();
        int nueva_cantidad = dinero_ahorrado - monto_a_eliminar;
        System.err.println();
        System.err.println("La cantidad de dinero ahorrado actualmente es de: " + nueva_cantidad);
        setDinero_ahorrado(nueva_cantidad);
        cantidad.close();
    }

    public void Registro_cliente(){
        System.err.print("Digite el nombre del cliente: ");
        Scanner nombre_scanner = new Scanner(System.in);
        String nombre = nombre_scanner.next();
        setNombre(nombre);
        nombre_scanner.close();
        Scanner cedula_scanner = new Scanner(System.in);
        int cedula = (int)cedula_scanner.nextInt();
        setCedula(cedula);
        cedula_scanner.close();
        System.err.println("Ahora estableceremos la cantidad de dinero inicial de su cuenta de ahorros.");
        Insertar_dinero();
        System.err.println("Para terminar con la creación del cliente digite la fecha actual.");
        System.err.print("Digite el día: ");
        Scanner dia_scanner = new Scanner(System.in);
        String dia = dia_scanner.next();
        System.err.print("Digite el mes: ");
        Scanner mes_scanner = new Scanner(System.in);
        String mes = mes_scanner.next();
        System.err.print("Digite el año: ");
        Scanner año_scanner = new Scanner(System.in);
        String año = año_scanner.next();
        setFechaDeCreacion(dia + "/" + mes + "/" + año);
        System.err.println("El cliente ha sido creado y añadido a la lista de clientes correctamente.");
        dia_scanner.close();
        mes_scanner.close();
        año_scanner.close();
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


