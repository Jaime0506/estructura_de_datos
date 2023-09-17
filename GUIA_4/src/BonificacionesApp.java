import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BonificacionesApp extends JFrame {
    private int[] rut = new int[100];
    private float[] sueldo = new float[100];
    
    public BonificacionesApp() {
        // Inicialización de datos (debes llenar los arreglos con los datos de los empleados)
        // ...

        setTitle("Bonificaciones de Empleados");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton botonMayor = new JButton("Empleado con Mayor Bonificación");
        JButton botonMenor = new JButton("Empleado con Menor Bonificación");
        JButton botonPorRut = new JButton("Buscar por RUT");
        JLabel resultadoLabel = new JLabel();
        
        botonMayor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceMayor = encontrarEmpleadoConMayorBonificacion();
                float bonificacion = calcularBonificacion(sueldo[indiceMayor]);
                resultadoLabel.setText("Empleado con la mayor bonificación:\nRUT: " + rut[indiceMayor] + "\nSueldo: $" + sueldo[indiceMayor] + "\nBonificación: $" + bonificacion);
            }
        });

        botonMenor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceMenor = encontrarEmpleadoConMenorBonificacion();
                float bonificacion = calcularBonificacion(sueldo[indiceMenor]);
                resultadoLabel.setText("Empleado con la menor bonificación:\nRUT: " + rut[indiceMenor] + "\nSueldo: $" + sueldo[indiceMenor] + "\nBonificación: $" + bonificacion);
            }
        });

        botonPorRut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rutBuscado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el RUT a buscar:"));
                int indiceEmpleado = encontrarEmpleadoPorRUT(rutBuscado);
                if (indiceEmpleado != -1) {
                    float bonificacion = calcularBonificacion(sueldo[indiceEmpleado]);
                    resultadoLabel.setText("Empleado encontrado por RUT " + rutBuscado + ":\nSueldo: $" + sueldo[indiceEmpleado] + "\nBonificación: $" + bonificacion);
                } else {
                    resultadoLabel.setText("Empleado con RUT " + rutBuscado + " no encontrado.");
                }
            }
        });

        panel.add(botonMayor);
        panel.add(botonMenor);
        panel.add(botonPorRut);
        panel.add(resultadoLabel);
        
        add(panel);
    }

    public float calcularBonificacion(float sueldo) {
        return sueldo * 0.05f; // Bonificación del 5%
    }

    public int encontrarEmpleadoConMayorBonificacion() {
        float maxBonificacion = calcularBonificacion(sueldo[0]);
        int indiceMax = 0;
        
        for (int i = 1; i < sueldo.length; i++) {
            float bonificacion = calcularBonificacion(sueldo[i]);
            if (bonificacion > maxBonificacion) {
                maxBonificacion = bonificacion;
                indiceMax = i;
            }
        }
        
        return indiceMax;
    }

    public int encontrarEmpleadoConMenorBonificacion() {
        float minBonificacion = calcularBonificacion(sueldo[0]);
        int indiceMin = 0;
        
        for (int i = 1; i < sueldo.length; i++) {
            float bonificacion = calcularBonificacion(sueldo[i]);
            if (bonificacion < minBonificacion) {
                minBonificacion = bonificacion;
                indiceMin = i;
            }
        }
        
        return indiceMin;
    }

    public int encontrarEmpleadoPorRUT(int rutBuscado) {
        for (int i = 0; i < rut.length; i++) {
            if (rut[i] == rutBuscado) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BonificacionesApp app = new BonificacionesApp();
                app.setVisible(true);
            }
        });
    }
}
