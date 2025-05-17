/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package divide_y_venceras;
import java.util.Stack;
/**
 *
 * @author JimXL
 */
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
        // Ejemplos de uso
        System.out.println(ackermann(0, 5));  // Debe devolver 6
        System.out.println(ackermann(1, 0));  // Debe devolver 2
        System.out.println(ackermann(2, 2));  // Debe devolver 7
    }
}