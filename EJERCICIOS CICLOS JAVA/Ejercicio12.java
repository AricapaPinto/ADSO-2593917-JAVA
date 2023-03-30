import java.util.Scanner;
public class Ejercicio12{
    public static void main(String[]args){
        Scanner entrada=new Scanner (System.in);
        //Algoritmo para imprimir el digito del dia
        int aleatorio=0;
        aleatorio=(int)(Math.random()*31);
       
        // algoritmo para crearel mes 
        boolean mes=true;
        int mes_ramdon=0;
            while(mes==true ){
                mes_ramdon=(int)(Math.random()*12);
            if(mes_ramdon>0){
                if(aleatorio==31 && (mes_ramdon==1 || mes_ramdon==3 || mes_ramdon==5 || mes_ramdon==7 || mes_ramdon==8|| mes_ramdon==10 || mes_ramdon==12)){
                    mes=false;
                }else if (aleatorio==30 && (mes_ramdon==4 || mes_ramdon==6 || mes_ramdon==9 || mes_ramdon==11)){
                    mes=false;
                }else if(aleatorio==28 && (mes_ramdon==2)){
                    mes=false;
                }else if(aleatorio <30){
                    mes= false;
                }
            }
        }
        // algoritmo para imprimir el año
        boolean anos=true;
        int final_t=0;
        while(anos==true){
            final_t = (int)(Math.random()*9999);
            if (final_t>999 && final_t<=9999){
                anos=false;
            }
        }
        if(aleatorio>0 && aleatorio<10 && mes_ramdon>0 && mes_ramdon<10){
            System.out.println("0"+aleatorio+"/0"+mes_ramdon+"/"+final_t);
        }else if(aleatorio>0 && aleatorio<10){
            System.out.println("0"+aleatorio+"/"+mes_ramdon+"/"+final_t);
        }else if(mes_ramdon>0 && mes_ramdon<10){
            System.out.print(aleatorio+"/0"+mes_ramdon+"/"+final_t);
        }else{
            System.out.println(aleatorio+"/"+mes_ramdon+"/"+final_t);
        }
    }

}