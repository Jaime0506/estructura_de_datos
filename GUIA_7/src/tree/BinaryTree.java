package tree;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

class BinaryTree<T extends Comparable<T>> {
	Node<T> root;

	public BinaryTree() {
		root = null;
	}

	public void add(T data) {
		if (root == null) {
			root = new Node<>(data);
			return;
		}

		if (!breadthFirstSearch(data)) {
			String[] options = { "Izquierda", "Derecha" };
			int choice = JOptionPane.showOptionDialog(null, "Dónde desea agregar el nuevo nodo?", "Agregar Nodo",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			if (choice == 0) {
				add(root, data, true);
			} else {
				add(root, data, false);
			}

		} else {
			JOptionPane.showMessageDialog(null, "El nodo a insertar ya existe dentro del arbol");
		}
	}

	private void add(Node<T> currentNode, T data, boolean isLeft) {
		if (isLeft) {
			if (currentNode.left == null) {
				currentNode.left = new Node<>(data);
			} else {
				String[] subOptions = { "Izquierda", "Derecha" };
				int subChoice = JOptionPane.showOptionDialog(null, "Dónde desea agregar el nuevo nodo en la izquierda?",
						"Agregar Nodo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, subOptions,
						subOptions[0]);

				if (subChoice == 0) {
					add(currentNode.left, data, true);
				} else {
					add(currentNode.left, data, false);
				}
			}
		} else {
			if (currentNode.right == null) {
				currentNode.right = new Node<>(data);
			} else {
				String[] subOptions = { "Izquierda", "Derecha" };
				int subChoice = JOptionPane.showOptionDialog(null, "Dónde desea agregar el nuevo nodo en la derecha?",
						"Agregar Nodo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, subOptions,
						subOptions[0]);

				if (subChoice == 0) {
					add(currentNode.right, data, true);
				} else {
					add(currentNode.right, data, false);
				}
			}
		}
	}

	public void deleteNode(T data) {
		root = deleteNode(root, data);
	}

	private Node<T> deleteNode(Node<T> root, T data) {
		if (root == null) {
			return root; // El árbol está vacío o el nodo no se encontró
		}

		// Buscar el nodo que se debe eliminar
		if (data.equals(root.data)) {
			// Caso 1: Nodo sin hijos
			if (root.left == null && root.right == null) {
				return null;
			}
			// Caso 2: Nodo con un hijo
			if (root.left == null) {
				return root.right;
			}
			if (root.right == null) {
				return root.left;
			}
			// Caso 3: Nodo con dos hijos
			T minValue = findMinValue(root.right);
			root.data = minValue;
			root.right = deleteNode(root.right, minValue);

		} else {
			root.left = deleteNode(root.left, data);
			root.right = deleteNode(root.right, data);
		}

		return root;
	}

	private T findMinValue(Node<T> node) {
		T minValue = node.data;
		while (node.left != null) {
			minValue = node.left.data;
			node = node.left;
		}
		return minValue;
	}

	public String in_order() {
		StringBuilder message = new StringBuilder();
		in_order(root, message);

		return message.toString();
	}

	private void in_order(Node<T> node, StringBuilder message) {
		if (node != null) {
			in_order(node.left, message);
			message.append(node.data).append("->");
			in_order(node.right, message);
		}
	}

	public String pre_order() {
		StringBuilder message = new StringBuilder();
		pre_order(root, message);

		return message.toString();
	}

	private void pre_order(Node<T> node, StringBuilder message) {
		if (node != null) {
			message.append(node.data).append("->");
			pre_order(node.left, message);
			pre_order(node.right, message);
		}
	}

	public String post_order() {
		StringBuilder message = new StringBuilder();
		post_order(root, message);

		return message.toString();
	}

	public void post_order(Node<T> node, StringBuilder message) {
		if (node != null) {
			post_order(node.left, message);
			post_order(node.right, message);
			message.append(node.data).append("->");
		}
	}

	public int getDegree() {
		return getDegree(root);
	}

	private int getDegree(Node<T> node) {
		if (node == null) {
            return 0;
        }

        // Verificamos el número de hijos del nodo actual.
        int gradoNodo = 0;

        if (node.left != null) {
            gradoNodo++;
        }
        if (node.right != null) {
            gradoNodo++;
        }

        // Llamamos recursivamente a los hijos izquierdo y derecho.
        int gradoIzquierdo = getDegree(node.left);
        int gradoDerecho = getDegree(node.right);

        // El grado del nodo actual es el máximo entre su propio grado y el grado de sus hijos.
        return Math.max(gradoNodo, Math.max(gradoIzquierdo, gradoDerecho));
	}

	public int getLevel(T data) {
		return getLevel(root, data, 0);
	}

	private int getLevel(Node<T> node, T data, int level) {
		if (node == null) {
			return -1;
		}

		if (node.data.equals(data)) {
			return level;
		}

		int leftLevel = getLevel(node.left, data, level + 1);
		if (leftLevel != -1) {
			return leftLevel;
		}

		int rightLevel = getLevel(node.right, data, level + 1);
		return rightLevel;
	}

	public int getHeight() {
		return getHeight(root);
	}

	private int getHeight(Node<T> node) {
		if (node == null) {
			return 0;
		}

		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);

		return Math.max(leftHeight, rightHeight) + 1;
	}

	public boolean breadthFirstSearch(T data) {
		if (root != null) {
			Queue<Node<T>> cola = new LinkedList<>();
			cola.add(root);

			while (!cola.isEmpty()) {
				Node<T> node = cola.poll();

				if (node.data.equals(data)) {
					return true;
				}

				if (node.left != null) {
					cola.add(node.left);
				}

				if (node.right != null) {
					cola.add(node.right);
				}
			}
		}

		return false;
	}
}