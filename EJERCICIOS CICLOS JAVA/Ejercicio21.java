import java.util.Scanner;
public class Ejercicio21{
    public static void main(String[]args){
        Scanner entrada=new Scanner(System.in);

        System.out.print("Ingrese un numero:");
        int numero=entrada.nextInt();
        int numeros=0;
        for(int i=0;i<=numero;i++){
        //    int contador=1;
        //    int resultado=0;
          
            for (int j=0;j<=numero;j++){
                if (j==0){
                    numeros=j+1;
                }else if(i==0){
                    numeros=i-1;
                }else{
                    numeros=numeros-1;
                }
            }
           
        }
        for(int m=0;m<=numero;m++){
            for(int n=0;n<=numero;n++){
                System.out.println(" "+numeros);
            }
        }
        System.out.println(" ");
    }
    
}