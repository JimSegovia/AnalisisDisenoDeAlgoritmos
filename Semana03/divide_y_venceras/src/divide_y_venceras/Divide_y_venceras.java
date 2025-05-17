package divide_y_venceras;
import java.util.Stack;
import java.util.Scanner;

public class Divide_y_venceras {

    public static int ackermann(int m, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(m);
        
        while (!stack.isEmpty()) {
            m = stack.pop();
            
            if (m == 0) {
                n += 1;
            } 
            else if (n == 0) {
                n = 1;
                stack.push(m - 1);
            } 
            else {
                stack.push(m - 1);
                stack.push(m);
                n -= 1;
            }
        }
        return n;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Pedir al usuario ingresar m y n
        System.out.print("Ingrese el valor de m: ");
        int m = scanner.nextInt();
        
        System.out.print("Ingrese el valor de n: ");
        int n = scanner.nextInt();
        
        // Medir el tiempo de ejecución
        long startTime = System.nanoTime();
        int resultado = ackermann(m, n);
        long endTime = System.nanoTime();
        
        // Calcular tiempo en nanosegundos
        long duration = endTime - startTime;
        
        // Mostrar resultados
        System.out.println("\nResultados");
        System.out.println("A(" + m + ", " + n + ") = " + resultado);
        System.out.println("Tiempo de ejecucion: " + duration + " ns");
        
        scanner.close();
    }
}