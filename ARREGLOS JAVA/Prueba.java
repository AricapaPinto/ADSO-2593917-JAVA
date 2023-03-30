 import java.util.Scanner;
public class Prueba{
    public static void main (String[]args){
        Scanner entrada=new Scanner (System.in);
        

        // ciclo para guardar los datos del areglo
        int arreglo[]=new int[10];
        int ultimo;
        for(int i=0;i<10;i++){
            System.out.print((i+1)+" Numero:");
            arreglo[i]=entrada.nextInt();
        }
        //  esta parte es para imprimir el areglo sin modificaciones
        for(int i=0;i<10;i++){
            System.out.println("["+arreglo[i]+"]");
            
        }
        System.out.print("movimientos:");
        int m=entrada.nextInt();

        
        // esta parte es para imprimir la cantidad de movimintos ingresados por el usuario

        for(int j=0;j<=m;j++){

            ultimo=arreglo[9];
            for(int i=8;i>=0;i--){
            arreglo[i+1]=arreglo[i];
            }
         
            arreglo[0]=ultimo;
           
        }
        // esta parte es para imprimir solo una vez los movimientos scritos por el usuario
        for(int k=1;k<=1;k++){
            System.out.println((k+1)+".Movimiento");
            for(int i=0;i<10;i++){
            System.out.println("["+arreglo[i]+"]");
            }  
        }
    }
} 
    