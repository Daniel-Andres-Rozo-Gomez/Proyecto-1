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
    System.out.println("El cliente ha sido creado y añadido a la lista de clientes correctamente.");
}

public static void Continuar(ArrayList<cliente> listaDeclientes, Scanner scanner){
    System.out.println("¿Desea realizar alguna otra función en el programa?");
    System.out.print("Digite 0 para no y 1 para si: ");
    byte seleccion = scanner.nextByte();
    scanner.nextLine();
    System.out.println();
    if (seleccion == 1){
        byte eleccion = Opciones(scanner);
        Estructura_de_elecciones(listaDeclientes, eleccion, scanner);
    }
}

public static void Prestamos(ArrayList<cliente> listaDeclientes, Scanner scanner){
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
                System.out.print("Digite el monto que quiere pedir prestado: ");
                long prestamo = scanner.nextLong();
                scanner.nextLine();
                long doble_saldo_actual = clientefor.getDinero_ahorrado()*2;
                long interes = (long)(prestamo * 0.2);
                long cuota = (long)((clientefor.getDinero_ahorrado()/6)+interes);
                if (prestamo <= clientefor.getDinero_ahorrado()){
                    clientefor.setDinero_ahorrado(clientefor.getDinero_ahorrado()+ prestamo);
                    System.out.println("Su prestamo ha sido realizado correctamente, el valor actual del dinero en su cuenta es de: " + clientefor.getDinero_ahorrado());
                    System.out.println("El valor de su cuota mensual es de: " + cuota);
                }
                else if (prestamo < doble_saldo_actual){
                    clientefor.setDinero_ahorrado(clientefor.getDinero_ahorrado()+ prestamo);
                    System.out.println("Su prestamo ha sido realizado correctamente, el valor actual del dinero en su cuenta es de: " + clientefor.getDinero_ahorrado());
                    System.out.println("El valor de su cuota mensual es de: " + cuota);
                }
                else {
                    System.out.println("La cantidad pedida no cumple con nuestras condiciones, el prestamo ha sido denegado.");
                }
                }
            }
        }
    
    else {
        for (cliente clientefor:listaDeclientes){
            if ((clientefor.getNombre().equals(nombre_a_buscar))){
                System.out.print("Digite el monto que quiere pedir prestado: ");
                long prestamo = scanner.nextLong();
                scanner.nextLine();
                long doble_saldo_actual = clientefor.getDinero_ahorrado()*2;
                long interes = (long)(prestamo * 0.2);
                long cuota = (long)((clientefor.getDinero_ahorrado()/6)+interes);
                if (prestamo <= clientefor.getDinero_ahorrado()){
                    clientefor.setDinero_ahorrado(clientefor.getDinero_ahorrado()+ prestamo);
                    System.out.println("Su prestamo ha sido realizado correctamente, el valor actual del dinero en su cuenta es de: " + clientefor.getDinero_ahorrado());
                    System.out.println("El valor de su cuota mensual es de: " + cuota);
                }
                else if (prestamo < doble_saldo_actual){
                    clientefor.setDinero_ahorrado(clientefor.getDinero_ahorrado()+ prestamo);
                    System.out.println("Su prestamo ha sido realizado correctamente, el valor actual del dinero en su cuenta es de: " + clientefor.getDinero_ahorrado());
                    System.out.println("El valor de su cuota mensual es de: " + cuota);
                }
                else {
                    System.out.println("La cantidad pedida no cumple con nuestras condiciones, el prestamo ha sido denegado.");
                }
            }
        }
    }
}

public static void CDT(ArrayList<cliente> listaDeclientes, Scanner scanner){
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
                System.out.print("Digite cuanto dinero desea invertir: ");
                long inversion = scanner.nextInt();
                scanner.nextLine();
                clientefor.setDinero_ahorrado(clientefor.getDinero_ahorrado()-inversion);
                System.out.print("Digite a cuanto plazo desea realizar la inversión (3 0 6 meses): ");
                byte plazo = scanner.nextByte();
                scanner.nextLine();
                if (plazo == 3){
                    long interes = (long)((inversion * (0.03))*(0.25000027397));
                    System.out.println("Las ganancias de su inversión en el plazo seleccionado seran de: " + interes );
                    clientefor.setDinero_ahorrado(clientefor.getDinero_ahorrado() + (inversion + interes));
                    System.err.println("Su saldo después de la inversión paso a ser de: " + clientefor.getDinero_ahorrado());
                }
                else if (plazo == 6){
                    long interes = (long)((inversion * (0.05))*(0.5));
                    System.out.println("Las ganancias de su inversión en el plazo seleccionado seran de: " + interes );
                    clientefor.setDinero_ahorrado(clientefor.getDinero_ahorrado() + (inversion + interes));
                    System.err.println("Su saldo después de la inversión paso a ser de: " + clientefor.getDinero_ahorrado());
                }
                }
            }
        }
    
    else {
        for (cliente clientefor:listaDeclientes){
            if ((clientefor.getNombre().equals(nombre_a_buscar))){
                System.out.print("Digite cuanto dinero desea invertir: ");
                long inversion = scanner.nextInt();
                scanner.nextLine();
                clientefor.setDinero_ahorrado(clientefor.getDinero_ahorrado()-inversion);
                System.out.print("Digite a cuanto plazo desea realizar la inversión (3 0 6 meses): ");
                byte plazo = scanner.nextByte();
                scanner.nextLine();
                if (plazo == 3){
                    long interes = (long)((inversion * (0.03))*(0.25000027397));
                    System.out.println("Las ganancias de su inversión en el plazo seleccionado seran de: " + interes );
                    clientefor.setDinero_ahorrado(clientefor.getDinero_ahorrado() + (inversion + interes));
                    System.err.println("Su saldo después de la inversión paso a ser de: " + clientefor.getDinero_ahorrado());
                }
                else if (plazo == 6){
                    long interes = (long)((inversion * (0.05))*(0.5));
                    System.out.println("Las ganancias de su inversión en el plazo seleccionado seran de: " + interes );
                    clientefor.setDinero_ahorrado(clientefor.getDinero_ahorrado() + (inversion + interes));
                    System.err.println("Su saldo después de la inversión paso a ser de: " + clientefor.getDinero_ahorrado());
                }
            }
        }
    }

}

    public static byte Opciones(Scanner scanner){
    System.out.println("Opciones: ");
    System.out.println("1. Crear cliente");
    System.out.println("2. Insertar dinero ahorrado");
    System.out.println("3. Eliminar dinero ahorrado");
    System.out.println("4. Buscar cliente por nombre y ver su ahorro");
    System.out.println("5. Listar todos los clientes");
    System.out.println("6. Hacer un prestamo");
    System.out.println("7. Hacer un CDT");
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
        cliente nuevo_cliente = new cliente();
        Registro_cliente(nuevo_cliente, scanner);
        listaDeclientes.add(nuevo_cliente);
        Continuar(listaDeclientes, scanner);
            break;
    
        case 2:
        if (listaDeclientes.size() == 0){
            System.out.println("No hay clientes registrados en el sistema, se le movera a la función de registro de cliente.");
            Registro_cliente(clientepordefecto, scanner);
            listaDeclientes.add(clientepordefecto);
        }
        BuscarYAñadirDinero(listaDeclientes, scanner);
        Continuar(listaDeclientes, scanner);
            break;
        
        case 3:
        if (listaDeclientes.size() == 0){
            System.out.println("No hay clientes registrados en el sistema, se le movera a la función de registro de cliente.");
            Registro_cliente(clientepordefecto, scanner);
            listaDeclientes.add(clientepordefecto);
        }
        BuscarYEliminarDinero(listaDeclientes, scanner);
        Continuar(listaDeclientes, scanner);
        
            break;

        case 4:
        if (listaDeclientes.size() == 0){
            System.out.println("No hay clientes registrados en el sistema, se le movera a la función de registro de cliente.");
            Registro_cliente(clientepordefecto, scanner);
            listaDeclientes.add(clientepordefecto);
        }
        Buscarcliente(listaDeclientes, scanner);
        Continuar(listaDeclientes, scanner);
            break;
        
        case 5:
        for (cliente clientefor:listaDeclientes){
            System.out.println("Nombre: " + clientefor.getNombre());
            System.out.println("Cedula: " + clientefor.getCedula());
            System.out.println("Dinero ahorrado: " + clientefor.getDinero_ahorrado());
            System.out.println("Nivel de ingresos: " + clientefor.getNivelIngresos());
            System.out.println("Fecha de creacion: " + clientefor.getFechaDeCreacion());
            System.out.println();
        }
        Continuar(listaDeclientes, scanner);
            break;
        case 6:
        if (listaDeclientes.size() == 0){
            System.out.println("No hay clientes registrados en el sistema, se le movera a la función de registro de cliente.");
            Registro_cliente(clientepordefecto, scanner);
            listaDeclientes.add(clientepordefecto);
        }
        Prestamos(listaDeclientes, scanner);
        Continuar(listaDeclientes, scanner);
            break;
        case 7:
        if (listaDeclientes.size() == 0){
            System.out.println("No hay clientes registrados en el sistema, se le movera a la función de registro de cliente.");
            Registro_cliente(clientepordefecto, scanner);
            listaDeclientes.add(clientepordefecto);
        }
        CDT(listaDeclientes, scanner);
        Continuar(listaDeclientes, scanner);
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
