package towerHanoi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

import javax.swing.table.DefaultTableModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

public class TowerHanoi { 
	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	
	Pila towerA;
	Pila towerB;
	Pila towerC; 
	
	DefaultTableModel ModelTableTowerA, ModelTableTowerB, ModelTableTowerC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TowerHanoi window = new TowerHanoi();
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
	public TowerHanoi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 767, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFocusable(false);
		scrollPane.setBounds(58, 58, 152, 225);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setFocusable(false);
		table.setAutoscrolls(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"TORRE 1"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFocusable(false);
		scrollPane_1.setBounds(303, 59, 155, 225);
		frame.getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setShowVerticalLines(false);
		table_1.setShowHorizontalLines(false);
		table_1.setAutoscrolls(false);
		table_1.setFocusable(false);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"TORRE 2"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setFocusable(false);
		scrollPane_2.setBounds(551, 58, 150, 226);
		frame.getContentPane().add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setShowHorizontalLines(false);
		table_2.setShowVerticalLines(false);
		table_2.setFocusable(false);
		table_2.setAutoscrolls(false);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"TORRE 3"
			}
		));
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblNewLabel = new JLabel("A");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(106, 24, 55, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblB = new JLabel("B");
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblB.setBounds(348, 24, 55, 26);
		frame.getContentPane().add(lblB);
		
		JLabel lblNewLabel_1_1 = new JLabel("C");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_1_1.setBounds(596, 24, 55, 26);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("B");
		btnNewButton.setBounds(61, 309, 66, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnC = new JButton("C");
		btnC.setBounds(141, 309, 66, 23);
		frame.getContentPane().add(btnC);
		
		JButton btnA = new JButton("A");
		btnA.setBounds(305, 309, 66, 23);
		frame.getContentPane().add(btnA);
		
		JButton btnC_1 = new JButton("C");
		btnC_1.setBounds(389, 309, 66, 23);
		frame.getContentPane().add(btnC_1);
		
		JButton btnA_1 = new JButton("A");
		btnA_1.setBounds(552, 309, 66, 23);
		frame.getContentPane().add(btnA_1);
		
		JButton btnB = new JButton("B");
		btnB.setBounds(633, 309, 66, 23);
		frame.getContentPane().add(btnB);
	}
}
