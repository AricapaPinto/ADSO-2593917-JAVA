import java.util.Scanner;
public class Arreglo5{
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
        System.out.print("Ingrese numeros de movimientos:");
        int m=entrada.nextInt();

        
        // esta parte es para imprimir la cantidad de movimintos ingresados por el usuario

        for(int j=1;j<=m;j++){

            ultimo=arreglo[9];
            for(int i=8;i>=0;i--){
            arreglo[i+1]=arreglo[i];
            }
         
            arreglo[0]=ultimo;
            // esta parte es para imprimir los movimientos puestos por el usuario
            System.out.println((j)+".Movimiento");
            for(int i=0;i<10;i++){
            System.out.print("["+arreglo[i]+"]");
            }  
           System.out.println();
        }
        
        
    }
} 
    