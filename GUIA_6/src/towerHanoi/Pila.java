package towerHanoi;

public class Pila {
	private Node head;
	private int size = 0;
	
	public Pila() {
		head = null;
	}
	
	public int size() {
		return size;
	}
	
	public void print() {
		Node temp = head;
		
		while(temp != null) {
			System.out.println(temp.getPlato());
			temp = temp.getDown();
		}
	}
	
	public void push(String value) {
		size++;
		
		if (head == null) {
			Node temp = new Node(value);
			temp.setPlato(value);
			
			head = temp;
		} else {
			Node temp = new Node(value); 

			temp.setDown(head);
			head.setUp(temp);
			
			head = temp; 
		}
	}
	
	public void pop() {
		if (size > 0) {
			size--;
			if (head.getDown() != null) {
				head = head.getDown();
				head.setUp(null);
			} else {
				head = null;
			}
		}
	}
	
	public Node peek() {
		if (head != null) { 
			return head;
		} 
		
		return null;
	}
	
	public static void main(String[] args) {
		Pila pila = new Pila();
		
		pila.push("Jaime"); 
		pila.push("Mejia");
		
		pila.pop();
		pila.push("Alberto");
		pila.print(); 
	}
}
