import java.util.Scanner;
public class Arreglo7{
    public static void main (String[]args){
        Scanner entrada=new Scanner(System.in);
        System.out.println("Ingrese el tamano del areglo");
        int n=entrada.nextInt();
        int areglo []=new int [n];
        for(int i=0;i<areglo.length;i++){
            System.out.println("Numero"+i);
            areglo[i]=entrada.nextInt();
        }
        System.out.print("Numero de movimientos");
        int movimiento=entrada.nextInt();
        int aux=0;
        for(int b=0;b<movimiento;b++){
            for(int i=0;i<areglo.length;i++){
                if(i==0){
                    aux= areglo[0];
                }else{
                    areglo[i-1]=areglo[i];
                }
            }
            areglo[n-1]=aux;
            System.out.print("Movimiento:"+b+":");
            for(int i=0;i<areglo.length;i++){
                System.out.print("["+areglo[i]+"]");
            }
            System.out.println("");
        }
    }
}