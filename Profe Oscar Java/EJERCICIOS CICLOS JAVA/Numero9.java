import java.util.Scanner;
public class Numero9{
    public static void main (String[]args){
        Scanner entrada=new Scanner (System.in);

        System.out.print("Ingrese un numero señor usuario:");
        long numero=entrada.nextLong();
        boolean proceso=true;
        int sumatoria=0;
        while(proceso){
            // para invertir el numero ingresado 
            long ultimo=0;
            long invertido=0;
            while(numero!=0){
                ultimo=numero%10;
                invertido=(invertido*10)+ultimo;
                numero=numero/10;
            }
            
            numero=invertido;
            // numero ya invertido
            sumatoria=0;
            while(numero!=0){
                long total=numero%10;
                numero=numero/10;
                sumatoria+=total;
                System.out.print(total+((numero==0)?"=":"+"));
            }
            System.out.println(sumatoria);
            if(sumatoria<10){
                proceso=false;
            }else{
                numero=sumatoria;
            }
        }
    }
}