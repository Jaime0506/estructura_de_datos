package orderTree;

public class Node {
	public int value;
	public Node childLeft, childRight;
	
	public Node(int value) {
		this.value = value;
		childLeft = null;
		childRight = null;
	} 

	public void getChildrends() {
		if (childLeft != null) {
			System.out.println("con un hijo izquierdo: " + (childLeft.value));
		}

		if (childRight != null) {
			System.out.println("con un hijo derecho: " + (childRight.value));
		}
	}
}
