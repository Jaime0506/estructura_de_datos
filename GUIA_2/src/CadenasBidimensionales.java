import javax.swing.JOptionPane;

public class CadenasBidimensionales {

    public static void main(String[] args) {
        int filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de filas: "));
        int columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de columnas: "));

        String[][] cadenas = new String[filas][columnas];

        almacenarCadenas(cadenas, filas, columnas);

        mostrarCadenas(cadenas);
    }

    public static void almacenarCadenas(String[][] matriz, int filas, int columnas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = JOptionPane.showInputDialog("Ingrese una cadena para la posición [" + i + "][" + j + "]: ");
            }
        }
    }

    public static void mostrarCadenas(String[][] matriz) {
        StringBuilder mensaje = new StringBuilder("Cadenas almacenadas:\n");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                mensaje.append("[").append(i).append("][").append(j).append("]: ").append(matriz[i][j]).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}