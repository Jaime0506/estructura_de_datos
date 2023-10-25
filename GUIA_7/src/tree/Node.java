package tree;

public class Node {
	public Object value;
	public Node childLeft, childRight;
	public int countChildrens;
	
	public Node(Object value) {
		this.value = value;
		childLeft = null;
		childRight = null;
		countChildrens = 0;
	} 
}
