package huffman;

import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HuffmanUi extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	Huffman huffman = new Huffman();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HuffmanUi frame = new HuffmanUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HuffmanUi() {
		setTitle("Codificacion de Huffman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(32, 63, 320, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Texto");
		lblNewLabel.setBounds(32, 36, 46, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(32, 159, 320, 65);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("CODIFICAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				String message = textField.getText();
				
				try {
					Integer.parseInt(message);
					
					JOptionPane.showMessageDialog(contentPane, "El valor ingresado es numerico, solo puede ser texto", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					// TODO: handle exception
					textArea.setText(huffman.buildHuffmanTree(message));
				}
			}
		});
		btnNewButton.setBounds(109, 111, 154, 23);
		contentPane.add(btnNewButton);
	}
}
