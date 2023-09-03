import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class Interface {

	private JFrame frame;
	private JTextField txtAdd;
	private JTextField txtFind;
	private JTextField txtDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
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
		Crud app = new Crud();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 620, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtAdd = new JTextField();
		txtAdd.setBounds(126, 52, 129, 31);
		frame.getContentPane().add(txtAdd);
		txtAdd.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(126, 243, 228, 22);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("AGREGAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = txtAdd.getText();
				
				if (value.length() > 0) {
					app.addItems(value);
					txtAdd.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "No se puede agregar un valor vacio", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(265, 52, 89, 31);
		frame.getContentPane().add(btnNewButton);
		
		txtFind = new JTextField();
		txtFind.setBounds(126, 94, 129, 31);
		frame.getContentPane().add(txtFind);
		txtFind.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("BUSCAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor = txtFind.getText(); 
				app.findItem(valor);
				txtFind.setText("");
			}
		});
		btnNewButton_1.setBounds(265, 94, 89, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblFind = new JLabel("La busqueda se realiza por el valor que previamente fue almacenado en el areglo");
		lblFind.setBounds(126, 131, 396, 31);
		frame.getContentPane().add(lblFind);
		
		txtDelete = new JTextField();
		txtDelete.setBounds(126, 163, 129, 27);
		frame.getContentPane().add(txtDelete);
		txtDelete.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("ELIMINAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = txtDelete.getText(); 
				app.removeItem(value); 
				
				txtDelete.setText(""); 
			}
		});
		btnNewButton_2.setBounds(265, 163, 89, 27);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("OBTENER MATRIZ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				textArea.setText(app.getItems());
			}
		});
		btnNewButton_3.setBounds(126, 201, 228, 31);
		frame.getContentPane().add(btnNewButton_3);
	}
}
