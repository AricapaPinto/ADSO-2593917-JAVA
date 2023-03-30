import java.util.Scanner;
public class Ejercicio7{
  public static void main(String[]args){
    Scanner entrada=new Scanner(System.in);
    
    System.out.print("ingrese un numero:");
    int numero1=entrada.nextInt();//numero2
    System.out.print("ingrese otro numero:");
    int numero2=entrada.nextInt();//numero 4
    System.out.print("ingrese el ultimo numero:");
    int numero3=entrada.nextInt();//numero 6
    int acum=numero1;//el acum se almacena el primer numero en el caso el numero 2
    if(numero2>acum){ //acum valdria ya lo del numero dos
      acum=numero2;
    }
    if(numero3>acum){ //acum ya valdria lo del numero tres
      acum=numero3;
    }
    int i=acum;//va a acumular el numero mayor
    while( i%numero1!=0 || i%numero2!=0 || i%numero3!=0){
      i++;
    }
    System.out.println("El minimo comun multiplo de "+numero1+","+numero2+","+numero3+" es:"+i);
  }
}
