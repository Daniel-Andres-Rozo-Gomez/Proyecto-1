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

public void BuscarYAñadirDinero(ArrayList<cliente> listaDeclientes){
    byte contador = 0;
    Scanner leer = new Scanner(System.in);
    System.out.print("Digite el nombre de la persona que busca: ");
    String nombre_a_buscar = leer.nextLine();
    for (cliente clientefor:listaDeclientes){
        if (clientefor.getNombre() == nombre_a_buscar){
            contador = (byte)(contador + 1);
        }
    }
    if (contador > 1){
        System.out.print("Se encontro más de un cliente con el mismo nombre, por favor digite la cedula del cliente que busca: ");
        int cedula_a_buscar = leer.nextInt();
        leer.nextLine();
        leer.close();   
        for (cliente clientefor:listaDeclientes){
            if (clientefor.getCedula() == cedula_a_buscar){
                clientefor.Insertar_dinero();;
            }
        }
    }
    else {
        leer.close();   
        for (cliente clientefor:listaDeclientes){
            if (clientefor.getNombre() == nombre_a_buscar){
                clientefor.Insertar_dinero();;
            }
        }
    }
}    

public void BuscarYEliminarDinero(ArrayList<cliente> listaDeclientes){
    byte contador = 0;
    Scanner leer = new Scanner(System.in);
    System.out.print("Digite el nombre de la persona que busca: ");
    String nombre_a_buscar = leer.nextLine();
    for (cliente clientefor:listaDeclientes){
        if (clientefor.getNombre() == nombre_a_buscar){
            contador = (byte)(contador + 1);
        }
    }
    if (contador > 1){
        System.out.print("Se encontro más de un cliente con el mismo nombre, por favor digite la cedula del cliente que busca: ");
        int cedula_a_buscar = leer.nextInt();
        leer.nextLine();
        leer.close();   
        for (cliente clientefor:listaDeclientes){
            if (clientefor.getCedula() == cedula_a_buscar){
                clientefor.Eliminar_dinero();
            }
        }
    }
    else {
        leer.close();   
        for (cliente clientefor:listaDeclientes){
            if (clientefor.getNombre() == nombre_a_buscar){
                clientefor.Eliminar_dinero();
            }
        }
    }
}

public void Buscarcliente(ArrayList<cliente> listaDeclientes){
    byte contador = 0;
    Scanner leer = new Scanner(System.in);
    System.out.print("Digite el nombre de la persona que busca: ");
    String nombre_a_buscar = leer.nextLine();
    for (cliente clientefor:listaDeclientes){
        if (clientefor.getNombre() == nombre_a_buscar){
            contador = (byte)(contador + 1);
        }
    }
    if (contador > 1){
        System.out.print("Se encontro más de un cliente con el mismo nombre, por favor digite la cedula del cliente que busca: ");
        int cedula_a_buscar = leer.nextInt();
        leer.nextLine();
        leer.close();
        for (cliente clientefor:listaDeclientes){
            if (clientefor.getCedula() == cedula_a_buscar){
                System.out.print("El dinero que tiene ahorrado el cliente " + clientefor.getNombre());
                System.out.println(" es: " + clientefor.getDinero_ahorrado());
            }
        }
    }
    else {
        leer.close();
        for (cliente clientefor:listaDeclientes){
            if (clientefor.getNombre() == nombre_a_buscar){
                System.out.print("El dinero que tiene ahorrado el cliente " + clientefor.getNombre());
                System.out.println(" es: " + clientefor.getDinero_ahorrado());
            }
        }
    }
}

public void Opciones(){
    System.out.println("Opciones: ");
    System.out.println("1. Crear cliente");
    System.out.println("2. Insertar dinero ahorrado");
    System.out.println("3. Eliminar dinero ahorrado");
    System.out.println("4. Buscar cliente por nombre y ver su ahorro");
    System.out.println("5. Listar todos los clientes");
    System.out.println("6. Salir");

    System.out.print("Seleccione la opción que desee: ");
    Scanner seleccion= new Scanner(System.in);
    setEleccion(seleccion.nextByte());
    seleccion.nextLine();
    seleccion.close();
}

public void Estructura_de_elecciones(ArrayList<cliente> listaDeclientes){
    cliente clientepordefecto = new cliente();
    switch (eleccion) {
        case 1:
            break;
    
        case 2:
        if (listaDeclientes.size() == 0){
            clientepordefecto.Registro_cliente();
            listaDeclientes.add(clientepordefecto);
        }
        BuscarYAñadirDinero(listaDeclientes);
            break;
        
        case 3:
        if (listaDeclientes.size() == 0){
            clientepordefecto.Registro_cliente();
            listaDeclientes.add(clientepordefecto);
        BuscarYEliminarDinero(listaDeclientes);
        }
        
            break;

        case 4:
        if (listaDeclientes.size() == 0){
            clientepordefecto.Registro_cliente();
            listaDeclientes.add(clientepordefecto);
        }
        Buscarcliente(listaDeclientes);
            break;
        
        case 5:
            break;
        
        default:
            break;
    }
}
}