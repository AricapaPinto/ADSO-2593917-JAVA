import java.util.Scanner;
public class Ejercicio9{
    public static void main(String[]args){
        Scanner entrada=new Scanner (System.in);
        System.out.print("Inrese un numero señor usuario:");
        int numero=entrada.nextInt();
        int i=2;
        boolean primo=true;
        while(primo==true && i<numero){
            if(numero%i==0){
              primo=false;
            }else {
                i++;
            }
        }
        if(primo==true){
          System.out.print("el numero es primo");
        }else
        System.out.print("El numero no es primo");
    }
}
