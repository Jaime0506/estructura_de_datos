package tree;

public class BinaryTree {
	Node root;
	int counterChildrens;
	
	public BinaryTree() { 
		root = null;
		counterChildrens = 0;
	}
	
	public void add(Object value) {
        root = add(root, value);
    }

    private Node add(Node current, Object value) {
        if (current == null) { 
            return new Node(value); 
        }

        if (current.countChildrens == 0) {
        	current.childLeft = add(current.childLeft, value); 
        	current.countChildrens = (current.countChildrens + 1) % 2;
        } else {
        	current.childRight = add(current.childRight,value);
        	current.countChildrens = (current.countChildrens + 1) % 2; 
        }

        return current;
    }
	
	public void inorden(Node current) {
		if (current != null) {
			inorden(current.childLeft);
			System.out.println(current.value);
			inorden(current.childRight);
		}
	}
}
