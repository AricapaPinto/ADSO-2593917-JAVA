import java.util.Scanner; 

public class Ejercicio7{
    public static void main(String[]args){
        Scanner entrada=new Scanner(System.in);
        System.out.print("Ingrese un numero(Maximo de 10 digitos)");
        int numero=entrada.nextInt();
        if(numero>=0 && numero<10){
            int digito=numero%10;
             System.out.println("//----------------FORMATO DE MONEDA-------------------//");
             System.out.print("$"+digito);
        }else if(numero>=10 && numero<100){
            int digito=numero%10;
            int digito2=(numero/10)%10;
             System.out.println("//----------------FORMATO DE MONEDA-------------------//");
             System.out.print("$"+digito2+digito);
        }else if(numero>=100 && numero<1000){
            int digito=numero%10;
            int digito2=(numero/10)%10;
            int digito3=(numero/100)%10;
             System.out.println("//----------------FORMATO DE MONEDA-------------------//");
             System.out.print("$"+digito3+digito2+digito);
        }else if(numero>=1000 && numero<10000){
            int digito=numero%10;
            int digito2=(numero/10)%10;
            int digito3=(numero/100)%10;
            int digito4=(numero/1000)%10;
             System.out.println("//----------------FORMATO DE MONEDA-------------------//");
             System.out.print("$"+digito4+"."+digito3+digito2+digito);
        }else if(numero>=10000 && numero<100000){
            int digito=numero%10;
            int digito2=(numero/10)%10;
            int digito3=(numero/100)%10;
            int digito4=(numero/1000)%10;
            int digito5=(numero/10000)%10;
             System.out.println("//----------------FORMATO DE MONEDA-------------------//");
             System.out.print("$"+digito5+digito4+"."+digito3+digito2+digito);
        }else if(numero>=100000 &&  numero<1000000){
            int digito=numero%10;
            int digito2=(numero/10)%10;
            int digito3=(numero/100)%10;
            int digito4=(numero/1000)%10;
            int digito5=(numero/10000)%10;
            int digito6=(numero/100000)%10;
             System.out.println("//----------------FORMATO DE MONEDA-------------------//");
             System.out.print("$"+digito6+digito5+digito4+"."+digito3+digito2+digito);
        }else if(numero>=1000000 && numero<10000000){
            int digito=numero%10;
            int digito2=(numero/10)%10;
            int digito3=(numero/100)%10;
            int digito4=(numero/1000)%10;
            int digito5=(numero/10000)%10;
            int digito6=(numero/100000)%10;
            int digito7=(numero/1000000)%10;
             System.out.println("//----------------FORMATO DE MONEDA-------------------//");
             System.out.print("$"+digito7+digito6+digito5+"."+digito4+digito3+digito2+"."+digito);
        }else if(numero>=10000000 && numero<100000000){
            int digito=numero%10;
            int digito2=(numero/10)%10;
            int digito3=(numero/100)%10;
            int digito4=(numero/1000)%10;
            int digito5=(numero/10000)%10;
            int digito6=(numero/100000)%10;
            int digito7=(numero/1000000)%10;
            int digito8=(numero/10000000)%10;
             System.out.println("//----------------FORMATO DE MONEDA-------------------//");
             System.out.print("$"+digito8+digito7+digito6+"."+digito5+digito4+digito3+"."+digito2+digito);
        }else if(numero>=100000000 && numero<1000000000){
            int digito=numero%10;
            int digito2=(numero/10)%10;
            int digito3=(numero/100)%10;
            int digito4=(numero/1000)%10;
            int digito5=(numero/10000)%10;
            int digito6=(numero/100000)%10;
            int digito7=(numero/1000000)%10;
            int digito8=(numero/10000000)%10;
            int digito9=(numero/100000000)%10;
             System.out.println("//----------------FORMATO DE MONEDA-------------------//");
             System.out.print("$"+digito9+digito8+digito7+"."+digito6+digito5+digito4+"."+digito3+digito2+digito);
        }else if(numero>=1000000000 ){
            int digito=numero%10;
            int digito2=(numero/10)%10;
            int digito3=(numero/100)%10;
            int digito4=(numero/1000)%10;
            int digito5=(numero/10000)%10;
            int digito6=(numero/100000)%10;
            int digito7=(numero/1000000)%10;
            int digito8=(numero/10000000)%10;
            int digito9=(numero/100000000)%10;
            int digito10=(numero/1000000000)%10;
             System.out.println("//----------------FORMATO DE MONEDA-------------------//");
             System.out.print("$"+digito10+"."+digito9+digito8+digito7+"."+digito6+digito5+digito4+"."+digito3+digito2+digito);
        }
    }
}