import java.util.Scanner;
public class Ejercicio80{
    public static void main(String[]args){
        Scanner entrada=new Scanner(System.in);

        int p=3;
        for(int i=1;i<=p;i++){
          System.out.print("ingrese un numero maxixmo de 6 digitos:");
          int numero=entrada.nextInt();
          if(numero>=0 && numero<10){
            int digito1=numero%10;
            System.out.println("el digito 01 es:"+digito1);
          }
          if(numero>=10 && numero<100){
            int digito1=numero%10;
            int digito2=(numero/10)%10;
            System.out.println("el digito 01 es:"+digito2);
            System.out.println("El digito 02 es:"+digito1);
          }
          if(numero>=100 && numero<1000){
            int digito1=numero%10;
            int digito2=(numero/10)%10;
            int digito3=(numero/100)%10;
            System.out.println("El digito 01 es:"+digito3);
            System.out.println("El digito 02 es:"+digito2);
            System.out.println("El digito 03 es:"+digito1);
          }
          if(numero>=1000 && numero<10000){
            int digito1=numero%10;
            int digito2=(numero/10)%10;
            int digito3=(numero/100)%10;
            int digito4=(numero/1000)%10;
            System.out.println("El digito 01 es:"+digito4);
            System.out.println("El digito 02 es:"+digito3);
            System.out.println("El digito 03 es:"+digito2);
            System.out.println("el digito 04 es:"+digito1);
          }
          if(numero>=10000 && numero<100000){
            int digito1=numero%10;
            int digito2=(numero/10)%10;
            int digito3=(numero/100)%10;
            int digito4=(numero/1000)%10;
            int digito5=(numero/10000)%10;
            System.out.println("El digito 01 es:"+digito5);
            System.out.println("El digito 02 es:"+digito4);
            System.out.println("El digito 03 es:"+digito3);
            System.out.println("el digito 04 es:"+digito2);
            System.out.println("El digito 05 es:"+digito1);
          }
          if(numero>=100000 && numero<1000000){
            int digito1=numero%10;
            int digito2=(numero/10)%10;
            int digito3=(numero/100)%10;
            int digito4=(numero/1000)%10;
            int digito5=(numero/10000)%10;
            int digito6=(numero/100000)%10;
            System.out.println("El digito 01 es:"+digito6);
            System.out.println("El digito 02 es:"+digito5);
            System.out.println("El digito 03 es:"+digito4);
            System.out.println("el digito 04 es:"+digito3);
            System.out.println("El digito 05 es:"+digito2);
            System.out.println("El digito 05 es:"+digito1);
          }else if(numero>1000000){
            System.out.println("***************************************************************");
            System.out.println("INGRESE UN NUMERO DE SEIS DIGITOS SENOR USUARIO NO SEA PENDEJO:)  :( ");
            System.out.println("****************************************************************");
          }

        }
    }
}
