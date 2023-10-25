package orderTree;

public class Node {
	public int value;
	public Node childLeft, childRight;
	public int countChildrens;
	
	public Node(int value) {
		this.value = value;
		childLeft = null;
		childRight = null;
	} 
}
