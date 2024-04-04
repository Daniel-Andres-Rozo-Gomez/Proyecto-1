import java.util.ArrayList;
import java.util.Scanner;

import clases.NivelIngresos;
import clases.cliente;

public class App {

public static void Insertar_dinero(cliente cliente, Scanner scanner){
    System.out.print("Digite la cantidad que desea ingresar a su cuenta de ahorro: ");
    long nuevo_monto = scanner.nextLong();
    scanner.nextLine();
    cliente.setDinero_ahorrado(cliente.getDinero_ahorrado() + nuevo_monto);
    System.out.println();
    System.out.println("La cantidad de dinero ahorrado actualmente es de: " + cliente.getDinero_ahorrado());
    Establecer_nivel_de_ingresos(cliente);
}


public static void Establecer_nivel_de_ingresos(cliente cliente){
    if (cliente.getDinero_ahorrado() < 420000){
        NivelIngresos nivel = NivelIngresos.Clase_Baja;
        cliente.setNivelIngresos(nivel);
    }
    else if (cliente.getDinero_ahorrado() >= 420000 && cliente.getDinero_ahorrado() <= 780000) {
        NivelIngresos nivel = NivelIngresos.Vulnerables;
        cliente.setNivelIngresos(nivel);
    }
    else if (cliente.getDinero_ahorrado() > 780000 && cliente.getDinero_ahorrado() <= 4200000){
        NivelIngresos nivel = NivelIngresos.Clase_Media;
        cliente.setNivelIngresos(nivel);
    }
    else if (cliente.getDinero_ahorrado() > 4200000){
        NivelIngresos nivel = NivelIngresos.Clase_Alta;
        cliente.setNivelIngresos(nivel);
    }
}

public static void BuscarYAñadirDinero(ArrayList<cliente> listaDeclientes, Scanner scanner){
    byte contador = 0;
    System.out.print("Digite el nombre de la persona que busca: ");
    String nombre_a_buscar = scanner.nextLine();
    for (cliente clientefor:listaDeclientes){
        if ((clientefor.getNombre().equals(nombre_a_buscar))){
            contador = (byte)(contador + 1);
        }
    }
    if (contador > 1){
        System.out.print("Se encontro más de un cliente con el mismo nombre, por favor digite la cedula del cliente que busca: ");
        int cedula_a_buscar = scanner.nextInt();
        scanner.nextLine();
        for (cliente clientefor:listaDeclientes){
            if (clientefor.getCedula() == cedula_a_buscar){
                Insertar_dinero(clientefor, scanner);
            }
        }
    }
    else {
        for (cliente clientefor:listaDeclientes){
            if ((clientefor.getNombre().equals(nombre_a_buscar))){
                Insertar_dinero(clientefor, scanner);
            }
        }
    }
}    

public static void Eliminar_dinero(cliente cliente, Scanner scanner){
    System.out.println("Este es el dinero que hay actualmente en su cuenta de ahorro: " + cliente.getDinero_ahorrado());
    System.out.print("Digite la cantidad que desea eliminar de su cuenta de ahorro: ");
    long monto_a_eliminar = scanner.nextLong();
    scanner.nextLine();
    cliente.setDinero_ahorrado(cliente.getDinero_ahorrado() - monto_a_eliminar);
    System.out.println();
    System.out.println("La cantidad de dinero ahorrado actualmente es de: " + cliente.getDinero_ahorrado());
}

public static void BuscarYEliminarDinero(ArrayList<cliente> listaDeclientes, Scanner scanner){
    byte contador = 0;
    System.out.print("Digite el nombre de la persona que busca: ");
    String nombre_a_buscar = scanner.nextLine();
    for (cliente clientefor:listaDeclientes){
        if ((clientefor.getNombre().equals(nombre_a_buscar))){
            contador = (byte)(contador + 1);
        }
    }
    if (contador > 1){
        System.out.print("Se encontro más de un cliente con el mismo nombre, por favor digite la cedula del cliente que busca: ");
        int cedula_a_buscar = scanner.nextInt();
        scanner.nextLine();
        for (cliente clientefor:listaDeclientes){
            if (clientefor.getCedula() == cedula_a_buscar){
                Eliminar_dinero(clientefor, scanner);
            }
        }
    }
    else {
        for (cliente clientefor:listaDeclientes){
            if ((clientefor.getNombre().equals(nombre_a_buscar))){
                Eliminar_dinero(clientefor, scanner);
            }
        }
    }
}

public static void Buscarcliente(ArrayList<cliente> listaDeclientes, Scanner scanner){
    byte contador = 0;
    System.out.print("Digite el nombre de la persona que busca: ");
    String nombre_a_buscar = scanner.nextLine();
    for (cliente clientefor:listaDeclientes){
        if ((clientefor.getNombre().equals(nombre_a_buscar))){
            contador = (byte)(contador + 1);
        }
    }
    if (contador > 1){
        System.out.print("Se encontro más de un cliente con el mismo nombre, por favor digite la cedula del cliente que busca: ");
        int cedula_a_buscar = scanner.nextInt();
        scanner.nextLine();
        for (cliente clientefor:listaDeclientes){
            if (clientefor.getCedula() == cedula_a_buscar){
                System.out.print("El dinero que tiene ahorrado el cliente " + clientefor.getNombre());
                System.out.println(" es: " + clientefor.getDinero_ahorrado());
            }
        }
    }
    else {
        for (cliente clientefor:listaDeclientes){
            if ((clientefor.getNombre().equals(nombre_a_buscar))){
                System.out.print("El dinero que tiene ahorrado el cliente " + clientefor.getNombre());
                System.out.println(" es: " + clientefor.getDinero_ahorrado());
            }
        }
    }
}

public static void Registro_cliente(cliente cliente, Scanner scanner){
    System.out.print("Digite el nombre del cliente: ");
    cliente.setNombre(scanner.nextLine());
    System.out.print("Digite la cedula del cliente: ");
    cliente.setCedula(scanner.nextInt());
    scanner.nextLine();
    System.out.println("Ahora estableceremos la cantidad de dinero inicial de su cuenta de ahorros.");
    Insertar_dinero(cliente, scanner);
    System.out.println("Para terminar con la creación del cliente digite la fecha actual.");
    System.out.print("Digite el día: ");
    String dia = scanner.nextLine();
    System.out.print("Digite el mes: ");
    String mes = scanner.nextLine();
    System.out.print("Digite el año: ");
    String año = scanner.nextLine();
    cliente.setFechaDeCreacion(dia + "/" + mes + "/" + año);
    System.out.print("El cliente ha sido creado y añadido a la lista de clientes correctamente.");
}

    public static byte Opciones(Scanner scanner){
    System.out.println("Opciones: ");
    System.out.println("1. Crear cliente");
    System.out.println("2. Insertar dinero ahorrado");
    System.out.println("3. Eliminar dinero ahorrado");
    System.out.println("4. Buscar cliente por nombre y ver su ahorro");
    System.out.println("5. Listar todos los clientes");
    System.out.println("6. Salir");

    System.out.print("Seleccione la opción que desee: ");
    byte eleccion = scanner.nextByte();
    scanner.nextLine();
    return eleccion;
}

public static void Estructura_de_elecciones(ArrayList<cliente> listaDeclientes, byte eleccion, Scanner scanner){
    cliente clientepordefecto = new cliente();
    switch (eleccion) {
        case 1:

            break;
    
        case 2:
        if (listaDeclientes.size() == 0){
            Registro_cliente(clientepordefecto, scanner);
            listaDeclientes.add(clientepordefecto);
        }
        BuscarYAñadirDinero(listaDeclientes, scanner);

            break;
        
        case 3:
        if (listaDeclientes.size() == 0){
            Registro_cliente(clientepordefecto, scanner);
            listaDeclientes.add(clientepordefecto);
        }
        BuscarYEliminarDinero(listaDeclientes, scanner);

        
            break;

        case 4:
        if (listaDeclientes.size() == 0){
            Registro_cliente(clientepordefecto, scanner);
            listaDeclientes.add(clientepordefecto);
        }
        Buscarcliente(listaDeclientes, scanner);

            break;
        
        case 5:

            break;
        
        default:
            break;
    }
}

    public static void main(String[] args) throws Exception {
        ArrayList<cliente> listaDeclientes = new ArrayList<cliente>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a Bancolombia");
        byte eleccion = Opciones(scanner);
        Estructura_de_elecciones(listaDeclientes, eleccion, scanner);
        System.out.println("Gracias por usar nuestros servicios, vuelva pronto.");
    }
}
