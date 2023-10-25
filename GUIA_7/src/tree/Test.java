package tree;

public class Test {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		
		tree.add(12);
		tree.add(5);
		tree.add(4);
		tree.add(8);
		tree.add(9);
		tree.add(10);
		tree.add(11);
		
		
		tree.inorden(tree.root);
		
//		System.out.println(tree.root.childLeft.childLeft.value);
//		System.out.println(tree.root.childLeft.childRight.value);
	}
}
