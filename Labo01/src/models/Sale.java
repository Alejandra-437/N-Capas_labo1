package models;



public class Sale {
    private Book book;
    private int quantity;
    private String saleDate;

    public Sale(Book book, int quantity, String saleDate) {
        this.book = book;
        this.quantity = quantity;
        this.saleDate = saleDate;
    }

    public Book getBook() {
        return book;
    }

    public int getQuantitySold() {
        return quantity;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void showDetail() {
        System.out.println("Detalles de la venta:");
        System.out.println("Libro: " + book.getTitle());
        System.out.println("Cantidad: " + quantity);
        System.out.println("Fecha: " + saleDate);
    }

    public static Sale createSale(Book book, int cantidad, String fecha) {
        return new Sale(book, cantidad, fecha);
    }
}
