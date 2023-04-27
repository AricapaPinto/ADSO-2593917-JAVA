public class ProbandoLayout{
	public static void main(String[] args){ 

		Persona listaPersona[]=new Persona[10];
		Persona listaVendedores[]=new Persona[10];
		Productos listaProductos[]=new Productos[10];
		// creamos un metod para llenar el areglo desde otra clase 
		listaPersona[0]=new Persona("108812", "Oscar Loaliza","calle 88#12");
		listaPersona[1]=new Persona("109022", "Pablo Muñoz","calle 38#24");
		
		// lista vendedores 
		listaVendedores[0]=new Persona("10903", "Carlitos Betancur");
		listaVendedores[1]=new Persona("98947", "Pepito Monterey");
		listaVendedores[2]=new Persona("108800", "Maria Antonieta ");
		listaVendedores[3]=new Persona("108801", "Esteban Salasar");
		listaVendedores[4]=new Persona("108803", "Felipe Cardona");
		listaVendedores[5]=new Persona("108804", "Willian Lopez");

		listaProductos[0]=new Productos("1", "Arroz", 3500);
		listaProductos[1]=new Productos("2", "Carne",5000 );
		listaProductos[2]=new Productos("3", "Frijoles", 1500);
		listaProductos[3]=new Productos("4", "papa", 4500);
		listaProductos[4]=new Productos("5", "panela", 4000);

		
		Factura ventana=new Factura(listaPersona,listaVendedores,listaProductos);



		
	}
}

