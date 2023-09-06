import javax.swing.JOptionPane;

public class ArregloDeNombres {
    public static void main(String[] args) {
        
        String[] nombres = new String[10];

        
        for (int i = 0; i < nombres.length; i++) {
            nombres[i] = JOptionPane.showInputDialog("Ingrese el nombre " + (i + 1));
        }

        
        StringBuilder nombresConcatenados = new StringBuilder("Nombres ingresados:\n");
        for (String nombre : nombres) {
            nombresConcatenados.append(nombre).append("\n");
        }

        JOptionPane.showMessageDialog(null, nombresConcatenados.toString());
    }
}
