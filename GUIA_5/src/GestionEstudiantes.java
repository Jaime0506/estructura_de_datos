package Gestion;

import java.util.HashMap;
import java.util.Scanner;

public class GestionEstudiantes {

    public static void main(String[] args) {

        HashMap<Integer, Estudiantes> mapaEstudiantes = new HashMap<>();
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de estudiantes a registrar: ");
        int cantidadEstudiantes = entrada.nextInt();

        for (int i = 1; i <= cantidadEstudiantes; i++) {
            System.out.println();
            System.out.println("Ingresando datos para el estudiante #" + i);
            System.out.println();
            Estudiantes estudiante = crearEstudiante(entrada);
            insertarEstudiante(mapaEstudiantes, i, estudiante);
            mapaEstudiantes.put(i, estudiante);
        }


        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Consultar estudiante");
            System.out.println("2. Modificar estudiante");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Mostrar todos los estudiantes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println();
                    consultarEstudiante(mapaEstudiantes, entrada);
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    modificarEstudiante(mapaEstudiantes, entrada);
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    eliminarEstudiante(mapaEstudiantes, entrada);
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    mostrarTodosLosEstudiantes(mapaEstudiantes);
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private static Estudiantes crearEstudiante(Scanner entrada) {
        Estudiantes estudiante = new Estudiantes();

        System.out.print("Ingrese el nombre del estudiante:");
        estudiante.setNombre(entrada.next());

        System.out.print("Ingrese los apellidos del estudiante:");
        estudiante.setApellidos(entrada.next());

        System.out.print("Ingrese la dirección del estudiante:");
        estudiante.setDireccion(entrada.next());

        System.out.print("Ingrese el teléfono del estudiante:");
        estudiante.setTelefono(entrada.nextInt());

        System.out.print("Ingrese la carrera del estudiante:");
        estudiante.setCarrera(entrada.next());
        System.out.println();

        return estudiante;
    }

  private static void insertarEstudiante(HashMap<Integer, Estudiantes> mapaEstudiantes, int clave, Estudiantes estudiante) {
        mapaEstudiantes.put(clave, estudiante);
        System.out.println("Estudiante insertado con éxito.");
    }

    private static void consultarEstudiante(HashMap<Integer, Estudiantes> mapaEstudiantes, Scanner entrada) {
        System.out.println("Ingrese la clave del estudiante a consultar:");
        int clave = entrada.nextInt();

        if (mapaEstudiantes.containsKey(clave)) {
            System.out.println("Datos del estudiante con clave " + clave + ":");
            mostrarInformacion(mapaEstudiantes, clave);
        } else {
            System.out.println("No se encontró ningún estudiante con esa clave.");
        }
    }

    private static void modificarEstudiante(HashMap<Integer, Estudiantes> mapaEstudiantes, Scanner entrada) {
        System.out.println("Ingrese la clave del estudiante a modificar:");
        int clave = entrada.nextInt();

        if (mapaEstudiantes.containsKey(clave)) {
            Estudiantes estudianteModificado = crearEstudiante(entrada);
            mapaEstudiantes.put(clave, estudianteModificado);
            System.out.println("Estudiante modificado con éxito.");
        } else {
            System.out.println("No se encontró ningún estudiante con esa clave.");
        }
    }

    private static void eliminarEstudiante(HashMap<Integer, Estudiantes> mapaEstudiantes, Scanner entrada) {
        System.out.println("Ingrese la clave del estudiante a eliminar:");
        int clave = entrada.nextInt();

        if (mapaEstudiantes.containsKey(clave)) {
            mapaEstudiantes.remove(clave);
            System.out.println("Estudiante eliminado con éxito.");
        } else {
            System.out.println("No se encontró ningún estudiante con esa clave.");
        }
    }

    private static void mostrarInformacion(HashMap<Integer, Estudiantes> mapaEstudiantes, int clave) {
        Estudiantes estudiante = mapaEstudiantes.get(clave);
        System.out.println("Nombre: " + estudiante.getNombre());
        System.out.println("Apellidos: " + estudiante.getApellidos());
        System.out.println("Dirección: " + estudiante.getDireccion());
        System.out.println("Teléfono: " + estudiante.getTelefono());
        System.out.println("Carrera: " + estudiante.getCarrera());
        System.out.println();
    }
    
     private static void mostrarTodosLosEstudiantes(HashMap<Integer, Estudiantes> mapaEstudiantes) {
        System.out.println("Lista de todos los estudiantes:");
        for (int clave : mapaEstudiantes.keySet()) {
            System.out.println("Clave: " + clave);
            mostrarInformacion(mapaEstudiantes, clave);
            System.out.println("------------------------");
        }
    }
}
