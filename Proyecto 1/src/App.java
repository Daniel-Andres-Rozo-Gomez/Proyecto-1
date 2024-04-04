import java.util.ArrayList;
import clases.cliente; 
import clases.metodos_menu;


public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<cliente> listaDeclientes = new ArrayList<cliente>();
        System.out.println("Bienvenido a Bancolombia");
        metodos_menu menu = new metodos_menu();
        menu.Opciones();
        menu.Estructura_de_elecciones(listaDeclientes);
        System.out.println("Gracias por usar nuestros servicios, vuelva pronto.");
    }
}
