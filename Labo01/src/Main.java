import models.Libro;
import models.Venta;

import java.util.*;
import java.util.stream.Collectors;

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

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(libro2, 500, "2021-01-01" ));
        ventas.add(new Venta(libro4, 450, "2021-01-02"));
        ventas.add(new Venta(libro1, 150, "2021-01-03"));
        ventas.add(new Venta(libro3, 100, "2021-01-04"));

        try(Scanner sc = new Scanner(System.in)) {
                int opcion;
                do {
                    showMenu();
                    opcion = sc.nextInt();

                    switch (opcion) {
                        case 1:
                            calculateBestSeller(ventas);
                            break;
                        case 2:
                            //TODO: Agregar nueva venta
                            break;
                        case 3:
                            nSales(sc, libros);
                            break;
                        case 4:
                            System.out.println("Saliendo...");
                            return;
                        default:
                            System.out.println("Opción no válida. Intente nuevamente.");
                    }
                }while(opcion != 4);


            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
    }

    private static void showMenu(){
        System.out.println("1. Mostrar libros mas vendidos");
        System.out.println("2. Agregar nueva venta");
        System.out.println("3. Filtrar libros por cantidad de ventas");
        System.out.println("4. Salir");
    }

    private static void nSales(Scanner sc, List<Libro> libros){
        System.out.println("Ingrese la cantidad de ventas a filtrar:");
        int numberOfSales = sc.nextInt();
        List<Libro> libroNumberSales = libros.stream()
                .filter(libro -> libro.getVentasTotales() >= numberOfSales)
                .collect(Collectors.toList());
        if (libroNumberSales.isEmpty()) {
            System.out.println("No hay libros con esa cantidad de ventas.");
        } else {
            System.out.println("Libros con " + numberOfSales + " o más ventas:");
            for (Libro libro : libroNumberSales) {
                System.out.println(libro);
            }
        }
    }

    //TODO: calculate best seller book
    public static void calculateBestSeller(List<Venta> ventas){
        if (ventas.isEmpty()){
            System.out.println("No hay ventas registradas.");
        }

        Map<Libro, Integer> salesPerBook = new HashMap<>();
        for(Venta venta : ventas){
            Libro libro  = venta.getLibro();
            int cantidad = venta.getCantidadVendida();
            salesPerBook.put(libro, salesPerBook.getOrDefault(libro, 0) + cantidad);
        }
        int maxVentas = Collections.max(salesPerBook.values());
        List<Libro> librosMasVendidos = salesPerBook.entrySet().stream()
                .filter(entry -> entry.getValue() == maxVentas)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Libro(s) más vendido(s):");
        librosMasVendidos.forEach(libro ->
                System.out.println(libro.getTitulo() + " - Ventas: " + maxVentas)
        );
    }
}