package models;

public class Book {
    int bookId;
    String title;
    String autor;
    float price;
    private int stockCount;
    int totalSales;

    //constructor
    public Book(int bookId, String title, String autor, float price, int stockCount) {
        this.bookId = bookId;
        this.title = title;
        this.autor = autor;
        this.price = price;
        this.stockCount = stockCount;
        this.totalSales = 0;
    }
    //Getters & Setters
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public float getTotalSales() {
        return totalSales;
    }
    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }
    public void updateSales(int units) {
        this.totalSales += units;
    }

    public boolean reduceStock(int units) {
        if (this.stockCount >= units) {
            this.stockCount -= units; // Reduce el stock si es válido
            return true;
        } else {
            System.out.println("Stock insuficiente para " + title);
            return false;
        }
    }

    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + bookId +
                ", titulo='" + title + '\'' +
                ", autor='" + autor +
                ", precio=" + price +
                ", ventasTotales=" + totalSales + '}';
    }
}
