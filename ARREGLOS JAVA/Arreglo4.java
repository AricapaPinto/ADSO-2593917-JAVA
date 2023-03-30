import java.util.Scanner;
public class Arreglo4{
    public static void main(String[]args){

        // esto es para pedir datos de entrada por el usuario 
        Scanner entrada=new Scanner(System.in);

        // datos a pedri al usuario 
        System.out.print("Ingrese el limite del vector:");
        int l=entrada.nextInt();
        int [] numero=new int[l];

        for(int i=0;i<numero.length;i++){
            System.out.print((i+1)+" Numero");
            numero[i]=entrada.nextInt();
        }
        for(int i=0;i<numero.length;i++){
            System.out.println("["+numero[i]+"]");     
        }

        // aqui se utiliza el metodo de burbja para imprimir los numeos desendentes
        int aux;
        for(int i=0;i<(numero.length-1);i++){
            for(int j=0;j<(numero.length-1);j++){
                if(numero[j]>numero[j+1]){
                    aux=numero[j];
                    numero[j]=numero[j+1];
                    numero[j+1]=aux;
                }
            }
        }
        System.out.println("Numeros desendentes:");
        for(int i=0;i<numero.length;i++){
            System.out.println("["+numero[i]+"]");
        }
    }
}