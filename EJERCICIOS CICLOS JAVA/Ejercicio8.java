import java.util.Scanner;
public class Ejercicio8{
    public static void main(String[]args){
        Scanner entrada=new Scanner(System.in);

        System.out.println("Ingrese un numero de 6 digitos maximo:");
        int numero=entrada.nextInt();
       int i=1;
       int j=0;
        //invertir numero antes de entrar al ciclo
        int invertir=0;
        int di;

        while(j<=0){
            di=numero%10;
            invertir=(invertir*10+di);
            numero=numero/10;
            if(numero==0){
                break;
            }
         }
         //System.out.println("El numero invertio es el:"+invertir);
         while(i<=6){
            int nu=invertir%10;
            System.out.println("El digito "+i+"es:"+nu);
            invertir=invertir/10;
            i++;

         }

    }
}
