package tarea_ternario;
import java.util.Scanner;
public class Tarea_Ternario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("menu");
        System.out.println("1.Par o Impar");
        System.out.println("2.Uso con varibles");
        System.out.println("3.evaluar si es mayor o menor");
        System.out.println("4.salir");
        i=sc.nextInt();
        while (i != 4) {
            if (i == 1) {
                System.out.println("ingresar un numero para saber si es par o impar");
                int x = sc.nextInt();
                String resultado = (x % 2 == 0) ? "Par" : "Impar";
                System.out.println(resultado);  // Salida indica si es par o impar
            }
            if (i == 2) {
                int a = 7;
                int b = 10;
                int mayor = (a > b) ? a : b;
                System.out.println(mayor);  // Salida: 10   
            }
            if (i == 3) {
                String resultado = (10 > 5) ? "Mayor" : "Menor";
                System.out.println(resultado);  // Salida: Mayor
            }
            if (i==5) {
               int at,it=5;
                System.out.println("ingresar un numero para saber m o m");
                at=sc.nextInt();
                if (at>it) {
                    System.out.println("mayor");   
                }
                else{
                    System.out.println("menor");
                }
                
            }
        }
    }

}
