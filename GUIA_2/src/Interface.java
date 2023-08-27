import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Interface {

	private JFrame frame;
	private JTable MondayTable;
	private JButton btnSaveTemp;
	private JScrollPane scrollPane;
	private JTextField inputMinTemp;
	private JTextField inputMaxTemp;
	private JPanel Header;
	private JSeparator separator;
	private JLabel lblNewLabel;
	private JPanel Table_Tuesday;
	private JTable TuesdayTable;
	private JScrollPane scrollPane_1;
	private JLabel lblMartes;
	private JTable WednesdayTable;
	private JScrollPane scrollPane_2;
	private JPanel Table_Thursday;
	private JTable ThursdayTable;
	private JScrollPane scrollPane_3;
	private JPanel Table_Friday;
	private JLabel lblMiercoles;
	private JSeparator separator_2;
	private JTable FridayTable;
	private JLabel lblSabado;
	private JSeparator separator_3;
	private JPanel Table_Saturday;
	private JLabel lblSabado_1;
	private JSeparator separator_4;
	private JPanel Table_Sunday;
	private JTable SaturdayTable;
	private JScrollPane scrollPane_5;
	private JTable SundayTable;
	private JScrollPane scrollPane_6;
	private JButton btnNewButton_2;

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
	
	public void setValuesByIdday(ClimaApi clima, DefaultTableModel matriz, int day, int valueMin, int valueMax) { 
		if ((day) >= 0 && (day) < clima.daysOfWeek.size()) {
			
		} else {
			clima.setDays(day); 
		}

		clima.setTempsByIdOfDay(day, valueMin, valueMax); 
		matriz.setRowCount(clima.daysOfWeek.get(day).size()); 
		
		for (int i = 0; i < clima.daysOfWeek.get(day).size(); i++) {
			for (int j = 0; j < clima.daysOfWeek.get(day).get(i).size(); j++) {
				if (j == 0) {
					matriz.setValueAt(clima.daysOfWeek.get(day).get(i).get(j), i, j);
				}
				
				if (j == 1) { 
					matriz.setValueAt(clima.daysOfWeek.get(day).get(i).get(j), i, j);
				}
			}
		} 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ClimaApi clima = new ClimaApi();
		
		HashMap<String, Integer> selectDay = new HashMap<String, Integer>();
		
		for (int i = 0; i < clima.listNameDays.length; i++) {
			selectDay.put(clima.listNameDays[i], i);
		} 

		frame = new JFrame();
		frame.setBounds(100, 100, 743, 669);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Header = new JPanel();
		Header.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Header.setBounds(20, 11, 697, 68);
		frame.getContentPane().add(Header);
		Header.setLayout(null);
		
				JLabel lblTempMin = new JLabel("TEMPERATUIRA MINIMA");
				lblTempMin.setBounds(10, 9, 127, 14);
				Header.add(lblTempMin);
				
				inputMinTemp = new JTextField();
				inputMinTemp.setBounds(10, 34, 127, 20);
				Header.add(inputMinTemp);
				inputMinTemp.setColumns(10);
				
				inputMaxTemp = new JTextField();
				inputMaxTemp.setBounds(180, 34, 128, 20);
				Header.add(inputMaxTemp);
				inputMaxTemp.setColumns(10);
				
				JLabel lblTempMax = new JLabel("TEMPERATUIRA MAXIMA");
				lblTempMax.setBounds(181, 9, 127, 14);
				Header.add(lblTempMax);
				
				JLabel lblDayOfWeek = new JLabel("DIA DE LA SEMANA");
				lblDayOfWeek.setBounds(344, 9, 127, 14);
				Header.add(lblDayOfWeek);
				
				JComboBox comboBox = new JComboBox(); 
				comboBox.setBounds(344, 33, 96, 22);
				Header.add(comboBox);
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"}));
				
				btnSaveTemp = new JButton("Guardar");
				btnSaveTemp.setBounds(559, 9, 127, 43);
				Header.add(btnSaveTemp);
				
				separator = new JSeparator();
				separator.setBounds(20, 102, 316, 2);
				frame.getContentPane().add(separator);
				
				lblNewLabel = new JLabel("Lunes");
				lblNewLabel.setBounds(20, 90, 46, 14);
				frame.getContentPane().add(lblNewLabel);
				
				JPanel Table_Monday = new JPanel();
				Table_Monday.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				Table_Monday.setBounds(20, 113, 316, 96);
				frame.getContentPane().add(Table_Monday);
				Table_Monday.setLayout(null);
				
				scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 11, 293, 74);
				Table_Monday.add(scrollPane);
				
				MondayTable = new JTable();
				scrollPane.setViewportView(MondayTable);
				MondayTable.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"TEMPERATURA MINIMA", "TEMPERATURA MAXIMA"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, true
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				
				Table_Tuesday = new JPanel();
				Table_Tuesday.setLayout(null);
				Table_Tuesday.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				Table_Tuesday.setBounds(20, 245, 316, 96);
				frame.getContentPane().add(Table_Tuesday);
				
				scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(10, 11, 296, 72);
				Table_Tuesday.add(scrollPane_1);
				
				TuesdayTable = new JTable();
				TuesdayTable.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"TEMPERATURA MINIMA", "TEMPERATURA MAXIMA"
					}
				));
				scrollPane_1.setViewportView(TuesdayTable);
				
				lblMartes = new JLabel("Martes");
				lblMartes.setBounds(20, 220, 46, 14);
				frame.getContentPane().add(lblMartes);
				
				JSeparator separator_1 = new JSeparator();
				separator_1.setBounds(20, 233, 316, 2);
				frame.getContentPane().add(separator_1);
				
				JPanel Table_Wednesday = new JPanel();
				Table_Wednesday.setBounds(397, 113, 306, 96);
				frame.getContentPane().add(Table_Wednesday);
				Table_Wednesday.setLayout(null);
				
				scrollPane_2 = new JScrollPane();
				scrollPane_2.setBounds(10, 11, 286, 74);
				Table_Wednesday.add(scrollPane_2);
				
				WednesdayTable = new JTable();
				WednesdayTable.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"TEMPERATURA MINIMA", "TEMPERATURA MAXIMA"
					}
				));
				scrollPane_2.setViewportView(WednesdayTable);
				
				Table_Thursday = new JPanel();
				Table_Thursday.setBounds(397, 245, 306, 96);
				frame.getContentPane().add(Table_Thursday);
				Table_Thursday.setLayout(null);
				
				scrollPane_3 = new JScrollPane();
				scrollPane_3.setBounds(12, 11, 284, 74);
				Table_Thursday.add(scrollPane_3);
				
				ThursdayTable = new JTable();
				ThursdayTable.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"TEMPERATURA MINIMA", "TEMPERATURA MAXIMA"
					}
				));
				scrollPane_3.setViewportView(ThursdayTable);
				
				Table_Friday = new JPanel();
				Table_Friday.setLayout(null);
				Table_Friday.setBounds(20, 380, 316, 96);
				frame.getContentPane().add(Table_Friday);
				
				JScrollPane scrollPane_4 = new JScrollPane();
				scrollPane_4.setBounds(10, 11, 296, 74);
				Table_Friday.add(scrollPane_4);
				
				FridayTable = new JTable();
				FridayTable.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"TEMPERATURA MINIMA", "TEMPERATURA MAXIMA"
					}
				));
				scrollPane_4.setViewportView(FridayTable);
				
				lblMiercoles = new JLabel("Miercoles");
				lblMiercoles.setBounds(397, 90, 46, 14);
				frame.getContentPane().add(lblMiercoles);
				
				separator_2 = new JSeparator();
				separator_2.setBounds(397, 102, 316, 2);
				frame.getContentPane().add(separator_2);
				
				JLabel lblJueves = new JLabel("Jueves");
				lblJueves.setBounds(397, 220, 46, 14);
				frame.getContentPane().add(lblJueves);
				
				JSeparator separator_1_1 = new JSeparator();
				separator_1_1.setBounds(397, 233, 316, 2);
				frame.getContentPane().add(separator_1_1);
				
				JLabel lblViernes = new JLabel("Viernes");
				lblViernes.setBounds(20, 354, 46, 14);
				frame.getContentPane().add(lblViernes);
				
				JSeparator separator_1_2 = new JSeparator();
				separator_1_2.setBounds(20, 367, 316, 2);
				frame.getContentPane().add(separator_1_2);
				
				lblSabado = new JLabel("Sabado");
				lblSabado.setBounds(397, 353, 46, 14);
				frame.getContentPane().add(lblSabado);
				
				separator_3 = new JSeparator();
				separator_3.setBounds(397, 366, 316, 2);
				frame.getContentPane().add(separator_3);
				
				Table_Saturday = new JPanel();
				Table_Saturday.setLayout(null);
				Table_Saturday.setBounds(397, 380, 316, 96);
				frame.getContentPane().add(Table_Saturday);
				
				scrollPane_5 = new JScrollPane();
				scrollPane_5.setBounds(10, 11, 296, 74);
				Table_Saturday.add(scrollPane_5);
				
				SaturdayTable = new JTable();
				SaturdayTable.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"TEMPERATURA MINIMA", "TEMPERATURA MAXIMA"
					}
				));
				scrollPane_5.setViewportView(SaturdayTable);
				
				lblSabado_1 = new JLabel("Domingo");
				lblSabado_1.setBounds(20, 494, 46, 14);
				frame.getContentPane().add(lblSabado_1);
				
				separator_4 = new JSeparator();
				separator_4.setBounds(20, 507, 316, 2);
				frame.getContentPane().add(separator_4);
				
				Table_Sunday = new JPanel();
				Table_Sunday.setLayout(null);
				Table_Sunday.setBounds(20, 519, 316, 96);
				frame.getContentPane().add(Table_Sunday);
				
				scrollPane_6 = new JScrollPane();
				scrollPane_6.setBounds(10, 11, 296, 74);
				Table_Sunday.add(scrollPane_6);
				
				SundayTable = new JTable();
				SundayTable.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"TEMPERATURA MINIMA", "TEMPERATURA MAXIMA"
					}
				));
				scrollPane_6.setViewportView(SundayTable);
				
				JButton showDays = new JButton("VER LISTADO DE DIAS CON SU TEMPERATURA");
				showDays.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clima.getTempsAllDays();
					}
				});
				showDays.setBounds(376, 494, 341, 23);
				frame.getContentPane().add(showDays);
				
				JButton showProm = new JButton("OBTENER MEDIAS MAXIMAS Y MINIMAS DE CADA DIA");
				showProm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clima.getPromTemp();
					}
				});
				showProm.setBounds(376, 524, 341, 23);
				frame.getContentPane().add(showProm);
				
				JButton btnNewButton_1 = new JButton("DIAS CUYAS TEMPERATUAS MIN ESTEN POR DEBAJO DE 0 C");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clima.showDaysByMinTemp();
					}
				});
				btnNewButton_1.setBounds(376, 553, 341, 33);
				frame.getContentPane().add(btnNewButton_1);
				
				btnNewButton_2 = new JButton("DIAS CUYAS TEMPERATURAS MAXIMAS ESTEN ENTRE 15 Y 20 C");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clima.showDaysByMaxTemp();
					}
				});
				btnNewButton_2.setBounds(376, 589, 341, 30);
				frame.getContentPane().add(btnNewButton_2);
				btnSaveTemp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						DefaultTableModel mondayMatriz = (DefaultTableModel) MondayTable.getModel();
						DefaultTableModel tuesdayMatriz = (DefaultTableModel) TuesdayTable.getModel();
						DefaultTableModel wednesdayMatriz = (DefaultTableModel) WednesdayTable.getModel();
						DefaultTableModel thursdayMatriz = (DefaultTableModel) ThursdayTable.getModel();
						DefaultTableModel fridayMatriz = (DefaultTableModel) FridayTable.getModel();
						DefaultTableModel saturdayMatriz = (DefaultTableModel) SaturdayTable.getModel();
						DefaultTableModel sundayMatriz = (DefaultTableModel) SundayTable.getModel();
						
						int valueMin = Integer.parseInt(inputMinTemp.getText()); 
						int valueMax = Integer.parseInt(inputMaxTemp.getText()); 
						String valueBox = (String) comboBox.getSelectedItem();

						int day = selectDay.get(valueBox); 
						
//						setValuesByIdday(clima, mondayMatriz, day, valueMin, valueMax);
						if ((40 >= valueMin && valueMin>= -40) && (valueMax <= 40 && valueMax >= -40)) {
							if (valueMax >= valueMin) {
								
								if (day == 0) {
									setValuesByIdday(clima, mondayMatriz, day, valueMin, valueMax);
								}
								
								if (day == 1) { 
									setValuesByIdday(clima, tuesdayMatriz, day, valueMin, valueMax);
								}
								
								if (day == 2) { 
									setValuesByIdday(clima, wednesdayMatriz, day, valueMin, valueMax);
								}
								
								if (day == 3) { 
									setValuesByIdday(clima, thursdayMatriz, day, valueMin, valueMax); 
								}
								
								if (day == 4) { 
									setValuesByIdday(clima, fridayMatriz, day, valueMin, valueMax); 
								}
								
								if (day == 5) { 
									setValuesByIdday(clima, saturdayMatriz, day, valueMin, valueMax); 
								}
								
								if (day == 6) { 
									setValuesByIdday(clima, sundayMatriz, day, valueMin, valueMax);
								}
							} else {
								JOptionPane.showMessageDialog(null, "La temperatura maxima no puede ser menor a la temperatura minima, verifique los datos", "Error", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "La temperatura minima no puede ser menor a -40 y la maxima no puede ser mayor a 40, verifique los datos", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						inputMinTemp.setText("");
						inputMaxTemp.setText(""); 
					}
				});
	}
}
