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

		String[] options = {"Izquierda", "Derecha"};
		int choice = JOptionPane.showOptionDialog(null, "Dónde desea agregar el nuevo nodo?", "Agregar Nodo",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		if (choice == 0) {
			add(root, data, true);
		} else {
			add(root, data, false);
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

	private Node<T> findNode(Node<T> currentNode, String nodeName) {
		if (currentNode == null) {
			return null;
		}

		if (currentNode.data.toString().equalsIgnoreCase(nodeName)) {
			return currentNode;
		}

		Node<T> leftResult = findNode(currentNode.left, nodeName);
		if (leftResult != null) {
			return leftResult;
		}

		Node<T> rightResult = findNode(currentNode.right, nodeName);
		return rightResult;
	} 

	public void inOrderTraversal(Node<T> node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.data + " ");
			inOrderTraversal(node.right);
		}
	}

	public void preOrderTraversal(Node<T> node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}

	public void postOrderTraversal(Node<T> node) {
		if (node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.data + " ");
		}
	}

	public int getDegree() {
		return getDegree(root);
	}

	private int getDegree(Node<T> node) {
		if (node == null) {
			return 0;
		}

		int leftDegree = getDegree(node.left);
		int rightDegree = getDegree(node.right);

		return Math.max(leftDegree, rightDegree) + 1;
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

	public void breadthFirstSearch() {
		if (root == null) {
			return;
		}

		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node<T> node = queue.poll();
			System.out.print(node.data + " ");

			if (node.left != null) {
				queue.add(node.left);
			}

			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}
}