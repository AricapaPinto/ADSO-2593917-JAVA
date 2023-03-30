import java.util.Scanner;
public class Arreglo3{
    public static void main (String[]args){
        Scanner entrada=new Scanner(System.in);
        System.out.println("Ingrese el tamano del areglo");
        int n=entrada.nextInt();
        int areglo []=new int [n];
        for(int i=0;i<areglo.length;i++){
            System.out.print("Ingrese numero ");
            areglo[i]=entrada.nextInt();
        }
        System.out.print("Numero de movimientos");
        int movimiento=entrada.nextInt();
        // el aux nose jajaa
        int aux=0;
        // aqui imprimimos el areglo sin modificaciones
        for(int i=0;i<areglo.length;i++){
            System.out.print("["+areglo[i]+"]");
        }
        System.out.println("");
        for(int b=1;b<movimiento;b++){
            for(int i=0;i<areglo.length;i++){
                if(i==0){
                    aux= areglo[0];
                }else{
                    areglo[i-1]=areglo[i];
                }
            }
            areglo[n-1]=aux;
        }
        
        for(int i=0;i<areglo.length;i++){
            System.out.print("["+areglo[i]+"]");
        }
    }
}