package ui;

import model.Atraccion;
import model.Parque;

import java.util.Scanner;

/**
 * Clase de interfaz de usuario del sistema MagicWorld.
 * Contiene el metodo main y el menu de opciones.
 * Se comunica con la clase Parque (controladora) para ejecutar las operaciones.
 */
public class Interfaz {

    private static Parque parque = new Parque("MagicWorld");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("  Bienvenido al Sistema de Gestion MagicWorld");
        System.out.println("=============================================");

        int opcion = -1;

        while (opcion != 0) {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    registrarSimuladorVirtual();
                    break;
                case 2:
                    registrarJuegoInfantil();
                    break;
                case 3:
                    registrarEspectaculoPirotecnico();
                    break;
                case 4:
                    registrarVisitantesAtraccion();
                    break;
                case 5:
                    mostrarIngresosDiarios();
                    break;
                case 6:
                    mostrarAtraccionesClasifRiesgo();
                    break;
                case 7:
                    generarReporteOperaciones();
                    break;
                case 8:
                    generarReporteAlertasCapacidad();
                    break;
                case 0:
                    System.out.println("\nHasta luego. Cerrando el sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }

        scanner.close();
    }

    // ---------------------------------------------------------------
    // MENU
    // ---------------------------------------------------------------

    public static void mostrarMenu() {
        System.out.println("\n----- MENU PRINCIPAL -----");
        System.out.println("1. Registrar Simulador Virtual");
        System.out.println("2. Registrar Juego Infantil");
        System.out.println("3. Registrar Espectaculo Pirotecnico");
        System.out.println("4. Registrar visitantes");
        System.out.println("5. Ver ingresos diarios");
        System.out.println("6. Ver atracciones con clasificacion de riesgo");
        System.out.println("7. Generar reporte de operaciones");
        System.out.println("8. Generar reporte alertas de capacidad");
        System.out.println("0. Salir");
        System.out.println("--------------------------");
    }

    // ---------------------------------------------------------------
    // REGISTRO DE ATRACCIONES
    // ---------------------------------------------------------------

    public static void registrarSimuladorVirtual() {
        System.out.println("\n-- Registrar Simulador Virtual --");
        String nombre        = leerTexto("Nombre de la atraccion: ");
        String zona          = leerTexto("Zona de ubicacion: ");
        int capacidad        = leerEntero("Capacidad maxima (personas): ");
        int edadMinima       = leerEntero("Edad minima permitida (anios): ");
        double precio        = leerDecimal("Precio de entrada ($): ");
        int estaciones       = leerEntero("Numero de estaciones: ");
        boolean anteojos     = leerBooleano("Requiere anteojos? (s/n): ");

        parque.agregarAtraccion(nombre, zona, capacidad, edadMinima, precio,
                estaciones, anteojos);
        System.out.println("Simulador registrado exitosamente.");
    }

    public static void registrarJuegoInfantil() {
        System.out.println("\n-- Registrar Juego Infantil --");
        String nombre        = leerTexto("Nombre de la atraccion: ");
        String zona          = leerTexto("Zona de ubicacion: ");
        int capacidad        = leerEntero("Capacidad maxima (personas): ");
        int edadMinima       = leerEntero("Edad minima permitida (anios): ");
        double precio        = leerDecimal("Precio de entrada ($): ");
        int edadMaxima       = leerEntero("Edad maxima permitida (anios): ");
        boolean supervision  = leerBooleano("Tiene supervision permanente? (s/n): ");

        parque.agregarAtraccion(nombre, zona, capacidad, edadMinima, precio,
                edadMaxima, supervision, "infantil");
        System.out.println("Juego infantil registrado exitosamente.");
    }

    public static void registrarEspectaculoPirotecnico() {
        System.out.println("\n-- Registrar Espectaculo Pirotecnico --");
        String nombre        = leerTexto("Nombre de la atraccion: ");
        String zona          = leerTexto("Zona de ubicacion: ");
        int capacidad        = leerEntero("Capacidad maxima (personas): ");
        int edadMinima       = leerEntero("Edad minima permitida (anios): ");
        double precio        = leerDecimal("Precio de entrada ($): ");
        int duracion         = leerEntero("Duracion en minutos: ");
        boolean materialPeligroso = leerBooleano("Usa material peligroso? (s/n): ");

        parque.agregarAtraccion(nombre, zona, capacidad, edadMinima, precio,
                duracion, materialPeligroso, 0);
        System.out.println("Espectaculo pirotecnico registrado exitosamente.");
    }

    public static void registrarVisitantesAtraccion() {
        System.out.println("\n-- Registrar visitantes por dia --");
        String nombreAtraccion = leerTexto("Nombre de la atraccion: ");
        int visitantes = leerEntero("Cantidad de visitantes del dia: ");

        if (visitantes < 0) {
            System.out.println("La cantidad de visitantes no puede ser negativa.");
        } else {
            parque.registrarVisitantes(nombreAtraccion, visitantes);
        }
    }

    public static void mostrarIngresosDiarios() {
        parque.mostrarIngresosDiarios();
    }

    public static void mostrarAtraccionesClasifRiesgo() {
        parque.mostrarAtraccionesClasifRiesgo();
    }

    public static void generarReporteOperaciones() {
        parque.generarReporteOperaciones();
    }

    public static void generarReporteAlertasCapacidad() {
        parque.generarReporteAlertasCapacidad();
    }

    // ---------------------------------------------------------------
    // METODOS DE LECTURA (utilitarios de consola)
    // ---------------------------------------------------------------

    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public static int leerEntero(String mensaje) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                valor = Integer.parseInt(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un numero entero valido.");
            }
        }
        return valor;
    }

    public static double leerDecimal(String mensaje) {
        double valor = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                valor = Double.parseDouble(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un numero valido (use punto para decimales).");
            }
        }
        return valor;
    }

    public static boolean leerBooleano(String mensaje) {
        System.out.print(mensaje);
        String respuesta = scanner.nextLine().trim().toLowerCase();
        return respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("si");
    }
}
