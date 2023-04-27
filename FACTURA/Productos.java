public class Productos {
    // atributos 
    private String identificador;
    private String nombre;
    private int precio_productos;
    public Productos(String identificador,String nombre, int precio_productos){
        this.identificador=identificador;
        this.nombre=nombre;
        this.precio_productos=precio_productos;

    }
    public String getIdentificador(){
        return this.identificador;
    }
    public String getName(){
        return this.nombre;
    }
    public int getPrecio(){
        return this.precio_productos;
    }
}
