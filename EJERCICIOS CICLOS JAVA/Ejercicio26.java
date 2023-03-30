import java.util.Scanner;
public class Ejercicio26{
    public static void main (String[]args){
        Scanner entrada=new Scanner(System.in);
        // datos a pedir al usuario 
        System.out.print("Ingrese el valor a financiar:");
        int valor=entrada.nextInt();
        // segundo dato a pedir al usuario 
        System.out.print("Ingrese la tasa de interes:");
        int interes=entrada.nextInt();
        // tercer dato a pedir al usuario 
        System.out.print("Ingrese la cantidad de coutas:");
        int cantidad=entrada.nextInt();
        int divicion=valor/cantidad;
        for(int i=1;i<=cantidad;i++){
            System.out.print("valor de cuota "+divicion);
        }
    }
}