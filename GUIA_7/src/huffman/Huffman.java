package huffman;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Un nodo de árbol

class Huffman {
	// Atraviesa el árbol de Huffman y almacena los códigos de Huffman en un mapa.
	public void encode(Node root, String str, Map<Character, String> huffmanCode) {
		if (root == null) {
			return;
		}

		// Encontré un nodo hoja
		if (isLeaf(root)) {
			huffmanCode.put(root.ch, str.length() > 0 ? str : "1");
		}

		encode(root.left, str + '0', huffmanCode);
		encode(root.right, str + '1', huffmanCode);
	}

	// Atraviesa el árbol de Huffman y decodifica la string codificada
	public int decode(Node root, int index, StringBuilder sb) {
		if (root == null) {
			return index;
		}

		// Encontré un nodo hoja
		if (isLeaf(root)) {
			System.out.print(root.ch);
			return index;
		}

		index++;

		root = (sb.charAt(index) == '0') ? root.left : root.right;
		index = decode(root, index, sb);
		return index;
	}

	// Función de utilidad para verificar si Huffman Tree contiene solo un solo nodo
	public boolean isLeaf(Node root) {
		return root.left == null && root.right == null;
	}

	// Construye Huffman Tree y decodifica el texto de entrada dado
	public String buildHuffmanTree(String text) {
		// Caso base: string vacía
		if (text == null || text.length() == 0) {
			return "";
		}

		// Contar la frecuencia de aparición de cada letra
		// y almacenarlo en un mapa

		Map<Character, Integer> freq = new HashMap<>();
		for (char c : text.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}

		// crea una cola de prioridad para almacenar nodos activos del árbol de Huffman.
		// Observe que el elemento de mayor prioridad tiene la frecuencia más baja

		PriorityQueue<Node> pq;
		pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.freq));

		// crea un nodo hoja para cada carácter y lo agrega
		// a la cola de prioridad.

		for (var entry : freq.entrySet()) {
			pq.add(new Node(entry.getKey(), entry.getValue()));
		}

		// hacer hasta que haya más de un nodo en la queue
		while (pq.size() != 1) {
			// Elimina los dos nodos de mayor prioridad
			// (la frecuencia más baja) de la queue

			Node left = pq.poll();
			Node right = pq.poll();

			// crea un nuevo nodo interno con estos dos nodos como hijos
			// y con una frecuencia igual a la suma de ambos nodos'
			// frecuencias. Agregue el nuevo nodo a la cola de prioridad.

			int sum = left.freq + right.freq;
			pq.add(new Node(null, sum, left, right));
		}

		// `root` almacena el puntero a la raíz de Huffman Tree
		Node root = pq.peek();

		// Atraviesa el árbol de Huffman y almacena los códigos de Huffman en un mapa
		Map<Character, String> huffmanCode = new HashMap<>();
		encode(root, "", huffmanCode);

		// Imprime los códigos de Huffman
		System.out.println("Huffman Codes are: " + huffmanCode);
		System.out.println("The original string is: " + text);

		// Imprimir string codificada
		StringBuilder sb = new StringBuilder();
		for (char c : text.toCharArray()) {
			sb.append(huffmanCode.get(c));
		}

		System.out.println("The encoded string is: " + sb);
		System.out.print("The decoded string is: ");

		if (isLeaf(root)) {
			// Caso especial: Para entradas como a, aa, aaa, etc.
			while (root.freq-- > 0) {
				System.out.print(root.ch);
			}
		} else {
			// Atraviesa el árbol Huffman de nuevo y esta vez,
			// decodifica la string codificada
			int index = -1;
			while (index < sb.length() - 1) {
				index = decode(root, index, sb);
			}
		}
		
		return sb.toString();
	}

	// Implementación del algoritmo de codificación de Huffman en Java
	public static void main(String[] args) {
		String text = "Hola";
		
		Huffman huffman = new Huffman(); 
		huffman.buildHuffmanTree(text);
	}
}
