import java.util.Scanner;
public class Ejercicio10{
    public static void main(String[]args){
        Scanner entrada= new Scanner(System.in);
        //float notas_matematicas=0
        //float nota_español=0
        //float nota_ingles=0
        //float nota_naturales=0
        //float nota_deportes=0
        float promedio=0;
        // datos del usuario 
        System.out.println("BIENVENIDO AL SISTEMA DE EVALUACION");
        //nota 1
        System.out.print("Ingrese la nota de matematicas");
        float matematicas=entrada.nextFloat();
        //NOTA2
        System.out.print("Ingrese la nota de espanol");
        float espanol=entrada.nextFloat();
        //nota3
        System.out.print("Ingrese la nota de ingles");
        float ingles=entrada.nextFloat();
        //nota4 
        System.out.print("Ingrese la nota de naturales");
        float naturales=entrada.nextFloat();
        //nota5
        System.out.print("Ingrese la nota de deportes");
        float deportes=entrada.nextFloat();
        promedio=(matematicas+espanol+ingles+naturales+deportes)/5;
       

        if(matematicas>espanol && matematicas>ingles && matematicas>naturales && matematicas>deportes){
            System.out.println("LA NOTA MAYOR ES MATEMATICAS"+matematicas);
        }else if(espanol>matematicas && espanol>ingles &&espanol>naturales && espanol>deportes){
            System.out.println("LA NOTA MAYOR ES ESPAÑOL"+espanol);
        }else if(ingles>matematicas && ingles>espanol && ingles>naturales && ingles>deportes){
            System.out.println("LA NOTA MAYOR ES INGLES"+ingles);
        }else if(naturales>matematicas && naturales>espanol && naturales>ingles && naturales>deportes){
            System.out.println("LA NOTA MAYOR ES NATURALES "+naturales);
        }else if(deportes>matematicas && deportes>espanol && deportes>ingles && deportes>naturales){
            System.out.println("LA NOTA MAYOR ES DEPORTES"+deportes);
            
        }


        if(matematicas<espanol && matematicas<ingles &&   matematicas<naturales&&   matematicas<deportes){
            System.out.println("LA NOTA MENOR ES MATEMATICAS"+matematicas);
            if(promedio<3){
                int multiplicacion=5*3;
                matematicas=multiplicacion-espanol-ingles-naturales-deportes;
                System.out.println("USTED DEBIO SACAR UN PORCENTAJE DE "+matematicas +" EN MATEMATICAS PARA APROVAR EL PERIODO");
            }
        }else if(espanol<matematicas&&  espanol<ingles &&  espanol<naturales &&  espanol<deportes){
            System.out.println("LA NOTA MENOR ES ESPANOL"+espanol);
              if(promedio<3){
                int multiplicacion=5*3;
                espanol=multiplicacion-matematicas-ingles-naturales-deportes;
                System.out.println("USTED DEBIO SACAR UN PORCENTAJE DE "+espanol +" EN ESPANOL PARA APROVAR EL PERIODO");
            }
            
        }else if(ingles<matematicas &&  ingles<espanol && ingles<naturales && ingles<deportes){
            System.out.println("LA NOTA MENOR ES INGLES"+ingles);
            if(promedio<3){
                int multiplicacion=5*3;
                ingles=multiplicacion-matematicas-espanol-naturales-deportes;
                System.out.println("USTED DEBIO SACAR UN PORCENTAJE DE "+ingles +" EN INGLES PARA APROVAR EL PERIODO");
            }
            
        }else if(naturales<matematicas &&  naturales<espanol && naturales<ingles && naturales<deportes){
             System.out.println("LA NOTA MENOR ES NATURALES "+naturales);
            if(promedio<3){
                int multiplicacion=5*3;
                naturales=multiplicacion-matematicas-ingles-espanol-deportes;
                System.out.println("USTED DEBIO SACAR UN PORCENTAJE DE "+naturales +" EN NATURALES PARA APROVAR EL PERIODO");
            }
           
        }else if(deportes<matematicas &&  deportes<espanol && deportes<ingles && deportes<naturales){
            System.out.println("LA NOTA MENOR ES DEPORTES"+deportes);
            if(promedio<3){
                int multiplicacion=5*3;
                deportes=multiplicacion-matematicas-ingles-naturales-espanol;
                System.out.println("USTED DEBIO SACAR UN PORCENTAJE DE "+deportes +" EN DEPORTES PARA APROVAR EL PERIODO");
            }
            
        }

        System.out.println("ESTE ES EL PROMEDIO TOTAL DE SUS NOTAS:"+promedio);
            
    }
}