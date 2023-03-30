import java.util.Scanner;
public class Ejercicio4{
    public static void main(String[]args){
        Scanner entrada= new Scanner (System.in);
        //bienvenida de el usuario 
        
        //variable de entrada
        int mayor=1;

        while(mayor>0){
            System.out.println("---------BIENVENIDO-------------");
            System.out.println("1. DOCENTE");
            System.out.println("2. ESTUDIANTE");
            System.out.println("3. SALIR");
            int opcion=entrada.nextInt();
            if(opcion==1){
                 System.out.print("ingrese la cantidad de notas senor docente :)");
                int cantidad=entrada.nextInt();

                float sumatoria=0;
                for(int i=1;i<=cantidad;i++){
                    System.out.print(":) Ingrese nota"+i+":");
                    float nota=entrada.nextFloat();

                    sumatoria =sumatoria +nota;
                }
                float promedio=sumatoria/cantidad;
                System.out.println("EL PROMEDIO ES:"+promedio);
            }else if(opcion==2 ){
                System.out.print("ingrese cantidad de materias:");
                int cantidad=entrada.nextInt();

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
                System.out.println("Total de creditos:"+credito_total);
            }else if(opcion==3){
                mayor=0;
            }else{
                System.out.println("__________________________________________");
                System.out.println("INGRESE UN NUMERO CORRECTO NO SEA PENDEJO ");
                System.out.println("------------------------------------------");
            }
        }
    }
}