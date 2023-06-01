package Clases;

public class Productos {

    // atributos 
    private String identificador;
    private String nombre;
    private String precio_productos;
    private String cantidad;
    private String fecha;

    public Productos(String identificador, String nombre, String precio_productos, String fecha,String cantidad ) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.precio_productos = precio_productos;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public String getName() {
        return this.nombre;
    }

    public String getPrecio() {
        return this.precio_productos;
    }

    public String getcantidad() {
        return this.cantidad;
    }

    public String getfecha() {
        return this.fecha;
    }

}
