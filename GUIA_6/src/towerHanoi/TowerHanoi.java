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

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip; 

public class TowerHanoi {
	private JFrame frame;
	private JTable tableTowerA;
	private JTable tableTowerB;
	private JTable tableTowerC;
	private JTextField textFieldMinMoves;
	private JTextField textFieldMoves;
	private JComboBox<String[]> comboBox;
	
	AudioInputStream audioInputStream;

	Pila towerA;
	Pila towerB;
	Pila towerC;

	DefaultTableModel ModelTableTowerA, ModelTableTowerB, ModelTableTowerC;

	int numberOfMoves, objetivo;
	String numberMinOfMoves;
	boolean stop = false;

	final ImageIcon icon = new ImageIcon(getClass().getResource("check.png"));
	String path = "effect.wav";
	
	private void startSound() { 
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File("effect.wav").getAbsoluteFile());
			
		    Clip clip = AudioSystem.getClip();
		    clip.open(audioInputStream);
		    clip.start();
			
		} catch (Exception e) {
			// TODO: handle excepti
			System.out.println(e);
		}
	}
	

	private Pila selectTower(String tower) {
		if (tower == "A") {
			return towerA;
		}

		if (tower == "B") {
			return towerB;
		}

		if (tower == "C") {
			return towerC;
		}

		return null;
	}

	private void resetGame() {
		// Validar de que el juego este iniciado para reiniciar
		startGame();
	}

	private int getNumberOfTowers() {
		return Integer.parseInt(String.valueOf(comboBox.getSelectedItem()));
	}

	private void moved() {
		startSound();
		numberOfMoves++;
		textFieldMoves.setText(String.valueOf(numberOfMoves));
	}

	private void setTowerA() {
		((DefaultTableModel) tableTowerA.getModel()).setRowCount(0);
		ModelTableTowerA.setRowCount(10);

		int rowDisco = (10 - towerA.size());
		Node temp; 

		if (towerA.size() > 0) {
			for (temp = towerA.peek(); temp.getDown() != null; temp = temp.getDown()) {
				ModelTableTowerA.setValueAt(temp.getPlato(), rowDisco, 0);
				rowDisco++;
			}

			if (temp.getDown() == null) {
				ModelTableTowerA.setValueAt(temp.getPlato(), rowDisco, 0);
			}
		}
	}

	private void setTowerB() {
		((DefaultTableModel) tableTowerB.getModel()).setRowCount(0);
		ModelTableTowerB.setRowCount(10);

		int rowDisco = (10 - towerB.size());
		Node temp; 

		if (towerB.size() > 0) {
			for (temp = towerB.peek(); temp.getDown() != null; temp = temp.getDown()) {
				ModelTableTowerB.setValueAt(temp.getPlato(), rowDisco, 0);
				rowDisco++;
			}

			if (temp.getDown() == null) {
				ModelTableTowerB.setValueAt(temp.getPlato(), rowDisco, 0);
			}
		}
	}

	private void setTowerC() {
		((DefaultTableModel) tableTowerC.getModel()).setRowCount(0);
		ModelTableTowerC.setRowCount(10);

		int rowDisco = (10 - towerC.size());
		Node temp;

		if (towerC.size() > 0) {
			for (temp = towerC.peek(); temp.getDown() != null; temp = temp.getDown()) {
				ModelTableTowerC.setValueAt(temp.getPlato(), rowDisco, 0);
				rowDisco++;
			}

			if (temp.getDown() == null) {
				ModelTableTowerC.setValueAt(temp.getPlato(), rowDisco, 0);
			}
		}
	}

	private void setTowers() {
		setTowerA();
		setTowerB();
		setTowerC();
	}

	private void moveDisc(String currentTower, String nextTower) {

		Pila current = selectTower(currentTower);
		Pila next = selectTower(nextTower);

		if (current.size() > 0) {

			if (next.peek() != null) {
				
				if (next.peek().getPlato().length() > current.peek().getPlato().length()) {
					Node temp = current.peek();
					current.pop();
					next.push(temp.getPlato());

					moved();
				}
			} else {
				Node temp = current.peek();
				current.pop();
				next.push(temp.getPlato());

				moved();
			}
		}

		setTowers();
		checkWin();
	}

	public void checkWin() {
		if (towerC.size() == objetivo) {
			// Significa que pude mover todos los discos a C, osea termine el juego

			if (numberOfMoves > Integer.parseInt(numberMinOfMoves)) {
				// Se paso de los movimientos minimos
				JOptionPane.showMessageDialog(frame,
						"Felicidades Terminaste el juego aunque trata de mejorar los movimientos minimos",
						"Fin del juego", 1, icon);
			} else {
				JOptionPane.showMessageDialog(frame, "Felicidades Terminaste el juego", "Fin del juego", 1, icon);
			}
			// Necesito verificar si lo hizo en los movimientos minimos o se paso

		}
	}

	private void startGame() {
		towerA = new Pila();
		towerB = new Pila();
		towerC = new Pila();

		// Cantidad de discos de la torre
		objetivo = getNumberOfTowers();
		numberMinOfMoves = String.valueOf(String.format("%.0f", Math.pow(2, objetivo) - 1));

		String disco = "";
		numberOfMoves = 0;
		
		for (int x = objetivo; x >= 1; x--) {
			for (int y = x; y > 0; y--) {
				disco += "#";
			}
			towerA.push(disco);
			disco = "";
		}

		textFieldMinMoves.setText(numberMinOfMoves);
		textFieldMoves.setText("" + numberOfMoves);

		setTowers();
	}

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 767, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFocusable(false);
		scrollPane.setBounds(58, 58, 152, 186);
		frame.getContentPane().add(scrollPane);

		tableTowerA = new JTable();
		tableTowerA.setShowVerticalLines(false);
		tableTowerA.setShowHorizontalLines(false);
		tableTowerA.setFocusable(false);
		tableTowerA.setAutoscrolls(false);
		tableTowerA.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "TORRE 1" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableTowerA.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(tableTowerA);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFocusable(false);
		scrollPane_1.setBounds(303, 59, 155, 186);
		frame.getContentPane().add(scrollPane_1);

		tableTowerB = new JTable();
		tableTowerB.setShowVerticalLines(false);
		tableTowerB.setShowHorizontalLines(false);
		tableTowerB.setAutoscrolls(false);
		tableTowerB.setFocusable(false);
		tableTowerB.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "TORRE 2" }));
		scrollPane_1.setViewportView(tableTowerB);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setFocusable(false);
		scrollPane_2.setBounds(551, 58, 150, 186);
		frame.getContentPane().add(scrollPane_2);

		tableTowerC = new JTable();
		tableTowerC.setShowHorizontalLines(false);
		tableTowerC.setShowVerticalLines(false);
		tableTowerC.setFocusable(false);
		tableTowerC.setAutoscrolls(false);
		tableTowerC.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "TORRE 3" }));
		scrollPane_2.setViewportView(tableTowerC);

		ModelTableTowerA = (DefaultTableModel) tableTowerA.getModel();
		ModelTableTowerB = (DefaultTableModel) tableTowerB.getModel();
		ModelTableTowerC = (DefaultTableModel) tableTowerC.getModel();

		// Maximo 10 rows va a tener la tabla
		ModelTableTowerA.setRowCount(10);
		ModelTableTowerB.setRowCount(10);
		ModelTableTowerC.setRowCount(10);

		// Este metodo nos permite renderizar nuestras tablas con la propiedad de que su
		// contenido este centrado
		DefaultTableCellRenderer renderA = new DefaultTableCellRenderer();
		DefaultTableCellRenderer renderC = new DefaultTableCellRenderer();
		DefaultTableCellRenderer renderB = new DefaultTableCellRenderer();

		renderA.setHorizontalAlignment(SwingConstants.CENTER);
		renderB.setHorizontalAlignment(SwingConstants.CENTER);
		renderC.setHorizontalAlignment(SwingConstants.CENTER);

		// Tenemos que aplicar el metodo CellRender a nuestros modelos de tablas
		// para que estos se encarguen de renderizarlo con los estilos que aplicamos
		tableTowerA.getColumnModel().getColumn(0).setCellRenderer(renderA);
		tableTowerB.getColumnModel().getColumn(0).setCellRenderer(renderB);
		tableTowerC.getColumnModel().getColumn(0).setCellRenderer(renderC);

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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveDisc("A", "B");
			}
		});
		btnNewButton.setBounds(58, 255, 66, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveDisc("A", "C");
			}
		});
		btnC.setBounds(144, 255, 66, 23);
		frame.getContentPane().add(btnC);

		JButton btnA = new JButton("A");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveDisc("B", "A");
			}
		});
		btnA.setBounds(303, 256, 66, 23);
		frame.getContentPane().add(btnA);

		JButton btnC_1 = new JButton("C");
		btnC_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveDisc("B", "C");
			}
		});
		btnC_1.setBounds(389, 256, 66, 23);
		frame.getContentPane().add(btnC_1);

		JButton btnA_1 = new JButton("A");
		btnA_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveDisc("C", "A");
			}
		});
		btnA_1.setBounds(551, 255, 66, 23);
		frame.getContentPane().add(btnA_1);

		JButton btnB = new JButton("B");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveDisc("C", "B");
			}
		});
		btnB.setBounds(635, 255, 66, 23);
		frame.getContentPane().add(btnB);

		JButton btnStart = new JButton("EMPEZAR JUEGO");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGame();
			}
		});
		btnStart.setBounds(206, 421, 163, 23);
		frame.getContentPane().add(btnStart);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "3", "4", "5", "6", "7", "8", "9", "10" }));
		comboBox.setBounds(389, 309, 154, 22);
		frame.getContentPane().add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("NUMERO DE PLATOS");
		lblNewLabel_1.setBounds(245, 309, 124, 23);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_2 = new JLabel("NUMERO MIN DE MOVIMIENTOS");
		lblNewLabel_1_2.setBounds(184, 343, 179, 23);
		frame.getContentPane().add(lblNewLabel_1_2);

		textFieldMinMoves = new JTextField();
		textFieldMinMoves.setEditable(false);
		textFieldMinMoves.setBounds(389, 344, 154, 20);
		frame.getContentPane().add(textFieldMinMoves);
		textFieldMinMoves.setColumns(10);

		textFieldMoves = new JTextField();
		textFieldMoves.setEditable(false);
		textFieldMoves.setBounds(389, 375, 154, 20);
		frame.getContentPane().add(textFieldMoves);
		textFieldMoves.setColumns(10);

		JLabel lblNewLabel_1_2_1 = new JLabel("NUMERO DE MOVIMIENTOS");
		lblNewLabel_1_2_1.setBounds(206, 374, 163, 23);
		frame.getContentPane().add(lblNewLabel_1_2_1);

		JButton btnNewButton_1 = new JButton("REINICIAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetGame();
			}
		});
		btnNewButton_1.setBounds(389, 421, 154, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
