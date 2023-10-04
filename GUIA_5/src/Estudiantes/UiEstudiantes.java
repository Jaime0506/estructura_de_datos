import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UiEstudiantes {

	private JFrame frmGestionDeEstudiantes;
	private JTextField textFieldId;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDireccion;
	private JTextField textFieldTelefono;
	private JTextField textFieldCarrera;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UiEstudiantes window = new UiEstudiantes();
					window.frmGestionDeEstudiantes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UiEstudiantes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		GestionEstudiantes app = new GestionEstudiantes();

		frmGestionDeEstudiantes = new JFrame();
		frmGestionDeEstudiantes.setTitle("GESTION DE ESTUDIANTES");
		frmGestionDeEstudiantes.setBounds(100, 100, 860, 489);
		frmGestionDeEstudiantes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDeEstudiantes.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(68, 52, 46, 14);
		frmGestionDeEstudiantes.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombres");
		lblNewLabel_1.setBounds(68, 88, 46, 14);
		frmGestionDeEstudiantes.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setBounds(68, 133, 46, 14);
		frmGestionDeEstudiantes.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Direccion");
		lblNewLabel_3.setBounds(68, 177, 46, 14);
		frmGestionDeEstudiantes.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Telefono");
		lblNewLabel_4.setBounds(68, 217, 46, 14);
		frmGestionDeEstudiantes.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Carrera");
		lblNewLabel_5.setBounds(68, 262, 46, 14);
		frmGestionDeEstudiantes.getContentPane().add(lblNewLabel_5);

		textFieldId = new JTextField();
		textFieldId.setBounds(137, 49, 122, 20);
		frmGestionDeEstudiantes.getContentPane().add(textFieldId);
		textFieldId.setColumns(10);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(137, 85, 122, 20);
		frmGestionDeEstudiantes.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(137, 130, 122, 20);
		frmGestionDeEstudiantes.getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);

		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(137, 174, 122, 20);
		frmGestionDeEstudiantes.getContentPane().add(textFieldDireccion);
		textFieldDireccion.setColumns(10);

		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(137, 214, 122, 20);
		frmGestionDeEstudiantes.getContentPane().add(textFieldTelefono);
		textFieldTelefono.setColumns(10);

		textFieldCarrera = new JTextField();
		textFieldCarrera.setBounds(137, 259, 122, 20);
		frmGestionDeEstudiantes.getContentPane().add(textFieldCarrera);
		textFieldCarrera.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(306, 18, 515, 404);
		frmGestionDeEstudiantes.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "NOMBRES", "APELLIDOS", "DIRECCION", "TELEFONO", "CARRERA" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(81);
		table.getColumnModel().getColumn(5).setResizable(false);

		DefaultTableModel table_data = (DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);
		JButton btnNewButton = new JButton("AGREGAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(textFieldId.getText());
					String nombre = textFieldNombre.getText();
					String apellido = textFieldApellido.getText();
					String direccion = textFieldDireccion.getText();
					String telefono = textFieldTelefono.getText();
					String carrera = textFieldCarrera.getText();

					if (id > 0 && nombre.length() > 0 && apellido.length() > 0 && direccion.length() > 0
							&& telefono.length() > 0 && carrera.length() > 0) {
						app.addEstudiante(id, nombre, apellido, direccion, telefono, carrera, frmGestionDeEstudiantes,
								table_data);

						textFieldId.setText("");
						textFieldNombre.setText("");
						textFieldApellido.setText("");
						textFieldDireccion.setText("");
						textFieldTelefono.setText("");
						textFieldCarrera.setText("");

					} else {
						JOptionPane.showMessageDialog(frmGestionDeEstudiantes, "Todos los campos son obligatorios",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2);
					JOptionPane.showMessageDialog(frmGestionDeEstudiantes,
							"Los valores en el campo ID deben ser numericos", "Error", JOptionPane.ERROR_MESSAGE);
					textFieldId.setText("");
				}
			}
		});

		btnNewButton.setBounds(68, 306, 196, 23);
		frmGestionDeEstudiantes.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("MODIFICAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					int id = Integer.parseInt(JOptionPane.showInputDialog(frmGestionDeEstudiantes,
							"Digite el ID del estudiante que desea modificar"));
					boolean existe = app.existeEstudiante(id);
					
					if (existe) {
						String[] options = { "Nombre", "Apellido", "Direccion", "Telefono", "Carrera" };
						int responseOption = JOptionPane.showOptionDialog(frmGestionDeEstudiantes, "Seleccione el campo que desea modificar", "Modificar valores del estudiante: " + app.estudiantes.get(id).obtenerNombre(), 0, 1, null, options, options[0]);
						
						String value = JOptionPane.showInputDialog(frmGestionDeEstudiantes,
								"Digite el nuevo valor para el campo: " + options[responseOption]);
						app.cambiarDatos(id, options[responseOption], value, frmGestionDeEstudiantes, table_data);
						
					} else {
						JOptionPane.showMessageDialog(frmGestionDeEstudiantes, "El estudiante con ese ID no existe",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(frmGestionDeEstudiantes, "El dato ID debe ser numerico", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(68, 349, 196, 23);
		frmGestionDeEstudiantes.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("BORRAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(JOptionPane.showInputDialog(frmGestionDeEstudiantes,
						"Indique el ID del estudiante que desea eliminar"));
				app.deleteEstudiante(id, frmGestionDeEstudiantes, table_data);
			}
		});
		btnNewButton_2.setBounds(68, 394, 196, 23);
		frmGestionDeEstudiantes.getContentPane().add(btnNewButton_2);
	}
}
