package polaca;

import java.util.Stack;
import javax.swing.JOptionPane;

public class CalculadoraPolaca {
    public static void main(String[] args) {
        String expresion = JOptionPane.showInputDialog("Ingresa la expresión matemática: ");

        if (estaBalanceada(expresion)) {
            String notacionPostfija = convertirAPostfija(expresion);
            double resultado = evaluarPostfija(notacionPostfija);

            JOptionPane.showMessageDialog(null, "Notación Postfija: " + notacionPostfija + "\nResultado: " + resultado);
        } else {
            JOptionPane.showMessageDialog(null, "La expresión no está balanceada.");
        }
    }

    public static boolean estaBalanceada(String expresion) {
        Stack<Character> pila = new Stack<>();

        for (char caracter : expresion.toCharArray()) {
            if (caracter == '(' || caracter == '[') {
                pila.push(caracter);
            } else if (caracter == ')' || caracter == ']') {
                if (pila.isEmpty()) return false;
                char tope = pila.pop();
                if ((caracter == ')' && tope != '(') || (caracter == ']' && tope != '[')) {
                    return false;
                }
            }
        }

        return pila.isEmpty();
    }

    public static String convertirAPostfija(String expresion) {
        StringBuilder resultado = new StringBuilder();
        Stack<Character> operadores = new Stack();

        for (char caracter : expresion.toCharArray()) {
            if (Character.isDigit(caracter)) {
                resultado.append(caracter);
                resultado.append(" ");
            } else if (caracter == '(') {
                operadores.push(caracter);
            } else if (caracter == ')') {
                while (!operadores.isEmpty() && operadores.peek() != '(') {
                    resultado.append(operadores.pop());
                    resultado.append(" ");
                }
                operadores.pop();
            } else {
                while (!operadores.isEmpty() && prioridad(operadores.peek()) >= prioridad(caracter)) {
                    resultado.append(operadores.pop());
                    resultado.append(" ");
                }
                operadores.push(caracter);
            }
        }

        while (!operadores.isEmpty()) {
            resultado.append(operadores.pop());
            resultado.append(" ");
        }

        return resultado.toString();
    }

    public static double evaluarPostfija(String expresion) {
        Stack<Double> pila = new Stack<>();
        String[] tokens = expresion.split(" ");

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                pila.push(Double.parseDouble(token));
            } else {
                double operand2 = pila.pop();
                double operand1 = pila.pop();
                double resultado;

                switch (token) {
                    case "+":
                        resultado = operand1 + operand2;
                        break;
                    case "-":
                        resultado = operand1 - operand2;
                        break;
                    case "*":
                        resultado = operand1 * operand2;
                        break;
                    case "/":
                        resultado = operand1 / operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Operador no válido: " + token);
                }
                pila.push(resultado);
            }
        }

        return pila.pop();
    }

    public static int prioridad(char operador) {
        if (operador == '+' || operador == '-') {
            return 1;
        } else if (operador == '*' || operador == '/') {
            return 2;
        }
        return 0; // Otros operadores, como paréntesis, corchetes, etc.
    }
}