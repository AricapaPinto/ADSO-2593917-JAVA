

public class Persona {
    private String cedula;
    private String nombre;
    private String direccion;

    public Persona(String cedula,String nombre,String direccion){
        this.cedula=cedula;
        this.nombre=nombre;
        this.direccion=direccion;
    }
    public Persona(String cedula,String nombre){
        this.cedula=cedula;
        this.nombre=nombre;
    }
    public String getCedula(){
        return this.cedula;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getDireccion(){
        return this.direccion;
    }

}
