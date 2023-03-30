import java.util.Scanner;

public class Ejercicio2{
    public static void main(String[]args){
        Scanner entrada= new Scanner (System.in);
        System.out.print("Ingrese un numero de tres dijitos");
        int numero_tres_dijitos = entrada.nextInt();

        if(numero_tres_dijitos % 2 == 0 ){
            System.out.print("El numero escrito es par ");
        }else{
            System.out.print("El numero escrito es impar ");
        }
    }
}