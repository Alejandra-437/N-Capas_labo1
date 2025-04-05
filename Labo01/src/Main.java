import models.Libro;
import models.Venta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro(1, "El Alquimista", "Paulo Coelho", 10.99f, 150);
        Libro libro2 = new Libro(2, "Cien años de soledad", "Gabriel García Márquez", 12.50f, 500);
        Libro libro3 = new Libro(3, "1984", "George Orwell", 15.00f, 100);
        Libro libro4 = new Libro(4, "El Principito", "Antoine de Saint-Exupéry", 8.99f, 450);

        List<Libro> libros = new ArrayList<>();
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro4);

        do {
            showMenu();

            try(Scanner sc = new Scanner(System.in)) {
                int opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        //calculateBestSeller(venta);
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

    private static void showMenu(){
        System.out.println("1. Mostrar libros mas vendidos");
        System.out.println("2. Agregar nueva venta");
        System.out.println("3. Filtrar libros por cantidad de ventas");
        System.out.println("4. Salir");
    }


    //TODO: calculate best seller book
    public static void calculateBestSeller(Venta venta){

    }
}