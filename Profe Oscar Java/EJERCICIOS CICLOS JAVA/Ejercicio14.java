import java.util.Scanner;
public class Ejercicio14{
    public static void main(String[]args){
        Scanner entrada=new Scanner (System.in);
        System.out.print("Ingrese un numero de maximo 6 digitos");
        int numero = entrada.nextInt();
        int original=numero;
        int ultimo=0;
        int invertido=0;
        int i=0; 
        while(numero!=0){
            ultimo=numero%10;
            invertido=(invertido*10) + ultimo;
             numero=numero/10;
        }
        if(invertido==original){
            System.out.println("El numero ingresado es palindromo");
        }else{
            System.out.println("El numero ingresado no es palindromo");
        }
     }
}