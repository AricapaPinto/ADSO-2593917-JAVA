import java.util.Scanner;
public class Ejercicio11{
    public static void main(String[]args){
        Scanner entrada=new Scanner (System.in);
        //datos de usuario 
        System.out.print("Ingrese un numero entero entre 1 y 6:");
        int numero=entrada.nextInt();
        int i=1;
        int nu=0;
        while(i<=numero){
            int aleatorio=(int)(Math.random()*10);
            i++;
            System.out.print(aleatorio);
            nu=nu*10+aleatorio;
        }
        
        int resultado=nu*2;
        System.out.println("resultado:"+resultado);
    }
}