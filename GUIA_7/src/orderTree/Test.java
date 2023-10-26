package orderTree;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Test {
    public static void main(String[] args) { 

        BinaryTree tree = new BinaryTree();

        tree.add(45);
        tree.add(30);
        tree.add(58);
        tree.add(19);
        tree.add(12);
        tree.add(8);
        tree.add(67);
        tree.add(20);
        tree.add(35);
        tree.add(55);
        tree.add(53);
        tree.add(56);
        tree.add(13);
        tree.add(65);
        tree.add(66);
        tree.add(68);
        
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Binary Tree Graph");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1280, 920);
            TreePanel panel = new TreePanel(tree);
            panel.setSize(800, 600);
            
            frame.add(panel);
            frame.setVisible(true);
        });
    }
}