import java.util.Scanner;
public class Ejercicio15{
    public static void main(String[]args){
        Scanner entrada=new Scanner (System.in);
        System.out.print("Ingrese un numero");
        int numero=entrada.nextInt();
        int n=1;
        for(int i=1;i<=numero;i++){
            n=n*i;
            if(i==numero){
                System.out.print(i+"=");
            }else{
                System.out.print(i+"*");
            }
           
        }
        System.out.print(n);
    }
}