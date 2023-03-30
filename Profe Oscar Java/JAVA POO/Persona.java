public class Persona{

	// Atributos
	private int documento;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String password;

	// Metodos
	public Persona(int documento, String nombres, String apellidos, String direccion, String telefono){
		this.documento = documento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.password = String.valueOf(documento);
	}

	public int getDocumento(){
		return this.documento;
	}

	public String getNombres(){
		return this.nombres;
	}

	public String getApellidos(){
		return this.apellidos;
	}

	public String getDireccion(){
		return this.direccion;
	}

	public String getTelefono(){
		return this.telefono;
	}

	public void setDocumento(int documento){
		this.documento = documento;
	}

	public void setNombres(String nombres){
		this.nombres = nombres;
	}

	public void setApellidos(String apellidos){
		this.apellidos = apellidos;
	}

	public void setDireccion(String direccion){
		this.direccion = direccion;
	}

	public void setTelefono(String telefono){
		this.telefono = telefono;
	}

	public boolean setPassword(String old_pass, String new_pass){
		if (old_pass.equals(this.password)) {
			this.password = new_pass;
			return true;
		}else{
			System.out.println(" -> Contraseña incorrecta ");
			return false;
		}
	}

	public void mostrarDatosPersonales(){
		System.out.print(" | documento: "+this.documento);
		System.out.print(" | nombres: "+this.nombres);
		System.out.print(" | apellidos: "+this.apellidos);
		System.out.print(" | direccion: "+this.direccion);
		System.out.println(" | telefono: "+this.telefono);
	}

	public void mostrarResumenDatos(){
		System.out.println("     "+this.documento+" - "+this.nombres+" "+this.apellidos);
	}

}