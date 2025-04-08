import models.Book;
import models.Sale;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(1, "El Alquimista", "Paulo Coelho", 10.99f, 150);
        Book book2 = new Book(2, "Cien años de soledad", "Gabriel García Márquez", 12.50f, 500);
        Book book3 = new Book(3, "1984", "George Orwell", 15.00f, 100);
        Book book4 = new Book(4, "El Principito", "Antoine de Saint-Exupéry", 8.99f, 450);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        List<Sale> sales = new ArrayList<>();
        List<Sale> initialSales = List.of(
                new Sale(book2, 500, "2021-01-01"),
                new Sale(book4, 450, "2021-01-02"),
                new Sale(book1, 150, "2021-01-03"),
                new Sale(book3, 100, "2021-01-04")
        );

        initialSales.forEach(sale -> {
            sale.getBook().updateSales(sale.getQuantitySold());
            sales.add(sale);
        });

        try(Scanner sc = new Scanner(System.in)) {
                int opcion;
                do {
                    showMenu();
                    opcion = sc.nextInt();

                    switch (opcion) {
                        case 1:
                            calculateBestSeller(sales);
                            break;
                        case 2:
                            newSale(sc, books, sales);
                            break;
                        case 3:
                            nSales(sc, books);
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

    private static void nSales(Scanner sc, List<Book> books){
        System.out.println("Ingrese la cantidad de ventas a filtrar:");
        int numberOfSales = sc.nextInt();
        List<Book> bookNumberSales = books.stream()
                .filter(book -> book.getTotalSales() >= numberOfSales)
                .collect(Collectors.toList());
        if (bookNumberSales.isEmpty()) {
            System.out.println("No hay libros con esa cantidad de ventas.");
        } else {
            System.out.println("Libros con " + numberOfSales + " o más ventas:");
            for (Book book : bookNumberSales) {
                System.out.println(book);
            }
        }
    }

    public static void calculateBestSeller(List<Sale> sales){
        if (sales.isEmpty()){
            System.out.println("No hay ventas registradas.");
        }

        Map<Book, Integer> salesPerBook = new HashMap<>();
        for(Sale sale : sales){
            Book book = sale.getBook();
            int salesCount = sale.getQuantitySold();
            salesPerBook.put(book, salesPerBook.getOrDefault(book, 0) + salesCount);
        }
        int maxSales = Collections.max(salesPerBook.values());
        List<Book> bestSellers = salesPerBook.entrySet().stream()
                .filter(entry -> entry.getValue() == maxSales)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Libro(s) más vendido(s):");
        bestSellers.forEach(book ->
                System.out.println(book.getTitle() + " - Ventas: " + maxSales)
        );
    }

    private static void newSale(Scanner sc, List<Book> books, List<Sale> sales) {
        System.out.println("Selecciona el libro a vender por ID: ");
        for (Book book : books) {
            System.out.println(book.getBookId() + " - " + book.getTitle());
        }
        int bookId = sc.nextInt();
        Book selectedBook = books.stream()
                .filter(book -> book.getBookId() == bookId)
                .findFirst()
                .orElse(null);

        if (selectedBook == null) {
            System.out.println("Libro no encontrado. Intenta nuevamente.");
            return;
        }

        System.out.println("Introduce la cantidad a vender: ");
        int quantity = sc.nextInt();

        if (quantity <= 0) {
            System.out.println("Cantidad inválida.");
            return;
        }
        if (selectedBook.reduceStock(quantity)) {
            String date = LocalDate.now().toString();
            Sale newSale = Sale.createSale(selectedBook, quantity, date);

            sales.add(newSale);
            selectedBook.updateSales(quantity);

            System.out.println("¡Venta registrada exitosamente!");
            newSale.showDetail();
        }


    }
}