package circularList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UiCircularList {

	private JFrame frmListaCircular;
	private JTextField textFieldList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UiCircularList window = new UiCircularList();
					window.frmListaCircular.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UiCircularList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CircularList list = new CircularList();
		
		frmListaCircular = new JFrame();
		frmListaCircular.getContentPane().setBackground(new Color(192, 192, 192));
		frmListaCircular.setTitle("LISTA CIRCULAR");
		frmListaCircular.setBounds(100, 100, 589, 430);
		frmListaCircular.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListaCircular.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(23, 23, 525, 202);
		frmListaCircular.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista Circular");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 126, 14);
		panel.add(lblNewLabel);
		
		textFieldList = new JTextField();
		textFieldList.setEditable(false);
		textFieldList.setBounds(20, 36, 484, 143);
		panel.add(textFieldList);
		textFieldList.setColumns(10);
		
		JButton btnNewButton = new JButton("AGREGAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] options = {"Agregar al inicio", "Agregar con indice", "Agregar al final"};
				
				int response = JOptionPane.showOptionDialog(frmListaCircular, "Seleccione de que forma desea agregar el valor", "Agregar", 0, 1, null, options, options[0]); 
				
				if (response != -1) {
					if (response == 0) { 
						int value = Integer.parseInt(JOptionPane.showInputDialog(frmListaCircular, "Digite el valor del nodo")); 
						list.addInit(value);
					}
					
					if (response == 1) {
						int index = Integer.parseInt(JOptionPane.showInputDialog(frmListaCircular, "Digite el indice donde desea agregar"));
						int value = Integer.parseInt(JOptionPane.showInputDialog(frmListaCircular, "Digite el valor del nodo"));
						
						list.add(index, value);
					}
					
					if (response == 2) {
						int value = Integer.parseInt(JOptionPane.showInputDialog(frmListaCircular, "Digite el valor del nodo"));
						list.add(value);
					}
				} 
				list.setTextUi(textFieldList);
			}
		});
		btnNewButton.setBounds(23, 241, 250, 35);
		frmListaCircular.getContentPane().add(btnNewButton);
		
		JButton btnModificar = new JButton("ACTUALIZAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = Integer.parseInt(JOptionPane.showInputDialog(frmListaCircular, "Digite el index del nodo que desea actualizar su valor"));
				int value = Integer.parseInt(JOptionPane.showInputDialog(frmListaCircular, "Digite el valor nuevo del nodo"));
				
				list.update(index, value);
				list.setTextUi(textFieldList);
			}
		});
		btnModificar.setBounds(23, 287, 250, 35);
		frmListaCircular.getContentPane().add(btnModificar);
		
		JButton btnNewButton_1_1 = new JButton("ELIMINAR");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] options = {"Eliminar Inicio", "Eliminar posicion", "Eliminar final"};
				
				int response = JOptionPane.showOptionDialog(frmListaCircular, "Seleccione de que forma desea eliminar", "Eliminar", 0, 1, null, options, options[0]);
				
				if (response != -1) {
					if (response == 0) {
						list.remove(0);
					}
					
					if (response == 1) { 
						int index = Integer.parseInt(JOptionPane.showInputDialog(frmListaCircular, "Digite el indice del nodo que desea eliminar"));
						list.remove(index);
					}
					
					if (response == 2) {
						list.remove();
					}
				} 
				list.setTextUi(textFieldList);
			}
		});
		btnNewButton_1_1.setBounds(298, 241, 250, 35);
		frmListaCircular.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("ORDENAR");
		btnNewButton_1_1_1.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				list.order();
				list.setTextUi(textFieldList);
			}
		});
		btnNewButton_1_1_1.setBounds(298, 287, 250, 35);
		frmListaCircular.getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnObtener = new JButton("BUSCAR");
		btnObtener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] options = {"Buscar por indice", "Buscar por valor"};
				
				int response = JOptionPane.showOptionDialog(frmListaCircular, "Seleccione la manera que desea hacer la busqueda", "Busqueda", 0, 1, null, options, options[0]);
				
				if (response != -1) {
					if (response == 0) {
						int index = Integer.parseInt(JOptionPane.showInputDialog(frmListaCircular, "Digite la posicion del nodo que desea buscar"));
						
						if (index > 0) { 
							list.getNodeByIndex(index);
						} else {
							JOptionPane.showMessageDialog(frmListaCircular, "El indice indicado no existe", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					if (response == 1) {
						int value = Integer.parseInt(JOptionPane.showInputDialog(frmListaCircular, "Digite el valor del nodo que desea buscar"));
						
						list.getNodeByValue(value);
					}
				}
			}
		});
		btnObtener.setBounds(23, 337, 250, 35);
		frmListaCircular.getContentPane().add(btnObtener);
		
		JButton btnTamao = new JButton("TAMAÑO");
		btnTamao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				JOptionPane.showMessageDialog(frmListaCircular, "El tamaño de la lista circualr es " + list.size());
			}
		});
		btnTamao.setBounds(298, 337, 250, 35);
		frmListaCircular.getContentPane().add(btnTamao);
	}
}
