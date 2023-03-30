import java.util.Scanner;
public class Ejercicio13{
    public static void main(String[]args){
        Scanner en= new Scanner (System.in);
        // datos a pedir al usuario
        System.out.print("Ingrese un numero senor usuario");
        int numero=en.nextInt();
        int i=1;
        while(i<=numero){
            int contador=0;
            int j=1;
            int aleatorio=(int)(Math.random()*99);
            while(j<=aleatorio){
                if(aleatorio % j ==0){
                    contador++;
                }
                j++;
            }
            if(contador==2){
                System.out.println("El primo "+i+" gererado es:"+aleatorio);
                i++;
            }
        }
    }
}