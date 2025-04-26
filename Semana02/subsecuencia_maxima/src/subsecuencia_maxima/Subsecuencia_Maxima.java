package subsecuencia_maxima;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Subsecuencia_Maxima {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int maximo_parcial=0, maximo_total=0, actual = 0, inicio = 0, fin = 0;
        
        System.out.println("Ingrese la cantidad de numeros a generar:");
        int n_generar = scanner.nextInt();
        System.out.println();
        List<Integer> numerosAleatorios = generarListaAleatoria(n_generar, -20, 20);
        System.out.printf("%-10s", "Valores");
        for (int numero : numerosAleatorios) {
            System.out.printf("%5d", numero); 
        }
        System.out.println();
        System.out.printf("%-10s", "Posicion");
        for (int i = 1; i <= numerosAleatorios.size(); i++) {
            System.out.printf("%5d", i);
        }
        System.out.println();
        System.out.println();
        System.out.print("Secuencia de comparaciones:");
        System.out.println();
        
        for (int i = 0; i < n_generar; i++) {
            int numero = numerosAleatorios.get(i);
            if( numero > maximo_parcial + numero) {
                maximo_parcial =  numero;
                actual = i;
            } else { maximo_parcial += numero; }
            
            if(maximo_parcial > maximo_total) {
                maximo_total =  maximo_parcial;
                inicio = actual;
                fin = i;
            }
            System.out.print(i + 1 + " - Numero actual: " + numero + ", Maximo Parcial: " + maximo_parcial + ", Maximo Total: " + maximo_total);
            System.out.println();
        }
        System.out.println();
        System.out.println("La sumatoria maxima consecutiva es de a" + (inicio+1) + " hasta a" + (fin+1) + " con un valor de " + maximo_total);
        System.out.println();
        System.out.println("Numero de inicio: " + numerosAleatorios.get(inicio) + " - Lugar del numero: " + (inicio + 1));
        System.out.println("Numero de fin: " + numerosAleatorios.get(fin)+ " - Lugar del numero: " + (fin + 1));
    }

    public static List<Integer> generarListaAleatoria(int cantidad, int minimo, int maximo) {
        List<Integer> lista = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            int numeroAleatorio = random.nextInt((maximo - minimo) + 1) + minimo;
            lista.add(numeroAleatorio);
        }
        return lista;
    }
}