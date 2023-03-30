import java.util.Scanner;

public class Ejercicio2{
    public static void main(String[] args){

        Scanner entrada= new Scanner(System.in);

        //solicitar 
        System.out.print("ingrese cantidad de materias:");
        int cantidad=entrada.nextInt();

    
        //int credito=0;
        float cantidad_notas=0;
        float notas_t=0;
        int credito_total=0;
        notas_t=0;
        for( int i=1;i<=cantidad;i++){
            System.out.print("Ingrese nota"+i+":");
          float notas=entrada.nextFloat();
          System.out.print("ingrese credito de materia:");
          int creditos=entrada.nextInt();
          
          credito_total=credito_total+creditos;
          //promedio ponderado
          //credito=credito+1;
           float promedio=notas*creditos;
          cantidad_notas=cantidad_notas+promedio;
          
        }
        
         float promedio_final=cantidad_notas/credito_total;
       // float promedio_notas=suma/cantidad;
        System.out.println("este es el promedio ponderado de todas las notas:"+promedio_final);
        //System.out.println("Promedio del semestre:"+promedio_notas);
        System.out.print("Total de creditos:"+credito_total);
    }
}