import javax.swing.JOptionPane;

public class NumerosEnteros {

    public static void main(String[] args) {
        int cantidadNumeros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de números: "));
        int[] numeros = new int[cantidadNumeros];

        
        for (int i = 0; i < cantidadNumeros; i++) {
            boolean validInput = false;
            while (!validInput) {
                try {
                    int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número " + (i + 1) + ": "));
                    numeros[i] = numero;
                    validInput = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número entero válido");
                }
            }
        }

        
        String mensaje = "Números ingresados:\n";
        for (int i = 0; i < cantidadNumeros; i++) {
            mensaje += numeros[i] + "\n";
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }
}