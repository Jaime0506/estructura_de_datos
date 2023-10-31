package tree;

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

public class TreeFrameNumbers extends JFrame {

	private JPanel contentPane;
	BinaryTree<Integer> tree = new BinaryTree<Integer>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					TreeFrameString frame = new TreeFrameString();
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
	public TreeFrameNumbers(){
		setTitle("BinaryTree Numbers");

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
		lblMessage.setBounds(534, 11, 534, 223);
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
					JOptionPane.showMessageDialog(contentPane,
							"El valor ingresado es texto, por favor indique unicamente Numerico");
				}
			}
		});
		btnNewButton.setBounds(10, 11, 152, 58);
		panel.add(btnNewButton);

		JButton btnBuscarNodo = new JButton("ELIMINAR NODO");
		btnBuscarNodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					int value = Integer.parseInt((JOptionPane.showInputDialog(contentPane, "Indique el valor del nodo a eliminar")));

					tree.deleteNode(value);
					canvas.setTree(tree);
					canvas.repaint();

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(contentPane,
							"El valor ingresado es numerico, por favor indique unicamente Texto");
				}
			}
		});
		btnBuscarNodo.setBounds(10, 92, 152, 58);
		panel.add(btnBuscarNodo);

		JButton btnBuscarNodo_1 = new JButton("BUSCAR NODO (AMPLITUD)");
		btnBuscarNodo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				try {
					int value = Integer.parseInt((JOptionPane.showInputDialog(contentPane, "Indique el valor del nodo a buscar")));
					
					boolean node = tree.breadthFirstSearch(value);
					
					if (node) { 
						JOptionPane.showMessageDialog(contentPane, "El nodo existe dentro del arbol", "Encontrado", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(contentPane, "El nodo no existe dentro del arbol", "Error", JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(contentPane,
							"El valor ingresado es numerico, por favor indique unicamente Texto");
				}
			}
		});
		btnBuscarNodo_1.setBounds(10, 176, 152, 58);
		panel.add(btnBuscarNodo_1);

		JButton btnInorden = new JButton("IN_ORDEN");
		btnInorden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText(tree.in_order());
			}
		});
		btnInorden.setBounds(172, 11, 171, 58);
		panel.add(btnInorden);

		JButton btnPreorden = new JButton("PRE_ORDEN");
		btnPreorden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText(tree.pre_order()); 
			}
		});
		btnPreorden.setBounds(172, 92, 171, 58);
		panel.add(btnPreorden);

		JButton btnPostorden = new JButton("POST_ORDEN");
		btnPostorden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText(tree.post_order());
			}
		});
		btnPostorden.setBounds(172, 176, 171, 58);
		panel.add(btnPostorden);

		JButton btnInorden_1 = new JButton("GRADO");
		btnInorden_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText("El grado del arbol binario es: " + String.valueOf(tree.getDegree()));
			}
		});
		btnInorden_1.setBounds(353, 11, 171, 58);
		panel.add(btnInorden_1);

		JButton btnInorden_1_1 = new JButton("NIVEL DE UN NODO");
		btnInorden_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try { 
					int value = Integer.parseInt(JOptionPane.showInputDialog(contentPane, "Digite el valor del nodo al que desea encontrar su nivel"));

					int response = tree.getLevel(value);
					
					if (response != -1) {
						lblMessage.setText("El nivel del nodo es: " + (tree.getLevel(value)));
					} else { 
						JOptionPane.showMessageDialog(contentPane, "El nodo no existe dentro del arbol", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(contentPane,
							"El valor ingresado es numerico, por favor indique unicamente Texto");
				}
				
			}
		});
		btnInorden_1_1.setBounds(353, 92, 171, 58);
		panel.add(btnInorden_1_1);

		JButton btnInorden_1_1_1 = new JButton("ALTURA");
		btnInorden_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText("La altura del arbol binario es: " + String.valueOf(tree.getHeight()));
			}
		});
		btnInorden_1_1_1.setBounds(353, 176, 171, 58);
		panel.add(btnInorden_1_1_1);
	}
}