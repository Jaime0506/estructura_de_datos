import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AbcUI {

	private JFrame frame;
	private JTextField inputRut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbcUI window = new AbcUI();
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
	public AbcUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Abc app = new Abc();
		app.assignRuts();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 526, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BUSCAR POR RUT");
		lblNewLabel.setBounds(109, 56, 105, 14);
		frame.getContentPane().add(lblNewLabel);
		
		inputRut = new JTextField();
		inputRut.setBounds(109, 81, 288, 20);
		frame.getContentPane().add(inputRut);
		inputRut.setColumns(10);
		
		JButton btnNewButton = new JButton("BUSCAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				String value = inputRut.getText();
				
				if (value.length() > 0) {
					try {
						int rut = Integer.parseInt(value);
						app.findEmployeesByRut(rut);
						
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(frame, "El valor digitano no es numerico, por favor verifique nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "El rut no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				inputRut.setText("");
			}
		});
		btnNewButton.setBounds(109, 110, 288, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("MOSTRAR EMPLEADOS");
		btnNewButton_1.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				app.showEmployees();
			}
		});
		btnNewButton_1.setBounds(109, 145, 288, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("MOSTRAR LISTA BENEFICIADOS");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.order();
				app.listOfTheThirtyBeneficiaries();
			}
		});
		btnNewButton_2.setBounds(109, 179, 288, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("EMPLEADO CON MAYOR BONIFICACION");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.rutMax();
			}
		});
		btnNewButton_3.setBounds(109, 213, 288, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("EMPLEADO CON MENOR BONIFICACION");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.rutMin();
			}
		});
		btnNewButton_4.setBounds(109, 247, 288, 23);
		frame.getContentPane().add(btnNewButton_4);
	}
}
