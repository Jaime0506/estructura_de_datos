package orderTree;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TreeFrame extends JFrame {

	private JPanel contentPane;
	BinaryTree tree = new BinaryTree(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreeFrame frame = new TreeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TreeFrame() { 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1114, 920);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		int width = 1080;
		int height = 600;
		
		TreeCanvas canvas = new TreeCanvas(width, height);
		canvas.setBackground(new Color(128, 128, 128));
		
		canvas.setFont(new Font("Dialog", Font.PLAIN, 18));
		canvas.setBounds(10, 10, width, height);

		contentPane.add(canvas);
		
		Panel panel = new Panel();
		panel.setBounds(10, 626, 1078, 245);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setBounds(749, 11, 319, 223);
		panel.add(lblMessage);
		
		JButton btnNewButton = new JButton("INSERTAR NODO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int value = Integer.parseInt(JOptionPane.showInputDialog(contentPane, "Seleccione el valor del nuevo nodo"));
					tree.add(value); 
					canvas.setTree(tree);
					canvas.repaint(); 
				} catch (Exception e2) {
					// TODO: handle exception 
					JOptionPane.showMessageDialog(contentPane, "El valor ingresado no es numerico", "Error", JOptionPane.ERROR_MESSAGE, null);
				} 
			}
		});
		btnNewButton.setBounds(10, 11, 347, 58);
		panel.add(btnNewButton);
		
		JButton btnBuscarNodo = new JButton("ELIMINAR NODO");
		btnBuscarNodo.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				try {
					int value = Integer.parseInt(JOptionPane.showInputDialog(contentPane, "Indique el valor del nodo a eliminar"));
					tree.deleteNodeByValue(value);
					canvas.setTree(tree);
					canvas.repaint();
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(contentPane, "El valor ingresado no es numerico", "Error", JOptionPane.ERROR_MESSAGE, null);
				}
			}
		});
		btnBuscarNodo.setBounds(10, 92, 347, 58);
		panel.add(btnBuscarNodo);
		
		JButton btnBuscarNodo_1 = new JButton("BUSCAR NODO");
		btnBuscarNodo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int value = Integer.parseInt(JOptionPane.showInputDialog(contentPane, "Indique el valor del nodo a buscar"));
					tree.findNodeByValue(value); 
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(contentPane, "El valor ingresado no es numerico", "Error", JOptionPane.ERROR_MESSAGE, null);
				}
			}
		});
		btnBuscarNodo_1.setBounds(10, 176, 347, 58);
		panel.add(btnBuscarNodo_1);
		
		JButton btnInorden = new JButton("IN_ORDEN");
		btnInorden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText(tree.in_order());
			}
		});
		btnInorden.setBounds(386, 11, 347, 58);
		panel.add(btnInorden);
		
		JButton btnPreorden = new JButton("PRE_ORDEN");
		btnPreorden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText(tree.pre_order()); 
			}
		});
		btnPreorden.setBounds(386, 92, 347, 58);
		panel.add(btnPreorden);
		
		JButton btnPostorden = new JButton("POST_ORDEN");
		btnPostorden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText(tree.post_order());
			}
		});
		btnPostorden.setBounds(386, 176, 347, 58);
		panel.add(btnPostorden);
		
		
	}
}
