import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;

public class CineUI {

	private JFrame frmCinemax;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CineUI window = new CineUI();
					window.frmCinemax.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CineUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "unchecked", "unchecked" })
	private void initialize() {
		Cine app = new Cine();

		JComboBox comboBox = new JComboBox();; 
		JPanel panel_table = new JPanel();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"PELICULA", "NUMERO DE PERSONAS"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		table.getColumnModel().getColumn(1).setResizable(false); 

		frmCinemax = new JFrame();
		frmCinemax.setTitle("Cinemax🎥");
		frmCinemax.setBounds(100, 100, 842, 483);
		frmCinemax.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCinemax.getContentPane().setLayout(null);

		JPanel panel_movies = new JPanel();
		panel_movies.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_movies.setBounds(10, 11, 285, 424);
		frmCinemax.getContentPane().add(panel_movies);
		panel_movies.setLayout(null);

		JLabel lblNewLabel = new JLabel("CARTELERA DEL DIA DE HOY");
		lblNewLabel.setBounds(66, 11, 163, 14);
		panel_movies.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 265, 2);
		panel_movies.add(separator); 

		JList txtMovies = new JList();
		txtMovies.setBounds(20, 49, 241, 353);
		panel_movies.add(txtMovies);
		txtMovies.setVisibleRowCount(100);

		txtMovies.setModel(new AbstractListModel() {
			String[] values = app.nameMovies;

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JPanel panel_info = new JPanel();
		panel_info.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_info.setBounds(305, 362, 511, 71);
		frmCinemax.getContentPane().add(panel_info);
		panel_info.setLayout(null);
		
		JLabel lblMostViewedMovieInTheRoom = new JLabel("");
		lblMostViewedMovieInTheRoom.setBounds(0, 18, 491, 14);
		panel_info.add(lblMostViewedMovieInTheRoom);
		
		JLabel lblMostViewedMoviedInTheCinema = new JLabel("");
		lblMostViewedMoviedInTheCinema.setBounds(0, 54, 511, 14);
		panel_info.add(lblMostViewedMoviedInTheCinema);
		
		JLabel lblPeopleWhoVisitedTheRoom = new JLabel("");
		lblPeopleWhoVisitedTheRoom.setBounds(0, 37, 511, 14);
		panel_info.add(lblPeopleWhoVisitedTheRoom);
		
		JLabel lblPeopleWhoVisitedTheCinema = new JLabel("");
		lblPeopleWhoVisitedTheCinema.setBounds(0, 0, 501, 14);
		panel_info.add(lblPeopleWhoVisitedTheCinema);
		
		JPanel panel_buttons = new JPanel();
		panel_buttons.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_buttons.setBounds(305, 11, 511, 116);
		frmCinemax.getContentPane().add(panel_buttons);
		panel_buttons.setLayout(null);
		
		JButton btnMejorCombinacion = new JButton("MEJOR COMBINACION");
		btnMejorCombinacion.setEnabled(false);
		btnMejorCombinacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = "Mejor combinacion Sala-Pelicula \n";
				String movie = app.mostViewedMovieInTheCinema();
				String sala = app.mostVisitedRoom(); 
				
				message += "Sala " + sala + "-" + movie;
				
				JOptionPane.showMessageDialog(frmCinemax, message);
			}
		});
		btnMejorCombinacion.setBounds(21, 62, 186, 39);
		panel_buttons.add(btnMejorCombinacion);
		
		JButton btnPeliculaMasVista = new JButton("OPTENER INFORMACION");
		btnPeliculaMasVista.setEnabled(false);
		btnPeliculaMasVista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int salaId = comboBox.getSelectedIndex();
				
				String movieForCinema = "Pelicula mas vista en el Cine: '" + app.mostViewedMovieInTheCinema() + "'";
				String movieForRoom = "Pelicula mas vista en la sala " + (salaId + 1) + ": '" + app.mostViewedMovieInTheRoom(salaId) + "'";
				
				String totalVisitorsInTheRoom = "Total de visitantes en la sala " + (salaId + 1)  + ": " + app.showTotalViewsForSala(salaId);
				String totalVisitorsInTheCiname = "Total de visitantes al Cine: " + app.showTotalViews();
				
				lblMostViewedMoviedInTheCinema.setText(movieForCinema); 
				lblMostViewedMovieInTheRoom.setText(movieForRoom);
				lblPeopleWhoVisitedTheRoom.setText(totalVisitorsInTheRoom);
				lblPeopleWhoVisitedTheCinema.setText(totalVisitorsInTheCiname);
			}
		});
		btnPeliculaMasVista.setBounds(227, 11, 186, 40);
		panel_buttons.add(btnPeliculaMasVista);
		JButton btnNewButton = new JButton("GENERAR REGISTROS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setEnabled(true);
				btnMejorCombinacion.setEnabled(true);
				btnPeliculaMasVista.setEnabled(true); 
				
				app.setData();
			}
		});
		btnNewButton.setBounds(21, 11, 186, 40);
		panel_buttons.add(btnNewButton);
		
		
		comboBox.setEnabled(false); 
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				int value = comboBox.getSelectedIndex(); 
				
				if (value >= 0) {
					System.out.println("Procedo a rellenar la tabla");
					app.showTotalViewsForSala(value);
					
					DefaultTableModel tableMovies = (DefaultTableModel) table.getModel(); 
					
					tableMovies.setRowCount(15);
					
					for (int i = 0; i < app.salas.get(value).length; i++) {
						for (int j = 0; j < 2; j++) {
							if (j == 0) {
								tableMovies.setValueAt(app.salas.get(value)[i].getMovie(), i, j);
							}
							
							if (j == 1) {
								tableMovies.setValueAt(app.salas.get(value)[i].getVies(), i, j); 
							}
						}
					}
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sala 1", "Sala 2", "Sala 3", "Sala 4", "Sala 5", "Sala 6", "Sala 7"}));
		comboBox.setBounds(227, 62, 186, 37);
		panel_buttons.add(comboBox);
		
		panel_table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_table.setBounds(305, 138, 511, 213);
		frmCinemax.getContentPane().add(panel_table);
		panel_table.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 491, 191);
		panel_table.add(scrollPane);
		
		scrollPane.setViewportView(table);
		
	}
}
