import java.util.Scanner;
public class Ejercicio6{
    public static void main(String[]args){
        Scanner entrada=new Scanner(System.in);
        int fib1=0;
        int fib2=1;
        int fib_actual=0;
         System.out.println("INGRESE UN NUMERO SENOR USUARIO");
         int numero=entrada.nextInt();
         for(int i=1;i<=numero;i++){
            fib_actual=fib1+fib2;
            fib1=fib2;
            fib2=fib_actual;  
       }  
       System.out.print("El n-esimo numero Fibonacci es:"+fib_actual); 
    }
}