import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UiCantantes {

	private JFrame frmCantantesFamosos;
	private JTextField TextFieldNombre;
	private JTextField TextFieldDisco;
	private JTextField TextFieldVentas;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UiCantantes window = new UiCantantes();
					window.frmCantantesFamosos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UiCantantes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ListaCantantesFamosos app = new ListaCantantesFamosos();
		
		frmCantantesFamosos = new JFrame();
		frmCantantesFamosos.setTitle("CANTANTES FAMOSOS");
		frmCantantesFamosos.setBounds(100, 100, 819, 494);
		frmCantantesFamosos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCantantesFamosos.getContentPane().setLayout(null);
		
		TextFieldNombre = new JTextField();
		TextFieldNombre.setBounds(229, 77, 159, 20);
		frmCantantesFamosos.getContentPane().add(TextFieldNombre);
		TextFieldNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setBounds(163, 80, 56, 14);
		frmCantantesFamosos.getContentPane().add(lblNewLabel);
		
		TextFieldDisco = new JTextField();
		TextFieldDisco.setBounds(229, 108, 159, 20);
		frmCantantesFamosos.getContentPane().add(TextFieldDisco);
		TextFieldDisco.setColumns(10);
		
		JLabel lblDisco = new JLabel("DISCO");
		lblDisco.setBounds(163, 111, 56, 14);
		frmCantantesFamosos.getContentPane().add(lblDisco);
		
		TextFieldVentas = new JTextField();
		TextFieldVentas.setBounds(229, 139, 159, 20);
		TextFieldVentas.setColumns(10);
		frmCantantesFamosos.getContentPane().add(TextFieldVentas);
		
		JLabel lblVentas = new JLabel("VENTAS");
		lblVentas.setBounds(163, 142, 56, 14);
		frmCantantesFamosos.getContentPane().add(lblVentas);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(163, 208, 455, 198);
		frmCantantesFamosos.getContentPane().add(scrollPane);	

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID", "NOMBRE", "DISCO", "N_VENTAS"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				String nombre = TextFieldNombre.getText();
				String disco = TextFieldDisco.getText();
				String ventas = TextFieldVentas.getText();
				
				if (nombre.length() <= 0 || disco.length() <= 0 || ventas.length() <= 0) {
					JOptionPane.showMessageDialog(frmCantantesFamosos, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						int ventas_n = Integer.parseInt(ventas); 
						
						app.agregarCantanteFamoso(nombre, disco, ventas_n);
						app.mostratCantantes();
						
						DefaultTableModel tableData = (DefaultTableModel) table.getModel();
						app.setValuesTable(tableData);
						
						// Limpio los campos agregados
						TextFieldNombre.setText("");
						TextFieldDisco.setText("");
						TextFieldVentas.setText("");

					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(frmCantantesFamosos, "El valor ingresado en el numero de ventas debe ser numerico", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(410, 76, 79, 83);
		frmCantantesFamosos.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Validar que la tabla tenga almenos algun valor
				int idCantante = Integer.parseInt(JOptionPane.showInputDialog(frmCantantesFamosos, "Digite el ID del cantante famoso que quiere modificar"));
				
				boolean estaVacio = app.verificarExisteId(idCantante);
				
				if (!estaVacio) { 
					String[] options = {"Nombre", "Disco mas ventas", "Ventas"};
					int response = JOptionPane.showOptionDialog(frmCantantesFamosos, "Seleccione el valor a modificar", "Modificar cantante: " + app.listaCantantesFamosos.get(idCantante).getNombre(), 0, 3, null, options, options[0]);
					
					System.out.println(response);
				} else {
					JOptionPane.showMessageDialog(frmCantantesFamosos, "El Id de cantante solicitado no existe, favor verifique la informacion", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(499, 76, 119, 38);
		frmCantantesFamosos.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Modificar");
		btnNewButton_1_1.setBounds(499, 120, 119, 38);
		frmCantantesFamosos.getContentPane().add(btnNewButton_1_1);		
	}
}
