package orderTree;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class TreeCanvas extends Canvas {
	private BinaryTree tree;
	private Map<Node, Point> nodePositions;
	private int canvasWidth;

	/**
	 * Create the panel.
	 */
	public TreeCanvas(int canvasWidth, int canvasHeight) {
		this.nodePositions = new HashMap<>();
		this.canvasWidth = canvasWidth;
	}

	public void setTree(BinaryTree tree) {
		this.tree = tree;
	}

	private void calculateNodePositions(Node node, int x, int y, int xOffset, int depth) {
		if (node == null) {
			return;
		}

		Point position = new Point(x, y);
		nodePositions.put(node, position);

		int horizontalSpacing = 20; // Espacio horizontal entre nodos
		int verticalSpacing = 50;

		if (node.childLeft != null) {
			int leftX = x - xOffset;
			calculateNodePositions(node.childLeft, leftX - horizontalSpacing, y + verticalSpacing, xOffset / 2,
					depth - 1);
		}

		if (node.childRight != null) {
			int rightX = x + xOffset;
			calculateNodePositions(node.childRight, rightX + horizontalSpacing, y + verticalSpacing, xOffset / 2,
					depth - 1);
		}

//        calculateNodePositions(node.childLeft, x - horizontalPadding, y + scalingFactor, xOffset / 2, depth - 1);
//        calculateNodePositions(node.childRight, x + horizontalPadding, y + scalingFactor, xOffset / 2, depth - 1);
	}

	private void drawTree(Graphics g, Node node) {
		if (node == null) {
			return;
		}

		Point position = nodePositions.get(node);

		if (position != null) {

			g.setColor(Color.BLACK);
			g.fillOval(position.x - 20, position.y - 20, 40, 40);
			g.setColor(Color.WHITE);
			g.drawString(String.valueOf(node.value), position.x - 10, position.y + 5);

			if (node.childLeft != null) {
				Point leftPosition = nodePositions.get(node.childLeft);
				g.setColor(Color.BLACK);
				g.drawLine(position.x - 10, position.y, leftPosition.x, leftPosition.y);
				drawTree(g, node.childLeft);
			}

			if (node.childRight != null) {
				Point rightPosition = nodePositions.get(node.childRight);
				g.setColor(Color.BLACK);
				g.drawLine(position.x - 10, position.y, rightPosition.x, rightPosition.y);
				drawTree(g, node.childRight);
			}
		}
	}

	private int calculateDepth(Node node) {
		if (node == null) {
			return 0;
		}

		int leftDepth = calculateDepth(node.childLeft);
		int rightDepth = calculateDepth(node.childRight);

		return Math.max(leftDepth, rightDepth) + 1;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (tree != null) { 
			int startX = canvasWidth / 2;
			int startY = 50; 
			calculateNodePositions(tree.root, startX, startY, 200, calculateDepth(tree.root));

			drawTree(g, tree.root);
		}
	}
}