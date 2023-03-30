import java.util.Scanner;
public class Ejercicio27{
    public static void main(String[]args){
        Scanner entrada= new Scanner (System.in);
        // variable en el caso que el lugar sea el mismo de destino
        double apia_a_apia = 5;
        double apia_a_balboa = 39.8;
        double apia_a_belen = 39.5;
        double apia_a_dosquebradas = 68.9;
        double apia_a_guatica = 58.7;
        double apia_a_celia = 24.1;
        double apia_a_virginia = 34.9;
        double apia_a_marsella = 88.1;
        double apia_a_mistrato = 55.6;
        double apia_a_pereira = 65.7;
        double apia_a_pueblo_rico = 26.4;
        double apia_a_quinchia = 77.4;
        double apia_a_santa_rosa = 77.8;
        double apia_a_santuario = 15.3;
        //balboa
        double balboa_a_apia = 39.8;
        double balboa_a_balboa = 5;
        double balboa_a_belen = 56.9;
        double balboa_a_dosquebradas = 52.9;
        double balboa_a_guatica = 76.1;
        double balboa_a_celia = 13.7;
        double balboa_a_virginia = 18.9;
        double balboa_a_marsella = 72.1;
        double balboa_a_mistrato = 73.0;
        double balboa_a_pereira = 49.7;
        double balboa_a_pueblo_rico = 64.8;
        double balboa_a_quinchia = 94.8;
        double balboa_a_santa_rosa = 61.9;
        double balboa_a_santuario = 38.3;
        //belen de umbria
        double belen_a_apia = 39.5;
        double belen_a_balboa = 56.9;
        double belen_a_belen = 5;
        double belen_a_dosquebradas = 74.6;
        double belen_a_guatica = 25.1;
        double belen_a_celia = 71.9;
        double belen_a_virginia = 40.8;
        double belen_a_marsella = 93.8;
        double belen_a_mistrato = 16.3;
        double belen_a_pereira = 71.4;
        double belen_a_pueblo_rico = 65.4;
        double belen_a_quinchia = 52.4;
        double belen_a_santa_rosa = 83.6;
        double belen_a_santuario = 71.4;
        //dosquebradas
        double dosquebradas_a_apia = 67.5;
        double dosquebradas_a_balboa = 51.5;
        double dosquebradas_a_belen = 73.1;
        double dosquebradas_a_dosquebradas = 5;
        double dosquebradas_a_guatica = 92.3;
        double dosquebradas_a_celia = 66.6;
        double dosquebradas_a_virginia = 32.5;
        double dosquebradas_a_marsella = 34.4;
        double dosquebradas_a_mistrato = 89.3;
        double dosquebradas_a_pereira = 2.4;
        double dosquebradas_a_pueblo_rico = 92.5;
        double dosquebradas_a_quinchia = 93.9;
        double dosquebradas_a_santa_rosa = 12.4;
        double dosquebradas_a_santuario =  66.0;
        //guatica
        double guatica_a_apia = 58.7;
        double guatica_a_balboa = 76.1;
        double guatica_a_belen = 25.1;
        double guatica_a_dosquebradas = 93.8;
        double guatica_a_guatica = 5.0;
        double guatica_a_celia = 91.1;
        double guatica_a_virginia = 60.0;
        double guatica_a_marsella = 98.5;
        double guatica_a_mistrato = 25.1;
        double guatica_a_pereira = 90.6;
        double guatica_a_pueblo_rico = 84.8;
        double guatica_a_quinchia = 22.9;
        double guatica_a_santa_rosa = 85.5;
        double guatica_a_santuario = 73.4;
        //la celia
        double celia_a_apia = 24.1;
        double celia_a_balboa = 13.7;
        double celia_a_belen = 71.9;
        double celia_a_dosquebradas = 67.9;
        double celia_a_guatica = 91.1;
        double celia_a_celia = 5.0;
        double celia_a_virginia = 33.9;
        double celia_a_marsella = 87.2;
        double celia_a_mistrato = 88.1;
        double celia_a_pereira = 64.7;
        double celia_a_pueblo_rico = 49.1;
        double celia_a_quinchia = 110.0;
        double celia_a_santa_rosa = 76.9;
        double celia_a_santuario = 22.6;
        //la virginia
        double virginia_a_apia = 35.0;
        double virginia_a_balboa = 19.0;
        double virginia_a_belen = 40.8;
        double virginia_a_dosquebradas = 34.0;
        double virginia_a_guatica = 60.0;
        double virginia_a_celia = 34.0;
        double virginia_a_virginia = 5.0;
        double virginia_a_marsella = 53.3;
        double virginia_a_mistrato = 56.9;
        double virginia_a_pereira = 30.8;
        double virginia_a_pueblo_rico = 60.0;
        double virginia_a_quinchia = 78.7;
        double virginia_a_santa_rosa = 43.0;
        double virginia_a_santuario = 33.5;
        //marsella
        double marsella_a_apia = 88.0;
        double marsella_a_balboa = 72.0;
        double marsella_a_belen = 93.6;
        double marsella_a_dosquebradas = 35.8;
        double marsella_a_guatica = 98.4;
        double marsella_a_celia = 87.0;
        double marsella_a_virginia = 53.0;
        double marsella_a_marsella = 5.0;
        double marsella_a_mistrato = 110.0;
        double marsella_a_pereira = 32.9;
        double marsella_a_pueblo_rico = 113.0;
        double marsella_a_quinchia = 96.6;
        double marsella_a_santa_rosa = 44.7;
        double marsella_a_santuario = 86.5;
        //mistrato
        double mistrato_a_apia         =55.7 ;
        double mistrato_a_balboa       =73.1 ;
        double mistrato_a_belen        =16.3 ;
        double mistrato_a_dosquebradas = 90.8;
        double mistrato_a_guatica      = 25.1;
        double mistrato_a_celia        = 88.1;
        double mistrato_a_virginia     = 57.0;
        double mistrato_a_marsella     = 110.0;
        double mistrato_a_mistrato     = 5.0;
        double mistrato_a_pereira      = 87.6;
        double mistrato_a_pueblo_rico  = 81.7;
        double mistrato_a_quinchia     = 53.6;
        double mistrato_a_santa_rosa   = 99.8;
        double mistrato_a_santuario    = 70.4;
        //pereira
        double pereira_a_apia         = 65.7;
        double pereira_a_balboa       = 49.8;
        double pereira_a_belen        = 71.3;
        double pereira_a_dosquebradas = 2.4;
        double pereira_a_guatica      = 90.5;
        double pereira_a_celia        = 64.8;
        double pereira_a_virginia     = 30.7;
        double pereira_a_marsella     = 33.0;
        double pereira_a_mistrato     = 87.5;
        double pereira_a_pereira      = 5.0;
        double pereira_a_pueblo_rico  = 90.7;
        double pereira_a_quinchia     = 95.8;
        double pereira_a_santa_rosa   = 14.3;
        double pereira_a_santuario    = 64.2;
        //pueblo rico
        double pueblo_rico_a_apia         = 26.2;
        double pueblo_rico_a_balboa       = 64.6;
        double pueblo_rico_a_belen        = 65.5;
        double pueblo_rico_a_dosquebradas = 93.7;
        double pueblo_rico_a_guatica      = 84.5;
        double pueblo_rico_a_celia        = 48.9;
        double pueblo_rico_a_virginia     = 59.7;
        double pueblo_rico_a_marsella     = 113.0;
        double pueblo_rico_a_mistrato     = 81.5;
        double pueblo_rico_a_pereira      = 90.5;
        double pueblo_rico_a_pueblo_rico  = 5.0;
        double pueblo_rico_a_quinchia     = 103.0;
        double pueblo_rico_a_santa_rosa   = 103.0;
        double pueblo_rico_a_santuario    = 34.6;
        //quinchia
        double quinchia_a_apia         = 77.4;
        double quinchia_a_balboa       = 94.7;
        double quinchia_a_belen        = 52.4;
        double quinchia_a_dosquebradas = 91.9;
        double quinchia_a_guatica      = 22.8;
        double quinchia_a_celia        = 110.0;
        double quinchia_a_virginia     = 78.7;
        double quinchia_a_marsella     = 96.2;
        double quinchia_a_mistrato     = 57.9;
        double quinchia_a_pereira      = 93.8;
        double quinchia_a_pueblo_rico  = 103.0;
        double quinchia_a_quinchia     = 5.0;
        double quinchia_a_santa_rosa   = 83.2;
        double quinchia_a_santuario    = 109.0;
        //santa rosa
        double santa_rosa_a_apia         = 76.7;
        double santa_rosa_a_balboa       = 60.8;
        double santa_rosa_a_belen        = 82.6;
        double santa_rosa_a_dosquebradas = 10.3;
        double santa_rosa_a_guatica      = 85.4;
        double santa_rosa_a_celia        = 75.8;
        double santa_rosa_a_virginia     = 41.7;
        double santa_rosa_a_marsella     = 43.6;
        double santa_rosa_a_mistrato     = 98.5;
        double santa_rosa_a_pereira      = 12.3;
        double santa_rosa_a_pueblo_rico  = 102.0;
        double santa_rosa_a_quinchia     = 83.5;
        double santa_rosa_a_santa_rosa   = 5.0;
        double santa_rosa_a_santuario    = 75.2;
        //santuario
        double santuario_a_apia         = 15.3;
        double santuario_a_balboa       = 38.3;
        double santuario_a_belen        = 71.4;
        double santuario_a_dosquebradas = 67.4;
        double santuario_a_guatica      = 73.5;
        double santuario_a_celia        = 22.6;
        double santuario_a_virginia     = 33.4;
        double santuario_a_marsella     = 86.6;
        double santuario_a_mistrato     = 70.5;
        double santuario_a_pereira      = 64.2;
        double santuario_a_pueblo_rico  = 34.5;
        double santuario_a_quinchia     = 109.0;
        double santuario_a_santa_rosa   = 76.4;
        double santuario_a_santuario    = 5.0;

        System.out.println(" ------------------------------------------------------------------------");
        System.out.println(" 1.Apia 2.Balboa 3.Belen de Umbria  4.Dosquebradas 5.Guatica 6.La Celia   ");
        System.out.println(" 7.La virginia  8.Marsella 9.Mistrato 10.Pereira 11.Pueblo rico 12.Quinchia");
        System.out.println(" 13.Santa rosa de Cabal .14 Santuario");
      
        System.out.println("Ingrese ciudad de origen");
        int actual=entrada.nextInt();
        System.out.println("Ingrese cantidad de paradas");
        int paradas=entrada.nextInt();
        System.out.println("Ingrese Kilometros/Galon del vehiculo");
        int vehiculo=entrada.nextInt();
        System.out.println("Ingrese el valor del galon");
        int galon=entrada.nextInt(); 
        // variables para entrar antes al ciclo
        int parada_anterior=actual;
        double kilometros=0;
        for(int i=1;i<=paradas;i++){
            System.out.print("Ingrese parada numero "+i+":");
            int parada_actual=entrada.nextInt();


            if(parada_anterior==1 && parada_actual==1){
                kilometros +=apia_a_apia;
            }else if(parada_anterior==1 && parada_actual==2){
                kilometros +=apia_a_balboa;
            }else if(parada_anterior==1 && parada_actual==3){
                kilometros+=apia_a_belen;
            }else if(parada_anterior==1 && parada_actual==4){
                kilometros+=apia_a_dosquebradas;
            }else if (parada_anterior==1 && parada_actual==5){
                kilometros+=apia_a_guatica;
            }else if(parada_anterior==1 && parada_actual==6){
                kilometros+=apia_a_celia;
            }else if(parada_anterior==1 && parada_actual==7){
                kilometros+=apia_a_virginia;
            }else if(parada_anterior==1 && parada_actual==8){
                kilometros+=apia_a_marsella;
            }else if(parada_anterior==1 && parada_actual==9){
                kilometros+=apia_a_mistrato;
            }else if(parada_anterior==1 && parada_actual==11){
                kilometros+=apia_a_pereira;
            }else if(parada_anterior==1 && parada_actual==12){
                kilometros+=apia_a_pueblo_rico;
            }else if(parada_anterior==1 && parada_actual==13){
                kilometros+=apia_a_quinchia;
            }else if(parada_anterior==1 && parada_actual==14){
                kilometros+=apia_a_santa_rosa;
            }else if(parada_anterior==1 && parada_actual==15){
                kilometros+=apia_a_santuario;
                // aqui comienza la seguna conparacion de la segunda ciudad
            }else if(parada_anterior==2 &&  parada_actual==1){ 
                kilometros+=balboa_a_apia;
            }else if(parada_anterior==2 &&  parada_actual==2){ 
                kilometros+=balboa_a_balboa;
            }else if(parada_anterior==2 &&  parada_actual==3){ 
                kilometros+=balboa_a_belen;
            }else if(parada_anterior==2 &&  parada_actual==4){ 
                kilometros+=balboa_a_dosquebradas;
            }else if(parada_anterior==2 &&  parada_actual==5){ 
                kilometros+=balboa_a_guatica;
            }else if(parada_anterior==2 &&  parada_actual==6){ 
                kilometros+=balboa_a_celia;
            }else if(parada_anterior==2 &&  parada_actual==7){ 
                kilometros+=balboa_a_virginia;
            }else if(parada_anterior==2 &&  parada_actual==8){ 
                kilometros+=balboa_a_marsella;
            }else if(parada_anterior==2 &&  parada_actual==9){ 
                kilometros+=balboa_a_mistrato;
            }else if(parada_anterior==2 &&  parada_actual==10){ 
                kilometros+=balboa_a_pereira;
            }else if(parada_anterior==2 &&  parada_actual==11){ 
                kilometros+=balboa_a_pueblo_rico;
            }else if(parada_anterior==2 &&  parada_actual==12){ 
                kilometros+=balboa_a_quinchia;
            }else if(parada_anterior==2 &&  parada_actual==13){ 
                kilometros+=balboa_a_santa_rosa;
            }else if(parada_anterior==2 &&  parada_actual==14){ 
                kilometros+=balboa_a_santuario;
                // aqui comienza la comparacion de la tercera ciudad
            }else if(parada_anterior==3 &&  parada_actual==1){ 
                kilometros+=belen_a_apia;
            }else if(parada_anterior==3 &&  parada_actual==2){ 
                kilometros+=belen_a_balboa;
            }else if(parada_anterior==3 &&  parada_actual==3){ 
                kilometros+=belen_a_belen;
            }else if(parada_anterior==3 &&  parada_actual==4){ 
                kilometros+=belen_a_dosquebradas;
            }else if(parada_anterior==3 &&  parada_actual==5){ 
                kilometros+=belen_a_guatica;
            }else if(parada_anterior==3 &&  parada_actual==6){ 
                kilometros+=belen_a_celia;
            }else if(parada_anterior==3 &&  parada_actual==7){ 
                kilometros+=belen_a_virginia;
            }else if(parada_anterior==3 &&  parada_actual==8){ 
                kilometros+=belen_a_marsella;
            }else if(parada_anterior==3 &&  parada_actual==9){ 
                kilometros+=belen_a_mistrato;
            }else if(parada_anterior==3 &&  parada_actual==10){ 
                kilometros+=belen_a_pereira;
            }else if(parada_anterior==3 &&  parada_actual==11){ 
                kilometros+=belen_a_pueblo_rico;
            }else if(parada_anterior==3 &&  parada_actual==12){ 
                kilometros+=belen_a_quinchia;
            }else if(parada_anterior==3 &&  parada_actual==13){ 
                kilometros+=belen_a_santa_rosa;
            }else if(parada_anterior==3 &&  parada_actual==14){ 
                kilometros+=belen_a_santuario;
                // aqui comina la conparacion de la cuarta ciudad 
            }else if(parada_anterior==4 &&  parada_actual==1){ 
                kilometros+=dosquebradas_a_apia;
            }else if(parada_anterior==4 &&  parada_actual==2){ 
                kilometros+=dosquebradas_a_balboa;
            }else if(parada_anterior==4 &&  parada_actual==3){ 
                kilometros+=dosquebradas_a_belen;
            }else if(parada_anterior==4 &&  parada_actual==4){ 
                kilometros+=dosquebradas_a_dosquebradas;
            }else if(parada_anterior==4 &&  parada_actual==5){ 
                kilometros+=dosquebradas_a_guatica;
            }else if(parada_anterior==4 &&  parada_actual==6){ 
                kilometros+=dosquebradas_a_celia;
            }else if(parada_anterior==4 &&  parada_actual==7){ 
                kilometros+=dosquebradas_a_virginia;
            }else if(parada_anterior==4 &&  parada_actual==8){ 
                kilometros+=dosquebradas_a_marsella;
            }else if(parada_anterior==4 &&  parada_actual==9){ 
                kilometros+=dosquebradas_a_mistrato;
            }else if(parada_anterior==4 &&  parada_actual==10){ 
                kilometros+=dosquebradas_a_pereira;
            }else if(parada_anterior==4 &&  parada_actual==11){ 
                kilometros+=dosquebradas_a_pueblo_rico;
            }else if(parada_anterior==4 &&  parada_actual==12){ 
                kilometros+=dosquebradas_a_quinchia;
            }else if(parada_anterior==4 &&  parada_actual==13){ 
                kilometros+=dosquebradas_a_santa_rosa;
            }else if(parada_anterior==4 &&  parada_actual==14){
                kilometros+=dosquebradas_a_santuario;
               // aqui comienza la comparacion de la 5 cuidad
            }else if(parada_anterior==5 &&  parada_actual==1){ 
                kilometros+=guatica_a_apia;
            }else if(parada_anterior==5 &&  parada_actual==2){ 
                kilometros+=guatica_a_balboa;
            }else if(parada_anterior==5 &&  parada_actual==3){ 
                kilometros+=guatica_a_belen;
            }else if(parada_anterior==5 &&  parada_actual==4){ 
                kilometros+=guatica_a_dosquebradas;
            }else if(parada_anterior==5 &&  parada_actual==5){ 
                kilometros+=guatica_a_guatica;
            }else if(parada_anterior==5 &&  parada_actual==6){ 
                kilometros+=guatica_a_celia;
            }else if(parada_anterior==5 &&  parada_actual==7){ 
                kilometros+=guatica_a_virginia;
            }else if(parada_anterior==5 &&  parada_actual==8){ 
                kilometros+=guatica_a_marsella;
            }else if(parada_anterior==5 &&  parada_actual==9){ 
                kilometros+=guatica_a_mistrato;
            }else if(parada_anterior==5 &&  parada_actual==10){ 
                kilometros+=guatica_a_pereira;
            }else if(parada_anterior==5 &&  parada_actual==11){ 
                kilometros+=guatica_a_pueblo_rico;
            }else if(parada_anterior==5 &&  parada_actual==12){ 
                kilometros+=guatica_a_quinchia;
            }else if(parada_anterior==5 &&  parada_actual==13){ 
                kilometros+=guatica_a_santa_rosa;
            }else if(parada_anterior==5 &&  parada_actual==14){
                kilometros+=guatica_a_santuario;
               // aqui comienza la comparacion de la 6 cuidad
            }else if(parada_anterior==6 &&  parada_actual==1){ 
                kilometros+=celia_a_apia;
            }else if(parada_anterior==6 &&  parada_actual==2){ 
                kilometros+=celia_a_balboa;
            }else if(parada_anterior==6 &&  parada_actual==3){ 
                kilometros+=celia_a_belen;
            }else if(parada_anterior==6 &&  parada_actual==4){ 
                kilometros+=celia_a_dosquebradas;
            }else if(parada_anterior==6 &&  parada_actual==5){ 
                kilometros+=celia_a_guatica;
            }else if(parada_anterior==6 &&  parada_actual==6){ 
                kilometros+=celia_a_celia;
            }else if(parada_anterior==6 &&  parada_actual==7){ 
                kilometros+=celia_a_virginia;
            }else if(parada_anterior==6 &&  parada_actual==8){ 
                kilometros+=celia_a_marsella;
            }else if(parada_anterior==6 &&  parada_actual==9){ 
                kilometros+=celia_a_mistrato;
            }else if(parada_anterior==6 &&  parada_actual==10){ 
                kilometros+=celia_a_pereira;
            }else if(parada_anterior==6 &&  parada_actual==11){ 
                kilometros+=celia_a_pueblo_rico;
            }else if(parada_anterior==6 &&  parada_actual==12){ 
                kilometros+=celia_a_quinchia;
            }else if(parada_anterior==6 &&  parada_actual==13){ 
                kilometros+=celia_a_santa_rosa;
            }else if(parada_anterior==6 &&  parada_actual==14){
                kilometros+=celia_a_santuario;
                // aqui comiena la comparacion de la 7 ciudad 
            }else if(parada_anterior==7 &&  parada_actual==1){ 
                kilometros+=virginia_a_apia;
            }else if(parada_anterior==7 &&  parada_actual==2){ 
                kilometros+=virginia_a_balboa;
            }else if(parada_anterior==7 &&  parada_actual==3){ 
                kilometros+=virginia_a_belen;
            }else if(parada_anterior==7 &&  parada_actual==4){ 
                kilometros+=virginia_a_dosquebradas;
            }else if(parada_anterior==7 &&  parada_actual==5){ 
                kilometros+=virginia_a_guatica;
            }else if(parada_anterior==7 &&  parada_actual==6){ 
                kilometros+=virginia_a_celia;
            }else if(parada_anterior==7 &&  parada_actual==7){ 
                kilometros+=virginia_a_virginia;
            }else if(parada_anterior==7 &&  parada_actual==8){ 
                kilometros+=virginia_a_marsella;
            }else if(parada_anterior==7 &&  parada_actual==9){ 
                kilometros+=virginia_a_mistrato;
            }else if(parada_anterior==7 &&  parada_actual==10){ 
                kilometros+=virginia_a_pereira;
            }else if(parada_anterior==7 &&  parada_actual==11){ 
                kilometros+=virginia_a_pueblo_rico;
            }else if(parada_anterior==7 &&  parada_actual==12){ 
                kilometros+=virginia_a_quinchia;
            }else if(parada_anterior==7 &&  parada_actual==13){ 
                kilometros+=virginia_a_santa_rosa;
            }else if(parada_anterior==7 &&  parada_actual==14){
                kilometros+=virginia_a_santuario;
                // aqui comienza la 8 octava  ciudad 
            }else if(parada_anterior==8 &&  parada_actual==1){ 
                kilometros+=marsella_a_apia;
            }else if(parada_anterior==8 &&  parada_actual==2){ 
                kilometros+=marsella_a_balboa;
            }else if(parada_anterior==8 &&  parada_actual==3){ 
                kilometros+=marsella_a_belen;
            }else if(parada_anterior==8 &&  parada_actual==4){ 
                kilometros+=marsella_a_dosquebradas;
            }else if(parada_anterior==8 &&  parada_actual==5){ 
                kilometros+=marsella_a_guatica;
            }else if(parada_anterior==8 &&  parada_actual==6){ 
                kilometros+=marsella_a_celia;
            }else if(parada_anterior==8 &&  parada_actual==7){ 
                kilometros+=marsella_a_virginia;
            }else if(parada_anterior==8 &&  parada_actual==8){ 
                kilometros+=marsella_a_marsella;
            }else if(parada_anterior==8 &&  parada_actual==9){ 
                kilometros+=marsella_a_mistrato;
            }else if(parada_anterior==8 &&  parada_actual==10){ 
                kilometros+=marsella_a_pereira;
            }else if(parada_anterior==8 &&  parada_actual==11){ 
                kilometros+=marsella_a_pueblo_rico;
            }else if(parada_anterior==8 &&  parada_actual==12){ 
                kilometros+=marsella_a_quinchia;
            }else if(parada_anterior==8 &&  parada_actual==13){ 
                kilometros+=marsella_a_santa_rosa;
            }else if(parada_anterior==8 &&  parada_actual==14){
                kilometros+=marsella_a_santuario;
                // aqui comienza la novena comparacion
            }else if(parada_anterior==9 &&  parada_actual==1){ 
                kilometros+=mistrato_a_apia;
            }else if(parada_anterior==9 &&  parada_actual==2){ 
                kilometros+=mistrato_a_balboa;
            }else if(parada_anterior==9 &&  parada_actual==3){ 
                kilometros+=mistrato_a_belen;
            }else if(parada_anterior==9 &&  parada_actual==4){ 
                kilometros+=mistrato_a_dosquebradas;
            }else if(parada_anterior==9 &&  parada_actual==5){ 
                kilometros+=mistrato_a_guatica;
            }else if(parada_anterior==9 &&  parada_actual==6){ 
                kilometros+=mistrato_a_celia;
            }else if(parada_anterior==9 &&  parada_actual==7){ 
                kilometros+=mistrato_a_virginia;
            }else if(parada_anterior==9 &&  parada_actual==8){ 
                kilometros+=mistrato_a_marsella;
            }else if(parada_anterior==9 &&  parada_actual==9){ 
                kilometros+=mistrato_a_mistrato;
            }else if(parada_anterior==9 &&  parada_actual==10){ 
                kilometros+=mistrato_a_pereira;
            }else if(parada_anterior==9 &&  parada_actual==11){ 
                kilometros+=mistrato_a_pueblo_rico;
            }else if(parada_anterior==9 &&  parada_actual==12){ 
                kilometros+=mistrato_a_quinchia;
            }else if(parada_anterior==9 &&  parada_actual==13){ 
                kilometros+=mistrato_a_santa_rosa;
            }else if(parada_anterior==9 &&  parada_actual==14){
                kilometros+=mistrato_a_santuario;
                // aqui comienza el 10 de la ciudad para comparar
            }else if(parada_anterior==10 &&  parada_actual==1){ 
                kilometros+=pereira_a_apia;
            }else if(parada_anterior==10 &&  parada_actual==2){ 
                kilometros+=pereira_a_balboa;
            }else if(parada_anterior==10 &&  parada_actual==3){ 
                kilometros+=pereira_a_belen;
            }else if(parada_anterior==10 &&  parada_actual==4){ 
                kilometros+=pereira_a_dosquebradas;
            }else if(parada_anterior==10 &&  parada_actual==5){ 
                kilometros+=pereira_a_guatica;
            }else if(parada_anterior==10 &&  parada_actual==6){ 
                kilometros+=pereira_a_celia;
            }else if(parada_anterior==10 &&  parada_actual==7){ 
                kilometros+=pereira_a_virginia;
            }else if(parada_anterior==10 &&  parada_actual==8){ 
                kilometros+=pereira_a_marsella;
            }else if(parada_anterior==10 &&  parada_actual==9){ 
                kilometros+=pereira_a_mistrato;
            }else if(parada_anterior==10 &&  parada_actual==10){ 
                kilometros+=pereira_a_pereira;
            }else if(parada_anterior==10 &&  parada_actual==11){ 
                kilometros+=pereira_a_pueblo_rico;
            }else if(parada_anterior==10 &&  parada_actual==12){ 
                kilometros+=pereira_a_quinchia;
            }else if(parada_anterior==10 &&  parada_actual==13){ 
                kilometros+=pereira_a_santa_rosa;
            }else if(parada_anterior==10 &&  parada_actual==14){
                kilometros+=pereira_a_santuario;
                // aqui comienza la 11 de la ciudad para comparar 
            }else if(parada_anterior==11 &&  parada_actual==1){ 
                kilometros+=pueblo_rico_a_apia;
            }else if(parada_anterior==11 &&  parada_actual==2){ 
                kilometros+=pueblo_rico_a_balboa;
            }else if(parada_anterior==11 &&  parada_actual==3){ 
                kilometros+=pueblo_rico_a_belen;
            }else if(parada_anterior==11 &&  parada_actual==4){ 
                kilometros+=pueblo_rico_a_dosquebradas;
            }else if(parada_anterior==11 &&  parada_actual==5){ 
                kilometros+=pueblo_rico_a_guatica;
            }else if(parada_anterior==11 &&  parada_actual==6){ 
                kilometros+=pueblo_rico_a_celia;
            }else if(parada_anterior==11 &&  parada_actual==7){ 
                kilometros+=pueblo_rico_a_virginia;
            }else if(parada_anterior==11 &&  parada_actual==8){ 
                kilometros+=pueblo_rico_a_marsella;
            }else if(parada_anterior==11 &&  parada_actual==9){ 
                kilometros+=pueblo_rico_a_mistrato;
            }else if(parada_anterior==11 &&  parada_actual==10){ 
                kilometros+=pueblo_rico_a_pereira;
            }else if(parada_anterior==11 &&  parada_actual==11){ 
                kilometros+=pueblo_rico_a_pueblo_rico;
            }else if(parada_anterior==11 &&  parada_actual==12){ 
                kilometros+=pueblo_rico_a_quinchia;
            }else if(parada_anterior==11 &&  parada_actual==13){ 
                kilometros+=pueblo_rico_a_santa_rosa;
            }else if(parada_anterior==11 &&  parada_actual==14){
                kilometros+=pueblo_rico_a_santuario;
                // aqui comienza la 12 de la ciudad para comparar 
            }else if(parada_anterior==12 &&  parada_actual==1){ 
                kilometros+=quinchia_a_apia;
            }else if(parada_anterior==12 &&  parada_actual==2){ 
                kilometros+=quinchia_a_balboa;
            }else if(parada_anterior==12 &&  parada_actual==3){ 
                kilometros+=quinchia_a_belen;
            }else if(parada_anterior==12 &&  parada_actual==4){ 
                kilometros+=quinchia_a_dosquebradas;
            }else if(parada_anterior==12 &&  parada_actual==5){ 
                kilometros+=quinchia_a_guatica;
            }else if(parada_anterior==12 &&  parada_actual==6){ 
                kilometros+=quinchia_a_celia;
            }else if(parada_anterior==12 &&  parada_actual==7){ 
                kilometros+=quinchia_a_virginia;
            }else if(parada_anterior==12 &&  parada_actual==8){ 
                kilometros+=quinchia_a_marsella;
            }else if(parada_anterior==12 &&  parada_actual==9){ 
                kilometros+=quinchia_a_mistrato;
            }else if(parada_anterior==12 &&  parada_actual==10){ 
                kilometros+=quinchia_a_pereira;
            }else if(parada_anterior==12 &&  parada_actual==11){ 
                kilometros+=quinchia_a_pueblo_rico;
            }else if(parada_anterior==12 &&  parada_actual==12){ 
                kilometros+=quinchia_a_quinchia;
            }else if(parada_anterior==12 &&  parada_actual==13){ 
                kilometros+=quinchia_a_santa_rosa;
            }else if(parada_anterior==12 &&  parada_actual==14){
                kilometros+=quinchia_a_santuario;
                // aqui comienza la 13 de la ciudad para comparar 
                
            } else if(parada_anterior==13 &&  parada_actual==1){ 
                kilometros+=santa_rosa_a_apia;
            }else if(parada_anterior==13 &&  parada_actual==2){ 
                kilometros+=santa_rosa_a_balboa;
            }else if(parada_anterior==13 &&  parada_actual==3){ 
                kilometros+=santa_rosa_a_belen;
            }else if(parada_anterior==13 &&  parada_actual==4){ 
                kilometros+=santa_rosa_a_dosquebradas;
            }else if(parada_anterior==13 &&  parada_actual==5){ 
                kilometros+=santa_rosa_a_guatica;
            }else if(parada_anterior==13 &&  parada_actual==6){ 
                kilometros+=santa_rosa_a_celia;
            }else if(parada_anterior==13 &&  parada_actual==7){ 
                kilometros+=santa_rosa_a_virginia;
            }else if(parada_anterior==13 &&  parada_actual==8){ 
                kilometros+=santa_rosa_a_marsella;
            }else if(parada_anterior==13 &&  parada_actual==9){ 
                kilometros+=santa_rosa_a_mistrato;
            }else if(parada_anterior==13 &&  parada_actual==10){ 
                kilometros+=santa_rosa_a_pereira;
            }else if(parada_anterior==13 &&  parada_actual==11){ 
                kilometros+=santa_rosa_a_pueblo_rico;
            }else if(parada_anterior==13 &&  parada_actual==12){ 
                kilometros+=santa_rosa_a_quinchia;
            }else if(parada_anterior==13 &&  parada_actual==13){ 
                kilometros+=santa_rosa_a_santa_rosa;
            }else if(parada_anterior==13 &&  parada_actual==14){
                kilometros+=santa_rosa_a_santuario;
                // aqui comienza la 14 de la ciudad para comparar 
            }else if(parada_anterior==14 &&  parada_actual==1){ 
                kilometros+=santuario_a_apia;
            }else if(parada_anterior==14 &&  parada_actual==2){ 
                kilometros+=santuario_a_balboa;
            }else if(parada_anterior==14 &&  parada_actual==3){ 
                kilometros+=santuario_a_belen;
            }else if(parada_anterior==14 &&  parada_actual==4){ 
                kilometros+=santuario_a_dosquebradas;
            }else if(parada_anterior==14 &&  parada_actual==5){ 
                kilometros+=santuario_a_guatica;
            }else if(parada_anterior==14 &&  parada_actual==6){ 
                kilometros+=santuario_a_celia;
            }else if(parada_anterior==14 &&  parada_actual==7){ 
                kilometros+=santuario_a_virginia;
            }else if(parada_anterior==14 &&  parada_actual==8){ 
                kilometros+=santuario_a_marsella;
            }else if(parada_anterior==14 &&  parada_actual==9){ 
                kilometros+=santuario_a_mistrato;
            }else if(parada_anterior==14 &&  parada_actual==10){ 
                kilometros+=santuario_a_pereira;
            }else if(parada_anterior==14 &&  parada_actual==11){ 
                kilometros+=santuario_a_pueblo_rico;
            }else if(parada_anterior==14 &&  parada_actual==12){ 
                kilometros+=santuario_a_quinchia;
            }else if(parada_anterior==14 &&  parada_actual==13){ 
                kilometros+=santuario_a_santa_rosa;
            }else if(parada_anterior==14 &&  parada_actual==14){
                kilometros+=santuario_a_santuario;
                
            }
            
          
        }
         double total=(kilometros/vehiculo)*galon;
            System.out.println("Consumo de gasolina:"+total);
            System.out.println("Este es el total recorido:"+kilometros);
            System.out.println("Galones consumidos:"+ (kilometros/vehiculo)+"galones");
    }
}