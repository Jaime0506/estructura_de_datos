import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CircularList {
	public Node init;
	public Node end;
	int size;

	Scanner sc = new Scanner(System.in);

	public void addInit(int value) {
		if (init == null) {
			init = new Node(value);
			init.link = init;
			end = init;
		} else {
			Node temp = new Node(value);
			Node auxInit = init;

			init = temp;
			init.link = auxInit;
			end.link = init;
		}
	}

	public void add(int value) {
		if (init == null) {
			init = new Node(value);
			init.link = init;
			end = init;
		} else {
			Node temp = new Node(value);
			Node aux = init;

			while (aux.link != init) {
				aux = aux.link;
			}

			aux.link = temp;
			temp.link = init;
			end = temp;
		}
	}

	public void add(int index, int value) {

		allValidations(index);

		int count = 0;

		Node temp = new Node(value);
		Node aux = init;

		if (index == 0) {
			addInit(value);
		} else {

			while (count != index - 1) {
				count++;
				aux = aux.link;
			}

			temp.link = aux.link;
			aux.link = temp;
		}

	}

	private void removeInit() {
		if (size() == 1) {
			init = null;
		} else {
			end.link = init.link;
			init = init.link;
		}

	}

	public void remove() {
		allValidations();

		if (size() == 1) {
			init = null;
		} else {
			Node aux = init;

			while (aux.link != end) {
				aux = aux.link;
			}

			aux.link = end.link;
			end = aux;
		}

	}

	public void remove(int index) {
		// int count = 0;
		allValidations(index);

		// Caso especial
		if (size() == 1) {
			init = null; 
		} else if (index == 0) {
			removeInit();
		} else {
			
			int count = 0;
			Node aux = init;

			while (count != index - 1) {
				count++;
				aux = aux.link;
			}

			aux.link = aux.link.link;
		}
	}

	public void order() {
		// Burbuja
		Node current = init;
		boolean flag = false;

		do {
			flag = false;

			for (int i = 0; i < size() - 1; i++) {
				Node next = current.link;

				if (current.value > next.value) {
					flag = true;
					Node temp = new Node(current.value);

					current.value = next.value;
					next.value = temp.value;
				}
				current = current.link;
			}
			current = init;
		} while (flag);

		show();
	}

	public void update(int index, int value) {
		allValidations(index);

		Node current = getNode(index);
		current.value = value;
	}

	public String show() {
		String message = "";

		if (init != null) {
			Node aux = init;

			do {
				if (aux == end) {
					message += aux.value;
				} else {
					message += aux.value + " -> ";
				}
				aux = aux.link;
			} while (aux != init);
		}

		System.out.println(message);
		return message;
	}

	public int size() {
		int count = 0;

		if (init != null) {
			Node aux = init;

			do {
				count++;
				aux = aux.link;
			} while (aux != init);
		}

		return count;
	}

	public Node getNodeByIndex(int index) {
		Node response = getNode(index);

		if (response != null) {
			System.out.println("El nodo fue encontrado en la posicion " + index);
		} else {
			System.out.println("No existe ningun nodo en la posicion " + index);
		}

		return response;
	}

	public Node getNodeByValue(int value) {
		Node aux = init;
		int count = 0;

		do {
			if (aux.value == value) {
				System.out.println("Se encontro el nodo en la posicion " + count);
				return aux;
			}
			count++;
			aux = aux.link;
		} while (aux != init);

		System.out.println("No se encontro el nodo con valor de " + value);
		return null;
	}

	private Node getNode(int index) {
		int count = 0;
		Node aux = init;

		if (index < size()) {

			while (count != index) {
				aux = aux.link;
				count++;
			}

			return aux;
		}

		return null;
	}

	public void setTextUi(JTextField text) {
		text.setText("");
		text.setText(show());
	}

	private void allValidations() {
		// Validadicon de que exista elementos
		if (size() == 0) {
			JOptionPane.showMessageDialog(null, "La lista no tiene elementos", "Error", JOptionPane.ERROR_MESSAGE);
			throw new Error("la lista no tiene elementos", null);
		}
	}

	private void allValidations(int index) {
		allValidations();
		// Validacion del size al realizar alguna operacion con index
		if (index >= size()) {
			JOptionPane.showMessageDialog(null, "Index fuera de rango", "Error", JOptionPane.ERROR_MESSAGE);
			throw new Error("index fuera de rango", null);
		}
	}
}