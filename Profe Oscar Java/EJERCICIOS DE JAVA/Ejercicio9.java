import java.util.Scanner;

public class Ejercicio9{
    public static void main(String[]args){
        Scanner entrada=new Scanner (System.in);

        //pedir datos al usuario 
        System.out.print("ingrese un numero maximo de 8 digitos que represete una fecha (dd/mm/aa)");
        int numero=entrada.nextInt();
         int digito1=numero%10;
         int digito2=(numero/10)%10;
         int digito3=(numero/100)%10;
         int digito4=(numero/1000)%10;
         int digito5=(numero/10000)%10;//mes
         int digito6=(numero/100000)%10;//mes
         int digito7=(numero/1000000)%10;//dias
         int digito8=(numero/10000000)%10;//dias


         //algoritmo para imprimir el 7 di
         //algoritmo para imprimir el 8 digito
        if(digito8==9){
            if(digito7==0){
                System.out.print("NOVENTA DE");
            }else{
                System.out.print("NOVENTA Y");
            }
            
        }else if(digito8==8){
            if(digito7==0){
                System.out.print("OCHENTA DE");
            }else{
                System.out.print("OCHENTA Y");
            }
            
        }else if(digito8==7){
            if(digito7==0){
                System.out.print("SETENTA DE ");
            }else {
                 System.out.print("SETENTA Y");
            }
           
        }else if(digito8==6){
            if(digito7==0){
                System.out.print("SESENTA DE ");
            }else{
                System.out.print("SESENTA Y");
            }
            
        }else if(digito8==5){
            if(digito7==0){
                System.out.print("CINCUETA DE ");
            }else{
                System.out.print("CINCUENTA Y");
            }
            
        }else if(digito8==4){
            if(digito7==0){
                System.out.print("CUARENTA DE ");
            }else{
                 System.out.print("CUARENTA Y");
            }
           
        }else if(digito8==3){
            if(digito7==0){
                System.out.print("TREINTA DE ");
            }else{
                System.out.print("TREINTA Y");
            }
            
        }else if(digito8==2){
            if(digito7==0){
                System.out.print("VEINTE DE ");
            }else{
                System.out.print("VEINTI ");
            }
            
        }else if(digito8==1){
            if(digito7==0){
                System.out.print("DIEZ DE");
            }else if(digito7==1){
                System.out.print("ONCE DE");
            }else if(digito7==2){
                System.out.print("DOCE DE");
            }else if(digito7==3){
                System.out.print("TRECE DE");
            }else if(digito7==4){
                System.out.print("CATORCE DE");
            }else if(digito7==5){
                System.out.print("QUINCE DE");
            }else if(digito7==6){
                System.out.print("DIESISEIS DE");
            }else if(digito7==7){
                System.out.print("DIESISIETE DE");
            }else if(digito7==8){
                System.out.print("DIESIOCHO DE");
            }else if(digito7==9){
                System.out.print("DIESINUVE DE");  
            }
        }

        //algoritmo para imprimir el 7 dijito
        if(digito7==9 && digito8!=1){
            System.out.print("NUEVE DE ");
        }else if(digito7==8 && digito8!=1){
            System.out.print("OCHO DE ");
        }else if(digito7==7 && digito8!=1){
            System.out.print("SIETE DE ");
        }else if(digito7==6 && digito8!=1){
            System.out.print("SEIS DE ");
        }else if(digito7==5 && digito8!=1){
            System.out.print("CINCO DE ");
        }else if(digito7==4 && digito8!=1){
            System.out.print("CUATRO DE ");
        }else if(digito7==3 && digito8!=1){
            System.out.print("TRES DE ");
        }else if(digito7==2 && digito8!=1){
            System.out.print("DOS DE ");
        }else if(digito7==1 && digito8!=1){
            System.out.print("UNO DE ");
        }
        
        
        //algoritmo pra imprimir el sentimo digito
        
        if(digito6==0 && digito5==1){
            System.out.print("ENERO DEL");
        }else if(digito6==0 && digito5==2){
            System.out.print("FEBRERO DEL");
        }else if(digito6==0 && digito5==3){
            System.out.print("MARZO DEL");
        }else if(digito6==0 && digito5==4){
            System.out.print("ABRIL DEL");
        }else if(digito6==0 && digito5==5){
            System.out.print("MAYO DEL");
        }else if(digito6==0 && digito5==6){
            System.out.print("JUNIO DEL");
        }else if(digito6==0 && digito5==7){
            System.out.print("JULIO DEL");
        }else if(digito6==0 && digito5==8){
            System.out.print("AGOSTO DEL");
        }else if(digito6==0 && digito5==9){
            System.out.print("SEPTIEMBRE DEL");
        }else if(digito6==1&& digito5==0){
            System.out.print("OCTUBRE DEL");
        }else if(digito6==1 && digito5==1){
            System.out.print("NOVIENBRE DEL");
        }else if(digito6==1 && digito5==2){
            System.out.print("DICIEMBRE DEL");
        }
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
                    System.out.print(" UN MIL ");
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
        }else if(digito3==1){
            System.out.print("CIENTO  ");
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
        if(digito1==0 && digito2==0 && digito3==0 && digito4==0 && digito5==0 && digito6==0 && digito7==0 && digito8==0)
        System.out.print("INGRESE UNA FECHA VALIDA SENOR USUARIO :)");
        
    }
}