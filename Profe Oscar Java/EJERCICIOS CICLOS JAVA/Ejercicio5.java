import java.util.Scanner;
public class Ejercicio5{
    public static void main(String[]args){
        Scanner entrada=new Scanner (System.in);

        //variables 
        int fib1=0;
        int fib2=1;
        int fib_actual=0;
         System.out.println("INGRESE UN NUMERO SENOR USUARIO");
         int numeros=entrada.nextInt();
         for(int i=1;i<=numeros;i++){
            if(i==1){
                System.out.print("0");
                System.out.print(",");
            }else if(i==2){
                System.out.print("1");
                System.out.print(",");
            }else{
                fib_actual=fib1+fib2;
                fib1=fib2;
                fib2=fib_actual;
                System.out.print(fib_actual);
                System.out.print(",");
            }
         }
    }
} 