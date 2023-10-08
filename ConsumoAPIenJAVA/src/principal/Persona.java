package principal;

public class Persona {
    
    // recuerda aqui los datos tiene que ser iguales a como viene el el json ya que no los encuentra y puede retornar el valor de nul
    private String cedula;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String email;

    
    public Persona(String cedula, String nombres, String apellidos, String telefono, String direccion, String email) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombre) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    // creamos las clases
    public void setEmail(String email) {
        this.email = email;
    }

    // ahora creamos el contructor junto con los metodos para obtener
}
