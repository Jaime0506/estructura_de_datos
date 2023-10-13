package towerHanoi;

public class Node {
	private String plato;
	
	private Node up;
	private Node down;

	public Node(String plato) {
		this.plato = plato;
	}
	
	public String getPlato() {
		return plato;
	}
	public void setPlato(String plato) {
		this.plato = plato;
	}
	public Node getUp() {
		return up;
	}
	public void setUp(Node up) {
		this.up = up;
	}
	public Node getDown() {
		return down;
	}
	public void setDown(Node down) {
		this.down = down;
	} 
}
