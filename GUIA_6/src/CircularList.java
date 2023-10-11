public class CircularList {
	public Node init;
	public Node end;
	int size;

	private void addInit(int value) {
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
		end.link = init.link;
		init = init.link;
	}

	public void remove() {
		allValidations();

		Node aux = init;

		while (aux.link != end) {
			aux = aux.link;
		}

		aux.link = end.link;
		end = aux;
	}

	public void remove(int index) {
		// int count = 0;
		allValidations(index);
		// Cuando el index es 0
		if (index == 0) {
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
		Node current = init;
		do {
			Node min = current;
			Node temp = current.link;

			do {
				if (temp.value < min.value) {
					min = temp;
				}
				temp = temp.link;
			} while (temp != init);

			int tempValue = current.value;
			current.value = min.value;
			min.value = tempValue;

			current = current.link;
		} while (current != init);

	}

	public String show() {
		String message = "";

		if (init != null) {
			Node aux = init;

			do {
//                System.out.println(aux.value + "");

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

	public Node getNode(int index) {
		int count = 0;
		Node aux = init;

		while (count != index) {
			aux = aux.link;
		}

		return aux;
	}

	private void allValidations() {
		// Validadicon de que exista elementos
		if (size() == 0) {
			throw new Error("la lista no tiene elementos para poder eliminar", null);
		}
	}

	private void allValidations(int index) {
		allValidations();
		// Validacion del size al realizar alguna operacion con index
		if (index >= size()) {
			throw new Error("index fuera de rango", null);
		}
	}
}