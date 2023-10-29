package tree;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Seleccione el tipo de datos para el árbol (1 - Números, 2 - Letras): ");
		int choice = 1;

		if (choice != 1 && choice != 2) {
            System.out.println("Selección no válida."); 
        } else {
        	if (choice == 1) {
        		BinaryTree<Integer> tree = new BinaryTree<Integer>();
        		tree.insert(23);
        		tree.insert(25);
        		tree.insert(34);
        		tree.insert(27);
        		tree.insert(12);

        		tree.inOrderTraversal(tree.root);
        	}
        	
        	if (choice == 2) {
        		BinaryTree<String> tree = new BinaryTree<String>();
        		tree.insert("Jaime");
        		tree.inOrderTraversal(tree.root);
        	}
        }
//		System.out.println(tree.root.childLeft.childLeft.value);
//		System.out.println(tree.root.childLeft.childRight.value);
	}
}
