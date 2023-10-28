package orderTree;

public class Node {
	public int value;
	public Node childLeft, childRight;
	
	public Node(int value) {
		this.value = value;
		childLeft = null;
		childRight = null;
	} 

	public String getChildrends() {
		String message = "";
		
		if (childLeft != null) {
			message += ("con un hijo izquierdo: " + (childLeft.value) + " ");
		}

		if (childRight != null) {
			message += ("con un hijo derecho: " + (childRight.value) + " ");
		}
		
		return message;
	}
}
