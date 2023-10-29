package tree;

import javax.swing.*; 

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TypeSelectedFrame extends JFrame {
	
    public TypeSelectedFrame() {
        setTitle("Seleccione el tipo de datos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(438, 133);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("Seleccione el tipo de datos para el árbol:");
        label.setBounds(37, 23, 235, 14);
        panel.add(label);

        String[] options = {"Números", "Cadenas"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(282, 20, 86, 20);
        panel.add(comboBox);

        JButton button = new JButton("Aceptar");
        button.setBounds(174, 60, 87, 23);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox.getSelectedItem();

                if ("Números".equals(selectedOption)) {
                    // Crear un TreeFrame con números
//                    TreeFrame<Integer> treeFrame = new TreeFrame<>();
//                    treeFrame.setTree(new BinaryTree<Integer>());
//                    treeFrame.setVisible(true);
                } else if ("Cadenas".equals(selectedOption)) {
                    // Crear un TreeFrame con cadenas
                    TreeFrameString treeFrame = new TreeFrameString();
                    
                    treeFrame.setVisible(true);
                }

                // Cierra este JFrame de selección de tipo de datos
                dispose();
            }
        });

        getContentPane().add(panel);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TypeSelectedFrame frame = new TypeSelectedFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
