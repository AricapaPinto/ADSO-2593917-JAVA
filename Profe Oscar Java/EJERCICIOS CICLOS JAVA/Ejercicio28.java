import java.util.Scanner;

public class Ejercicio28 {
    public static void main(String[]args) {
        Scanner Entrada = new Scanner(System.in);
        

        System.out.print("=> Ingrese el valor a financiar: ");
        int valor = Entrada.nextInt();

        System.out.print("=> Ingrese la tasa de interes: ");
        int interes = Entrada.nextInt();

        System.out.print("=> Ingrese la cantidad de cuotas: ");
        int cant_cuotas = Entrada.nextInt();
        int multi = 0;
        int acum_interes=0;
        int interes_cuota = 0;
        int restanteInteres = 0;
        
        for(int i = 1; i<=cant_cuotas; i++){
            System.out.println("Cual es el valor que desea dar en la cuota "+i+" :" );
            int cuota = Entrada.nextInt();

            multi = valor * interes;
            interes_cuota = multi/100;
            
            
            System.out.println("Este el valor que pagara en interes: "+interes_cuota);
            acum_interes=acum_interes+restanteInteres;
            restanteInteres = cuota-interes_cuota;

            System.out.println("Este es el abono al capital financiado: "+restanteInteres);
            
            
            System.out.println("=> Asi quedo la deuda: "+valor);
            valor=valor-restanteInteres;
            System.out.println("__________________________________________");
        }
        System.out.println("Este es el total que pago de intereses: "+acum_interes);
    }
    
}