import java.util.Scanner;
public class Ejercicio19{
    public static void main (String[]args){
        Scanner entrada=new Scanner(System.in);
        // dato de entrada al usuario
        System.out.print("Ingrese un sueldo total:");
        int sueldo=entrada.nextInt();
        System.out.print("Cantidad de pagos:");
        int cantidad=entrada.nextInt();
        System.out.println("--------FORMAS DE PAGO----------");
        System.out.println(" 1.pagos de igual valor.");
        System.out.println(" 2.Primer pago diferente.");
        System.out.println(" 3.Ultimo pago diferente");
        System.out.println(" 4.Primer y Ultimo pago diferente. ");
        System.out.println("Ingrese forma de pago");
        int opcion=entrada.nextInt();
        if(opcion==1){
            System.out.println("-------SUS PAGOS SERAN-----------");
            for(int i=1;i<=cantidad;i++){
                int dividir=sueldo/cantidad;
               
                System.out.println("Mes "+i+ "$ "+dividir);
            }

            // segunda accion
        }else if(opcion==2 ){
            System.out.print("Ingrese el primer pago:");
            int primer=entrada.nextInt();
            int resta=sueldo-primer;
            int n=sueldo-resta;
            // quitarle uno a la cantida a dividir
            int menor=cantidad-1;
            System.out.println("Mes 1:$"+n);
            for(int j=1;j<=menor;j++){
               int pago_1=resta/menor;
                System.out.println("Mes "+(j+1)+"$"+pago_1);
            }
            // Tercera opcion para imprimir el ultimo saldo de pediendo de lo que el usuario ponga
        }else if(opcion==3){
            System.out.print("Ingrese el ultimo pago");
            int ultimo=entrada.nextInt();
            //quitarle la cantidad a dividir 
            int resta_d=sueldo-ultimo;
            int menor_t=cantidad-1;
            for(int m=1;m<=menor_t;m++){
               int pago_1=resta_d/menor_t;
                System.out.println("Mes "+m+"$"+pago_1);
            }
            System.out.print("MES $"+ultimo);
        
        // cuarta opcion primero y ultimo
        }else if(opcion==4){
            System.out.print("Ingrese el primer pago:");
            int primer=entrada.nextInt();
            System.out.print("Ingrese el ultimo pago:");
            int ultimo=entrada.nextInt();

            int restar=sueldo-primer-ultimo;

            // quitarle uno a la cantida a dividir
            int menos=cantidad-2;
            System.out.println("Mes 1 $"+primer);
            for(int k=1;k<=menos;k++){
               int pago_2=restar/menos;
                System.out.println("Mes "+k+"$"+pago_2);
            }
            System.out.println("mes pago final "+ultimo);
        }
        
    }
}