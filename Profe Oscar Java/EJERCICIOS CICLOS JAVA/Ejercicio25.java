import java.util.Scanner;
public class Ejercicio25{
    public static void main (String[]args){
        Scanner entrada=new Scanner (System.in);

        System.out.print("Ingrese la cantidad  a financiar");
        int cantidad=entrada.nextInt();

        System.out.print("Ingrese la cantidad de cuotas");
        int cuotas=entrada.nextInt();

        System.out.print("cual es el valor de la cuota");
        int valor=entrada.nextInt();

        int mult=cuotas*valor;
        int nuevo=mult*cantidad;
        float multi= (float)nuevo/(float)cantidad;
        float porcentaje =(float)multi*100;
        System.out.println("este es el porcentaje del interes:"+porcentaje);
    }
}