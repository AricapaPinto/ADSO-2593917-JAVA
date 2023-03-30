import java.util.Scanner;
public class Ejercicio16{
    public static void main(String[]args){
        Scanner entrada=new Scanner (System.in);
        // Datos a pedir al usuario
        System.out.print("Ingrese numero N:");
        int n=entrada.nextInt();
        System.out.print("Ingrese numero M:");
        int m=entrada.nextInt();
        int numero=1;
        // proceso para imprimir la cantidad de veses
         for(int i=n;i<=m;i++){
            int contador=1;
            int resultado=0;
             System.out.println("Factorial de"+i+"("+i+"!):");
             System.out.println("                            ");
            for(int j=1;j<=i;j++){
                resultado=contador*j;
                contador=resultado;
                if(j==i){
                    System.out.print(j+"="+resultado);
                }else{
                    System.out.print(j+"*");
                }
            }
            System.out.println();
        }
        
    }
}