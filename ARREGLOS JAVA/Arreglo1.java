import java.util.Scanner;
public class Arreglo1{
    public static void main(String[]args){

        Scanner entrada=new Scanner(System.in);
    
        // datos apedir al usuario 
        System.out.print("Ingrese el limite del vector");
        int nu=entrada.nextInt();
         int []numeros=new int [nu];
         for(int i=0;i<numeros.length;i++){
            numeros[i]=((i+1)*2)-1;
         }
         for(int i=0;i<numeros.length;i++){
            System.out.print("["+numeros[i]+"]");
         }
    }
}