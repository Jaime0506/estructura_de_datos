import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interface {

	private JFrame frmBusquedaBinaria;
	private JTextField inputVector;
	private JTextField inputFind;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frmBusquedaBinaria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBusquedaBinaria = new JFrame();
		Array array = new Array();
		BinarySearch search = new BinarySearch(); 

		frmBusquedaBinaria.setTitle("Busqueda Binaria");
		frmBusquedaBinaria.setBounds(100, 100, 542, 255);
		frmBusquedaBinaria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBusquedaBinaria.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NUMERO DE ELEMENTOS DEL VECTOR:");
		lblNewLabel.setBounds(57, 80, 204, 26);
		frmBusquedaBinaria.getContentPane().add(lblNewLabel);
		
		inputVector = new JTextField();
		inputVector.setBounds(285, 84, 86, 20);
		frmBusquedaBinaria.getContentPane().add(inputVector);
		inputVector.setColumns(10);
		
		JButton btnNewButton = new JButton("GENERAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int numberOfVector = Integer.parseInt(inputVector.getText());

					array.setSize(numberOfVector);
					array.fillMatrix();
					
					System.out.println("Vector generado ");
					array.showMatrix();
					
					QuickShort quickSort = new QuickShort(array.getArray());
					quickSort.quickSort(array.getArray(), 0, array.getArray().length - 1);
					System.out.println("");
					System.out.println("Vector organizado");
					array.showMatrix();
					
					System.out.println(""); 

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(frmBusquedaBinaria, "El valor ingresado no es un numero", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				inputVector.setText("");
			}
		});
		btnNewButton.setBounds(381, 83, 89, 23);
		frmBusquedaBinaria.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("ELEMENTO A BUSCAR:");
		lblNewLabel_1.setBounds(57, 117, 188, 26);
		frmBusquedaBinaria.getContentPane().add(lblNewLabel_1);
		
		inputFind = new JTextField();
		inputFind.setBounds(285, 121, 86, 20);
		frmBusquedaBinaria.getContentPane().add(inputFind);
		inputFind.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("BUSCAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					int numberToFind = Integer.parseInt(inputFind.getText()); 
					String message = search.binarySearch(array.getArray(), numberToFind);
					System.out.println("");
					System.out.println(message);
					
//					System.out.println("La operacion de busqueda binaria tardo: " + timeEnd + " ms");
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(frmBusquedaBinaria, "El valor ingresado no es un numero", "Error", JOptionPane.ERROR_MESSAGE);
				}
				inputFind.setText("");
			}
		});
		btnNewButton_1.setBounds(381, 120, 89, 23);
		frmBusquedaBinaria.getContentPane().add(btnNewButton_1);
	}
}
