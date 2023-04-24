public class ProbandoLayout{
	public static void main(String[] args) {
		// creamos los areglos para almacenar las personas y los vendedores 
		Persona listaPersona[]=new Persona[10];
		Persona listaVendedores[]=new Persona[10];
		listaPersona[0]=new Persona("1234", "Alberth","mamahuevo");
		listaVendedores[0]=new Persona("12345", "Carlitos");

		Factura ventana=new Factura(listaPersona,listaVendedores);



		
	}
}

