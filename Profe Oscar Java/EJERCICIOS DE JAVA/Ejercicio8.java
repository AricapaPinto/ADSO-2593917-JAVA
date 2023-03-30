import java.util.Scanner;
public class Ejercicio8{
    public static void main(String[]args){
        //creando variale de entrada
        Scanner entrada=new Scanner (System.in);
        //Solicitar ingresa un numero 
        System.out.print("ingrese un numero de 6 digitos maximos :");
        int numero=entrada.nextInt();
        //PERMITIR QUE SOLO INGRESE UN NUMERODE 6 DIGITOS MAXIMOS
        //OBTENER TODOS LOS DIGITOS POR SEPARADO
        int digito1=numero%10;
        int digito2=(numero/10)%10;
        int digito3=(numero/100)%10;
        int digito4=(numero/1000)%10;
        int digito5=(numero/10000)%10;
        int digito6=(numero/100000)%10;
        //algoritmo para imprimir el texto del 6 digito
        if(digito6==9){
            System.out.print("NOVECIENTOS  ");
        }else if(digito6==8){
            System.out.print("OCHOCIENTOS  ");
        }else if(digito6==7){
            System.out.print("SETECIENTOS  ");
        }else if(digito6==6){
            System.out.print("SEISCIENTOS  ");
        }else if(digito6==5){
            System.out.print("QUINIENTOS  ");
        }else if(digito6==4){
            System.out.print("CUATROCIENTOS  ");
        }else if(digito6==3){
            System.out.print("TRECIENTOS  ");
        }else if(digito6==2){
            System.out.print("DOSCIENTOS  ");
        }else if(digito6==1){
            if(digito5==0 && digito4==0){
                System.out.print("CIEN  ");
            }else{
                System.out.print("CIENTO  ");
            }
        }else if(digito6==0){
            System.out.print("");
        }
        //ALGORITMO PARA IMPRIMIR EL 5 DIGITO
        if(digito5==9){
            if(digito4==0){
                System.out.print("NOVENTA  ");
            }else{
                System.out.print("NOVENTA Y  ");
            }
        }else if(digito5==8){
            if(digito4==0){
                System.out.print("OCHENTA  ");
            }else{
                System.out.print("OCHENTA Y  ");
            }
        }else if(digito5==7){
            if(digito4==0){
                System.out.print("SETENTA  ");
            }else{
                System.out.print("SETENTA Y  ");
            }
        }else if(digito5==6){
            if(digito4==0){
                System.out.print("SESENTA  ");
            }else{
                System.out.print("SESENTA Y  ");
            }
        }else if(digito5==5){
            if(digito4==0){
                System.out.print("CINCUENTA  ");
            }else{
                System.out.print("CINCUENTA Y  ");
            }
        }else if(digito5==4){
            if(digito4==0){
                System.out.print("CUARENTA  ");
            }else{
                System.out.print("CUARENTA Y ");
            }
        }else if(digito5==3){
            if(digito4==0){
                System.out.print("TREINTA "  );
            }else{
                System.out.print("TREINTA Y  ");
            }
        }else if(digito5==2){
            if(digito4==0){
                System.out.print("VEINTE ");
            }else{
                System.out.print("VEINTI ");
            }
        }else if(digito5==1){


            if(digito4==0){
                System.out.print("DIEZ MIL  ");
            }else if(digito4==1){
                System.out.print("ONCE  ");
            }else if(digito4==2){
                System.out.print("DOCE  ");
            }else if(digito4==3){
                System.out.print("TRECE  ");
            }else if(digito4==4){
                System.out.print("CATORCE  ");
            }else if(digito4==5){
                System.out.print("QUINCE  ");
            }else if(digito4==6){
                System.out.print("DIECI  ");
            }else if(digito4==7){
                System.out.print("DIECI  ");
            }else if(digito4==8){
                System.out.print("DIECI  ");
            }else if(digito4==9){
                System.out.print("DIECI  ");
            } 
          
        } //algoritmo para imprimir el 4 digito
        if(digito4==9){
                System.out.print("NUEVE MIL  ");
        }else if(digito4==8){
                    System.out.print("OCHO MIL  ");
        }else if(digito4==7){
                    System.out.print("SIETE MIL  ");
        }else if(digito4==6){
                    System.out.print("SEIS MIL  ");
        }else if(digito4==5){
                    System.out.print("CINCO MIL  ");
        }else if(digito4==4){
                    System.out.print("CUATRO MIL  ");
        }else if(digito4==3){
                    System.out.print("TRES MIL ");
        }else if(digito4==2){
                    System.out.print("DOS MIL  ");
        }else if(digito4==1){
                    System.out.print("  MIL ");
        }
        //algoritmo para imprimir el tercer digito
        if(digito3==9){
                System.out.print("NOVECIENTOS ");
        }else if(digito3==8){
                System.out.print("OCHOCIENTOS ");
        }else if(digito3==7){
                System.out.print("SETECIENTOS ");
        }else if(digito3==6){
                System.out.print("SEICIENTOS ");
        }else if(digito3==5){
                System.out.print("QUINIENTOS ");
        }else if(digito3==4){
                System.out.print("CUATROCIENTOS ");
        }else if(digito3==3){
                System.out.print("TRECIENTOS ");
        }else if(digito3==2){
                System.out.print("DOCIENTOS ");
        }
        //ALGORITMO PARA IMPRIMIR EL SEGUNDO DIGITO
        if(digito2==9){
            if(digito1==0){
                System.out.print("NOVENTA ");
            }else{
                System.out.print("NOVENTA Y ");
            }
        }else if(digito2==8){
            if(digito1==0){
                System.out.print("OCHENTA ");
            }else{
                System.out.print("OCHENTA Y ");
            }
        }else if(digito2==7){
            if(digito1==0){
                System.out.print("SETENTA ");
            }else{
                System.out.print("SETENTA Y ");
            }
        }else if(digito2==6){
            if(digito1==0){
                System.out.print("SESENTA ");
            }else{
                System.out.print("SESENTA Y ");
            }
        }else if(digito2==5){
            if(digito1==0){
                System.out.print("CINCUENTA ");
            }else{
                System.out.print("CINCUENTA Y ");
            }
        }else if(digito2==4){
            if(digito1==0){
                System.out.print("CUARENTA ");
            }else{
                System.out.print("CUARENTA Y ");
            }
        }else if(digito2==3){
            if(digito1==0){
                System.out.print("TREINTA ");
            }else{
                System.out.print("TREINTA Y ");
            }
        }else if(digito2==2){
            if(digito1==0){
                System.out.print("VEINTE ");
            }else{
                System.out.print("VEINTE Y ");
            }
        }else if(digito2==1){
            if(digito1==0){
                System.out.print("DIEZ ");
            }else{
                System.out.print("DIEZ Y ");
            }
        }
        //ALGORITMO PARA IMPRIMIR EL PRIMER DIGITO
        if(digito1==9){
            System.out.print("NUEVE ");
        }else if(digito1==8){
            System.out.print("OCHO ");
        }else if(digito1==7){
            System.out.print("SIETE ");
        }else if(digito1==6){
            System.out.print("SEIS ");
        }else if(digito1==5){
            System.out.print("CINCO ");
        }else if(digito1==4){
            System.out.print("CUATRO ");
        }else if(digito1==3){
            System.out.print("TRES ");
        }else if(digito1==2){
            System.out.print("DOS ");
        }else if(digito1==1){
            System.out.print("UNO");
        }
        if(digito6==0 && digito5==0 && digito4==0 && digito3==0 && digito2==0 && digito1==0){
            System.out.print("ingrese un numero que sea mayor a 0 no sea pendejo :)");
        }
    }
}