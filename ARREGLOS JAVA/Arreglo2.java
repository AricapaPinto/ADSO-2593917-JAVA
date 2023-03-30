import java.util.Scanner;
public class Arreglo2{
    public static void main (String[]args){
        Scanner entrada=new Scanner(System.in);
        // dato a pedir al usuario

        System.out.print("Ingrese el limite del vector");
        int n=entrada.nextInt();
        // areglos
        int []numeros=new int[n];
        for(int m=0;m<numeros.length;m++){
            // sacar los numeros primos
            int i=1;
          while(i<=n){
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
                // System.out.println("El primo "+i+" gererado es:"+aleatorio);
                i++;
                numeros[m]=aleatorio;
            }
          }
        }
        
        // este es para imprimr los numeros primos guardados en el areglo
        for(int m=0;m<numeros.length;m++){
            System.out.print("["+numeros[m]+"]");
        }
    }
}

    