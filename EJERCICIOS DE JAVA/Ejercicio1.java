import java.util.Scanner;

public class Ejercicio1{
    public static void main(String[]args){

        Scanner entrada=new Scanner(System.in);


        System.out.print("Hola senor usuario");
        System.out.print("Ingrese su edad senor usuario");
        int edad_usuario=entrada.nextInt();
        if(edad_usuario>=1 && edad_usuario <=17){
            System.out.print("senor usuario usted recibe un auxilio de : 800000");
        }else if (edad_usuario>=18 && edad_usuario <=100){
             System.out.print("senor usuario usted recibe un impuesto de:200000");
        }else 
             System.out.print("La edad ingresada es incorrecta");
    }
}
