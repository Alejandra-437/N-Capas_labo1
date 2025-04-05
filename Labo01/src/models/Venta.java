package models;

public class Venta {
    private Libro libro;
    private int cantidad;
    private String fecha;

    public Venta(Libro libro, int cantidad, String fecha) {
        this.libro = libro;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public void mostrarDetalles() {
        System.out.println("Detalles de la venta:");
        // TODO: System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Fecha: " + fecha);
    }

    public static Venta crearVenta(Libro libro, int cantidad, String fecha) {
        return new Venta(libro, cantidad, fecha);
    }
}
