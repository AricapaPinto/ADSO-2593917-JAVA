import java.util.Scanner;
public class Ejercicio17{
    public static void main(String[]args){
        Scanner entrada=new Scanner (System.in);
        // datos a pedir
        System.out.print("Ingrese un numero entero");
        int numero=entrada.nextInt();
        int rombo=(numero+1)/2;
        int abajo=0;
        for(int i=1;i<=rombo;i++){
            
            for(int j=1;j<=rombo-i;j++){
                System.out.print(" ");
            }
             for (int k = 1; k <= (i * 2) - 1; k++) {

                System.out.print("x");
            }
            System.out.println();
        }
        abajo=rombo-1;
        // System.out.print(abajo);
        for(int e=0;e<=abajo;e++){
            int valor=((abajo-e)*2)-1;
            int multiplicacion=e+1;
             for(int w=1;w<=multiplicacion;w++){
                System.out.print(" ");
            }
             for(int n=1;n<=valor;n++){
                System.out.print("x");
            }
            System.out.println();
        }
        
    }
}