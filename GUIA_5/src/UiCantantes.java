import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class UiCantantes {

	private JFrame frmCantantesFamosos;
	private JTextField nombre;
	private JTextField disco;
	private JTextField ventas;
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
		frmCantantesFamosos = new JFrame();
		frmCantantesFamosos.setTitle("CANTANTES FAMOSOS");
		frmCantantesFamosos.setBounds(100, 100, 819, 494);
		frmCantantesFamosos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCantantesFamosos.getContentPane().setLayout(null);
		
		nombre = new JTextField();
		nombre.setBounds(229, 77, 159, 20);
		frmCantantesFamosos.getContentPane().add(nombre);
		nombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setBounds(163, 80, 56, 14);
		frmCantantesFamosos.getContentPane().add(lblNewLabel);
		
		disco = new JTextField();
		disco.setBounds(229, 108, 159, 20);
		frmCantantesFamosos.getContentPane().add(disco);
		disco.setColumns(10);
		
		JLabel lblDisco = new JLabel("DISCO");
		lblDisco.setBounds(163, 111, 56, 14);
		frmCantantesFamosos.getContentPane().add(lblDisco);
		
		ventas = new JTextField();
		ventas.setBounds(229, 139, 159, 20);
		ventas.setColumns(10);
		frmCantantesFamosos.getContentPane().add(ventas);
		
		JLabel lblVentas = new JLabel("VENTAS");
		lblVentas.setBounds(163, 142, 56, 14);
		frmCantantesFamosos.getContentPane().add(lblVentas);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(410, 76, 79, 83);
		frmCantantesFamosos.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.setBounds(499, 76, 119, 38);
		frmCantantesFamosos.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Modificar");
		btnNewButton_1_1.setBounds(499, 120, 119, 38);
		frmCantantesFamosos.getContentPane().add(btnNewButton_1_1);
		
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
	}
}
