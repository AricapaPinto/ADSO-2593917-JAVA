public class Personas {
    // atributos
    int cedula;
    String  nombres;
    String apellidos;
    String genero;
    int edad;
    int peso;
    int altura;

    // metodos...
    // el this.hace llamado al ambito global osea ala variable de afuera
    // y despues del igual son los parametors que estan dentro de public persona

    // Cnstructores no se le dan valores de retorno solo public y el nombre del clase 
    public Personas(){
        this.cedula=0;
        this.nombres="";
        this.apellidos="";
        this.genero="";
        this.edad=0;
        this.peso=0;
        this.altura=0;
    }
    public Personas(int cedula,String nombres,String apellidos, String genero,int edad,int peso,int altura){
        this.cedula=cedula;
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.genero=genero;
        this.edad=edad;
        this.peso=peso;
        this.altura=altura;
    }
    public Personas(int cedula,String nombres,String apellidos){
        this.cedula=cedula;
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.genero="";
        this.edad=0;
        this.peso=0;
        this.altura=0;
    }

    // metodos get 
    public int getpeso(){
        return this.peso;
    }
    public void setpeso(int new_peso){
       this.peso=new_peso;
    }
    public void  comer(int gramos){
        this.peso+=(int)(gramos*0.1);
        // eso es como decir esto 
        // this.peso=this.peso+(int)(gramos*0.1);
    }

    // imprimir 
    public void imprimirCartaPresentacion(){
        System.out.println("------------------------------------------");
        System.out.println("--DATOS PERSONA");
        System.out.println("------------------------------------------");
        System.out.println("|  cedula:"+this.cedula);
        System.out.println("|  nombres:"+this.nombres);
        System.out.println("|  apellidos:"+this.apellidos);
        System.out.println("|  genero:"+this.genero);
        System.out.println("|  edad:"+this.edad);
        System.out.println("|  peso:"+this.peso);
        System.out.println("|  altura:"+this.altura);
        System.out.println("--------------------------------------------");
    }
}
