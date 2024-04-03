package clases;
import java.util.ArrayList;
import java.util.Scanner;

public class metodos_menu {
    public byte eleccion;

    public byte getEleccion() {
        return eleccion;
    }

    public void setEleccion(byte eleccion) {
        this.eleccion = eleccion;
    }

public void Opciones(){
    System.err.println("Opciones: ");
    System.out.println("1. Crear cliente");
    System.out.println("2. Insertar dinero ahorrado");
    System.out.println("3. Actualizar dinero ahorrado");
    System.out.println("4. Eliminar dinero ahorrado");
    System.out.println("5. Buscar cliente por nombre y ver su ahorro");
    System.out.println("6. Listar todos los clientes");
    System.err.println("7. Salir");

    System.out.println("Seleccione la opción que desee: ");
    Scanner seleccion= new Scanner(System.in);
    byte eleccion=(byte)seleccion.nextInt();
    seleccion.close();
    setEleccion(eleccion);
}

public void estructura_de_elecciones(ArrayList<cliente> listaDeclientes){
    switch (eleccion) {
        case 1:
            
            break;
    
        case 2:
        byte tamañoListaDeClientes = (byte)listaDeclientes.size();
        if (tamañoListaDeClientes == 0){


        }
            break;
        
        case 3:
            break;
        
        case 4:
            break;

        case 5:
            break;
        
        case 6:
            break;
        
        default:
            break;
    }
}



}