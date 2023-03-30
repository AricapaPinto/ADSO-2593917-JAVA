import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args){

        Scanner reader = new Scanner(System.in);

        
        int pisos;

        
        System.out.println("SENOR USUARIO INGRESE LA ALTURA DE LA PIRAMIDE");
       
        pisos = reader.nextInt();


        
        for (int i = 1; i <= pisos; i++) {

            for (int j = 1; j <= pisos - i; j++) {

                System.out.print(" ");
            }
            for (int k = 1; k <= (i * 2) - 1; k++) {

                System.out.print("x");
            }
            System.out.println();
        }
    }

}
