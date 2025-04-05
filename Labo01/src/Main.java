import models.Libro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro(1, "El Alquimista", "Paulo Coelho", 10.99f, 0);
        Libro libro2 = new Libro(2, "Cien años de soledad", "Gabriel García Márquez", 12.50f, 0);
        Libro libro3 = new Libro(3, "1984", "George Orwell", 15.00f, 0);
        Libro libro4 = new Libro(4, "El Principito", "Antoine de Saint-Exupéry", 8.99f, 0);

        do {
            mostrarMenu();

            try(Scanner sc = new Scanner(System.in)) {
                int opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                       //TODO: Mostrar los libros más vendidos
                        break;
                    case 2:
                        //TODO: Agregar nueva venta
                        break;
                    case 3:
                        //TODO: Filtrar libros por cantidad de ventas
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }while(true);
    }

    private static void mostrarMenu(){
        System.out.println("1. Mostrar libros mas vendidos");
        System.out.println("2. Agregar nueva venta");
        System.out.println("3. Filtrar libros por cantidad de ventas");
        System.out.println("4. Salir");
    }
}