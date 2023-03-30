import java.util.Scanner;
public class Matrices1{
    public static void main(String[]args){
        Scanner entrada=new Scanner (System.in);
            // datos a,pedir al usuario 
          int uno,dos;
            System.out.print("Ingrese el primer numero");
            uno=entrada.nextInt();
            // segundo dato a solicitar 
            System.out.print("Ingrese el segundo numero");
            dos=entrada.nextInt();
             
            int numero [][]=new int [uno][dos];
            for (int i=0;i<uno;i++){
                for(int j=0;j<dos;j++){
                    System.out.print("numero a alamacenar posicion:"+(i+1)+" "+(i+1));
                    numero[i][j]=entrada.nextInt();
                }
            }

            for (int i=0;i<uno;i++){
                for(int j=0;j<dos;j++){
                    System.out.print("["+numero[i][j]+"]");
                    
                }
                System.out.println();
            }
            
        
    }
}