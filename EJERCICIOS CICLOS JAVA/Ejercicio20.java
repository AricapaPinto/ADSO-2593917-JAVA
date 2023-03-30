import java.util.Scanner;
public class Ejercicio20{
    public static void main (String[]args){
        Scanner entrada=new Scanner (System.in);
        // cantidad total financiada
        for(int i=1;i<=5;i++){
            System.out.print("Ingrese la cantidad total financiada");
            int cantidad=entrada.nextInt();

            // pedir el valor de cada cuota
            System.out.print("ingrese el valor de las cuotas");
            int valor=entrada.nextInt();
            // cantidad de cuotas pagadas
            System.out.print("Ingrese la cantidad de cuotas pagadas");
            int pagadas=entrada.nextInt();
            // operacio para sacar el porcentaje del interes 
            float interes=(cantidad*valor)/pagadas;
            System.out.println("Interes pagado:"+interes+"%");
        }
    }
}