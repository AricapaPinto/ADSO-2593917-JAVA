import java.util.Scanner;
public class Arreglo6{
    public static void main (String[]args){
     //esto es para poder escribir datos de entrada
      Scanner entrada=new Scanner(System.in);

      // Datos a pedir al usuario
    
        System.out.println("Ingrese el limite del vector");
        int l=entrada.nextInt();
        // este es el primer areglo
        int areglo1 []=new int [l];

        for(int i=0;i<areglo1.length;i++){
            System.out.print((i+1)+" Numero: ");
            areglo1[i]=entrada.nextInt();
        }
        for(int i=0;i<areglo1.length;i++){
            System.out.println("["+areglo1[i]+"]");
        }
        // segundo arreglo 
        int arreglo2[]=new int [l];
        // areglo tres para los numeros no primos 
        int arreglo3[]=new int [l];
        // este es para saber si los numeros son primos o no
        int conteo_primos=0;
        int conteo_noprimos=0;
        for(int i=0;i<areglo1.length;i++){
           int j=1;
           int contador=0;
           while(j<=areglo1[i]){
                if(areglo1[i]%j==0){
                    contador++;
                }
                j++;
           }

           if(contador==2){
            conteo_primos++;
         
           }else{
            conteo_noprimos++;
           }
        }
        // arreglos para los primos y no primos
        int primos[]=new int[conteo_primos];
        int noprimos[]=new int[conteo_noprimos];
        // este es para imprimir los numeros primos

        // estos los use como iteradores para no crear mas 
        conteo_primos=0;
        conteo_noprimos=0;


        for(int i=0;i<areglo1.length;i++){
            int j=1;
            int contador=0;
            while(j<=areglo1[i]){
                 if(areglo1[i]%j==0){
                     contador++;
                 }
                 j++;
            }
           
            if(contador==2){
                primos[conteo_primos]=areglo1[i];
             conteo_primos++;
             // arreglo2[i]=areglo1[i];
           
            }else{ 
                 //  si el numero no es primo 
             // arreglo3[i]=areglo1[i];
             noprimos[conteo_noprimos]=areglo1[i];
             conteo_noprimos++;
            }
         }
        //  esta parte es para imprimir los numeros primos y no primosqu hay en el primer areglo
        System.out.println("NUMEROS PRIMOS");
        for(int i=0;i<conteo_primos;i++){
            System.out.println("["+primos[i]+"]");
        }

        System.out.println("NUMERO NO PRIMOS");
        for(int i=0;i<conteo_noprimos;i++){
            System.out.println("["+noprimos[i]+"]");
        }
    }
}