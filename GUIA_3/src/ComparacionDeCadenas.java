import javax.swing.JOptionPane;

public class ComparacionDeCadenas {
    public static void main(String[] args) {
        
        String cadena1 = JOptionPane.showInputDialog("Ingrese la primera cadena:");

        
        String cadena2 = JOptionPane.showInputDialog("Ingrese la segunda cadena:");

        
        if (cadena1.equals(cadena2)) {
            JOptionPane.showMessageDialog(null, "Las cadenas son iguales.");
        } else {
            JOptionPane.showMessageDialog(null, "Las cadenas son diferentes.");
        }
    }
}

