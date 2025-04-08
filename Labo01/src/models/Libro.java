package models;

public class Libro {
    int idLibro;
    String titulo;
    String autor;
    float precio;
    private int stockDisponible;
    float ventasTotales;

    //constructor
    public Libro(int idLibro, String titulo, String autor, float precio, int stockDisponible) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.stockDisponible = stockDisponible;
        this.ventasTotales = 0;
    }
    //Getters & Setters
    public int getIdLibro() {
        return idLibro;
    }
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public float getVentasTotales() {
        return ventasTotales;
    }
    public void setVentasTotales(float ventasTotales) {
        this.ventasTotales = ventasTotales;
    }
    public void actualizarVentas(int unidades) {
        this.ventasTotales += unidades; // Incrementa el total de ventas
    }

    public boolean reducirStock(int unidades) {
        if (this.stockDisponible >= unidades) {
            this.stockDisponible -= unidades; // Reduce el stock si es válido
            return true;
        } else {
            System.out.println("Stock insuficiente para " + titulo);
            return false;
        }
    }

    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor +
                ", precio=" + precio +
                ", ventasTotales=" + ventasTotales + '}';
    }
}
